/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Services;

import beans.*;
import java.util.concurrent.Callable;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author waxxan
 */
public class MatricEduDataLoader implements Callable {
     private MatricInformation matric;
    private HttpServletRequest request;
    
    
    public MatricEduDataLoader(MatricInformation matric,HttpServletRequest request){
        this.request = request;
        this.matric = matric;
    }
    @Override 
    public MatricInformation call(){
        return getInterData();
    }
    private MatricInformation getInterData(){
         //printWriter.println("true");
            String collageName = request.getParameter("matricCollageName");
            String grade = request.getParameter("matricGrade");
            String passingYear = request.getParameter("matricPassingYear");
            String totalMarks = request.getParameter("matricTotalMarks");
            String obtainedMarks = request.getParameter("matricObtainedMarks");
            String district = request.getParameter("matricDistrict");
            String board = request.getParameter("matricBoard");

            
            
           matric.setBoard(board);
           matric.setSchoolName(collageName);
           matric.setDistrict(district);
           matric.setGrade(grade);
           matric.setTotalMarks(totalMarks);
           matric.setObtainedMarks(obtainedMarks);
           matric.setPassingYear(passingYear);
            
             
            
            return matric;
    }
}
