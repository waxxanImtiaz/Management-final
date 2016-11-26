/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Students;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import beans.*;
import java.io.IOException;

public class StudentChecker extends Person {
    private Students student;
    private boolean isUsernameOkFlage;
    
    public StudentChecker(String username,String password,Initialiazer initializer)
    {
        super.setUserName(username);
        super.setPassword(password);
        super.setInitializer(initializer);
    }
    public boolean isStudent(){
        System.out.println("isStudent is called");
        System.out.println("isUsernameOkFlage="+isUsernameOkFlage);
        if(isUsernameOk() & isPasswordOk())
        {
            return true;
        }
        return false;
    }//end of isStudent method
    public boolean isUsernameOk() {
     try{
         setUserInfo();
       return true;
     }catch(IndexOutOfBoundsException e){
         System.out.println("Exception in studentChecker's method isUsernameOk()="+e.getMessage());
         return false;
     }
 }//end of isUsernameOk method

    
      private boolean isPasswordOk(){
      try{
        if(isUsernameOk())
        {
        String pass = getStudent().getPassword();
        
        if(pass.equals(getPassword()))
        {
            return true;
        }else{
            return false;
        }
        }//end of outer if else
      }catch(Exception e){
          System.out.println("exception in isPasswordOk "+e.getMessage());
          e.printStackTrace();
          return false;
      }
      return false;
      
  }//end of isPasswordOk method
      
      public void setUserInfo(){
          Criteria c = null;
          try{
          //GET STUDENTS DATA
          c = getInitializer().getSession().createCriteria(Students.class);
          c.add(Restrictions.eq("rollNum", getUserName()));
          List result = c.list();
          setStudent((Students)result.get(0));
          
          //GET MATRICULATION INFOR
          c = getInitializer().getSession().createCriteria(MatricInformation.class);
          c.add(Restrictions.eq("uniRollNum", getUserName()));
          result = c.list();
          Fields.setMatricInformation((MatricInformation)result.get(0));
          
          //GET INTER INFOR
          c = getInitializer().getSession().createCriteria(Intermediate.class);
          c.add(Restrictions.eq("uniRollNum", getUserName()));
          result = c.list();
          Fields.setIntermediate((Intermediate)result.get(0));
          System.out.println("board="+Fields.getIntermediate().getBoard());
          System.out.println("User information is set");
          }catch (Exception e){
              System.err.println("Exception in setUserInfo "+e.getMessage());
          }
          
      }
      public void goToStudentProfile(){
      try{
         //go to profile of student
          super.getInitializer().getRequest().getSession().setAttribute("personalInfo", getStudent());  
          super.getInitializer().getRequest().getSession().setAttribute("inter", Fields.getIntermediate());  
          super.getInitializer().getRequest().getSession().setAttribute("matric", Fields.getMatricInformation());  
          super.getInitializer().getResponse().sendRedirect("about-us/index.jsp");
         
      }catch(IOException e)
      {
          
      }
  }//end of goToStudentProfile method
    /**
     * @return the student
     */
    public Students getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Students student) {
        this.student = student;
    }


}
