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

public class NewsLoader extends HttpServlet {


    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private List<News> news;
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
        
        
        Criteria newsCriteria = session.createCriteria(News.class);
        news = newsCriteria.list();
        
        request.getSession().setAttribute("news", news);
        
        
        request.getSession().setAttribute("news",news);
        response.sendRedirect("about-us/news.jsp");
        System.out.println("News:");
        for(News n: news){
            System.out.println("Date:"+n.getDate());
            System.out.println("News:"+n.getNews());
            System.out.println("News Id:"+n.getId());
            System.out.println("");
        }
        
        
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
