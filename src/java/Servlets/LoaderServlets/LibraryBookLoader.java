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

public class LibraryBookLoader extends HttpServlet {

    private LibraryBooks books;
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

            AllBooksDataLoaderService loader = new AllBooksDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<LibraryBooks> books = (List<LibraryBooks>) future.get();

            request.getSession().setAttribute("allBooks", books);

            response.sendRedirect("content_pages/librarybooks/view_librarybooks.jsp");
            System.out.println("All Books Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("LibraryBookLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in LibraryBookLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "LibraryBookLoader";
    }// </editor-fold>

    class AllBooksDataLoaderService implements Callable {
    private Session session;
    public AllBooksDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<LibraryBooks> call(){
        return getAllBooks();
    }
    
    public List<LibraryBooks> getAllBooks(){
        Criteria cr = session.createCriteria(LibraryBooks.class);
        List<LibraryBooks> books = cr.list();
        
        return books;
    }
}
}
