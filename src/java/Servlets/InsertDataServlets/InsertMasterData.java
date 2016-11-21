/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.InsertDataServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author waxxan
 */
public class InsertMasterData extends HttpServlet {

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
        String password = request.getParameter("password");

        try {
            session = sf.openSession();
            Master master = new Master();

            master.setDepart(department);
            master.setMasterKey(password);

            session.save(master);

            session.beginTransaction().commit();
            session.close();

            out.println("Master key data stored successfully");

        } catch (ConstraintViolationException e) {
            out.println("Entered Master key is Already Available");
        } catch (Exception e) {
            out.println("Exception in InsertMasterData:" + e.getMessage());
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
        return "InsertMasterData";
    }// </editor-fold>
}
