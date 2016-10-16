/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.LibraryDetails;
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
import org.hibernate.Transaction;
import beans.*;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author waxxan
 */
public class StoreBookIssueFormData extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private List<LibraryDetails> details;
    private String bookName;
    private String rollNumber;
    private String bookAuthor;
    private String name;
    private String department;
    private String bookIssueDate;
    private String bookReturnDate;
    private PrintWriter pw;
    private int count;

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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //GET WRITER
        pw = response.getWriter();

        //GET PARAMENTERS
        bookName = request.getParameter("bookName");
        rollNumber = request.getParameter("rollNumber");
        bookAuthor = request.getParameter("bookAuthor");
        bookIssueDate = request.getParameter("bookIssueDate");
        bookReturnDate = request.getParameter("bookReturnDate");
        department = request.getParameter("department");
        name = request.getParameter("name");

        Criteria criteria = session.createCriteria(LibraryDetails.class);
        details = criteria.list();

        try {

            criteria = session.createCriteria(LibraryBooks.class);
            storeData();
            pw.println("true");
        } catch (NullPointerException e) {
            //e.printStackTrace();
            pw.println(e.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void checkRollNumber(List<LibraryDetails> libraryDetails) {
        List<LibraryDetails> temp = new ArrayList<LibraryDetails>();
        count = 0;
        // pw.println("list size in checkROllNumber="+libraryDetails.size());
        for (LibraryDetails det : libraryDetails) {
            String rollNum = det.getRollNum();
            String state = det.getState();
            if (state.equalsIgnoreCase("got") && rollNum.equalsIgnoreCase(rollNumber)) {
                temp.add(det);
                count++;
            }
        }//end of loop
        //this.details = temp;
    }//end of method

    public boolean checkBooks(List<LibraryBooks> books) {

        for (LibraryBooks book : books) {
            String bookName = book.getBookName();
            String bookAuthor = book.getAuthor();
            if (bookName.equalsIgnoreCase(bookName) && bookAuthor.equalsIgnoreCase(bookAuthor)
                    && book.getState().equalsIgnoreCase("avail")) {
                return true;
            }
        }
        return false;
    }

    public void storeData() {
        LibraryDetails booksDetails = new LibraryDetails();
        LibraryBooks b = new LibraryBooks();
        //get Transaction object
        Transaction tr = session.beginTransaction();

        booksDetails.setBookName(bookName);
        booksDetails.setDepartment(department);
        booksDetails.setIssueDate(bookIssueDate);
        booksDetails.setReturnDate(bookReturnDate);
        booksDetails.setName(name);
        booksDetails.setRollNum(rollNumber);
        booksDetails.setState("got");

        int id = getBookId(bookName, bookAuthor);

        if (id > 0) {

            try {
                System.out.println("book id=" + id);
                b = (LibraryBooks)session.get(LibraryBooks.class,id);
                b.setState("got");
                session.update(b);
                tr.commit();
                
                tr = session.beginTransaction();
                int pk = (Integer) session.save(booksDetails);
                tr.commit();
                session.evict(booksDetails);
                System.out.println("Data stored");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        //save beans
    }

    public int getBookId(String bookName, String bookAuthor) {
        List<LibraryBooks> books = new ArrayList<LibraryBooks>();
        Criteria criteria = session.createCriteria(LibraryBooks.class);

        books = criteria.list();

        books = alterList(books);
        for (LibraryBooks book : books) {
            if (book.getAuthor().equalsIgnoreCase(bookAuthor) && book.getBookName()
                    .equalsIgnoreCase(bookName) && book.getState().equalsIgnoreCase("avail")) {
                return book.getId();
            }
        }
        return 0;
    }

    public List<LibraryBooks> alterList(List<LibraryBooks> libraryBooks) {
        List<LibraryBooks> temp = new ArrayList<LibraryBooks>();

        for (int i = 0; i < libraryBooks.size(); i++) {
            String state = libraryBooks.get(i).getState();
            if (state.equalsIgnoreCase("avail")) {
                temp.add(libraryBooks.get(i));
            }
        }//end of loop

        return temp;
    }
}
