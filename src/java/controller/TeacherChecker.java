/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author waxxan
 */
public class TeacherChecker extends Person {

    private Initialiazer init;
    private Teacher teacher;

    public TeacherChecker(Initialiazer init) {
        super.setInitializer(init);
    }

    public boolean isTeacher() {
        try {
            Criteria c = getInitializer().getSession().createCriteria(Teacher.class);
            System.out.println("username="+getUserName());
            c.add(Restrictions.eq("username", getUserName()));
            System.out.println("inside isTeacher()");
            List result = c.list();
            if (result != null) {
                result = c.add(Restrictions.eq("password", getPassword())).list();
                if (result != null) {
                    setTeacher((Teacher) result.get(0));
                    return true;
                }else
                    return false;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception in Librarian=" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @return the librarian
     */
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
