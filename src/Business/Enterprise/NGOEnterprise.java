/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class NGOEnterprise extends Enterprise{
    private PatientDirectory patientDirectory;
    public NGOEnterprise(String name){
        super(name,EnterpriseType.NGO);
                patientDirectory= new PatientDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
   
    }

