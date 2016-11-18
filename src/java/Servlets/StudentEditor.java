/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Intermediate;
import beans.MatricInformation;
import beans.Students;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author waxxan
 */
public class StudentEditor extends HttpServlet {

   private Intermediate inter;
   private MatricInformation matric;
    private Session session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rollNumber = request.getParameter("rollNumber");
        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        
        List<Students> students = (List<Students>)request.getSession().getAttribute("allStudents");
        System.out.println("Inside studentEditor");
       
        matric = (MatricInformation)session.get(MatricInformation.class, rollNumber);
        inter = (Intermediate)session.get(Intermediate.class, rollNumber);
       
        
        for(Students st : students){
            if(st.getRollNum().equalsIgnoreCase(rollNumber)){
                request.getSession().setAttribute("student",st);
                request.getSession().setAttribute("inter",inter);
                request.getSession().setAttribute("matric",matric);
                
                response.getWriter().println("true");
                System.out.println("editor is ok");
                //response.sendRedirect("content_pages/edit_student.jsp");
                return;
            }
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
