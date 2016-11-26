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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author waxxan
 */
public class InsertResultData extends HttpServlet {

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

        System.out.println("Inside InsertResultData servlet");

        String department = request.getParameter("department");
        String batchName = request.getParameter("batch");
        String subjectName = request.getParameter("subjectName");
        String semester = request.getParameter("semester");
        String rollNumber = request.getParameter("rollNumber");
        String rs = request.getParameter("result");
        String theoryOrPractical = request.getParameter("theoryOrPractical");

        try {
            session = sf.openSession();
            StudentSemesterResult result = new StudentSemesterResult();

            if (checkResult(department, rollNumber, subjectName)) {
                result.setBatch(batchName);
                result.setDepart(department);
                result.setResult(rs);
                result.setSemester(semester);
                result.setSemesterState("no");
                result.setSubject(subjectName);
                result.setRollNum(rollNumber);
                result.setTheoryOrPractical(theoryOrPractical);

                session.save(result);

                session.beginTransaction().commit();
                session.close();

                System.out.println("InsertResultData is ok");
                out.println("Result data stored successfully");
            } else {
                out.println("Entered Result is Already Available");
            }

        } catch (ConstraintViolationException e) {
            out.println("Entered Result is Already Available");
        } catch (Exception e) {
            out.println("Exception in InsertResultData:" + e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean checkResult(String department, String rollNumber, String subjectName) {

        Criteria cr = session.createCriteria(StudentSemesterResult.class);
        List<StudentSemesterResult> list = cr.list();

        for (StudentSemesterResult rs : list) {
            if (rs.getDepart().equalsIgnoreCase(department) && rs.getRollNum().equalsIgnoreCase(rollNumber)
                    && rs.getSubject().equalsIgnoreCase(subjectName)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "InsertSubjectData";
    }// </editor-fold>

}
