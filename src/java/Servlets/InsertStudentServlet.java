/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Servlets.Services.InterEduDataLoader;
import Servlets.Services.MatricEduDataLoader;
import Servlets.Services.StoreStudentData;
import Servlets.Services.StudentDataChecker;
import Servlets.Services.StudentDataLoader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import beans.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;

/**
 *
 * @author waxxan
 */
public class InsertStudentServlet extends HttpServlet {

    private PrintWriter printWriter;
    private Session session;
    private Students student;
    private ExecutorService executorService;
    private Intermediate inter;
    private MatricInformation matric;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = (Session) request.getServletContext().getAttribute("hibernateSession");
        printWriter = response.getWriter();

       

       
        try {

             if (session == null) {
                  throw new NullPointerException("Hibernate Session is null");
              }
             
             
            executorService = Executors.newFixedThreadPool(5);

            //Initialize student data
            StudentDataLoader loader = new StudentDataLoader(new Students(), request);
            Future<Students> studentFuture = executorService.submit(loader);


            InterEduDataLoader interData = new InterEduDataLoader(new Intermediate(), request);
            MatricEduDataLoader matricData = new MatricEduDataLoader(new MatricInformation(), request);
            
            Future<MatricInformation> matricFuture = executorService.submit(matricData);
            Future<Intermediate> interFuture = executorService.submit(interData);
            
            
            
            student = studentFuture.get();
            
            
            //Check data..
            StudentDataChecker studentChecker = new StudentDataChecker(student, session);
            Future<Boolean> b = executorService.submit(studentChecker);
            
            inter = interFuture.get();
            matric = matricFuture.get();
            
            inter.setUniRollNum(student.getRollNum());
            matric.setUniRollNum(student.getRollNum());
            
            Boolean result = b.get();
            if (result) {
                printWriter.println("Student with " + student.getRollNum() + " already exists");
                System.out.println("Student with " + student.getRollNum() + " already exists");
                return ;
            }

            //Store student data
             //Check data..
            StoreStudentData store = new StoreStudentData(student,inter,matric, session);
            Future<Boolean> st = executorService.submit(store);
            
            result = st.get();
            
            if(result){
                printWriter.println("Data Stored Successfully");
            }
            
            executorService.shutdown();
            
        } catch (NullPointerException e) {
            System.err.println("InsertStudentServlet: null value is thrown="+e.getMessage());
            printWriter.println("NPE exception");
        }catch(NonUniqueObjectException e){
             System.err.println("Duplicate Data in table:"+e.getMessage());
        }catch(Exception e){
             System.err.println("Exceptoin in InsertStudentServlet:="+e.getMessage());
        }
    }

}
