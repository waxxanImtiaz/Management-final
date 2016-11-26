/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.LoaderServlets;

import Servlets.Services.AllStudentDataLoaderService;
import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class SubjectLoader extends HttpServlet {

    private Session session;
    private SessionFactory sf;
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");
        try {

            session = sf.openSession();
            if (session == null) {
                throw new NullPointerException("Hibernate Session is null");
            }

            String department = request.getParameter("department");
            out = response.getWriter();
            Criteria cr = session.createCriteria(Subjects.class);
            // cr.add(Restrictions.eq("department", department));
            List<Subjects> sb = cr.list();

            System.out.println("Department subjects");
            for (Subjects s : sb) {
                System.out.println(s.getSubjectName());
            }

            String[] subjects = new String[sb.size()];
            for (int i = 0; i < subjects.length; i++) {
                if (sb.get(i).getDepartment().equalsIgnoreCase(department)) {
                    subjects[i] = sb.get(i).getSubjectName();
                }
            }

            System.out.println("Convert into json object");
            String jsonString = "";

            JSONArray jsonArray = new JSONArray();
            JSONObject subjectsJson = new JSONObject();
            
            for (int j = 0; j < subjects.length; j++) {
                subjectsJson.put("subject".concat(j+""), subjects[j]);
            }

            

            
            jsonArray.add(subjectsJson);
            out.println(subjectsJson);
            System.out.println("Subjects Got");
        } catch (NullPointerException e) {
            System.err.println("SubjectsLoader: null value is thrown=" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceptoin in SubjectsLoader:=" + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "AllStudentLoader";
    }// </editor-fold>

}
