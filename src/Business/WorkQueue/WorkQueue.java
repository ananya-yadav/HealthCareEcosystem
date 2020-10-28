/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author swarnadeekshitha
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workQueue;
    private String patientName;
    public WorkQueue() {
        workQueue= new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(ArrayList<WorkRequest> workQueue) {
        this.workQueue = workQueue;
    }
    
    public WorkRequest findRequest(String message){
       WorkRequest ret = null;
       for(WorkRequest r : workQueue){
           System.out.println("in workqueue loop: " + r.getMessage());
           if(r.getMessage().equals(message)){
               ret = r;
           }
       }
       return ret;
   }

    public WorkRequest findRequest(String name, String sender){
        for(WorkRequest req : workQueue){
            if(req.getSender().equals(sender) && req.getMessage().equals(name))
                return req;
        }
        return null;
    }


    
}
