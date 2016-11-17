/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;

import beans.Students;
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
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class UpdateStudentDataServlet extends HttpServlet {

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
        student =(Students) request.getSession().getAttribute("student");
        
        out = response.getWriter();
        
         session = (Session) request.getServletContext().getAttribute("hibernateSession");
        
        Transaction tr = session.beginTransaction();
        
        session.saveOrUpdate(student);
        
        tr.commit();
        out.print("Data updated successfully");
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "UpdateStudentDataServlet ";
    }// </editor-fold>

}
