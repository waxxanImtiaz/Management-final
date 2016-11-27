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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class SendMessage extends HttpServlet {

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

        System.out.println("Inside SendMessage servlet");

        String to = request.getParameter("to");
        String message = request.getParameter("message");

        try {
            session = sf.openSession();
            Message n = new Message();

            if(isRollNumberOk(to)){
            
            Calendar calender = Calendar.getInstance();
            String date = calender.getTime().toString();
            
            n.setDate(date);
            n.setRollNumber(to);
            n.setMessage(message);

                System.out.println("message="+message);
            session.save(n);

            session.beginTransaction().commit();
            session.close();

            System.out.println("NewsSender is ok");
            out.println("Message sent successfully");
            }else{
                out.println("Invalid Roll Number!");
            }

        }  catch (Exception e) {
            out.println("Exception in SendMessage:" + e.getMessage());
            e.printStackTrace();
        }

    }
    @Override
    public String getServletInfo() {
        return "SendMessage";
    }// </editor-fold>

    private boolean isRollNumberOk(String to){
        Criteria cr = session.createCriteria(Students.class);
        List<Students> students = cr.list();
        
        for(Students s : students){
            if(s.getRollNum().equalsIgnoreCase(to)){
                return true;
            }
        }
        return false;
    }
}
