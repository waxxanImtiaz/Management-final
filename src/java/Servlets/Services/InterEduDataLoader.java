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
public class InterEduDataLoader implements Callable {
    private Intermediate inter;
    private HttpServletRequest request;
    
    
    public InterEduDataLoader(Intermediate inter,HttpServletRequest request){
        this.request = request;
        this.inter = inter;
    }
    @Override 
    public Intermediate call(){
        return getInterData();
    }
    private Intermediate getInterData(){
         //printWriter.println("true");
            String collageName = request.getParameter("interCollageName");
            String grade = request.getParameter("interGrade");
            String passingYear = request.getParameter("interPassingYear");
            String totalMarks = request.getParameter("interTotalMarks");
            String obtainedMarks = request.getParameter("interObtainedMarks");
            String district = request.getParameter("interDistrict");
            String board = request.getParameter("interBoard");

           inter.setBoard(board);
           inter.setCollageName(collageName);
           inter.setDistrict(district);
           inter.setTotalMarks(totalMarks);
           inter.setObtainedMarks(obtainedMarks);
           inter.setPassingYear(passingYear);
           inter.setGrade(grade);
            return inter;
    }
    
}
