package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import controller.*;
import java.util.*;
import beans.*;
import org.hibernate.Criteria;
import org.hibernate.Transaction;

/**
 *
 * @author waxxan
 */
public class Checker extends HttpServlet {

    private String username;
    private String password;
    private StudentChecker studentChecker;
    private TeacherChecker teacherChecker;
    private PrintWriter printWriter;
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    private Initialiazer initializer;
    private LibrarianChecker librarian;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            setUsername(request.getParameter("username"));
            setPassword(request.getParameter("password"));
            setPrintWriter(response.getWriter());

            //set initializer
            initializer = new Initialiazer(request, response);
            librarian = new LibrarianChecker(initializer);
            teacherChecker = new TeacherChecker(initializer);
            teacherChecker.setPassword(password);
            teacherChecker.setUserName(username);
            librarian.setUserName(getUsername());
            librarian.setPassword(getPassword());
            request.setAttribute("initializer", initializer);
            //set master..
            CheckMaster master = new CheckMaster(getUsername(), getPassword(), initializer);
            
            if (master.isMaster()) {
                storeUserInformation(request);
                System.out.println("inside master");
                if (request.getSession().isNew()) {
                            
                    System.out.println("is new");
                    request.getSession().setAttribute("username", getUsername());
                    request.getSession().setAttribute(visitCountKey, visitCount);
                     storeUserInformation(request);
                     master.getStudentChecker().goToStudentProfile();
                } else {
                    visitCount = (Integer) request.getSession().getAttribute(visitCountKey);
                    visitCount = visitCount + 1;
                    System.out.println("not new");
                    storeUserInformation(request);
                    request.getSession().setAttribute(visitCountKey, visitCount);
                    master.getStudentChecker().goToStudentProfile();
                }
                
                // setStudentChecker((StudentChecker)request.getServletContext().getAttribute("studentChecker"));
                //getStudentChecker().goToStudentProfile();
            } else if (master.getStudentChecker().isStudent()) {
                //ADD USER'S LOGIN INFORMATION
                storeUserInformation(request);

                request.getSession().setAttribute("session", "true");
                master.getStudentChecker().goToStudentProfile();
            } else if (librarian.isLibrarian()) {
                storeUserInformation(request);
                response.sendRedirect("about-us/Librarian.jsp");
            }else if (teacherChecker.isTeacher()) {
                Criteria cr = initializer.getSession().createCriteria(TeacherSubjects.class);
                request.getSession().setAttribute("username", getUsername());
                
                if(cr != null )
                {
                     storeUserInformation(request);
                    request.getSession().setAttribute("teacherSubject", cr.list());
                    response.sendRedirect("./TeacherDataLoader");
                }else
                    printWriter.println("TeacherSujbects table is empty");
            }
            else if(teacherChecker.isChairman()){
                    storeUserInformation(request);
                    request.getSession().setAttribute("department",getUsername());
                    response.sendRedirect("chairman.jsp");
            }
            else {
                 //showMessage("Invalid username or password");
                 request.getRequestDispatcher("about-us/invalidPassword.jsp").include(request, response);
               
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception in Checker:" + e.getMessage());
        }

    }//end of doPost method

    private void storeUserInformation(HttpServletRequest request) {

        LoginInformation login = new LoginInformation();
        Enumeration headerNames = request.getHeaderNames();

        //  getPrintWriter().println("<table border=\'1\'>");
        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            String paramValue = request.getHeader(paramName);
            if (paramName.equals("host")) {
                login.setHost(paramValue);
            } else if (paramName.equals("user-agent")) {
                login.setUserAgent(paramValue);
            } else if (paramName.equals("cookie")) {
                login.setCookie(paramValue);
            } else if (paramName.equals("accept")) {
                login.setAccept(paramValue);
            } else if (paramName.equals("accept-encoding")) {
                login.setAcceptEncoding(paramValue);
            } else if (paramName.equals("cookie")) {
                login.setCookie(paramValue);
            } else if (paramName.equals("cache-control")) {
                login.setCacheControl(paramValue);
            } else if (paramName.equals("connection")) {
                login.setConnection(paramValue);
            }

        }//end of while loop

        Calendar cal = Calendar.getInstance();
        
        login.setDate(cal.getTime().toString());  
        login.setUsername(this.getUsername());
        login.setPassword(this.getPassword());
        
        
        
        Session s = initializer.getSessionFactory().openSession();
        try {

            Transaction tran = s.beginTransaction();
            s.save(login);
            tran.commit();
        } catch (RuntimeException e) {
            s.getTransaction().rollback();
            throw e;
        }

    }//end of storeUserInformation method..

    private void showMessage(String message) {
        getPrintWriter().println(message);
    }//end of showMessage

    @Override
    public String getServletInfo() {
        return "This is Id and password checker servlet";
    }// end getServletInfo method

    /**
     * @return the username
     */
    private String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    private void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    private String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    private void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the printWriter
     */
    private PrintWriter getPrintWriter() {
        return printWriter;
    }

    /**
     * @param printWriter the printWriter to set
     */
    private void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    /**
     * @return the studentChecker
     */
    private StudentChecker getStudentChecker() {
        return studentChecker;
    }

    /**
     * @param studentChecker the studentChecker to set
     */
    private void setStudentChecker(StudentChecker studentChecker) {
        this.studentChecker = studentChecker;
    }

}
