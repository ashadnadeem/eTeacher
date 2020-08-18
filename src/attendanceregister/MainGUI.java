/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import static java.awt.Toolkit.getDefaultToolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Ashad Nadeem
 */
public class MainGUI extends javax.swing.JFrame{

    public MainGUI() throws FileNotFoundException,NullPointerException{
        
        try {
            
            this.height = 570;
            this.width = 850;
            initComponents();
            this.setVisible(true);
            this.setAlwaysOnTop(false);
            this.setPreferredSize(new Dimension(this.width,this.height));
            this.setLocation(((int)getDefaultToolkit().getScreenSize().getWidth()- this.width)/2, ((int)getDefaultToolkit().getScreenSize().getHeight()- this.height)/2);
            
        } catch (Exception ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        autenticateL = new javax.swing.JLabel();
        AttendanceJB = new javax.swing.JButton();
        MarkSheetJB = new javax.swing.JButton();
        editInfoJB = new javax.swing.JButton();
        exitJB = new javax.swing.JButton();
        adminL = new javax.swing.JLabel();
        addStudentJB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eTeacher's by Ashcorp");
        setAlwaysOnTop(true);
        setPreferredSize(new Dimension(this.width,this.height));
        getContentPane().setLayout(null);

        autenticateL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        autenticateL.setForeground(new java.awt.Color(255, 0, 0));
        autenticateL.setText("Authentication Required");
        autenticateL.setVisible(false);
        getContentPane().add(autenticateL);
        autenticateL.setBounds(470, 400, 140, 20);

        AttendanceJB.setBackground(new java.awt.Color(0, 102, 51));
        AttendanceJB.setForeground(new java.awt.Color(255, 255, 255));
        AttendanceJB.setBorderPainted(false);
        AttendanceJB.setContentAreaFilled(false);
        AttendanceJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceJBActionPerformed(evt);
            }
        });
        getContentPane().add(AttendanceJB);
        AttendanceJB.setBounds(330, 196, 170, 30);

        MarkSheetJB.setBackground(new java.awt.Color(0, 153, 153));
        MarkSheetJB.setForeground(new java.awt.Color(255, 255, 255));
        MarkSheetJB.setBorderPainted(false);
        MarkSheetJB.setContentAreaFilled(false);
        MarkSheetJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkSheetJBActionPerformed(evt);
            }
        });
        getContentPane().add(MarkSheetJB);
        MarkSheetJB.setBounds(330, 236, 170, 30);

        editInfoJB.setBackground(new java.awt.Color(153, 0, 0));
        editInfoJB.setForeground(new java.awt.Color(255, 255, 255));
        editInfoJB.setBorderPainted(false);
        editInfoJB.setContentAreaFilled(false);
        editInfoJB.setPreferredSize(new java.awt.Dimension(73, 18));
        editInfoJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInfoJBActionPerformed(evt);
            }
        });
        getContentPane().add(editInfoJB);
        editInfoJB.setBounds(330, 320, 170, 30);

        exitJB.setBackground(new java.awt.Color(255, 102, 102));
        exitJB.setText("Exit");
        exitJB.setContentAreaFilled(false);
        exitJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJBActionPerformed(evt);
            }
        });
        getContentPane().add(exitJB);
        exitJB.setBounds(210, 390, 110, 30);

        adminL.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        adminL.setForeground(new java.awt.Color(102, 102, 255));
        adminL.setText("Admin Panel");
        adminL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminLMouseExited(evt);
            }
        });
        getContentPane().add(adminL);
        adminL.setBounds(530, 390, 80, 10);

        addStudentJB.setBackground(new java.awt.Color(255, 255, 51));
        addStudentJB.setForeground(new java.awt.Color(255, 255, 255));
        addStudentJB.setBorderPainted(false);
        addStudentJB.setContentAreaFilled(false);
        addStudentJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentJBActionPerformed(evt);
            }
        });
        getContentPane().add(addStudentJB);
        addStudentJB.setBounds(330, 280, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceregister/MainGUI.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AttendanceJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceJBActionPerformed
        try {
            // TODO add your handling code here:
            attGUI a = new attGUI("Student.xls","Attendance");
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Please Submit Your Details First", "Error!", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AttendanceJBActionPerformed

    private void MarkSheetJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkSheetJBActionPerformed
        try {
            // TODO add your handling code here:
//            JOptionPane.showMessageDialog(null, "Sorry for Inconvenience! \nThis option will be available soon", "Error", JOptionPane.INFORMATION_MESSAGE);
            addMarks m = new addMarks();
        } catch (Exception ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MarkSheetJBActionPerformed

    private void editInfoJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInfoJBActionPerformed
        // TODO add your handling code here:
        try {
            new updateStudentInfo().setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editInfoJBActionPerformed

    private void exitJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJBActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION);
        if (exit == 0) System.exit(0);
    }//GEN-LAST:event_exitJBActionPerformed

    private void adminLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLMouseClicked
        // TODO add your handling code here:
        System.err.print("Admin");
        try {
//            Login lg = new Login();
            this.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null," Admin File Not Found ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_adminLMouseClicked

    private void adminLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLMouseEntered
        // TODO add your handling code here:
        autenticateL.setVisible(true);
    }//GEN-LAST:event_adminLMouseEntered

    private void adminLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLMouseExited
        // TODO add your handling code here:
        autenticateL.setVisible(false);
    }//GEN-LAST:event_adminLMouseExited

    private void addStudentJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentJBActionPerformed
        // TODO add your handling code here:
        addStudent n = new addStudent();
        this.setVisible(false);
    }//GEN-LAST:event_addStudentJBActionPerformed
    
    private int height,width;
    private JDateChooser dateChooser1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttendanceJB;
    private javax.swing.JButton MarkSheetJB;
    private javax.swing.JButton addStudentJB;
    private javax.swing.JLabel adminL;
    private javax.swing.JLabel autenticateL;
    private javax.swing.JButton editInfoJB;
    private javax.swing.JButton exitJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
