/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import beans.*;
import java.util.ArrayList;
import org.hibernate.Criteria;

public class TeacherSubjectsAndStudentLoader extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private  String subj;
    private String department;
    private List<Students> students;
    private List<String> db;
    private List<TeacherSubjects> subjects ;
    @Override
    public void init() {
        cf = new Configuration();
        cf.configure("xmlFiles/hibernate.cfg.xml");
        sf = cf.buildSessionFactory();
        session = sf.openSession();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("subjectName");

        subj = request.getParameter("subjectName");
        department = request.getParameter("department");

        subjects = (List<TeacherSubjects>) request.getSession().getAttribute("subjects");
        students = (List<Students>) request.getSession().getAttribute("studentsList");
        db = (List<String>) request.getSession().getAttribute("departments");
        TeacherSubjects t = getTeacherUsingSubject(subjects);
        
        
        
        List<Students> st = getStudentList(department,t.getSemester(),t.getBatch());
        
        request.getSession().removeAttribute("studentsList");
        
        request.getSession().setAttribute("studentsList", st);
        
        response.sendRedirect("about-us/teacher_attendance.jsp");
    }

       public List<Students> getStudentList(String depart, String semester, String batch) {
        List<Students> temp = new ArrayList<Students>();

        Criteria cr = session.createCriteria(Students.class);
        for (Students st : (List<Students>) cr.list()) {
            if (st.getBatch().equalsIgnoreCase(batch) && depart.equalsIgnoreCase(st.getDepartment())
                    && semester.equalsIgnoreCase(semester)) {
                temp.add(st);
            }
        }
        return temp;

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public TeacherSubjects getTeacherUsingSubject(List<TeacherSubjects> subjects){
        for(TeacherSubjects s : subjects){
            if(s.getSubject().equalsIgnoreCase(subj)){
                return s;
            }
        }
        return null;
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
