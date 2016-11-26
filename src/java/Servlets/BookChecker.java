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
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author waxxan
 */
public class BookChecker extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        //GET WRITER
        pw = response.getWriter();

        if (sf == null) {
            throw new NullPointerException("BookChecker: Session is null");
        }
        session = sf.openSession();
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
            checkRollNumber(details);
            criteria = session.createCriteria(LibraryBooks.class);
            if(!isValidStudent() && !rollNumber.isEmpty() ){
                pw.println("Warning! "+name+ " is not Enrolled!");
                return;
            }
            
            if (count >= 2) {
                pw.println(rollNumber + " already got " + count + " book");
                return;
            } else if (!bookAuthor.isEmpty() && !bookName.isEmpty()) {
                if (!checkBooks(criteria.list())) {
                    pw.println(bookName + " book is not available ");
                    return;
                }
            } 
           

        } catch (NullPointerException e) {
            //e.printStackTrace();
            pw.println(e.getMessage());
        }

    }

    private boolean isValidStudent() {
        Criteria c = session.createCriteria(Students.class);

        System.out.println("rollnumber="+rollNumber);
        Criterion res = Restrictions.eq("rollNum", rollNumber);

        c.add(res);

      
        List result = c.list();
        if(result != null && result.size() > 0){
            Students st = (Students)result.get(0);
            if(st.getName().equalsIgnoreCase(name)){
                System.out.println("valid student");
                return true;
            }
        }
        System.out.println("invalid student");
        return false;
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
            if (bookName.equalsIgnoreCase(this.bookName) && bookAuthor.equalsIgnoreCase(this.bookAuthor)
                    && book.getState().equalsIgnoreCase("avail")) {
                return true;
            }
        }
        return false;
    }
}
