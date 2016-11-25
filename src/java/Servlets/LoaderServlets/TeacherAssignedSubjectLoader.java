/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class TeacherAssignedSubjectLoader extends HttpServlet {

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
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            department = request.getSession().getAttribute("department").toString();
            executorService = Executors.newFixedThreadPool(1);

            AllSubjectsDataLoaderService loader = new AllSubjectsDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<TeacherSubjects> subjects = (List<TeacherSubjects>) future.get();

            request.getSession().setAttribute("allAssignedSubjects", subjects);

            response.sendRedirect("content_pages/chairman/view_subject.jsp");
            
            executorService.shutdown();
            
            for(TeacherSubjects t : subjects){
                System.out.println("********************************************************");
                System.out.println(t.getTeacherName());
            }
            
            System.out.println("All Subjects Got");
        } catch (NullPointerException e) {
            System.err.println("TeacherAssignedSubjectLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in TeacherAssignedSubjectLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "TeacherAssignedSubjectLoader";
    }// </editor-fold>

    class AllSubjectsDataLoaderService implements Callable {

        private Session session;

        public AllSubjectsDataLoaderService(Session session) {
            this.session = session;
        }

        @Override
        public List<TeacherSubjects> call() {
            return getAllSubjects();
        }

        public List<TeacherSubjects> getAllSubjects() {
            Criteria cr = session.createCriteria(TeacherSubjects.class);
            Criterion res = Restrictions.eq("department", department);
            cr.add(res);

            return cr.list();
        }
    }
}
