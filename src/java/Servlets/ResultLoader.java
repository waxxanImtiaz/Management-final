/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class ResultLoader extends HttpServlet {

    private Session hibernateSession;
    private Students student;
    private PrintWriter pw;
    private Criteria criteria;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private List<StudentSemesterResult> resultList;
    private Map<String, Integer> result;
    private List<Subjects> theoryOrPractical;
    private List<StudentSemesterResult> list;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        pw = response.getWriter();
        String semester = request.getParameter("semester");
        this.request = request;
        this.response = response;
        student = (Students) request.getSession().getAttribute("personalInfo");

        SessionFactory sf = (SessionFactory) request.getServletContext().getAttribute("sessionFactory");

        hibernateSession = sf.openSession();
        //GET CRITERIA
        criteria = hibernateSession.createCriteria(StudentSemesterResult.class);
        list = criteria.list();
        System.out.println("result size="+list.size());
        semesterAttendance(semester);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is StudentChecker Servlet";
    }// </editor-fold>

    public void secondSemester() {

    }

    public void semesterAttendance(String semester) {
        Criteria c = null;
        try {

            getResultListOf("theory", list, semester);
            System.out.println("first semester result=" + resultList.size());
            //for theroy subjects
            //alterList(resultList, semester, "theory");
            //countResult(theoryOrPractical);
            request.getSession().setAttribute("theorySubjects", getSubjects("theory",semester,student.getDepartment()));
            request.getSession().setAttribute("theoryResult", resultList);
            //for practical subjects
            //getResultListOf("practical", list, semester);
            System.out.println("Practical Result");
           // alterList(resultList, semester, "practical");
            //countResult(theoryOrPractical);
            getResultListOf("practical", list, semester);
            request.getSession().setAttribute("practicalResult", resultList);
            request.getSession().setAttribute("practicalSubjects", getSubjects("practical",semester,student.getDepartment()));
            //request.getSession().setAttribute("studentAttendance", resultList);

            request.getSession().setAttribute("yearOrSemseter", semester);

            response.sendRedirect("about-us/result.jsp");
        } catch (Exception e) {
            System.out.println("Exception in first semester " + e.getMessage());
        }
    }//END OF METHOD

    public void getResultListOf(String type, List<StudentSemesterResult> list, String semester) {
        resultList = new ArrayList<StudentSemesterResult>();
        for (StudentSemesterResult st : list) {
            //GET CURRENT STUDENT
            System.out.println(st.getSemester()+","+semester+",roll avail="+st.getRollNum()+
                    ", requested="+student.getRollNum()+",avail="+st.getTheoryOrPractical()+",request="+type);
            
            System.out.println(st.getTheoryOrPractical().equalsIgnoreCase(type));
            if (st.getSemester().equalsIgnoreCase(semester) && st.getRollNum().equalsIgnoreCase(student.getRollNum())
                    && st.getTheoryOrPractical().equalsIgnoreCase(type)) {
                resultList.add(st);
                
                System.out.println(type + "," + st.getSubject() + "," + st.getTheoryOrPractical());
            }//end of else if
        }//END OF LOOP
    }//end of getResultListOf method

    public List<Subjects> getSubjects(String type,String semester,String depart){
        if (depart.contains("computer system") || depart.contains("Computer System")) {
            depart = "CS";
        }
        String hql = "FROM Subjects s WHERE s.semester = '" + semester + "' and s.department='" + depart + "' and s.theoryOrPractical='" + type + "'";
        Query query = hibernateSession.createQuery(hql);
        
        return query.list();
    }
    /*============================*/
    public void alterList(List<StudentSemesterResult> students, String semester, String type) {
        String depart = student.getDepartment();

        if (depart.contains("computer system") || depart.contains("Computer System")) {
            depart = "CS";
        }
        String hql = "FROM Subjects s WHERE s.semester = '" + semester + "' and s.department='" + depart + "' and s.theoryOrPractical='" + type + "'";
        Query query = hibernateSession.createQuery(hql);
        theoryOrPractical = query.list();
        System.out.println("TheroyOrPractical subject list=" + theoryOrPractical.size());

    }//END OF alterList METHOD

    /*============================COUNT ATTENDANCE USING SUBJECTS===============*/
    public void countResult(List<Subjects> subjects) {
        int size = subjects.size();
        result = new HashMap<String, Integer>();

        System.out.println("Couting result");
        for (int i = 0; i < size; i++) {
            String sub = subjects.get(i).getSubjectName();
            int count = 0;
            for (int j = 0; j < resultList.size(); j++) {
                String subj = resultList.get(j).getSubject();
                if (subj.equalsIgnoreCase(sub)) {
                    ++count;
                    // System.out.println(sub+" "+count);
                }
            }//END OF INNER LOOP
            result.put(sub, count);
        }//END OF OUTER LOOP
        System.out.println("Total result");
        for (Map.Entry map : result.entrySet()) {
            System.out.println(map.getKey() + "==" + map.getValue());
        }
    }//END OF METHOD
}
