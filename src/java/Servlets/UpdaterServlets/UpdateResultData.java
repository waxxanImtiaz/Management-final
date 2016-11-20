package Servlets.UpdaterServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servlets.Services.InterEduDataLoader;
import Servlets.Services.MatricEduDataLoader;
import Servlets.Services.StudentDataLoader;
import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class UpdateResultData extends HttpServlet {

  
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

        System.out.println("Inside UpdateResultData servlet");
        
        String department = request.getParameter("department");
        String batchName = request.getParameter("batch");
        String subjectName= request.getParameter("subjectName");
        String semester= request.getParameter("semester");
        String rollNumber= request.getParameter("rollNumber");
        String rs= request.getParameter("result");
        String id= request.getParameter("id");
        String theoryOrPractical= request.getParameter("theoryOrPractical");
        
        
        try {
            int i = Integer.parseInt(id);
            session = sf.openSession();
            StudentSemesterResult res = new StudentSemesterResult();

            res.setBatch(batchName);
            res.setDepart(department);
            res.setSemester(semester);
            res.setRollNum(rollNumber);
            res.setResult(rs);
            res.setTheoryOrPractical(theoryOrPractical);
            res.setId(i);
            res.setSubject(subjectName);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateBatchDataServlet");

            System.out.println("Result data in UpdateSubjectDataServlet");
            
             //out.println("Before Data updated successfully");
            session.merge(res);
            tr.commit();
            out.println("Data updated successfully");
            System.out.println("Result updated successfully by UpdateResultDataServlet");

        }
        catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
            
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateResultDataServlet ";
    }// </editor-fold>

}
