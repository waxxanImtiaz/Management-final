/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import beans.*;
/**
 *
 * @author waxxan
 */
public class InsertStudentServlet extends HttpServlet {
    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Session session = (Session)request.getServletContext().getAttribute("hibernateSession");
        
        if(session != null){
            System.out.println("session is not null");
            
        }else
            return;
        
        String rollNumber = request.getParameter("id");
        String name = request.getParameter("student_name");
        String batch = request.getParameter("batch");
        String fatherName = request.getParameter("fatherName");
        String caste = request.getParameter("caste");
        String dob = request.getParameter("dob");
        String department = request.getParameter("department");
        String perm_address = request.getParameter("perm_address");
        String gender = request.getParameter("gender");
        String father_contact = request.getParameter("father_contact");
        String student_contact_num = request.getParameter("student_contact_num");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String nic = request.getParameter("nic");
        
        Students student = new Students();
        student.setName(name);
        student.setCaste(caste);
        student.setDepartment(department);
        student.setPermAdd(perm_address);
        student.setFatherName(fatherName);
        student.setFtContactNum(father_contact);
        student.setPassword(password);
        student.setStEmail(email);
        student.setTempAdd(address);
        student.setCnic(nic);
        
        System.out.println("Data got data ");
        
    }


}
