/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author bigbo
 */
public class Transcript {
    private String teacherID;
    private String studentID;
    private String subID;
    private Float point;
    
    public Transcript(){
        
    }

    public Transcript(String teacherID, String studentID, String subID, Float point) {
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.subID = subID;
        this.point = point;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return teacherID + "\n" + studentID + "\n" + subID + "\n" + point;
    }
    
}
