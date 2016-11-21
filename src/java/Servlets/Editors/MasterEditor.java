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
public class MasterEditor extends HttpServlet {

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

        System.out.println("Inside MasterEditor");

        String dep = request.getParameter("department");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        session = sf.openSession();

        Master b = (Master) session.get(Master.class, dep);

        request.getSession().setAttribute("master", b);

        response.getWriter().println("true");
        System.out.println("MasterEditor is ok");
        //response.sendRedirect("content_pages/edit_student.jsp");
        return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "MasterEditor";
    }// </editor-fold>

}
