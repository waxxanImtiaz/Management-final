/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Complain;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author waxxan
 */
public class ComplaintHandler extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request,response);
        PrintWriter pw = response.getWriter();
        response.setContentType("text/javascript");
        response.setCharacterEncoding("UTF-8");

         sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
         session = sf.openSession();
         //get Transaction object
        Transaction tr = session.beginTransaction();
        //GET PARAMETERS
        Complain complain = new Complain();

        String name = request.getParameter("name");
        String rollNumber = request.getParameter("rollNumber");
        String complaint = request.getParameter("complain");

        Calendar cal = Calendar.getInstance();
        String time = cal.getTime().toString();
        
        complain.setDateTime(time);
        complain.setComplain(complaint);
        complain.setName(name);
        complain.setRollNumber(rollNumber);
//        //save beans
        int pk = (Integer) session.save(complain);
        tr.commit();
        session.evict(complain);
        pw.print("true");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Complaint handler servlet";
    }// </editor-fold>

}
