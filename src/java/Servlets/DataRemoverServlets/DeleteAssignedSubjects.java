/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.DataRemoverServlets;

import beans.Students;
import beans.Subjects;
import beans.TeacherSubjects;
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
public class DeleteAssignedSubjects extends HttpServlet {

    private TeacherSubjects subject; 
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
        String subjectId = request.getParameter("id");

        out = response.getWriter();

         System.out.println("Inside SubjectDelete");
        
        int id = Integer.parseInt(subjectId);
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        session = sf.openSession();
        subject = (TeacherSubjects) session.get(TeacherSubjects.class, id);
        
        Transaction tr = session.beginTransaction();

        session.delete(subject);

        tr.commit();
        out.print("Deleted successfully");
        System.out.println("Deleted successfully");

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