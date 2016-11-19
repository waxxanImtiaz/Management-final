/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.Subjects;
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

/**
 *
 * @author waxxan
 */
public class InsertSubjectData extends HttpServlet {

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

        String department = request.getParameter("department");
        String subjectName = request.getParameter("subjectName");
        String semester = request.getParameter("semester");
        String theoryOrPractical = request.getParameter("theoryOrPractical");
        String creditHours = request.getParameter("creditHours");
        String totalLectures = request.getParameter("totalLectures");

        try {
            session = sf.openSession();
            Subjects subject = new Subjects();

            subject.setCreditHours(creditHours);
            subject.setDepartment(department);
            subject.setSemester(semester);
            subject.setSubjectName(subjectName);
            subject.setTotalLectures(totalLectures);
            subject.setTheoryOrPractical(theoryOrPractical);

            if (isOkSubject(subject)) {
                session.save(subject);

                session.beginTransaction().commit();
                session.close();

                out.println("Subject data stored successfully");
            } else {
                out.println("Subject already existis");
            }

        } catch (Exception e) {
            out.println("Exception in InsertSubjectData:" + e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean isOkSubject(Subjects subject) {
        Criteria cr = session.createCriteria(Subjects.class);
        List<Subjects> subList = cr.list();

        for (Subjects s : subList) {
            if (s.getSubjectName().equalsIgnoreCase(subject.getSubjectName())) {
                if (s.getDepartment().equalsIgnoreCase(subject.getDepartment())) {
                    return false;
                }
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
