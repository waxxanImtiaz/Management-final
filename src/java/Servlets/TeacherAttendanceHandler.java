/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.StudentAttendance;
import beans.Students;
import beans.Subjects;
import beans.TeacherSubjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeacherAttendanceHandler extends HttpServlet {

    private Configuration cf;
    private SessionFactory sf;
    private Session session;
    private String subj;
    private String department;
    private Subjects subject;
    private String currentDate;
    private Students st;
    private String rollNumber;
    private PrintWriter pw;

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

        rollNumber = request.getParameter("rollNumber");
        subj = (String) request.getSession().getAttribute("subjectName");

        pw = response.getWriter();

        Criteria cr = session.createCriteria(Subjects.class);
        List<Subjects> subjects = cr.list();

        for (Subjects sub : subjects) {
            if (sub.getSubjectName().equalsIgnoreCase(subj)) {
                subject = sub;
                break;
            }
        }
        st = (Students) request.getSession().getAttribute(rollNumber);

        currentDate = new SimpleDateFormat("dd/MMMM/YYYY").format(new Date());
        if (checkStudent()) {
            insertAttendance();
        } else {
            pw.println("Sorry! " + st.getRollNum() + ",s attendance already inserted!");
        }
    }

    public boolean checkStudent() {
        Criteria cr = session.createCriteria(StudentAttendance.class);
        List<StudentAttendance> att = cr.list();

        for (StudentAttendance a : att) {
            if (a.getLectureDate().equalsIgnoreCase(currentDate) && a.getRollNum().equalsIgnoreCase(st.getRollNum())
                    && a.getSubject().equalsIgnoreCase(subj)) {
                return false;
            }
        }
        return true;
    }

    public void insertAttendance() {
        Transaction tr = session.beginTransaction();

        //STUDENT ATTANDENCE
        StudentAttendance studentAttendance = new StudentAttendance();

        studentAttendance.setAttendance("P");
        studentAttendance.setLectureDate(currentDate);
        studentAttendance.setRollNum(st.getRollNum());
        studentAttendance.setTheoryOrPractical("theory");
        studentAttendance.setSubject(subj);
        studentAttendance.setSemester(subject.getSemester());
        studentAttendance.setBatch(st.getBatch());
        studentAttendance.setDepart(st.getDepartment());
        studentAttendance.setSemesterState("yes");

        //INSERT ATTENDANCE OBJECT
        session.save(studentAttendance);
        tr.commit();
        session.evict(studentAttendance);

        pw.println("Attendance of " + st.getRollNum() + " is inserted");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
