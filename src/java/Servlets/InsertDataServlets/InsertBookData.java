/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.InsertDataServlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class InsertBookData extends HttpServlet {

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

        String department = request.getParameter("bookName");
        String batchName = request.getParameter("bookAuthor");

        try {
            session = sf.openSession();
            LibraryBooks book = new LibraryBooks();

            book.setBookName(batchName);
            book.setAuthor(batchName);

            
            session.save(book);

            session.beginTransaction().commit();
            session.close();

            out.println("Book data stored successfully");

        } catch (ConstraintViolationException e) {
            out.println("Entered Book is Already Available");
        } catch (Exception e) {
            out.println("Exception in InsertBookData:" + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "InsertBookData";
    }// </editor-fold>

}
