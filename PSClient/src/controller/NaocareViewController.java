/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Naocare;
import form.NaocareViewForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.NaocareTabele;

/**
 *
 * @author Laza Laki Lakosta
 */
public class NaocareViewController {
    private final NaocareViewForm nvForm;
    private NaocareTabele nt;

    public NaocareViewController(NaocareViewForm nvForm) {
        this.nvForm = nvForm;
        addActionListener();
    }

    private void addActionListener() {
        nvForm.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = nvForm.getTblNaocare().getSelectedRow();
                if (row >= 0) {
                    Naocare naocare = ((NaocareTabele) nvForm.getTblNaocare().getModel()).getNaocare(row);
                    MainCoordinator.getInstanca().addParam(Constant.PARAM_NAOCARE, naocare);
                    MainCoordinator.getInstanca().openNaocareDetailsForm();
                    nvForm.dispose();
                } else {
                    JOptionPane.showMessageDialog(nvForm, "Sistem ne može da učita naocare", "Naocare greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
//        nvForm.getBtnFiltrirajAddActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    String naocare = nvForm.getPoljeNaocare().getText().trim();
//
//                    if (naocare.isEmpty()) {
//                        JOptionPane.showMessageDialog(nvForm, "Morate uneti naocare", "Naocare greška", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//
//                    List<Naocare> sobe = Communication.getInstance().getAllNaocare();
//                    if (sobe.isEmpty()) {
//                        fillTabelaSobe();
//                        JOptionPane.showMessageDialog(nvForm, "Sistem ne može da nađe naocare po zadatoj vrednosti", "Naocare greška", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//                    JOptionPane.showMessageDialog(nvForm, "Sistem je našao naocare po zadatoj vrednosti");
//                    stm = (SobaTableModel) nvForm.getTabelaSoba().getModel();
//                    stm.setSobe(sobe);
//                } catch (Exception ex) {
//                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(frmPretragaSoba, "Sistem ne može da nađe sobe po zadatoj vrednosti", "Soba greška", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//        });
        
        nvForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                fillTabelaSobe();
            }

        });
    }
    public void openForm() {
        nvForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView();
        nvForm.setVisible(true);
    }

    private void prepareView() {
        nvForm.setTitle("Pretraga naocara");
    }

    private void fillTabelaSobe() {
        try {
            List<Naocare> sobe = Communication.getInstance().getAllNaocare();
            nt = new NaocareTabele(sobe);

            nvForm.getTblNaocare().setModel(nt);
        } catch (Exception ex) {
            Logger.getLogger(NaocareViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
