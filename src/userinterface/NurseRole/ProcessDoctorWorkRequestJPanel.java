/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NurseRole;

import Business.WorkQueue.VaccinationRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.Enterprise.Enterprise;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


/**
 *
 * @author Sonia
 */
public class ProcessDoctorWorkRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private VaccinationRequest request;
    private Enterprise enterprise;
    private String patientName;
    private String patientHistory;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessDoctorWorkRequestJPanel(JPanel userProcessContainer, VaccinationRequest request, Enterprise enterprise, String name) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.patientName = name;
        this.patientHistory = enterprise.getPatientDirectory().findPatientByName(name).getHistory();
        
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
                ImageIcon img=new ImageIcon("health logo21.jpg");
                Image i=img.getImage();

                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height,this);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Result");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 26, -1, -1));

        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NurseWorkAreaJPanel dwjp = (NurseWorkAreaJPanel) component;
        dwjp.populateTable(patientHistory, patientName);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        //request.setVaccinationStatus(jTextArea1.getText());
        request.setStatus("Completed");
        JOptionPane.showMessageDialog(null, "Result submitted successfully.");
        String s = jTextArea1.getText();
        
        patientHistory = patientHistory + "\n\n"+ s;
        System.out.println(patientHistory);
        /*if(enterprise == null)
            System.out.println("its null enterprise problem");*/
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
