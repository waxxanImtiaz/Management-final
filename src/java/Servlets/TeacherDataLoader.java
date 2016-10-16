/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Students;
import beans.TeacherSubjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TeacherDataLoader extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;

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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TeacherSubjects subjects = (TeacherSubjects) request.getSession().getAttribute("teacherSubject");

        // String subject = subjects.getSubject();
        String department = subjects.getDepartment();
        String semester = subjects.getSemester();
        String batch = subjects.getBatch();

        List<Students> students = getStudentList(department, semester, batch);

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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
