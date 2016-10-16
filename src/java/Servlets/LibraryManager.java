/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.LibraryDetails;
import beans.Students;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class LibraryManager extends HttpServlet {

    private Students student;
    private Session hibernateSession;
    private List<LibraryDetails> libraryDetails;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        student = (Students) request.getSession().getAttribute("personalInfo");
        
        SessionFactory sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        hibernateSession = sf.openSession();
        Criteria criteria = hibernateSession.createCriteria(LibraryDetails.class);
        libraryDetails = criteria.list();
        alterList(libraryDetails);
        request.getSession().setAttribute("libraryDetails", libraryDetails);
        response.sendRedirect("about-us/library.jsp");
    }

    public void alterList(List<LibraryDetails> libraryDetails){
        List<LibraryDetails> temp = new ArrayList<LibraryDetails>();
        
        for(int i = 0 ; i<libraryDetails.size(); i++){
            String rollNum = libraryDetails.get(i).getRollNum();
            String state = libraryDetails.get(i).getState();
            if(state.equalsIgnoreCase("got") && rollNum.equalsIgnoreCase(student.getRollNum()))
            {
                temp.add(libraryDetails.get(i));
              }
        }//end of loop
        
        this.libraryDetails = temp;
    }//end of method
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
