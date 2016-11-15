package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.DepartAndBatches;
import beans.Intermediate;
import beans.Master;
import beans.MatricInformation;
import beans.StudentAttendance;
import beans.Students;
import java.util.Date;


// <property name="hibernate.hbm2ddl.auto">create</property>
public class Driver {

    public static void main(String[] args) {

        //create bean objects
        //bean 1
        Master master = new Master();
        master.setDepart("Computer System Engineering");
        master.setMasterKey("computer");
        //bean 2
        DepartAndBatches departAndBatches = new DepartAndBatches();
        departAndBatches.setBatch("13");
        departAndBatches.setDepart("computer system");
        //bean 3
        Students st = new Students();
        st.setBatch("13");
        st.setCaste("wassan");
        st.setCnic("4420582182812");
        st.setDepartment("computer system");
        st.setRollNum("13_CS_19");
        st.setFatherName("Sobdar");
        st.setFtContactNum("03001230123");
        st.setGender("male");
        st.setName("Imtiaz Ali");
        st.setPassword("computer");
        st.setPermAdd("Sanghar");
        st.setStContactNum("030023123223");
        st.setStEmail("wassanimtiaz@outlook.com");
        st.setTempAdd("Mallir cantt karachi");
        
        Intermediate inter = new Intermediate();
        MatricInformation matricInformation = new MatricInformation();
        
        //INTERMEDIATE INFO
        inter.setBoard("BISE Mirpurkhas");
        inter.setCollageName("P.S.S.S.S.S Degree Collage Sanger");
        inter.setDistrict("Sanghar");
        inter.setGrade("B");
        inter.setPassingYear("2012");
        inter.setTotalMarks("850");
        inter.setUniRollNum("13_CS_19");
        inter.setObtainedMarks("712");
        
        //MATRIC INFOR
        matricInformation.setBoard("BISE Mirpurkhas");
        matricInformation.setSchoolName("GBHS JHOL");
        matricInformation.setDistrict("Sanghar");
        matricInformation.setGrade("B");
        matricInformation.setPassingYear("2012");
        matricInformation.setTotalMarks("850");
        matricInformation.setUniRollNum("13_CS_19");
        matricInformation.setObtainedMarks("712");
        
        
        //STUDENT ATTANDENCE
        StudentAttendance studentAttendance = new StudentAttendance();
        
        studentAttendance.setAttendance("P");
        studentAttendance.setLectureDate("3/10/206");
        studentAttendance.setRollNum("13_CS_19");
        studentAttendance.setTheoryOrPractical("theory");
        studentAttendance.setSubject("ITC");
        studentAttendance.setSemester("1st");
        studentAttendance.setDepart("Computer System");
        studentAttendance.setSemesterState("no");

        //configure cfg xml file
        Configuration cf = new Configuration();
        cf.configure("xmlFiles/hibernate.cfg.xml");
        
        
        
        //build session factory
        SessionFactory sf = cf.buildSessionFactory();
        //get session object
        Session session = sf.openSession();
        //get Transaction object
        Transaction tr = session.beginTransaction();
		//begin transaction
        //save beans
        session.save(st);
        tr.commit();
//        tr.begin();
        session.evict(st);
//                session.close();
        tr = session.beginTransaction();
//
        session.save(master);
//        tr.begin();
        tr.commit();
        session.evict(master);

        tr = session.beginTransaction();
		
        session.save(departAndBatches);
        tr.commit();
        session.evict(departAndBatches);
        
        tr = session.beginTransaction();
        //INSERT INTER OBJECT
        session.save(inter);
        tr.commit();
        session.evict(inter);
        
        tr = session.beginTransaction();
        //INSERT MATRICINFORMATION OBJECT
        session.save(matricInformation);
        tr.commit();
        session.evict(matricInformation);
        
         tr = session.beginTransaction();
        //INSERT ATTENDANCE OBJECT
        session.save(studentAttendance);
        tr.commit();
        session.evict(studentAttendance);
        
        
        
        //close session and session factory
        session.close();
        sf.close();
    }//end of main method..
    
}//end of class

