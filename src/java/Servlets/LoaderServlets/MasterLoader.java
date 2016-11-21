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

public class MasterLoader extends HttpServlet {

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
        System.out.println("Inside all MasterLoader");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllMasterDataLoaderService loader = new AllMasterDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Master> lib = (List<Master>) future.get();

            request.getSession().setAttribute("allMasters", lib);

            response.sendRedirect("content_pages/master/view_master.jsp");
            System.out.println("All Masters Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("MasterLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in MasterLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "MasterLoader";
    }// </editor-fold>

    class AllMasterDataLoaderService implements Callable {
    private Session session;
    public AllMasterDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Master> call(){
        return getAllMasters();
    }
    
    public List<Master> getAllMasters(){
        Criteria cr = session.createCriteria(Master.class);
        List<Master> master = cr.list();
        
        return master;
    }
}
}
