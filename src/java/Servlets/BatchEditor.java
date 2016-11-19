/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.DepartAndBatches;
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
public class BatchEditor extends HttpServlet {

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

        String batch = request.getParameter("batch");
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        session = sf.openSession();

//        List<DepartAndBatches> allSubjects = (List<DepartAndBatches>) request.getSession().getAttribute("allBatches");
        System.out.println("Inside BatchEditor");

        DepartAndBatches b = (DepartAndBatches) session.get(DepartAndBatches.class, batch);

        request.getSession().setAttribute("batch", b);

        response.getWriter().println("true");
        System.out.println("BatchEditor is ok");
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
        return "BatchEditor";
    }// </editor-fold>

}
