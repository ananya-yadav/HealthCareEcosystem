/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.NurseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VaccinationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Sonia
 */
public class RequestVaccinationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestVaccinationJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network=network;
        valueLabel.setText(enterprise.getOrganizationName());
        
        vaccinationNameComboBox.addItem("Hepatitis-B");
        vaccinationNameComboBox.addItem("RotaVirus");
        vaccinationNameComboBox.addItem("DTaP");
        vaccinationNameComboBox.addItem("Influenza7");
        vaccinationNameComboBox.addItem("Hib");
        vaccinationNameComboBox.addItem("MMR");
        vaccinationNameComboBox.addItem("Varicella");
        vaccinationNameComboBox.addItem("Hepatitis A");
        vaccinationNameComboBox.addItem("Meningococcal");
        vaccinationNameComboBox.addItem("HPV");
        jComboBox1.removeAllItems();
        for(Patient p : enterprise.getPatientDirectory().getPatientDirectory()){
            jComboBox1.addItem(p.getFirstName());
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
                ImageIcon img=new ImageIcon("health logo10.jpg");
                Image i=img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height,this);
            }

        };
        jPanel3 = new javax.swing.JPanel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        vaccinationNameComboBox = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox<String>();
        requestTestJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        jPanel3.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        valueLabel.setText("<value>");
        jPanel3.add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, -1));

        jLabel1.setText("Vaccination Name");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jPanel3.add(vaccinationNameComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 160, -1));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 110, -1));

        requestTestJButton.setText("Request Vaccination");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        jPanel3.add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel3.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 138, -1, -1));

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.CENTER);
        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        String message = vaccinationNameComboBox.getSelectedItem().toString();
        
        VaccinationRequest request = new VaccinationRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Waiting");
        request.setPatientName(jComboBox1.getSelectedItem().toString());
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationDirectory()){
            if (organization instanceof NurseOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkQueue().add(request);
            userAccount.getWorkQueue().getWorkQueue().add(request);
        }
        JOptionPane.showMessageDialog(null, "Vaccination Request sent.");
        
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
        dwjp.populatePatientTable();
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JComboBox vaccinationNameComboBox;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
