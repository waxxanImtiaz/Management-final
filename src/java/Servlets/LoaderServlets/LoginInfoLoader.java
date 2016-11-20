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

public class LoginInfoLoader extends HttpServlet {

    private LoginInformation info;
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
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            executorService = Executors.newFixedThreadPool(1);

            LoginInfoLoaderService loader = new LoginInfoLoaderService(session);

            Future future = executorService.submit(loader);

            List<LoginInformation> batches = (List<LoginInformation>) future.get();

            request.getSession().setAttribute("loginInfo", batches);

            response.sendRedirect("content_pages/login_information.jsp");
            System.out.println("All Login data Got");
            
            executorService.shutdown();
        } catch (NullPointerException e) {
            System.err.println("LoginInfoLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in LoginInfoLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

    class LoginInfoLoaderService implements Callable {
    private Session session;
    public LoginInfoLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<LoginInformation> call(){
        return getLoginInfo();
    }
    
    public List<LoginInformation> getLoginInfo(){
        Criteria cr = session.createCriteria(LoginInformation.class);
        List<LoginInformation> batches = cr.list();
        
        return batches;
    }
}
}
