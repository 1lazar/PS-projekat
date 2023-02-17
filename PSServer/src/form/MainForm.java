/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import server.Server;


/**
 *
 * @author Milos Milic
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    private Server server;

    public MainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        btnStop.setEnabled(false);
        serverStatus.setText("Server is turn off. ");
        serverStatus.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverStatus = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jmbMain = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jmiSettings = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serverStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serverStatus.setText(" ");

        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Server");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jmServer.setText("Server");
        jmServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmServerActionPerformed(evt);
            }
        });

        jmiSettings.setText("Settings");
        jmiSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSettingsActionPerformed(evt);
            }
        });
        jmServer.add(jmiSettings);

        jMenuItem1.setText(" Active users");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmServer.add(jMenuItem1);

        jmbMain.add(jmServer);

        jmAbout.setText("About");

        jmiAboutSoftware.setText("About Software");
        jmiAboutSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutSoftwareActionPerformed(evt);
            }
        });
        jmAbout.add(jmiAboutSoftware);

        jmbMain.add(jmAbout);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(serverStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(serverStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSettingsActionPerformed
        new FormSettings(this, true).setVisible(true);
    }//GEN-LAST:event_jmiSettingsActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
//        if (server == null || !server.isAlive()) {
//            try {
//                server = new Server();
//                server.start();
//                btnStart.setEnabled(false);
//                btnStop.setEnabled(true);
//                serverStatus.setText("Server is turn on");
//                serverStatus.setForeground(Color.GREEN);
//            } catch (IOException ex) {
//                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
//        if (server.getServerSocket() != null) {
//            try {
//                server.closeActiveUsers();
//                server.getServerSocket().close();
//                btnStart.setEnabled(true);
//                btnStop.setEnabled(false);
//                serverStatus.setText("Server is turn off. ");
//                serverStatus.setForeground(Color.red);
//                //System.exit(1);
//                server.closeActiveUsers();
//            } catch (IOException ex) {
//                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void jmServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmServerActionPerformed
        
    }//GEN-LAST:event_jmServerActionPerformed

    private void jmiAboutSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutSoftwareActionPerformed
       // new FormSettings(this, true).setVisible(true);
    }//GEN-LAST:event_jmiAboutSoftwareActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//       new FormActiveUsers(this, rootPaneCheckingEnabled, server).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmAbout;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiSettings;
    private javax.swing.JLabel serverStatus;
    // End of variables declaration//GEN-END:variables
    public void jmiPodesavanjaAdminaAddActionListener(ActionListener actionListener) {
        jmiSettings.addActionListener(actionListener);
    }
    public void jmiOSoftveruAdminaAddActionListener(ActionListener actionListener) {
        jmiAboutSoftware.addActionListener(actionListener);
    }
    public void addStartBtnActionListener(ActionListener actionListener) {
        btnStart.addActionListener(actionListener);
    }
    public void addStopBtnActionListener(ActionListener actionListener) {
        btnStop.addActionListener(actionListener);
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public JLabel getServerStatus() {
        return serverStatus;
    }
    
}
