/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author swarnadeekshitha
 */
public class Patient {
    private String firstName;
    private String lastName;
    private String DOB;
    private String address;
    private int patientID;
    private String history;

    
    public Patient() {
        Random random = new Random();
        patientID = random.nextInt(1000);
    }
    public Patient(String _name, String _lname, String _DOB, String _address){
        firstName = _name;
        lastName = _lname;
        DOB = _DOB;
        address = _address;
        Random random = new Random();
        patientID = random.nextInt(1000);
        String history = "";
    }

    public String getFirstName() {
        return firstName;
    }
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void appendHistory(String s){
        history = history + "\n";
        history = history + s;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public int getPatientID() {
        return patientID;
    }



    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName+lastName;
    }
    
 }
