/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controller.Fields;
import controller.Initialiazer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import beans.*;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author waxxan
 */
public class SemesterChecker extends HttpServlet {

    private Session hibernateSession;
    private Students student;
    private PrintWriter pw;
    private Criteria criteria;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private List<StudentAttendance> attendanceList;
    private Map<String, Integer> attendance;
    private List<Subjects> theoryOrPractical;
    private List<StudentAttendance> list;

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
        criteria = hibernateSession.createCriteria(StudentAttendance.class);
        list = criteria.list();
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

            getAttendanceListOf("theory", list, semester);
            System.out.println("first semester attendance=" + attendanceList.size());
            //for theroy subjects
            alterList(attendanceList, semester, "theory");
            countAttendance(theoryOrPractical);
            request.getSession().setAttribute("theorySubjects", theoryOrPractical);
            request.getSession().setAttribute("theoryAttendance", attendance);
            //for practical subjects
            getAttendanceListOf("practical", list, semester);
            System.out.println("Practical Attendance");
            alterList(attendanceList, semester, "practical");
            countAttendance(theoryOrPractical);
            request.getSession().setAttribute("practicalAttendace", attendance);
            request.getSession().setAttribute("practicalSubjects", theoryOrPractical);
            //request.getSession().setAttribute("studentAttendance", attendanceList);

            request.getSession().setAttribute("yearOrSemseter", semester);

            response.sendRedirect("about-us/attendance.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in first semester " + e.getMessage());
        }
    }//END OF METHOD

    public void getAttendanceListOf(String type, List<StudentAttendance> list, String semester) {
        attendanceList = new ArrayList<StudentAttendance>();

        
        System.out.println("type="+type);
        for (StudentAttendance st : list) {
            System.out.println(st.getTheoryOrPractical());
            
            //GET CURRENT STUDENT
            if (st.getSemester().equalsIgnoreCase(semester) && st.getRollNum().equalsIgnoreCase(student.getRollNum())
                    && st.getAttendance().equalsIgnoreCase("p")
                    && st.getTheoryOrPractical().equalsIgnoreCase(type)) {
                     attendanceList.add(st);
                System.out.println(type + "," + st.getSubject() + "," + st.getTheoryOrPractical());
            }//end of else if
        }//END OF LOOP
            
        System.out.println("attendanceList "+type+"=" + attendanceList.size());
    }//end of getAttendanceListOf method

    /*============================*/
    public void alterList(List<StudentAttendance> students, String semester, String type) {
        String depart = student.getDepartment();

       
//        String hql = "FROM Subjects s WHERE s.semester = '" + semester + "' and s.department='" + depart + "' and s.theoryOrPractical='" + type + "'";
//        Query query = hibernateSession.createQuery(hql);
//        theoryOrPractical = query.list();
        Criteria cr = hibernateSession.createCriteria(Subjects.class);
        theoryOrPractical = new ArrayList<Subjects>();
        List<Subjects> sub = cr.list();
        
        for(Subjects s : sub ){
            if(s.getSemester().equalsIgnoreCase(semester)
                    && s.getDepartment().equalsIgnoreCase(depart) && s.getTheoryOrPractical().equalsIgnoreCase(type))
                theoryOrPractical.add(s);
        }
        
        
        
        System.out.println("TheroyOrPractical list=" + theoryOrPractical.size());

    }//END OF alterList METHOD

    /*============================COUNT ATTENDANCE USING SUBJECTS===============*/
    public void countAttendance(List<Subjects> subjects) {
        int size = subjects.size();
        attendance = new HashMap<String, Integer>();

        System.out.println("Couting attendance");
        for (int i = 0; i < size; i++) {
            String sub = subjects.get(i).getSubjectName();
            int count = 0;
            for (int j = 0; j < attendanceList.size(); j++) {
                String subj = attendanceList.get(j).getSubject();
                if (subj.equalsIgnoreCase(sub)) {
                    ++count;
                    // System.out.println(sub+" "+count);
                }
            }//END OF INNER LOOP
            attendance.put(sub, count);
        }//END OF OUTER LOOP
        System.out.println("Total Attendance");
        for (Map.Entry map : attendance.entrySet()) {
            System.out.println(map.getKey() + "==" + map.getValue());
        }
    }//END OF METHOD
}//END OF CLASS
