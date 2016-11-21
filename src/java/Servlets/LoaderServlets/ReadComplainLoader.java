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

public class ReadComplainLoader extends HttpServlet {
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
        System.out.println("Inside ReadComplainLoader");
        sf= (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {
            
            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }
            int i = Integer.parseInt(request.getParameter("id"));

            Complain complain = (Complain)session.get(Complain.class, i);

            request.getSession().setAttribute("complainRead", complain);
                
            response.getWriter().println("true");
            //response.sendRedirect("content_pages/complains/complain.jsp");
            System.out.println("All ReadComplainLoader Got");
            
        } catch (NullPointerException e) {
            System.err.println("ReadComplainLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in ReadComplainLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "ReadComplainLoader";
    }// </editor-fold>

   
}
