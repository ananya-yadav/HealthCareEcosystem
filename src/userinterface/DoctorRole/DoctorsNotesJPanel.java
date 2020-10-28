/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import Business.Patient.Patient;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Sonia
 */
public class DoctorsNotesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorsNotesJPanel
     */
    private JPanel userProcessContainer;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    private int patientID;
    public DoctorsNotesJPanel() {
        initComponents();
        
        
    }
    public DoctorsNotesJPanel(JPanel _userProcessContainer, DoctorOrganization _organization, Enterprise _enterprise,UserAccount _userAccount , Network _network, int id ) {
        initComponents();
        this.organization = _organization;
        this.enterprise = _enterprise;
        this.userAccount = _userAccount;
        this.network = _network;
        this.userProcessContainer = _userProcessContainer;
        this.patientID = id;
        jTextArea1.setText(enterprise.getPatientDirectory().findPatientById(patientID).getHistory());
        
        String s = enterprise.getPatientDirectory().findPatientById(patientID).getFirstName() + " " + enterprise.getPatientDirectory().findPatientById(patientID).getLastName()+"'s Medical History";
        jLabel1.setText(s);
      
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
                ImageIcon img=new ImageIcon("health logo9.jpg");
                Image i=img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height,this);

            }};
            jLabel1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();

            setLayout(new java.awt.BorderLayout());

            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setText("Doctor's Notes");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 13, 152, 22));

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 68, 333, 195));

            jButton1.setText("back");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 313, -1, -1));

            jButton2.setText("save");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

            add(jPanel1, java.awt.BorderLayout.CENTER);
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("asdstart", new DoctorWorkAreaJPanel( userProcessContainer,  userAccount,  organization, enterprise));
        //System.out.println("going to next!");
        layout.next(userProcessContainer);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Patient p = enterprise.getPatientDirectory().findPatientById(patientID);
        p.setHistory(jTextArea1.getText());
        JOptionPane.showMessageDialog(null, "Saved!");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}