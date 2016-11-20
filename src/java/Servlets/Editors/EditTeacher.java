/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Editors;

import beans.*;
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
public class EditTeacher extends HttpServlet {

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

        int i = Integer.parseInt(id);
       System.out.println("Inside EditTeacher");

        Teacher b = (Teacher) session.get(Teacher.class, i);

        request.getSession().setAttribute("editTeacher", b);

        response.getWriter().println("true");
        System.out.println("EditTeacher is ok");
        return;
    }

    @Override
    public String getServletInfo() {
        return "EditTeacher";
    }// </editor-fold>

}
