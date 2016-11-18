/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;

import Servlets.Services.InterEduDataLoader;
import Servlets.Services.MatricEduDataLoader;
import Servlets.Services.StudentDataLoader;
import beans.Intermediate;
import beans.MatricInformation;
import beans.Students;
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
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class UpdateStudentDataServlet extends HttpServlet {

    private Students student;
    private Session session;
    private PrintWriter out;
    private ExecutorService executorService;
    private Intermediate inter;
    private MatricInformation matric;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // student = (Students) request.getSession().getAttribute("student");

        out = response.getWriter();

        session = (Session) request.getServletContext().getAttribute("hibernateSession");

        try {
            executorService = Executors.newFixedThreadPool(3);

            //Initialize student data
            StudentDataLoader loader = new StudentDataLoader(new Students(), request);
            Future<Students> studentFuture = executorService.submit(loader);

            InterEduDataLoader interData = new InterEduDataLoader(new Intermediate(), request);
            MatricEduDataLoader matricData = new MatricEduDataLoader(new MatricInformation(), request);

            Future<MatricInformation> matricFuture = executorService.submit(matricData);
            Future<Intermediate> interFuture = executorService.submit(interData);

            student = studentFuture.get();

            Transaction tr = session.beginTransaction();

            System.out.println("student data");
            System.out.println(student);
            session.saveOrUpdate(student);

            tr.commit();
            out.print("Data updated successfully");

        } catch (Exception e) {
            out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateStudentDataServlet ";
    }// </editor-fold>

}
