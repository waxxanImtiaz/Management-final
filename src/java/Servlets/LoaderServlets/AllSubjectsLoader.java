/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import Servlets.Services.AllStudentDataLoaderService;
import beans.Subjects;
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

public class AllSubjectsLoader extends HttpServlet {

    private Subjects subjects;
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
        sf= (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllSubjectsDataLoaderService loader = new AllSubjectsDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Subjects> subjects = (List<Subjects>) future.get();

            request.getSession().setAttribute("allSubjects", subjects);

            response.sendRedirect("content_pages/view_subject.jsp");
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
    public AllSubjectsDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Subjects> call(){
        return getAllStudents();
    }
    
    public List<Subjects> getAllStudents(){
        Criteria cr = session.createCriteria(Subjects.class);
        List<Subjects> subjects = cr.list();
        
        return subjects;
    }
}
}
