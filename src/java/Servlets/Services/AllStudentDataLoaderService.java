/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Services;

import beans.Students;
import java.util.List;
import java.util.concurrent.Callable;
import org.hibernate.Criteria;
import org.hibernate.Session;
public class AllStudentDataLoaderService implements Callable {
    private Session session;
    public AllStudentDataLoaderService(Session session){
        this.session = session;
    }
    @Override 
    public List<Students> call(){
        return getAllStudents();
    }
    
    public List<Students> getAllStudents(){
        Criteria cr = session.createCriteria(Students.class);
        List<Students> students = cr.list();
        
        return students;
    }
}
