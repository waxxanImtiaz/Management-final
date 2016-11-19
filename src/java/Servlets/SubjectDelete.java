/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Students;
import beans.Subjects;
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
public class SubjectDelete extends HttpServlet {

    private Subjects subject; 
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

         System.out.println("Inside SubjectDelete");
        String subjectId = request.getParameter("subjectId");
        //  subject =(Students) request.getSession().getAttribute("subject");

        out = response.getWriter();

         System.out.println("Inside SubjectDelete");
        
        int id = Integer.parseInt(subjectId);
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        session = sf.openSession();
        subject = (Subjects) session.get(Subjects.class, id);
        
        Transaction tr = session.beginTransaction();

        session.delete(subject);

        tr.commit();
        out.print("Subject  deleted successfully");
        System.out.println("Subject deleted successfully");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "SubjectDelete";
    }// </editor-fold>
}