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

public class AllBatchLoader extends HttpServlet {

    private DepartAndBatches batch;
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

            AllBatchesDataLoaderService loader = new AllBatchesDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<DepartAndBatches> batches = (List<DepartAndBatches>) future.get();

            request.getSession().setAttribute("allBatches", batches);

            response.sendRedirect("content_pages/batch_and_depart_pages/view_depart_batch.jsp");
            System.out.println("All Batches Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("AllBatchesLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in AllBatchesLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

    class AllBatchesDataLoaderService implements Callable {
    private Session session;
    public AllBatchesDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<DepartAndBatches> call(){
        return getAllStudents();
    }
    
    public List<DepartAndBatches> getAllStudents(){
        Criteria cr = session.createCriteria(DepartAndBatches.class);
        List<DepartAndBatches> batches = cr.list();
        
        return batches;
    }
}
}
