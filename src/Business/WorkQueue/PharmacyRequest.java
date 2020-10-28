/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author swarnadeekshitha
 */
public class PharmacyRequest extends WorkRequest{
    private String vaccineStatus;

    public String getPharmacyStatus() {
        return vaccineStatus;
    }

    public void setPharmacyStatus(String pharmacyStatus) {
        this.vaccineStatus = pharmacyStatus;
    }
    
    
}
