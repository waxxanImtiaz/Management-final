/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;

import beans.*;
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
public class UpdateMasterData extends HttpServlet {

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

        String password = request.getParameter("password");
        String department = request.getParameter("department");

        try {
            session = sf.openSession();
            Master master = new Master();

            master.setDepart(department);
            master.setMasterKey(password);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateMasterData");

            System.out.println("Batch data in UpdateMasterData");

            //out.println("Before Data updated successfully");
            session.merge(master);
            tr.commit();
            out.println("Data updated successfully");
            System.out.println("Data updated successfully by UpdateMasterData");

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());

        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateMasterData ";
    }// </editor-fold>

}
