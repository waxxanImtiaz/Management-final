/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Editors;
import beans.DepartAndBatches;
import beans.Intermediate;
import beans.LibraryBooks;
import beans.MatricInformation;
import beans.Students;
import beans.Subjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class BookEditor extends HttpServlet {

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

        String id = request.getParameter("id");
//        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        session = sf.openSession();

//        List<DepartAndBatches> allSubjects = (List<DepartAndBatches>) request.getSession().getAttribute("allBatches");
        System.out.println("Inside BookEditor");

        int i = Integer.parseInt(id);
        
        LibraryBooks b = (LibraryBooks) session.get(LibraryBooks.class, i);

        request.getSession().setAttribute("book", b);

        response.getWriter().println("true");
        System.out.println("BookEditor is ok");
        //response.sendRedirect("content_pages/edit_student.jsp");
        return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "BookEditor";
    }// </editor-fold>

}

