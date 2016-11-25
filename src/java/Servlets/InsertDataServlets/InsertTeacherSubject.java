/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.InsertDataServlets;


import beans.Subjects;
import beans.TeacherSubjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class InsertTeacherSubject extends HttpServlet {

    private PrintWriter out;
    private Session session;
    private SessionFactory sf;
    private String teacherName;

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

        
        String department = request.getSession().getAttribute("department").toString();
        String subjectName = request.getParameter("subject");
        String semester = request.getParameter("semester");
        String theoryOrPractical = request.getParameter("theoryOrPractical");
        String batch = request.getParameter("batch");
        teacherName = request.getParameter("teacherName");

        try {
            session = sf.openSession();
            TeacherSubjects subject = new TeacherSubjects();

            
            subject.setBatch(batch);
            subject.setDepartment(department);
            subject.setSemester(semester);
            subject.setSubject(subjectName);
            subject.setType(theoryOrPractical);
            subject.setTeacherName(teacherName);

            if (isOkSubject(subject)) {
                session.save(subject);

                session.beginTransaction().commit();
                session.close();

                out.println("Subject data stored successfully");
            } else {
                out.println(subject.getSubject()+" is already assigned to "+this.teacherName);
            }

        } catch (Exception e) {
            out.println("Exception in InsertSubjectData:" + e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean isOkSubject(TeacherSubjects subject) {
        Criteria cr = session.createCriteria(TeacherSubjects.class);
        List<TeacherSubjects> subList = cr.list();

        for (TeacherSubjects s : subList) {
            if (s.getSubject().equalsIgnoreCase(subject.getSubject())) {
                if (s.getDepartment().equalsIgnoreCase(subject.getDepartment())) {
                    teacherName = s.getTeacherName();
                    return false;
                }
            }
        }
         return true;
    }
        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
        return "InsertSubjectData";
        }// </editor-fold>

    }