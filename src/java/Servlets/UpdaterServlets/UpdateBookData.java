/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.UpdaterServlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servlets.Services.InterEduDataLoader;
import Servlets.Services.MatricEduDataLoader;
import Servlets.Services.StudentDataLoader;
import beans.DepartAndBatches;
import beans.Intermediate;
import beans.LibraryBooks;
import beans.MatricInformation;
import beans.Students;
import beans.Subjects;
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
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class UpdateBookData extends HttpServlet {

  
    private Session session;
    private PrintWriter out;
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

        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        
        
        try {
            session = sf.openSession();
            LibraryBooks book = new LibraryBooks();

            book.setBookName(bookName);
            book.setAuthor(bookAuthor);

            Transaction tr = session.beginTransaction();

            System.out.println("UpdateBookData");

            System.out.println("Book data in UpdateBookData");
            
             //out.println("Before Data updated successfully");
            session.merge(book);
            tr.commit();
            out.println("Data updated successfully");
            System.out.println("Data updated successfully by UpdateBookData");

        }
        catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
            
        }
    }

    @Override
    public String getServletInfo() {
        return "UpdateBookData ";
    }// </editor-fold>

}
