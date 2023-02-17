/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.controller;

import controller.Controller;
import form.MainForm;
import form.coordinator.MainCoordinator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laza Laki Lakosta
 */
public class MainController {
    
    private final MainForm mainForm;

    public MainController(MainForm mainForm) {
        this.mainForm = mainForm;
        addActionListener();
    }
    public void openForm() {
        mainForm.setVisible(true);
    }
    private void addActionListener() {
        mainForm.jmiPodesavanjaAdminaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openSettingsForm();
            }
        });
        mainForm.jmiOSoftveruAdminaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainForm, "Softver je napravio student Branislav Trajkov.");
            }
        });
        
        mainForm.addStartBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.getInstance().startujServer();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                mainForm.getBtnStart().setEnabled(false);
                mainForm.getBtnStop().setEnabled(true);
                mainForm.getServerStatus().setForeground(Color.green);
            }
        });

        mainForm.addStopBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getInstance().stopServer();
                mainForm.getBtnStart().setEnabled(true);
                mainForm.getBtnStop().setEnabled(false);
                mainForm.getServerStatus().setForeground(Color.red);
            }
        });
    }
    public MainForm getMainForm() {
        return mainForm;
    }
    
}
