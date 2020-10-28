/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyRequest;
import Business.WorkQueue.VaccinationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Patient.Patient;
import java.util.ArrayList;
import Business.Person.Person;
import Business.Patient.PatientDirectory;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author raunak
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;

        this.network=network;
        valueLabel.setText(enterprise.getOrganizationName());
        populateRequestTable();
        populatePatientTable();
    }
    
   /** public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        if(userAccount.getRole().equals("DoctorRole")){
            for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
                Object[] row = new Object[4];
                row[0] = request.getMessage();
                row[1] = request.getReceiver();
                row[2] = request.getStatus();
                String result = ((WorkRequest) request).getStatus();
                row[3] = result == null ? "Waiting" : result;

                model.addRow(row);
            }
        }
        else if(userAccount.getRole().equals("PharmacistRole")){
            for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
                Object[] row = new Object[4];
                row[0] = request.getMessage();
                row[1] = request.getReceiver();
                row[2] = request.getStatus();
                String result = ((PharmacyRequest) request).getPharmacyStatus();
                row[3] = result == null ? "Waiting" : result;

                model.addRow(row);
            }
        }
        else if(userAccount.getRole().equals("NurseRole")){
            for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
                Object[] row = new Object[4];
                row[0] = request.getMessage();
                row[1] = request.getReceiver();
                row[2] = request.getStatus();
                String result = ((VaccinationRequest) request).getVaccinationStatus();
                row[3] = result == null ? "Waiting" : result;

                model.addRow(row);
            }
        }
    }**/

     public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkQueue()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            row[3] = request.getPatientName();
            //String result = ((VaccinationRequest) request).getStatus();
            //row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
    }
     
     public void populatePatientTable(){
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        
        model.setRowCount(0);
        Enterprise e = enterprise;
        PatientDirectory p2 = e.getPatientDirectory();
        PatientDirectory pd = new PatientDirectory();
        if(p2 == null)
            
            e.setPatientDirectory(pd);
        
        for (Patient p  : enterprise.getPatientDirectory().getPatientDirectory()){
            Object[] row = new Object[4];
            row[0] = p.getPatientID();
            String s = p.getFirstName() + " " + p.getLastName();
            row[1] = s;
            row[2] = p.getDOB();
            row[3] = p.getAddress();
                    
            //String result = ((VaccinationRequest) request).getStatus();
            //row[3] = result == null ? "Waiting" : result;
            
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
                ImageIcon img=new ImageIcon("health logo8.jpg");
                Image i=img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height,this);
            }};
            enterpriseLabel = new javax.swing.JLabel();
            valueLabel = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            patientTable = new javax.swing.JTable();
            jButton1 = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            workRequestJTable = new javax.swing.JTable();
            jButton2 = new javax.swing.JButton();
            requestTestJButton = new javax.swing.JButton();

            setLayout(new java.awt.BorderLayout());

            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            enterpriseLabel.setText("EnterPrise :");
            jPanel1.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 127, 30));

            valueLabel.setText("<value>");
            jPanel1.add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 110, 26));

            jLabel1.setText("Patients");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 43));

            patientTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Patient ID", "Patient Name", "Date Of Birth", "Address"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane2.setViewportView(patientTable);
            if (patientTable.getColumnModel().getColumnCount() > 0) {
                patientTable.getColumnModel().getColumn(0).setResizable(false);
                patientTable.getColumnModel().getColumn(1).setResizable(false);
                patientTable.getColumnModel().getColumn(3).setResizable(false);
            }

            jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 520, 97));

            jButton1.setText("Register Patient");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 236, -1));

            workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Vaccination Name", "Receiver", "Status", "Patient"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
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
                workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            }

            jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 540, 102));

            jButton2.setText("Add Doctor's Notes");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

            requestTestJButton.setText("Request Vaccination");
            requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    requestTestJButtonActionPerformed(evt);
                }
            });
            jPanel1.add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, -1, -1));

            add(jPanel1, java.awt.BorderLayout.CENTER);
        }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestVaccinationTestJPanel", new RequestVaccinationJPanel(userProcessContainer, userAccount, enterprise,network));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DoctorRegisterPatient2", new DoctorRegisterPatientJPanel(userProcessContainer, userAccount, enterprise,network, organization));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        
       
        int col =0;
        int row =  patientTable.getSelectedRow();
        if(row == -1)
            return;
        String id = patientTable.getModel().getValueAt(row, col).toString();
        int idd = Integer.parseInt(id);
        userProcessContainer.add("DoctorsNotes", new DoctorsNotesJPanel(userProcessContainer, organization, enterprise,userAccount,network, idd ));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
