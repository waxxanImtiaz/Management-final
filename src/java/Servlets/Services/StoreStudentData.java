/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Services;

import beans.*;
import java.io.PrintWriter;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import java.util.concurrent.Callable;
import org.hibernate.Transaction;

public class StoreStudentData implements Callable {

    private Students student;
    private Session session;
    private Intermediate inter;
    private MatricInformation matric;
    public StoreStudentData(Students student,Intermediate inter,MatricInformation matric, Session session) {
        this.student = student;
        this.session = session;
        this.inter = inter;
        this.matric = matric;
    }

    @Override
    public Boolean call() {
        return storeData();
    }

    private Boolean storeData() {

        boolean flag = true;
        
        Transaction tr = session.beginTransaction();
        
        String pk = (String) session.save(student);
        
        System.out.println("pk=" + pk);
        tr.commit();
        session.evict(student);
        
        
        if (pk == null) {
            System.err.println("student data not stored");
            flag = false;
        }
        
        tr = session.beginTransaction();
        
        pk = (String) session.save(inter);
        
        tr.commit();
        session.evict(inter);
        
        if (pk == null) {
            System.err.println("inter data not stored");
            flag = false;
        }
        
        
        tr = session.beginTransaction();
        
        pk = (String) session.save(matric);
        
        tr.commit();
        session.evict(matric);
        
        if (pk == null) {
            System.err.println("matric data not stored");
            flag = false;
        }
        
        if(flag){
            System.err.println("All student data stored successfully");
        }
         return flag;
    }

}
