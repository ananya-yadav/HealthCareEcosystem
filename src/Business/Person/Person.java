/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;
import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class Person {
    private String name;
    private int id;
    private static int count=0;
    private ArrayList<Patient> patientList;
    public Person() {
        id=count;
        ArrayList<Patient> list = new ArrayList<Patient>();
        patientList = list;
        count++;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Patient> getPatientList(){
        return patientList;
    }
    public void setPatientList(ArrayList<Patient> pl){
        this.patientList = pl;
    }

    public int getId() {
        return id;
    }
    public void addPatient(Patient p){
        patientList.add(p);
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
