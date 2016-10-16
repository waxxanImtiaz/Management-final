/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.StudentAttendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertAttendance {
        public static void main(String[] args) {
            //configure cfg xml file
        Configuration cf = new Configuration();
        cf.configure("xmlFiles/hibernate.cfg.xml");

        //build session factory
        SessionFactory sf = cf.buildSessionFactory();
        //get session object
        Session session = sf.openSession();
        //get Transaction object
        Transaction tr = session.beginTransaction();
        
        
          //STUDENT ATTANDENCE
        StudentAttendance studentAttendance = new StudentAttendance();
        
        studentAttendance.setAttendance("P");
        studentAttendance.setLectureDate("20/7/2013");
        studentAttendance.setRollNum("13_CS_19");
        studentAttendance.setTheoryOrPractical("practical");
        studentAttendance.setSubject("BEE");
        studentAttendance.setSemester("2nd");
        studentAttendance.setBatch("13");
        studentAttendance.setDepart("Computer System");
        studentAttendance.setSemesterState("no");

        
        
        //INSERT ATTENDANCE OBJECT
        session.save(studentAttendance);
        tr.commit();
        session.evict(studentAttendance);
        
        
        
        //close session and session factory
        session.close();
        sf.close();
        
        }
}
