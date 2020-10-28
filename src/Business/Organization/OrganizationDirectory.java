/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationDirectory;

    public OrganizationDirectory() {
        organizationDirectory= new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationDirectory() {
        return organizationDirectory;
    }
     
    public Organization addOrganization(Type type){
        Organization organization = null;
        if(type.getValue().equals(Type.Vaccination.getValue())){
            organization= new NurseOrganization();
            organizationDirectory.add(organization);
        }
        
        
        else if(type.getValue().equals(Type.Doctor.getValue())){
            organization= new DoctorOrganization();
            organizationDirectory.add(organization);
        }
        else if(type.getValue().equals(Type.Pharmacy.getValue())){
            organization= new PharmacyOrganization();
            organizationDirectory.add(organization);
        }
    return organization;
    
    
}
     public void deleteOrganization(Organization org){
         organizationDirectory.remove(org);
       
        
    }
}
