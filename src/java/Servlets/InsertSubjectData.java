/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Subjects;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class InsertSubjectData extends HttpServlet {

    private PrintWriter out;
    private Session session;
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
        
        
        String department = request.getParameter("department");
        String subjectName = request.getParameter("subjectName");
        String semester = request.getParameter("semester");
        String theoryOrPractical = request.getParameter("theoryOrPractical");
        String creditHours = request.getParameter("creditHours");
        String totalLectures = request.getParameter("totalLectures");
        
        try{
            out.println("Before inserting subject data");
            session = sf.openSession();
            Subjects subject = new Subjects();
            
            subject.setCreditHours(creditHours);
            subject.setDepartment(department);
            subject.setSemester(semester);
            subject.setSubjectName(subjectName);
            subject.setTotalLectures(totalLectures);
            subject.setTheoryOrPractical(theoryOrPractical);
            
            session.save(subject);
            
            session.beginTransaction().commit();
            session.close();
            
            out.println("Subject data stored successfully");
            
        }catch(Exception e){
            out.println("Exception in InsertSubjectData:"+e.getMessage());
            e.printStackTrace();
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "IextnsertSubjectData";
    }// </editor-fold>

}
