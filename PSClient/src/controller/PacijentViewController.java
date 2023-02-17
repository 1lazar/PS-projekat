/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Pacijent;
import form.PacijentiViewForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CommandAPDU;
import javax.swing.JOptionPane;
import table.PacijentiTabele;

/**
 *
 * @author Laza Laki Lakosta
 */
public class PacijentViewController {
    private final PacijentiViewForm pvForm;
    private PacijentiTabele pt;

    public PacijentViewController(PacijentiViewForm pvForm) {
        this.pvForm = pvForm;
        addActionListener();
    }

    private void addActionListener() {
        pvForm.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = pvForm.getTblPacijenti().getSelectedRow();
                if (row >= 0) {
                    Pacijent pacijent = ((PacijentiTabele) pvForm.getTblPacijenti().getModel()).getPacijent(row);
                    MainCoordinator.getInstanca().addParam(Constant.PARAM_PACIJENTI, pacijent);
                    MainCoordinator.getInstanca().openPacijentDetailsForm();
                } else {
                    JOptionPane.showMessageDialog(pvForm, "Sistem ne može da učita pacijenta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pvForm.getBtnFiltrirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ime = pvForm.getPoljeIme().getText().trim();
                    String prezime = pvForm.getPoljePrezime().getText().trim();
                    if(ime.isEmpty() || prezime.isEmpty()){
                        JOptionPane.showMessageDialog(pvForm, "Morate uneti ime i prezime", "Gost greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    List<Pacijent> gosti = Communication.getInstance().vratiPacijenteImePrezime(ime, prezime);
                    if(gosti.isEmpty()){
                        fillTabelaPacijente();
                        JOptionPane.showMessageDialog(pvForm, "Sistem ne može da nađe goste po zadatoj vrednosti", "Gost greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(pvForm, "Sistem je našao goste po zadatoj vrednosti");
                    pt = (PacijentiTabele) pvForm.getTblPacijenti().getModel();
                    pt.setPacijente(gosti);
                } catch (Exception ex) {
                    Logger.getLogger(PacijentViewController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(pvForm, "Sistem ne može da nađe goste po zadatoj vrednosti", "Gost greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        pvForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                fillTabelaPacijente();
            }

        });
    }
    public void openForm() {
        pvForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView();
        pvForm.setVisible(true);
    }

    private void prepareView() {
        pvForm.setTitle("Pretraga pacijenta");
    }

    private void fillTabelaPacijente() {
        try {
            List<Pacijent> sobe = Communication.getInstance().getAllPacijent();
            pt = new PacijentiTabele(sobe);
            pvForm.getTblPacijenti().setModel(pt);
        } catch (Exception ex) {
            Logger.getLogger(PacijentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
