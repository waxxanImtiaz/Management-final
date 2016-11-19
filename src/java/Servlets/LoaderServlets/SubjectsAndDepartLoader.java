/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import beans.DepartAndBatches;
import beans.Subjects;
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

public class SubjectsAndDepartLoader extends HttpServlet {

    private Subjects subjects;
    private DepartAndBatches departs;
    private Session session;
    private SessionFactory sf;
    private ExecutorService executorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        System.out.println("Inside subjects and depart loader");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(2);

            AllSubjectsDataLoaderService loader = new AllSubjectsDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Subjects> subjects = (List<Subjects>) future.get();

            AllDepartsDataLoaderService dep = new AllDepartsDataLoaderService(session);

            Future fut = executorService.submit(dep);

            List<DepartAndBatches> departs = (List<DepartAndBatches>) fut.get();

            System.out.println("Total departs");

            for (DepartAndBatches db : departs) {
                System.out.println(db.getDepart());
            }

            request.getSession().setAttribute("allSubjects", subjects);
            request.getSession().setAttribute("departments", departs);

            response.sendRedirect("content_pages/result_pages/add_result.jsp");
            System.out.println("All Subjects Got");
        } catch (NullPointerException e) {
            System.err.println("AllSubjectsLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in AllSubjectsLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

    class AllSubjectsDataLoaderService implements Callable {

        private Session session;

        public AllSubjectsDataLoaderService(Session session) {
            this.session = session;
        }

        @Override
        public List<Subjects> call() {
            return getAllStudents();
        }

        public List<Subjects> getAllStudents() {
            Criteria cr = session.createCriteria(Subjects.class);
            List<Subjects> subjects = cr.list();

            return subjects;
        }
    }

    class AllDepartsDataLoaderService implements Callable {

        private Session session;

        public AllDepartsDataLoaderService(Session session) {
            this.session = session;
        }

        @Override
        public List<DepartAndBatches> call() {
            return getAllDeparts();
        }

        public List<DepartAndBatches> getAllDeparts() {
            Criteria cr = session.createCriteria(DepartAndBatches.class);

            List<DepartAndBatches> alterDeparts = new ArrayList<DepartAndBatches>();
            //cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<DepartAndBatches> departs = cr.list();

            return departs;
        }
    }
}
