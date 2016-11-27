/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MessageLoader extends HttpServlet {


    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private List<Message> message;
    private List<Message> messageList;
    @Override
    public void init() {
        cf = new Configuration();
        cf.configure("xmlFiles/hibernate.cfg.xml");
        sf = cf.buildSessionFactory();
        session = sf.openSession();
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Students st =  (Students)request.getSession().getAttribute("personalInfo");
        
        Criteria messageCriteria = session.createCriteria(Message.class);
        
        messageList = new ArrayList<Message>();
        message = messageCriteria.list();
        
        for(Message m : message){
            if(m.getRollNumber().equalsIgnoreCase(st.getRollNum())){
                messageList.add(m);
                
            }
        }
        
        
        request.getSession().setAttribute("messageList", messageList);
        response.sendRedirect("about-us/messages.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
