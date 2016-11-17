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

    public StoreStudentData(Students student, Session session) {
        this.student = student;
        this.session = session;
    }

    @Override
    public Boolean call() {
        return storeData();
    }

    private Boolean storeData() {

        Transaction tr = session.beginTransaction();
        String pk = (String) session.save(student);
        System.out.println("pk=" + pk);
        tr.commit();
        session.evict(student);

        if (pk != null) {
            System.err.println("data stored successfully");
            return true;
        } else {
            System.err.println("data not stored");
            return false;
        }
    }

}
