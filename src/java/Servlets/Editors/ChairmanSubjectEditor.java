/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Editors;

import beans.*;
import java.io.IOException;
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
public class ChairmanSubjectEditor extends HttpServlet {

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

        String id = request.getParameter("id");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        session = sf.openSession();

        System.out.println("Inside ChairmanSubjectEditor");

        int i = Integer.parseInt(id);
        
        TeacherSubjects b = (TeacherSubjects) session.get(TeacherSubjects.class, i);

        request.getSession().setAttribute("assignedSubject", b);

         List<Subjects> subjects = (List<Subjects>) request.getSession().getAttribute("allSubjects");
        List<Teacher> teachers = (List<Teacher>) request.getSession().getAttribute("departTeachers");
        System.out.println("Subjects");
        for(Subjects s : subjects){
             System.out.println(s.getSubjectName());
         }
         
        System.out.println("Teachers");
        for(Teacher t : teachers){
             System.out.println(t.getDepartment());
         }
        
        
//        response.sendRedirect("content_pages/chairman/edit_subject.jsp");
        
        //response.getWriter().println("true");
        System.out.println("ChairmanSubjectEditor is ok");
        return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "ChairmanSubjectEditor";
    }// </editor-fold>

}

