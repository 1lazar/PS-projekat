/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.VrsteUsluga;
import form.VrstaUslugeViewForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.VrstaUslugeTabele;

/**
 *
 * @author Laza Laki Lakosta
 */
public class VrstaUslugeViewController {
    private final VrstaUslugeViewForm vuvForm;
    private VrstaUslugeTabele vut;

    public VrstaUslugeViewController(VrstaUslugeViewForm vuvForm) {
        this.vuvForm = vuvForm;
        addActionListener();
    }

    private void addActionListener() {
        vuvForm.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = vuvForm.getTblVrstausluge().getSelectedRow();
                if (row >= 0) {
                    VrsteUsluga vu = ((VrstaUslugeTabele) vuvForm.getTblVrstausluge().getModel()).getVrsteUsluga(row);
                    MainCoordinator.getInstanca().addParam(Constant.PARAM_VRSTE_USLUGA, vu);
                    MainCoordinator.getInstanca().openVrstaUslugeDetailsForm();
                    vuvForm.dispose();
                } else {
                    JOptionPane.showMessageDialog(vuvForm, "Sistem ne može da učita sobu", "Soba greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        vuvForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                fillTabelaSobe();
            }

        });
    }
    public void openForm() {
        vuvForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView();
        vuvForm.setVisible(true);
    }

    private void prepareView() {
        vuvForm.setTitle("Pretraga soba");
    }

    private void fillTabelaSobe() {
        try {
            List<VrsteUsluga> sobe = Communication.getInstance().getAllVrstaUsluge();
            vut = new VrstaUslugeTabele(sobe);
            vuvForm.getTblVrstausluge().setModel(vut);
        } catch (Exception ex) {
            Logger.getLogger(VrstaUslugeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
