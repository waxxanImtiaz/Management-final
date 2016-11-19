/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author waxxan
 */
public class InsertBatchData extends HttpServlet {

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
        String batchName = request.getParameter("batchName");

        try {
            session = sf.openSession();
            DepartAndBatches batch = new DepartAndBatches();

            batch.setBatch(batchName);
            batch.setDepart(department);

            session.save(batch);

            session.beginTransaction().commit();
            session.close();

            out.println("Subject data stored successfully");

        } catch (ConstraintViolationException e) {
            out.println("Entered Batch is Already Available");
        } catch (Exception e) {
            out.println("Exception in InsertBatchData:" + e.getMessage());
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
        return "InsertSubjectData";
    }// </editor-fold>

}
