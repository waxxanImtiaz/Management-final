/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;

import beans.Subjects;
import beans.TeacherSubjects;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class UpdateAssignedSubjectData extends HttpServlet {

  
    private Session session;
    private PrintWriter out;
    private SessionFactory sf;

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

        String subjectId = request.getParameter("id");
        String department = request.getSession().getAttribute("department").toString();
        String subjectName = request.getParameter("subjectName");
        String semester = request.getParameter("semester");
        String theoryOrPractical = request.getParameter("theoryOrPractical");
        String batch = request.getParameter("batch");
        String teacherName = request.getParameter("teacherName");
        
        try {
            int id = Integer.parseInt(subjectId);
            session = sf.openSession();
            TeacherSubjects subject = new TeacherSubjects();

            subject.setId(id);
            subject.setSemester(semester);
            subject.setTeacherName(teacherName);
            subject.setDepartment(department);
            subject.setSubject(subjectName);
            subject.setBatch(batch);
            subject.setType(theoryOrPractical);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateAssignedSubjectData");

            System.out.println("Student data in UpdateSubjectDataServlet");
            
           
            session.merge(subject);
            tr.commit();
            out.print("Data updated successfully");
            System.out.println("Data updated successfully by UpdateAssignedSubjectData");

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
            
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateAssignedSubjectData ";
    }// </editor-fold>

}
