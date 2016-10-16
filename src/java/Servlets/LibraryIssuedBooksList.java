/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.LibraryDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import beans.*;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author waxxan
 */
public class LibraryIssuedBooksList extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private List<LibraryDetails> books;
   
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
        Criteria cri = session.createCriteria(LibraryDetails.class);
        
        books = cri.list();
        
        //books = getAlteredList(books);
        
        request.getSession().setAttribute("bookIssuedList",books);
        response.sendRedirect("about-us/library_issued_books.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

//   public List<LibraryBooks> getAlteredList(List<LibraryBooks> list){
//       List<LibraryBooks> lib = new ArrayList<LibraryBooks>();
//       
//       for(LibraryBooks books : list){
//           if(books.getState() != null && books.getState().equalsIgnoreCase("avail")){
//               lib.add(books);
//           }
//       }
//       return lib;
//   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
