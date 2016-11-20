/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.InsertDataServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
public class SendNews extends HttpServlet {

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

        System.out.println("Inside NewsSender servlet");

        String department = request.getParameter("department");
        String news = request.getParameter("news");

        try {
            session = sf.openSession();
            News n = new News();

            Calendar calender = Calendar.getInstance();
            String date = calender.getTime().toString();
            
            n.setDate(date);
            n.setSender("Admin");
            n.setReciever(department);
            n.setNews(news);

            session.save(n);

            session.beginTransaction().commit();
            session.close();

            System.out.println("NewsSender is ok");
            out.println("News sent successfully");

        }  catch (Exception e) {
            out.println("Exception in NewsSender:" + e.getMessage());
            e.printStackTrace();
        }

    }
    @Override
    public String getServletInfo() {
        return "NewsSender";
    }// </editor-fold>

}
