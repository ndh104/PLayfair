/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author bigbo
 */
public class Teacher {
    private String teacherID;
    private String userName;
    private String fullName;
    private String sex;
    private String phoneNumber;
    private String mail ;
    private String address ;
    
    public Teacher(){
        
    }
    
    public Teacher(String teacherID, String userName, String fullName, String sex, String phoneNumber, String mail, String address) {
        this.teacherID = teacherID;
        this.userName = userName;
        this.fullName = fullName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
    }
    public Teacher(String userName, String fullName, String sex, String phoneNumber, String mail, String address) {
        this.userName = userName;
        this.fullName = fullName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return teacherID + "\n" + userName + "\n" + fullName + "\n" + sex + "\n" + phoneNumber + "\n" + mail + "\n" + address;
    }
    
}
