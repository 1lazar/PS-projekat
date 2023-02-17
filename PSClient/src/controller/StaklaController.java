/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Stakla;
import domain.StatistikaOdUsluga;
import domain.Usluga;
import form.StaklaForm;
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
public class StaklaController {
    private final StaklaForm staklaForm;

    public StaklaController(StaklaForm staklaForm) {
        this.staklaForm = staklaForm;
        addActionListener();
    }

    private void addActionListener() {
        staklaForm.addSacuvajBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                try {
                    Stakla stakla = new Stakla();
                    stakla.setNaziv(staklaForm.getPoljeNaziv().getText().trim());
                    stakla.setVrsta(staklaForm.getPoljeVrsta().getText().trim());
                    stakla.setDioptrija(Double.parseDouble(staklaForm.getPoljeDioptrija().getText().trim()));
                    stakla.setKolicina(Integer.parseInt(staklaForm.getPoljeKolicina().getText().trim()));
                    stakla.setCena(Double.parseDouble(staklaForm.getPoljeCena().getText().trim()));

                    if (validacija()) {
                        JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da zapamti staklo", "Staklo greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Communication.getInstance().addStakla(stakla);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem je zapamtio staklo", "Čuvanje stakla", JOptionPane.INFORMATION_MESSAGE);
                    staklaForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(StaklaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da zapamti staklo", "Staklo greška", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        staklaForm.addOmoguciIzmeneBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }

        });

        staklaForm.addOtkaziBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staklaForm.dispose();
            }
        });
        staklaForm.addObrisiBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                try {
                    Stakla stakla = makeStaklaFromForm();
                    if (stakla == null) {
                        JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da obriše stakla", "Staklo greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    List<Usluga> usluge = Communication.getInstance().vratiUslugeSID(stakla.getId());
                    System.out.println(usluge);
                    for(int i=0;i<usluge.size();i++){
                        List<StatistikaOdUsluga> sou = Communication.getInstance().vratiStatistikuOdUsluga(usluge.get(i).getId());
                        Communication.getInstance().deleteStatistikaOdUsluga(sou.get(0));
                                                
                    }
                    for(int i=0;i<usluge.size();i++){
                        Communication.getInstance().deleteUsluga(usluge.get(i));
                    }
                    
                    Communication.getInstance().deleteStakla(stakla);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem je obrisao podatke o stakla", "Brisanje staklo", JOptionPane.INFORMATION_MESSAGE);
                    staklaForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(StaklaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da obriše stakla", "Staklo greška", JOptionPane.ERROR_MESSAGE);

                }
            }

        });
        staklaForm.addIzmeniBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

            private void edit() {
                try {
                    Stakla staklo = makeStaklaFromForm();
                    if (staklo == null) {
                        JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da zapamti stakla", "Staklo greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Communication.getInstance().editStakla(staklo);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem je zapamtio staklo", "Izmena stakla", JOptionPane.INFORMATION_MESSAGE);
                    staklaForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(StaklaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(staklaForm, "Sistem ne može da zapamti stakla", "Staklo greška", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        
    }
     public void openForm(FormMode formMode) {
        staklaForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView(formMode);
        staklaForm.setVisible(true);
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
                staklaForm.getBtnOtkazi().setEnabled(true);
                staklaForm.getBtnIzbrisi().setEnabled(false);
                staklaForm.getBtnIzmeni().setEnabled(false);
                staklaForm.getBtnOmoguciIzmene().setEnabled(false);
                staklaForm.getBtnSacuvaj().setEnabled(true);

                staklaForm.getPoljeId().setEnabled(false);
                staklaForm.getPoljeNaziv().setEnabled(true);
                staklaForm.getPoljeVrsta().setEnabled(true);
                staklaForm.getPoljeDioptrija().setEnabled(true);
                staklaForm.getPoljeKolicina().setEnabled(true);
                staklaForm.getPoljeCena().setEnabled(true);
                break;
            case FORM_VIEW:
                staklaForm.getBtnOtkazi().setEnabled(true);
                staklaForm.getBtnIzbrisi().setEnabled(true);
                staklaForm.getBtnIzmeni().setEnabled(false);
                staklaForm.getBtnOmoguciIzmene().setEnabled(true);
                staklaForm.getBtnSacuvaj().setEnabled(false);

                staklaForm.getPoljeId().setEnabled(false);
                staklaForm.getPoljeNaziv().setEnabled(false);
                staklaForm.getPoljeVrsta().setEnabled(false);
                staklaForm.getPoljeDioptrija().setEnabled(false);
                staklaForm.getPoljeKolicina().setEnabled(false);
                staklaForm.getPoljeCena().setEnabled(false);

                Stakla stakla = (Stakla) MainCoordinator.getInstanca().getParam(Constant.PARAM_STAKLA);
                staklaForm.getPoljeId().setText(stakla.getId() + "");
                staklaForm.getPoljeNaziv().setText(stakla.getNaziv());
                staklaForm.getPoljeVrsta().setText(stakla.getVrsta());
                staklaForm.getPoljeKolicina().setText(String.valueOf(stakla.getKolicina()));
                staklaForm.getPoljeDioptrija().setText(String.valueOf(stakla.getDioptrija()));
                staklaForm.getPoljeCena().setText(String.valueOf(stakla.getKolicina()));
                JOptionPane.showMessageDialog(staklaForm, "Sistem je učitao staklo");
                break;
            case FORM_EDIT:
                staklaForm.getBtnOtkazi().setEnabled(true);
                staklaForm.getBtnIzbrisi().setEnabled(true);
                staklaForm.getBtnIzmeni().setEnabled(true);
                staklaForm.getBtnOmoguciIzmene().setEnabled(false);
                staklaForm.getBtnSacuvaj().setEnabled(false);

                staklaForm.getPoljeId().setEnabled(false);
                staklaForm.getPoljeNaziv().setEnabled(true);
                staklaForm.getPoljeVrsta().setEnabled(true);
                staklaForm.getPoljeDioptrija().setEnabled(true);
                staklaForm.getPoljeKolicina().setEnabled(true);
                staklaForm.getPoljeCena().setEnabled(true);
                break;
        }
    }
    private Stakla makeStaklaFromForm() throws ParseException {
        Stakla staklo = new Stakla();
        staklo.setId(Integer.parseInt(staklaForm.getPoljeId().getText().trim()));
        staklo.setNaziv(staklaForm.getPoljeNaziv().getText().trim());
        staklo.setVrsta(staklaForm.getPoljeVrsta().getText().trim());
        staklo.setDioptrija(Double.parseDouble(staklaForm.getPoljeDioptrija().getText().trim()));
        staklo.setKolicina(Integer.parseInt(staklaForm.getPoljeKolicina().getText().trim()));
        try {
            if(validacija()){
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(StaklaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staklo;
    }
    public boolean validacija() throws Exception {
        String error="";
        String id = staklaForm.getPoljeId().getText();
        String naziv = staklaForm.getPoljeNaziv().getText();
        String vrsta = staklaForm.getPoljeVrsta().getText();
        String dioptirja = staklaForm.getPoljeDioptrija().getText();
        String cena = staklaForm.getPoljeCena().getText();
        boolean fali=false;
        
//        if(id==null || id.isEmpty()){
//            staklaForm.getTextId().setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//            fali=true;
//        }
        if(naziv==null || naziv.isEmpty()){
            staklaForm.getTextNaziv().setText("Name cannot be empty!");
            error += "Name cannot be empty!\n";
            fali=true;
        }
        if(vrsta==null || vrsta.isEmpty()){
            staklaForm.getTextVrsta().setText("Type cannot be empty!");
            error += "Type cannot be empty!\n";
            fali=true;
        }
        if(dioptirja==null || dioptirja.isEmpty()){
            staklaForm.getTextDioptrija().setText("Dioptrija cannot be empty!");
            error += "Dioptrija cannot be empty!\n";
            fali=true;
        }
        if(Double.parseDouble(cena) <=0 ){
            staklaForm.getTextCena().setText("Price cannot be zero or negative number!");
            error += "Price cannot be zero or negative number!\n";
            fali=true;
        }
        if (!error.isEmpty()) {
            throw new Exception(error);
        }
        return fali;
    }
}
