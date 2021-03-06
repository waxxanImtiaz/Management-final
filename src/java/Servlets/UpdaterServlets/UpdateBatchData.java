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
public class UpdateBatchData extends HttpServlet {

  
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

        String b = request.getParameter("batchName");
        String department = request.getParameter("department");
        
        
        try {
            session = sf.openSession();
            DepartAndBatches batch = new DepartAndBatches();

            batch.setBatch(b);
            batch.setDepart(department);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateBatchDataServlet");

            System.out.println("Batch data in UpdateSubjectDataServlet");
            
             //out.println("Before Data updated successfully");
            session.merge(batch);
            tr.commit();
            out.println("Data updated successfully");
            System.out.println("Data updated successfully by UpdateBatchDataServlet");

        }
        catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
            
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateBatchtDataServlet ";
    }// </editor-fold>

}
