/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author bigbo
 */
public class Subject {
    private String subID;
    private String subName;
    private int subCredits;
    
    public Subject(){
        
    }
    
    public Subject(String subID, String subNameString, int subCredits) {
        this.subID = subID;
        this.subName = subNameString;
        this.subCredits = subCredits;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubCredits() {
        return subCredits;
    }

    public void setSubCredits(int subCredits) {
        this.subCredits = subCredits;
    }

    @Override
    public String toString() {
        return subID + "\n" + subName + "\n" + subCredits;
    }
    
}
