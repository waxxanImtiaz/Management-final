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

public class StudentDataChecker implements Callable {
    private Students student;
    private Session session;
  
    public StudentDataChecker(Students student, Session session){
        this.student = student;
        this.session = session;
    }
    
    @Override
    public Boolean call(){
        return !isRollNumberOk(student.getRollNum());
    }
    
    public boolean isRollNumberOk( String rollNumber ){
        
        try{
        if(rollNumber != null && !rollNumber.isEmpty()){
            Criteria cr = session.createCriteria(Students.class);
            List<Students> list = cr.list();
            for(Students st : list){
                if(st.getRollNum().equalsIgnoreCase(rollNumber)){
                     return false;
                }
            }
            return true;
            
        }else{
            return false;
        } }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }
       return false;
    }
    
}
