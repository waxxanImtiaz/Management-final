/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Services;

import java.util.concurrent.Callable;
import beans.*;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author waxxan
 */
public class StudentDataLoader implements Callable {
    private Students student;
    private HttpServletRequest request;
    
    
    public StudentDataLoader(Students student,HttpServletRequest request){
        this.request = request;
        this.student = student;
    }
    @Override 
    public Students call(){
        return getStudent();
    }
    private Students getStudent(){
         //printWriter.println("true");
            String rollNumber = request.getParameter("rollNumber");
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
            student.setBatch(batch);
            student.setFatherName(fatherName);
            student.setFtContactNum(father_contact);
            student.setPassword(password);
            student.setStEmail(email);
            student.setGender(gender);
            student.setRollNum(rollNumber);
            student.setStContactNum(student_contact_num);
            student.setTempAdd(address);
            student.setCnic(nic);
            
            return student;
    }
    
}
