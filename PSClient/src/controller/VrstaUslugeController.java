/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.StatistikaOdUsluga;
import domain.Usluga;
import domain.VrsteUsluga;
import form.VrstaUslugeForm;
import form.util.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laza Laki Lakosta
 */
public class VrstaUslugeController {
    private final VrstaUslugeForm vuForm;

    public VrstaUslugeController(VrstaUslugeForm vuForm) {
        this.vuForm = vuForm;
        addActionListener();
    }

    private void addActionListener() {
        vuForm.addSacuvajBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                try {
                    VrsteUsluga vu = new VrsteUsluga();
                    vu.setVrsta(vuForm.getPoljeNaziv().getText().trim());
                    vu.setCena(Double.parseDouble(vuForm.getPoljeCena().getText().trim()));
                    
                    if(validacija()){
                        return;
                    }

                    Communication.getInstance().addVrstaUsluge(vu);
                    JOptionPane.showMessageDialog(vuForm, "Sistem je zapamtio vrstu usluge", "Čuvanje vrste usluge", JOptionPane.INFORMATION_MESSAGE);
                    vuForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(VrstaUslugeController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(vuForm, "Sistem ne može da zapamti vrstu usluge", "Vrsta usluge greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        vuForm.addOmoguciIzmeneBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }

        });

        vuForm.addOtkaziBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vuForm.dispose();
            }
        });
        vuForm.addObrisiBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                try {
                    VrsteUsluga vu = makeVrstaUslugaFromForm();
                    if (vu == null) {
                        JOptionPane.showMessageDialog(vuForm, "Sistem ne može da obriše vrste usluga", "Vrste usluga greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    List<Usluga> usluge = Communication.getInstance().vratiUslugeVUID(vu.getId());
                    System.out.println(usluge);
                    for(int i=0;i<usluge.size();i++){
                        List<StatistikaOdUsluga> sou = Communication.getInstance().vratiStatistikuOdUsluga(usluge.get(i).getId());
                        Communication.getInstance().deleteStatistikaOdUsluga(sou.get(0));
                                                
                    }
                    for(int i=0;i<usluge.size();i++){
                        Communication.getInstance().deleteUsluga(usluge.get(i));
                    }
                    
                    Communication.getInstance().deleteVrsteUsluga(vu);
                    JOptionPane.showMessageDialog(vuForm, "Sistem je obrisao podatke o vrsti usluga", "Brisanje vrste usluga", JOptionPane.INFORMATION_MESSAGE);
                    vuForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(VrstaUslugeController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(vuForm, "Sistem ne može da obriše vrste usluga", "Vrste usluga greška", JOptionPane.ERROR_MESSAGE);

                }
            }

        });
        vuForm.addIzmeniBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

            private void edit() {
                try {
                    VrsteUsluga vu = makeVrstaUslugaFromForm();
                    if (vu == null) {
                        JOptionPane.showMessageDialog(vuForm, "Sistem ne može da zapamti vrstu usluga", "Vrsta usluge greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Communication.getInstance().editVrstaUsluge(vu);
                    JOptionPane.showMessageDialog(vuForm, "Sistem je zapamtio vratu usluga", "Izmena vratu usluga", JOptionPane.INFORMATION_MESSAGE);
                    vuForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(VrstaUslugeController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(vuForm, "Sistem ne može da zapamti vrstu usluga", "Vrsta usluge greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void openForm(FormMode formMode) {
        vuForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView(formMode);
        vuForm.setVisible(true);
    }

    private void prepareView(FormMode formMode) {
//        try {
//            fillCbGrad();
//        } catch (Exception ex) {
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        setupComponents(formMode);
    }
    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_ADD:
                vuForm.getBtnOtkazi().setEnabled(true);
                vuForm.getBtnIzbrisi().setEnabled(false);
                vuForm.getBtnIzmeni().setEnabled(false);
                vuForm.getBtnOmoguciIzmene().setEnabled(false);
                vuForm.getBtnSacuvaj().setEnabled(true);

                vuForm.getPoljeId().setEnabled(false);
                vuForm.getPoljeNaziv().setEnabled(true);
                vuForm.getPoljeCena().setEnabled(true);
                break;
            case FORM_VIEW:
                vuForm.getBtnOtkazi().setEnabled(true);
                vuForm.getBtnIzbrisi().setEnabled(true);
                vuForm.getBtnIzmeni().setEnabled(false);
                vuForm.getBtnOmoguciIzmene().setEnabled(true);
                vuForm.getBtnSacuvaj().setEnabled(false);

                vuForm.getPoljeId().setEnabled(false);
                vuForm.getPoljeNaziv().setEnabled(false);
                vuForm.getPoljeCena().setEnabled(false);

                VrsteUsluga vu = (VrsteUsluga) MainCoordinator.getInstanca().getParam(Constant.PARAM_VRSTE_USLUGA);
                vuForm.getPoljeId().setText(vu.getId() + "");
                vuForm.getPoljeNaziv().setText(vu.getVrsta());
                vuForm.getPoljeCena().setText(String.valueOf(vu.getCena()));
                JOptionPane.showMessageDialog(vuForm, "Sistem je učitao vrstu usluge");
                break;
            case FORM_EDIT:
                vuForm.getBtnOtkazi().setEnabled(true);
                vuForm.getBtnIzbrisi().setEnabled(true);
                vuForm.getBtnIzmeni().setEnabled(true);
                vuForm.getBtnOmoguciIzmene().setEnabled(false);
                vuForm.getBtnSacuvaj().setEnabled(false);

                vuForm.getPoljeId().setEnabled(false);
                vuForm.getPoljeNaziv().setEnabled(true);
                vuForm.getPoljeCena().setEnabled(true);
                break;
        }
    }
    private VrsteUsluga makeVrstaUslugaFromForm() throws ParseException {
        VrsteUsluga vu = new VrsteUsluga();
        vu.setId(Integer.parseInt(vuForm.getPoljeId().getText().trim()));
        vu.setVrsta(vuForm.getPoljeNaziv().getText().trim());
        vu.setCena(Double.parseDouble(vuForm.getPoljeCena().getText().trim()));

        try {
            if(validacija()){
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(VrstaUslugeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vu;
    }
    public boolean validacija() throws Exception {
        String error="";
        String id = vuForm.getPoljeId().getText();
        String naziv = vuForm.getPoljeNaziv().getText();
        String cena = vuForm.getPoljeCena().getText();
        boolean fali = false;
        
//        if(id==null || id.isEmpty()){
//            vuForm.getTextId().setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//            fali = true;
//        }
        if(naziv==null || naziv.isEmpty()){
            vuForm.getTextVrsta().setText("Name cannot be empty!");
            error += "Name cannot be empty!\n";
            fali = true;
        }
        if(Double.parseDouble(cena) <=0 ){
            vuForm.getTextCena().setText("Price cannot be zero or negative number!");
            error += "Price cannot be zero or negative number!\n";
            fali = true;
        }
        if (!error.isEmpty()) {
            throw new Exception(error);
        }
        return fali;
    }
}
