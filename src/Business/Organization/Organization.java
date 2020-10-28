/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Patient.PatientDirectory;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public abstract class Organization {
    private String organizationName;
    private int organizationID;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;

    private static int count=0;
    private WorkQueue workQueue;
    public enum Type{
        Admin("AdminOrganization"),Vaccination("VaccinationOrganization"),Doctor("DoctorOrganization"),Pharmacy("PharmacyOrganization");
        private String value;
        private Type(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }

    public Organization(String organizationName) {
        this.organizationName = organizationName;
        personDirectory= new PersonDirectory();
        userAccountDirectory= new UserAccountDirectory();
        workQueue= new WorkQueue();
        organizationID=count;
        ++count;
    }

    public abstract ArrayList<Role> getSupportedRole();
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }



    public int getOrganizationID() {
        return organizationID;
    }

    @Override
    public String toString() {
        return organizationName;
    }
    
}
