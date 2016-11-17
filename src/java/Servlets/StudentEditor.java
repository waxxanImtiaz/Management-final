/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Students;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author waxxan
 */
public class StudentEditor extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rollNumber = request.getParameter("rollNumber");
        
        List<Students> students = (List<Students>)request.getSession().getAttribute("allStudents");
        System.out.println("Inside studentEditor");
       
        
        for(Students st : students){
            if(st.getRollNum().equalsIgnoreCase(rollNumber)){
                request.getSession().setAttribute("student",st);
                response.getWriter().println("true");
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
