/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author waxxan
 */
public class Subjects {
    private int id;
    private String subjectName;
    private String department;
    private String semester;
    private String theoryOrPractical;
    private String totalLectures;
    private String creditHours;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the totalLectures
     */
    public String getTotalLectures() {
        return totalLectures;
    }

    /**
     * @param totalLectures the totalLectures to set
     */
    public void setTotalLectures(String totalLectures) {
        this.totalLectures = totalLectures;
    }

    /**
     * @return the creditHours
     */
    public String getCreditHours() {
        return creditHours;
    }

    /**
     * @param creditHours the creditHours to set
     */
    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * @return the theoryOrPractical
     */
    public String getTheoryOrPractical() {
        return theoryOrPractical;
    }

    /**
     * @param theoryOrPractical the theoryOrPractical to set
     */
    public void setTheoryOrPractical(String theoryOrPractical) {
        this.theoryOrPractical = theoryOrPractical;
    }
   
}
