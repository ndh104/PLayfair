/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author bigbo
 */
public class Student {
    private String studentID;
    private String fullName;
    private String sex;
    private String phoneNumber;
    private String mail;
    private String address;

    public Student(){
        
    }
    public Student(String studentID, String fullName, String sex, String phoneNumber, String mail, String address) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return studentID + "\n" + fullName + "\n" + sex + "\n" + phoneNumber + "\n" + mail + "\n" + address;
    }
    
}
