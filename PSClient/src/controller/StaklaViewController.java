/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Stakla;
import form.StaklaViewForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.StaklaTabele;

/**
 *
 * @author Laza Laki Lakosta
 */
public class StaklaViewController {
    private final StaklaViewForm svForm;
    private StaklaTabele st;

    public StaklaViewController(StaklaViewForm svForm) {
        this.svForm = svForm;
        addActionListener();
    }

    private void addActionListener() {
        svForm.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = svForm.getTblStakla().getSelectedRow();
                if (row >= 0) {
                    Stakla stakla = ((StaklaTabele) svForm.getTblStakla().getModel()).getStakla(row);
                    MainCoordinator.getInstanca().addParam(Constant.PARAM_STAKLA, stakla);
                    MainCoordinator.getInstanca().openStaklatDetailsForm();
                    svForm.dispose();
                } else {
                    JOptionPane.showMessageDialog(svForm, "Sistem ne može da učita sobu", "Soba greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        svForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                fillTabelaSobe();
            }

        });
    }
    public void openForm() {
        svForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView();
        svForm.setVisible(true);
    }

    private void prepareView() {
        svForm.setTitle("Pretraga soba");
    }

    private void fillTabelaSobe() {
        try {
            List<Stakla> stakla = Communication.getInstance().getAllStakla();
            st = new StaklaTabele(stakla);
            svForm.getTblStakla().setModel(st);
        } catch (Exception ex) {
            Logger.getLogger(StaklaViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
