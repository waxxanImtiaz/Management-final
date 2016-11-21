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
public class InsertTeacherData extends HttpServlet {

    private PrintWriter out;
    private Session session;
    private SessionFactory sf;
    private  Teacher teacher;
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

        System.out.println("Inside InsertTeacherData servlet");

        String department = request.getParameter("department");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");

        try {
            session = sf.openSession();
            teacher = new Teacher();

           
            teacher.setName(name);
            teacher.setUsername(username);
            teacher.setEmail(email);
            teacher.setPassword(password);
            teacher.setDepartment(department);
            
            if(isTeacherOk())
            {
            session.save(teacher);

            session.beginTransaction().commit();
            session.close();

            System.out.println("InsertTeacherData is ok");
            out.println("Data inserted successfully");
            }else
                out.println("Teacher already available");
        }  catch (Exception e) {
            out.println("Exception in InsertTeacherData:" + e.getMessage());
            e.printStackTrace();
        }

    }
    @Override
    public String getServletInfo() {
        return "InsertTeacherData";
    }// </editor-fold>

    public boolean isTeacherOk(){
        Criteria cr = session.createCriteria(Teacher.class);
        for(Teacher t : (List<Teacher>)cr.list()){
            if(t.getName().equalsIgnoreCase(teacher.getName()) && t.getDepartment().equalsIgnoreCase(teacher.getDepartment())
                    || t.getUsername().equalsIgnoreCase(teacher.getUsername()))
                return false;
        }
        return true;
    }
}
