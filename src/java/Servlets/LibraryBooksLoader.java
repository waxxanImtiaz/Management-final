/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import beans.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LibraryBooksLoader extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private List<LibraryBooks> libraryBooks;

    @Override
    public void init() {
        cf = new Configuration();
        cf.configure("xmlFiles/hibernate.cfg.xml");
        sf = cf.buildSessionFactory();
        session = sf.openSession();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Criteria criteria = session.createCriteria(LibraryBooks.class);
      
       String webPage = request.getParameter("jspPage");
       
       libraryBooks = criteria.list();
        
        alterList(libraryBooks);
        
        request.getSession().setAttribute("libraryBooks", libraryBooks);
        
        if(webPage == null || webPage.isEmpty())
            response.sendRedirect("about-us/libraryBooks.jsp");
        else{
            response.sendRedirect("about-us/librarianAvailableBooks.jsp");
        }
    }

      public void alterList(List<LibraryBooks> libraryBooks){
        List<LibraryBooks> temp = new ArrayList<LibraryBooks>();
        
        for(int i = 0 ; i<libraryBooks.size(); i++){
            String state = libraryBooks.get(i).getState();
            if(state.equalsIgnoreCase("avail") )
            {
                temp.add(libraryBooks.get(i));
              }
        }//end of loop
        
        this.libraryBooks = temp;
    }//end of method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "LibraryBooksLoader";
    }
}
