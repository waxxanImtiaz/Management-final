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

public class LibraryDetailsLoader extends HttpServlet {

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

            System.out.println("Inside Library details");
            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            LibraryDetailsLoaderService loader = new LibraryDetailsLoaderService(session);

            Future future = executorService.submit(loader);

            List<LoginInformation> libdet = (List<LoginInformation>) future.get();

            request.getSession().setAttribute("libraryDetails", libdet);

            response.sendRedirect("content_pages/librarybooks/booksDetail.jsp");
            System.out.println("All Library details data Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("LibraryDetailsLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in LibraryDetailsLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "LibraryDetailsLoader";
    }// </editor-fold>

    class LibraryDetailsLoaderService implements Callable {
    private Session session;
    public LibraryDetailsLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<LibraryDetails> call(){
        return getLibraryDetails();
    }
    
    public List<LibraryDetails> getLibraryDetails(){
        Criteria cr = session.createCriteria(LibraryDetails.class);
        List<LibraryDetails> det = cr.list();
        
        return det;
    }
}
}
