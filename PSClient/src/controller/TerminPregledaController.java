/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Naocare;
import domain.Opticar;
import domain.Pacijent;
import domain.Stakla;
import domain.StavkePregleda;
import domain.TerminPregleda;
import domain.Usluga;
import domain.VrsteUsluga;
import form.TerminPregledaForm;
import form.TerminPregledaForma;
import form.TerminPregledaProba;
import form.util.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import table.NaocareTabele;
import table.StaklaTabele;
import table.UslugeTabele;

/**
 *
 * @author Laza Laki Lakosta
 */
public class TerminPregledaController {
    private final TerminPregledaProba tpForm;
    private UslugeTabele ut;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private int rb = 1;
    

    public TerminPregledaController(TerminPregledaProba tpForm) {
        this.tpForm = tpForm;
        addActionListener();
    }

    private void addActionListener() {
        tpForm.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }

            private void addItem() {
                try {
                    Usluga usluga = new Usluga();
                    Naocare naocare = (Naocare) tpForm.getComboNaocare().getSelectedItem();
                    Stakla stakla = (Stakla) tpForm.getComboStakla().getSelectedItem();
                    VrsteUsluga vu = (VrsteUsluga) tpForm.getComboVU().getSelectedItem();
                    

                    int id = Communication.getInstance().maxIdUsluga();
                    usluga.setId(id);
                    usluga.setNaocare(naocare);
                    usluga.setVrsteUsluge(vu);
                    usluga.setStakla(stakla);
                    ut = (UslugeTabele) tpForm.getTabelaUsluge().getModel();
                    List<Usluga> usluge = ut.getUsluga();
                    for(Usluga u:usluge){
                        if(u.getNaocareId()==naocare.getId() && u.getStaklaId()==stakla.getId() && u.getVrsteUslugeId() == vu.getId()){
                            JOptionPane.showMessageDialog(tpForm, "Usluga je već dodata", "Termin pregleda greška", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    System.out.println(usluga);
                    ut.dodajUslugu(usluga);
                    rb += 1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Logger.getLogger(TerminPregledaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tpForm.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }

            private void removeItem() {
                int row = tpForm.getTabelaUsluge().getSelectedRow();
                ut = (UslugeTabele) tpForm.getTabelaUsluge().getModel();
                if (row >= 0) {
                    ut.obrisiUslugu(row);
                    rb = 1;
                    List<Usluga> usluga = ut.getUsluga();
                    for (Usluga u : usluga) {
                        u.setId(rb);
                        rb += 1;
                    }
                    ut.refresh();
                } else {
                    JOptionPane.showMessageDialog(tpForm, "Morate izabrati stavku", "Termin pregleda greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tpForm.addBtnOtkaziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tpForm.dispose();
            }
        });
        
        tpForm.addBtnSacuvajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                try {
                    int id = Communication.getInstance().maxIdTP();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date datum = sdf.parse(tpForm.getPoljeDatum().getText().trim());
                    System.out.println(datum);
                    Opticar opticar = (Opticar) tpForm.getComboOpticar().getSelectedItem();
                    Pacijent pacijent = (Pacijent) tpForm.getComboPacijent().getSelectedItem();
                    ut = (UslugeTabele) tpForm.getTabelaUsluge().getModel();
                    List<Usluga> usluge = ut.getUsluga();
                    System.out.println();
//                    if (datum == null || opticar == null || pacijent == null || usluge.isEmpty()) {
//                        JOptionPane.showMessageDialog(tpForm, "Sistem ne može da zapamti termin pregledaa", "Termin pregleda greška", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
                    TerminPregleda tp = new TerminPregleda(id, datum, pacijent.getId(), opticar.getId());
                    Communication.getInstance().addTerminPregleda(tp);
                    JOptionPane.showMessageDialog(tpForm, "Sistem je zapamtio termin pregleda", "Čuvanje termina pregleda", JOptionPane.INFORMATION_MESSAGE);
                    tpForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(TerminPregledaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(tpForm, "Sistem ne može da zapamti termin pregleda", "Termin pregleda greška", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    
    public void openForm(FormMode formMode) {
        tpForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView(formMode);
        tpForm.setVisible(true);
    }

    private void prepareView(FormMode formMode) {
        try {
            List<Usluga> usluge = Communication.getInstance().getAllUsluga();
            System.out.println(usluge);
            ut = new UslugeTabele(usluge);
            tpForm.getTabelaUsluge().setModel(ut);
            
            fillComboPacijnet();
            fillComboOpticar();
            fillComboNaocare();
            fillComboStakla();
            fillComboVrsteUsluge();
//            fillTabelaUsluge();
            setupComponents(formMode);
        } catch (Exception ex) {
            Logger.getLogger(TerminPregledaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fillComboPacijnet() throws Exception {
        tpForm.getComboPacijent().removeAllItems();
        List<Pacijent> pacijenti = Communication.getInstance().getAllPacijent();
        tpForm.getComboPacijent().setModel(new DefaultComboBoxModel<>(pacijenti.toArray()));
    }

    private void fillComboOpticar() throws Exception {
        tpForm.getComboOpticar().removeAllItems();
        List<Opticar> opticari = Communication.getInstance().getAllOpticari();
        tpForm.getComboOpticar().setModel(new DefaultComboBoxModel<>(opticari.toArray()));
    }

    private void fillComboNaocare() throws Exception {
        tpForm.getComboNaocare().removeAllItems();
        List<Naocare> naocare = Communication.getInstance().getAllNaocare();
        tpForm.getComboNaocare().setModel(new DefaultComboBoxModel<>(naocare.toArray()));
    }
    
    private void fillComboStakla() throws Exception {
        tpForm.getComboStakla().removeAllItems();
        List<Stakla> stakla = Communication.getInstance().getAllStakla();
        tpForm.getComboStakla().setModel(new DefaultComboBoxModel<>(stakla.toArray()));
    }
    
    private void fillComboVrsteUsluge() throws Exception {
        tpForm.getComboVU().removeAllItems();
        List<VrsteUsluga> vu = Communication.getInstance().getAllVrstaUsluge();
        tpForm.getComboVU().setModel(new DefaultComboBoxModel<>(vu.toArray()));
    }
    
//    private void fillTabelaUsluge() {
//        try {
//            List<Usluga> usluga = Communication.getInstance().getAllUsluga();
//            ut = new UslugeTabele(usluga);
//            tpForm.getTabelaUsluge().setModel(ut);
//        } catch (Exception ex) {
//            Logger.getLogger(PacijentViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private void setupComponents(FormMode formMode) throws Exception {
        switch (formMode) {
            case FORM_ADD:
                tpForm.getBtnDodaj().setEnabled(true);
                tpForm.getBtnObrisi().setEnabled(true);
                tpForm.getBtnOtkazi().setEnabled(true);
                tpForm.getBtnSacuvaj().setEnabled(true);

                tpForm.getPoljeId().setEnabled(false);
                tpForm.getPoljeDatum().setEnabled(true);
                tpForm.getComboNaocare().setEnabled(true);
                tpForm.getComboOpticar().setEnabled(true);
                tpForm.getComboPacijent().setEnabled(true);
                tpForm.getComboStakla().setEnabled(true);
                tpForm.getComboVU().setEnabled(true);
                tpForm.getTabelaUsluge().setEnabled(true);
                break;
            case FORM_VIEW:
                tpForm.getBtnDodaj().setEnabled(false);
                tpForm.getBtnObrisi().setEnabled(false);
                tpForm.getBtnOtkazi().setEnabled(true);
                tpForm.getBtnSacuvaj().setEnabled(false);

                tpForm.getPoljeId().setEnabled(false);
                tpForm.getPoljeDatum().setEnabled(false);
                tpForm.getComboNaocare().setEnabled(false);
                tpForm.getComboOpticar().setEnabled(false);
                tpForm.getComboPacijent().setEnabled(false);
                tpForm.getComboStakla().setEnabled(false);
                tpForm.getComboVU().setEnabled(false);
                tpForm.getTabelaUsluge().setEnabled(false);


                TerminPregleda tp = (TerminPregleda) MainCoordinator.getInstanca().getParam(Constant.PARAM_TERMIN_PREGLEDA);
                tpForm.getPoljeId().setText(tp.getId() + "");
                tpForm.getPoljeDatum().setText(sdf.format(tp.getDatum()));
                
                List<Opticar> opticari = Communication.getInstance().getAllOpticari();
                int index = 0;
                for (Opticar opticar:opticari) {
                    if (opticar.getId() == tp.getOpticarId()) {
                        break;
                    }
                    index += 1;
                }
                System.out.println(index);
                tpForm.getComboOpticar().setSelectedIndex(index);
                
                List<Pacijent> pacijenti = Communication.getInstance().getAllPacijent();
                for (Pacijent pacijent:pacijenti) {
                    if (pacijent.getId() == tp.getPacijentId()) {
                        break;
                    }
                    index += 1;
                }
                tpForm.getComboPacijent().setSelectedIndex(index);
                
                Usluga usluga = new Usluga();
                List<StavkePregleda> sp = Communication.getInstance().getAllStavkePregelda();
                
                List<Usluga> usluge = Communication.getInstance().getAllUsluga();
                UslugeTabele ut = (UslugeTabele) tpForm.getTabelaUsluge().getModel();
                for(StavkePregleda s:sp){
                    if(s.getTerminPregledaId()==tp.getId()){
                        for(Usluga u:usluge){
                            if(u.getId()==s.getId()){
                                ut.dodajUslugu(u);
                                usluga = u;
                            }
                        }
                    }
                }
                
                List<Naocare> naocare = Communication.getInstance().getAllNaocare();
                for (Naocare n:naocare) {
                    if (n.getId() == usluga.getNaocareId()) {
                        break;
                    }
                    index += 1;
                }
                tpForm.getComboNaocare().setSelectedIndex(index);
                
                List<Stakla> stakla = Communication.getInstance().getAllStakla();
                for (Stakla s:stakla) {
                    if (s.getId() == usluga.getStaklaId()) {
                        break;
                    }
                    index += 1; 
                }
                tpForm.getComboStakla().setSelectedIndex(index);
                
//                List<StavkaRezervacije> stavke = Komunikacija.getInstanca().vratiSveStavke();
//                StavkaRezervacijeTableModel srtm = (StavkaRezervacijeTableModel) frmRezervacija.getTabelaStavki().getModel();
//                for (StavkaRezervacije stavkaRezervacije : stavke) {
//                    if (stavkaRezervacije.getRezervacija().getRezervacijaID() == rezervacija.getRezervacijaID()) {
//                        srtm.dodajStavku(stavkaRezervacije);
//                    }
//                }
                JOptionPane.showMessageDialog(tpForm, "Sistem je učitao rezervaciju");
                break;

        }
    }
}
