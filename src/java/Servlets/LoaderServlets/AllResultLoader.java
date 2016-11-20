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

public class AllResultLoader extends HttpServlet {

    private StudentSemesterResult result;
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
        sf= (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllResultDataLoaderService loader = new AllResultDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<DepartAndBatches> batches = (List<DepartAndBatches>) future.get();

            request.getSession().setAttribute("allResult", batches);

            response.sendRedirect("content_pages/result_pages/view_result.jsp");
            System.out.println("All Result Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("AllResultLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in AllResultLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

    class AllResultDataLoaderService implements Callable {
    private Session session;
    public AllResultDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<StudentSemesterResult> call(){
        return getAllResult();
    }
    
    public List<StudentSemesterResult> getAllResult(){
        Criteria cr = session.createCriteria(StudentSemesterResult.class);
        List<StudentSemesterResult> result = cr.list();
        
        return result;
    }
}
}
