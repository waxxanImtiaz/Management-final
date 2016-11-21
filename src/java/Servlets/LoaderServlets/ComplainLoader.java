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

public class ComplainLoader extends HttpServlet {
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
        System.out.println("Inside ComplainsLoader");
        sf= (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {
            
            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllComplainDataLoaderService loader = new AllComplainDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Complain> complain = (List<Complain>) future.get();

            request.getSession().setAttribute("allComplains", complain);
                
            System.out.println("Complains");
            System.out.println(complain.get(0).getComplain());
            response.sendRedirect("content_pages/complains/readComplain.jsp");
            System.out.println("All ComplainsLoader Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("ComplainsLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in ComplainsLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "ComplainsLoader";
    }// </editor-fold>

    class AllComplainDataLoaderService implements Callable {
    private Session session;
    public AllComplainDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Complain> call(){
        return getAllComplains();
    }
    
    public List<Complain> getAllComplains(){
        Criteria cr = session.createCriteria(Complain.class);
        List<Complain> complains = cr.list();
        
        return complains;
    }
}
}
