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

public class LibrarianLoader extends HttpServlet {

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
        System.out.println("Inside all LibrarianLoader");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllLibrarianDataLoaderService loader = new AllLibrarianDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Librarian> lib = (List<Librarian>) future.get();

            request.getSession().setAttribute("allLibrarian", lib);

            response.sendRedirect("content_pages/librarian/view_librarian.jsp");
            System.out.println("All Librarians Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("LibrarianLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in LibrarianLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "LibrarianLoader";
    }// </editor-fold>

    class AllLibrarianDataLoaderService implements Callable {
    private Session session;
    public AllLibrarianDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Librarian> call(){
        return getAllLibrarians();
    }
    
    public List<Librarian> getAllLibrarians(){
        Criteria cr = session.createCriteria(Librarian.class);
        List<Librarian> lib = cr.list();
        
        return lib;
    }
}
}
