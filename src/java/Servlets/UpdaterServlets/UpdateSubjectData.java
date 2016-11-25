/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;

import beans.Subjects;
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
public class UpdateSubjectData extends HttpServlet {

  
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

        String subjectId = request.getParameter("subjectId");
        String department = request.getParameter("department");
        String subjectName = request.getParameter("subjectName");
        String semester = request.getParameter("semester");
        String theoryOrPractical = request.getParameter("theoryOrPractical");
        String creditHours = request.getParameter("creditHours");
        String totalLectures = request.getParameter("totalLectures");
        
        try {
            int id = Integer.parseInt(subjectId);
            session = sf.openSession();
            Subjects subject = new Subjects();

            subject.setId(id);
            subject.setCreditHours(creditHours);
            subject.setDepartment(department);
            subject.setSemester(semester);
            subject.setSubjectName(subjectName);
            subject.setTotalLectures(totalLectures);
            subject.setTheoryOrPractical(theoryOrPractical);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateSubjectDataServlet");

            System.out.println("Student data in UpdateSubjectDataServlet");
            
           
            session.merge(subject);
            tr.commit();
            out.print("Data updated successfully");
            System.out.println("Data updated successfully by UpdateSubjectDataServlet");

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
            
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateSubjectDataServlet ";
    }// </editor-fold>

}
