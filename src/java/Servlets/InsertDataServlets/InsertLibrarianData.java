/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.InsertDataServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author waxxan
 */
public class InsertLibrarianData extends HttpServlet {

    private PrintWriter out;
    private Session session;
    private SessionFactory sf;
    private  Librarian librarian;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        out = response.getWriter();

        System.out.println("Inside InsertLibrarianData servlet");

        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");

        try {
            session = sf.openSession();
            librarian = new Librarian();

           
            librarian.setMobileNumber(mobileNumber);
            librarian.setUsername(username);
            librarian.setEmail(email);
            librarian.setPassword(password);
            
            if(isLibrarianOk())
            {
            session.save(librarian);

            session.beginTransaction().commit();
            session.close();

            System.out.println("InsertLibrarianData is ok");
            out.println("Data inserted successfully");
            }else
                out.println("Librarian already available");
        }  catch (Exception e) {
            out.println("Exception in InsertLibrarianData:" + e.getMessage());
            e.printStackTrace();
        }

    }
    @Override
    public String getServletInfo() {
        return "InsertLibrarianData";
    }// </editor-fold>

    public boolean isLibrarianOk(){
        Criteria cr = session.createCriteria(Librarian.class);
        for(Librarian t : (List<Librarian>)cr.list()){
            if(t.getUsername().equalsIgnoreCase(librarian.getUsername()) && t.getEmail().equalsIgnoreCase(librarian.getEmail()))
                return false;
        }
        return true;
    }
}
