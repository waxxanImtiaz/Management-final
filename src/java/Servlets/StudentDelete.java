/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Students;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class StudentDelete extends HttpServlet {

    private Students student;
    private Session session;
    private PrintWriter out;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rollNumber = request.getParameter("rollNumber");
      //  student =(Students) request.getSession().getAttribute("student");
        
        out = response.getWriter();
        
         session = (Session) request.getServletContext().getAttribute("hibernateSession");
        
         student = (Students)session.get(Students.class, rollNumber);
        Transaction tr = session.beginTransaction();
        
        session.delete(student);
        
        tr.commit();
        out.print("Data deleted successfully");
        System.out.println("Data deleted successfully");
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "StudentDelete";
    }// </editor-fold>

}
