/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class PatientDirectory {
    private ArrayList<Patient> patientDirectory;

    public PatientDirectory() {
        patientDirectory=new ArrayList<>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(ArrayList<Patient> patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    public Patient findPatientById(int id){
        int s = 0;
        for(Patient p : patientDirectory){
             s = p.getPatientID();
            if(id ==s){
                return p;
            }
        }
        return null;
    }
    public Patient findPatientByName(String name){

        for(Patient p : patientDirectory){
            String s = p.getFirstName();
            if(s.equals(name)){
                return p;
            }
        }
        return null;
    }
    public void addPatient(Patient p){
        patientDirectory.add(p);
    }

    
}
