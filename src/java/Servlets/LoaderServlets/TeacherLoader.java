/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;


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
import java.util.concurrent.Callable;
import org.hibernate.Criteria;

public class TeacherLoader extends HttpServlet {

    private Session session; 
    private SessionFactory sf;
    private ExecutorService executorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sf= (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        System.out.println("Inside all TeacherLoader");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            AllTeacherDataLoaderService loader = new AllTeacherDataLoaderService(session);

            Future future = executorService.submit(loader);

            List<Teacher> batches = (List<Teacher>) future.get();

            request.getSession().setAttribute("allTechers", batches);

            response.sendRedirect("content_pages/teacher/view_teacher.jsp");
            System.out.println("All TeacherLoader Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("TeacherLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in TeacherLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

    class AllTeacherDataLoaderService implements Callable {
    private Session session;
    public AllTeacherDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Teacher> call(){
        return getAllTeachers();
    }
    
    public List<Teacher> getAllTeachers(){
        Criteria cr = session.createCriteria(Teacher.class);
        List<Teacher> teacher = cr.list();
        
        return teacher;
    }
}
}
