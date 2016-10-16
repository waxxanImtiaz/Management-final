/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.StudentAttendance;
import beans.Subjects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author waxxan
 */
public class InsertSubjects {

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

        //SUBJECTS OF CS
//          Subjects subjects = new Subjects();
//          subjects.setDepartment("comptuer system");
//          subjects.setSemester("1st");
//          subjects.setSubjectName("Calculus");
//        //INSERT ATTENDANCE OBJECT
//        session.save(subjects);
//        tr.commit();
//        session.evict(subjects);
        //close session and session factory
        session.close();
        sf.close();

    }
}
