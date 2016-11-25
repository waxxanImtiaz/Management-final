/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.hibernate.SessionFactory;
import java.util.concurrent.Callable;
import org.hibernate.Criteria;

public class ChairmanLoader extends HttpServlet {

    private Session session;
    private SessionFactory sf;
    private ExecutorService executorService;
    private String department;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        try {

            session = sf.openSession();
            department = request.getSession().getAttribute("department").toString();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);
            System.out.println("department = "+department);
            AllTeachersLoaderLoaderService loader = new AllTeachersLoaderLoaderService(session);
            AllSubjectsLoaderLoaderService subjectsLoader = new AllSubjectsLoaderLoaderService(session);

            Future future = executorService.submit(loader);
            Future subjectsFuture = executorService.submit(subjectsLoader);

            List<Teacher> teachers = (List<Teacher>) future.get();
            List<Subjects> subjects = (List<Subjects>) subjectsFuture.get();

            request.getSession().setAttribute("departTeachers", teachers);
            request.getSession().setAttribute("allSubjects", subjects);

            
            response.sendRedirect("content_pages/chairman/assign_subject.jsp");
            System.out.println("ChairmanLoader is Ok");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("ChairmanLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in ChairmanLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "ChairmanLoader";
    }// </editor-fold>

    class AllTeachersLoaderLoaderService implements Callable {

        private Session session;

        public AllTeachersLoaderLoaderService(Session session) {
            this.session = session;
        }

        @Override
        public List<Teacher> call() {
            return getAllTeachers();
        }

        public List<Teacher> getAllTeachers() {
            Criteria cr = session.createCriteria(Teacher.class);
            List<Teacher> teachers = cr.list();
            List<Teacher> departTeachers = new ArrayList<Teacher>();

            for (Teacher t : teachers) {
                if (t.getDepartment().equalsIgnoreCase(department)) {
                    departTeachers.add(t);
                }
            }

            return departTeachers;
        }

    }
    class AllSubjectsLoaderLoaderService implements Callable {

        private Session session;

        public AllSubjectsLoaderLoaderService(Session session) {
            this.session = session;
        }

        @Override
        public List<Subjects> call() {
            return getAllSubjects();
        }

        public List<Subjects> getAllSubjects() {
            Criteria cr = session.createCriteria(Subjects.class);
            List<Subjects> teachers = cr.list();
            List<Subjects> departSubjects = new ArrayList<Subjects>();

            for (Subjects t : teachers) {
                if (t.getDepartment().equalsIgnoreCase(department)) {
                    departSubjects.add(t);
                }
            }

            return departSubjects;
        }

    }
}
