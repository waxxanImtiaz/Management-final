/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import Servlets.Services.AllStudentDataLoaderService;
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

public class AllStudentLoader extends HttpServlet {

    private Students student;
    private Session session;
    private ExecutorService executorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        try {

            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllStudentDataLoaderService loader = new AllStudentDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Students> students = (List<Students>) future.get();

            request.getSession().setAttribute("allStudents", students);

            response.sendRedirect("content_pages/student_list.jsp");
            System.out.println("data got");
        } catch (NullPointerException e) {
            System.err.println("AllStudentLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in AllStudentLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

}
