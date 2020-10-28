/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NurseRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VaccinationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import Business.Patient.PatientDirectory;
import Business.Patient.Patient;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author raunak
 */
public class NurseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private NurseOrganization vaccOrganization;
    private PharmacyOrganization pharmaOrganization;
    private Network network;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public NurseWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, NurseOrganization organization,EcoSystem business,Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = enterprise;
        this.network=network;
        this.vaccOrganization = (NurseOrganization)organization;
        
        populateTable();
        populateVaccinationTable();
        
    }
    
    public void populateTable(){
       DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();

       model.setRowCount(0);
       
       for(WorkRequest request : vaccOrganization.getWorkQueue().getWorkQueue()){
           Object[] row = new Object[5];
           row[0] = request;
           row[1] = request.getSender().getUsername();
         
           row[2] = request.getReceiver() == null ? null : request.getReceiver().getUsername();
           row[3] = request.getStatus();
           row[4] = request.getPatientName();
           model.addRow(row);
       }
   }
    
    public void populateTable(String s, String name){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        if(s==null)
            return;
        if(!s.equals(""))
            enterprise.getPatientDirectory().findPatientByName(name).setHistory(s);
            
        model.setRowCount(0);
        
        for(WorkRequest request : vaccOrganization.getWorkQueue().getWorkQueue()){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender().getPerson().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
            row[3] = request.getStatus();
            row[4] = request.getPatientName();
            model.addRow(row);
        }
    }
    
     public void populateVaccinationTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest r : userAccount.getWorkQueue().getWorkQueue()){
            if (r.getQuantity()==0){
                r.setStatus("Out of Stock");
            }
        }
            for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
                Object[] row = new Object[5];
                row[0] = request.getMessage();
                row[1] = request.getSender();
                row[2] = request.getReceiver();
                row[3] = request.getQuantity();
                String result = ((WorkRequest) request).getStatus();
                row[4] = result == null ? "Waiting" : result;

                model.addRow(row);
               
            }
           
        
    }
    public void populateVaccinationTable(int index){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        model.setRowCount(0);
        
            for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
                if(index >=1){
                    index--;
                    continue;
                }
                Object[] row = new Object[5];
                row[0] = request.getMessage();
                row[1] = request.getSender();
                row[2] = request.getReceiver();
                row[3] = request.getQuantity();
                String result = ((WorkRequest) request).getStatus();
                row[4] = result == null ? "Waiting" : result;

                model.addRow(row);
            }
           
        
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g)
            {
                ImageIcon img=new ImageIcon("health logo20.png");
                Image i=img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height,this);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RestockJButton = new javax.swing.JButton();
        RequestVaccineBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("My Tasks");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Patient"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 560, 96));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Request Vaccine Stock");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        RestockJButton.setText("Restock");
        RestockJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestockJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RestockJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        RequestVaccineBtn.setText("Request Vaccine");
        RequestVaccineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestVaccineBtnActionPerformed(evt);
            }
        });
        jPanel1.add(RequestVaccineBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Sender", "Order Fulfiller", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 560, 130));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateTable("","");
        
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        int col = 4;
        int typeCol = 0;
        System.out.println(selectedRow+ " SELECTED ROW");
        if (selectedRow == -1){
            return;
        }
        String typetocheck = workRequestJTable.getValueAt(selectedRow, typeCol).toString();
        String statuscheck = workRequestJTable.getValueAt(selectedRow, 3).toString();
        Object receivercheck = workRequestJTable.getValueAt(selectedRow, 2);
   
        
        if(statuscheck.equals("Completed")){
            System.out.println("ALREADY COMPLETED");
            JOptionPane.showMessageDialog(null, "This Request was already completed!");
            return;
        }
        else if(statuscheck.equals("Order Delivered")){
           
           JOptionPane.showMessageDialog(null, "The Package has arrived, but you need to restock "+typetocheck + " vaccine!");
           return;
       }
        else if(receivercheck==null){
            JOptionPane.showMessageDialog(null, "Work request needs to be assigned first!");
            return;
        }
        else if(statuscheck.equals("Processing")){
                    String name = workRequestJTable.getValueAt(selectedRow, col).toString();
                    Patient p = enterprise.getPatientDirectory().findPatientByName(name);
                    VaccinationRequest request = (VaccinationRequest)workRequestJTable.getValueAt(selectedRow, 0);
                    ProcessDoctorWorkRequestJPanel processWorkRequestJPanel = new ProcessDoctorWorkRequestJPanel(userProcessContainer, request, enterprise, name);
                    userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
        }
        else{
           
           int found =0;

        for(int i =0; i < jTable1.getRowCount(); ++i){
            String s = jTable1.getValueAt(i, typeCol).toString();
            if(s.equals(typetocheck)){
                if(Integer.parseInt(jTable1.getValueAt(i, 3).toString()) == 0){
                    continue;
                }
                found =1;
                if(Integer.parseInt(jTable1.getValueAt(i, 3).toString()) ==0){
                    JOptionPane.showMessageDialog(null, "Out of Stock Please Order More " + typetocheck + " vaccine!");
                    return;
                }
                if(jTable1.getValueAt(i,4).equals("Completed"))
                    JOptionPane.showMessageDialog(null, "This Vaccination is already completed!");
                if(jTable1.getValueAt(i,4).equals("Vaccine requested"))
                    JOptionPane.showMessageDialog(null, "Need to restock " + typetocheck + " vaccine!");
                if(Integer.parseInt(jTable1.getValueAt(i, 3).toString()) >=1 && jTable1.getValueAt(i,4).equals("In Stock")){
                    int newVal = Integer.parseInt(jTable1.getValueAt(i, 3).toString());  
                    newVal--;
                    WorkRequest r = userAccount.getWorkQueue().findRequest(typetocheck);
                    r.setQuantity(newVal);
                    if(newVal==0){
                        String status = "Out of Stock";
                        r.setStatus(status);
                        jTable1.setValueAt(status,i,4);
                    }
                    int e=jTable1.getRowCount()-1;
                    
                    jTable1.setValueAt(newVal,i,3);
                    String name = workRequestJTable.getValueAt(selectedRow, col).toString();
                    Patient p = enterprise.getPatientDirectory().findPatientByName(name);
                    VaccinationRequest request = (VaccinationRequest)workRequestJTable.getValueAt(selectedRow, 0);
                    ProcessDoctorWorkRequestJPanel processWorkRequestJPanel = new ProcessDoctorWorkRequestJPanel(userProcessContainer, request, enterprise, name);
                    userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                    request.setStatus("Processing");
                    
        
                }
            }
        }
        if(found ==0)
            JOptionPane.showMessageDialog(null, "Out of Stock Please Order More " + typetocheck + " vaccine!");
        




        
 
        }
        

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable("","");
        populateVaccinationTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void RequestVaccineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestVaccineBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", new RequestVaccineJPanel(userProcessContainer, userAccount,enterprise,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_RequestVaccineBtnActionPerformed

    private void RestockJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestockJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();
        
        if(selectedRow == -1)
            return;
        for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
            if(request.getMessage() == jTable1.getValueAt(selectedRow, 0)){
                if(request.getStatus().equals("Order Delivered")){
                    //request.setReceiver(userAccount);
                    request.setStatus("In Stock");
                    jTable1.setValueAt("In Stock", selectedRow, 4);
                    //jTable1.setValueAt(userAccount.getUsername(),selectedRow,2);
                }
                else if (request.getStatus().equals("Fulfilling Order")){
                    JOptionPane.showMessageDialog(null, "Pharmacy is still fulfilling order. Please wait for delivery to arrive.");
                }
            }
                
        }
        
    }//GEN-LAST:event_RestockJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RequestVaccineBtn;
    private javax.swing.JButton RestockJButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
