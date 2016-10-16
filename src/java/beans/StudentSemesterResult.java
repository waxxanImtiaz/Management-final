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
public class StudentSemesterResult {
    private int id;
    private String semester;
    private String rollNum;
    private String depart;
    private String subject;
    private String result;
    private String batch;
    private String theoryOrPractical;
    private String semesterState;  

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
     * @return the rollNum
     */
    public String getRollNum() {
        return rollNum;
    }

    /**
     * @param rollNum the rollNum to set
     */
    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    /**
     * @return the depart
     */
    public String getDepart() {
        return depart;
    }

    /**
     * @param depart the depart to set
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
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

    /**
     * @return the semesterState
     */
    public String getSemesterState() {
        return semesterState;
    }

    /**
     * @param semesterState the semesterState to set
     */
    public void setSemesterState(String semesterState) {
        this.semesterState = semesterState;
    }
}
