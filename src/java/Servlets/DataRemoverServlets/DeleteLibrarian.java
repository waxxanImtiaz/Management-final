/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.DataRemoverServlets;

import beans.Librarian;
import beans.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class DeleteLibrarian extends HttpServlet {

    private Librarian librarian;
    private Session session;
    private SessionFactory sf;
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        System.out.println("Inside DeleteLibrarian");
        String tId = request.getParameter("id");
        //  subject =(Students) request.getSession().getAttribute("subject");

        
        
        out = response.getWriter();

        try{
            
            
        System.out.println("Inside DeleteLibrarian");

        int id = Integer.parseInt(tId);
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        session = sf.openSession();
        librarian = (Librarian) session.get(Librarian.class, id);

        
        Transaction tr = session.beginTransaction();

        session.delete(librarian);

        tr.commit();
        out.print("true");
        System.out.println("Librarian's data deleted successfully");
        }catch(Exception e){
            out.println("DeleteLibrarian:"+e.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "DeleteLibrarian";
    }// </editor-fold>
}
