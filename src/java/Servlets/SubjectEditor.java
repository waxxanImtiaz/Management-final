/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Intermediate;
import beans.MatricInformation;
import beans.Students;
import beans.Subjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class SubjectEditor extends HttpServlet {

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

        String subjectId = request.getParameter("subjectId");
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        session = sf.openSession();

        List<Subjects> allSubjects = (List<Subjects>) request.getSession().getAttribute("allSubjects");
        System.out.println("Inside subjectsEditor");

        System.out.println("Subject id =" + subjectId);
        
        int id = Integer.parseInt(subjectId);
        Subjects subjects = (Subjects) session.get(Subjects.class, id);

        for (Subjects sb : allSubjects) {
            if (sb.getId() == id) {
                request.getSession().setAttribute("subject", sb);

                response.getWriter().println("true");
                System.out.println("SubjectEditor is ok");
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
        return "SubjectEditor";
    }// </editor-fold>

}
