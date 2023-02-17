/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Naocare;
import domain.StatistikaOdUsluga;
import domain.Usluga;
import form.NaocareForm;
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
public class NaocareController {
    private final NaocareForm naocareForm;

    public NaocareController(NaocareForm naocareForm) {
        this.naocareForm = naocareForm;
        addActionListener();
    }

    private void addActionListener() {
        naocareForm.addSacuvajBtnActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                try {
                    Naocare naocare = new Naocare();
                    validacija();
                    //naocare.setId(Integer.parseInt(naocareForm.getPoljeId().getText().trim()));
                    naocare.setMarka(naocareForm.getPoljeMarka().getText().trim());
                    naocare.setModel(naocareForm.getPoljeModel().getText().trim());
                    naocare.setCena(Double.parseDouble(naocareForm.getPoljeCena().getText().trim()));
                    naocare.setKolicina(Integer.parseInt(naocareForm.getPoljeKolicina().getText().trim()));
                    
                    Communication.getInstance().addNaocare(naocare);
                    JOptionPane.showMessageDialog(naocareForm, "Sistem je zapamtio naocare", "Čuvanje naocara", JOptionPane.INFORMATION_MESSAGE);
                    naocareForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(NaocareController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        naocareForm.addOmoguciIzmeneBtnActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }
        });
        naocareForm.addObrisiBtnActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                try {
                    Naocare naocare = makeNaocareFromForm();
                    if(naocare==null){
                        JOptionPane.showMessageDialog(naocareForm, "Sistem ne može da obriše naocare", "Naocare greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    List<Usluga> usluge = Communication.getInstance().vratiUslugeNID(naocare.getId());
                    System.out.println(usluge);
                    for(int i=0;i<usluge.size();i++){
                        List<StatistikaOdUsluga> sou = Communication.getInstance().vratiStatistikuOdUsluga(usluge.get(i).getId());
                        Communication.getInstance().deleteStatistikaOdUsluga(sou.get(0));
                        //System.out.println(sou.get(0).getId());
                        //System.out.println(usluge.get(i).getId());
                                                
                    }
                    for(int i=0;i<usluge.size();i++){
                        Communication.getInstance().deleteUsluga(usluge.get(i));
                    }
                    Communication.getInstance().deleteNaocare(naocare);
                    JOptionPane.showMessageDialog(naocareForm, "Sistem je obrisao podatke o naocarima", "Brisanje naocare", JOptionPane.INFORMATION_MESSAGE);
                    naocareForm.dispose();
                } catch (ParseException ex) {
                    Logger.getLogger(NaocareController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(NaocareController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        naocareForm.addIzmeniBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

            private void edit() {
                try {
                    Naocare naocare = makeNaocareFromForm();
                    if (naocare == null) {
                        JOptionPane.showMessageDialog(naocareForm, "Sistem ne može da zapamti naocare", "Naocare greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Communication.getInstance().editNaocare(naocare);
                    JOptionPane.showMessageDialog(naocareForm, "Sistem je zapamtio naocare", "Izmena naocare", JOptionPane.INFORMATION_MESSAGE);
                    naocareForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(NaocareController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(naocareForm, "Sistem ne može da zapamti naocare", "Naocare greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_ADD:
                naocareForm.getBtnOtkazi().setEnabled(true);
                naocareForm.getBtnIzbrisi().setEnabled(false);
                naocareForm.getBtnIzmeni().setEnabled(false);
                naocareForm.getBtnOmoguciIzmene().setEnabled(false);
                naocareForm.getBtnSacuvaj().setEnabled(true);

                naocareForm.getPoljeId().setEnabled(false);
                naocareForm.getPoljeMarka().setEnabled(true);
                naocareForm.getPoljeModel().setEnabled(true);
                naocareForm.getPoljeKolicina().setEnabled(true);
                naocareForm.getPoljeCena().setEnabled(true);
                break;
            case FORM_VIEW:
                naocareForm.getBtnOtkazi().setEnabled(true);
                naocareForm.getBtnIzbrisi().setEnabled(true);
                naocareForm.getBtnIzmeni().setEnabled(false);
                naocareForm.getBtnOmoguciIzmene().setEnabled(true);
                naocareForm.getBtnSacuvaj().setEnabled(false);

                naocareForm.getPoljeId().setEnabled(false);
                naocareForm.getPoljeMarka().setEnabled(false);
                naocareForm.getPoljeModel().setEnabled(false);
                naocareForm.getPoljeKolicina().setEnabled(false);
                naocareForm.getPoljeCena().setEnabled(false);

                Naocare naocare = (Naocare) MainCoordinator.getInstanca().getParam(Constant.PARAM_NAOCARE);
                naocareForm.getPoljeId().setText(naocare.getId() + "");
                naocareForm.getPoljeMarka().setText(naocare.getMarka());
                naocareForm.getPoljeModel().setText(naocare.getModel());
                naocareForm.getPoljeKolicina().setText(String.valueOf(naocare.getKolicina()));
                naocareForm.getPoljeCena().setText(String.valueOf(naocare.getCena()));
                JOptionPane.showMessageDialog(naocareForm, "Sistem je učitao naocare");
                break;
            case FORM_EDIT:
                naocareForm.getBtnOtkazi().setEnabled(true);
                naocareForm.getBtnIzbrisi().setEnabled(true);
                naocareForm.getBtnIzmeni().setEnabled(true);
                naocareForm.getBtnOmoguciIzmene().setEnabled(false);
                naocareForm.getBtnSacuvaj().setEnabled(false);

                naocareForm.getPoljeId().setEnabled(false);
                naocareForm.getPoljeMarka().setEnabled(true);
                naocareForm.getPoljeModel().setEnabled(true);
                naocareForm.getPoljeKolicina().setEnabled(true);
                naocareForm.getPoljeCena().setEnabled(true);
                break;
        }        
    }
    private Naocare makeNaocareFromForm() throws ParseException, Exception {
        Naocare naocare = new Naocare();
        validacija();
        naocare.setId(Integer.parseInt(naocareForm.getPoljeId().getText().trim()));
        naocare.setMarka(naocareForm.getPoljeMarka().getText().trim());
        naocare.setModel(naocareForm.getPoljeModel().getText().trim());
        naocare.setKolicina(Integer.parseInt(naocareForm.getPoljeKolicina().getText().trim()));
        naocare.setCena(Double.parseDouble(naocareForm.getPoljeCena().getText().trim()));
//        if (gost.getIme().isEmpty() || gost.getPrezime().isEmpty() || gost.getDatumRodjenja() == null || gost.getGrad() == null) {
//            return null;
//        }
        return naocare;
    }
    public void validacija() throws Exception {
        String error="";
        String id = naocareForm.getPoljeId().getText();
        String marka = naocareForm.getPoljeMarka().getText();
        String model = naocareForm.getPoljeModel().getText();
        String kolicnina = naocareForm.getPoljeKolicina().getText();
        String cena = naocareForm.getPoljeCena().getText();
        //String cena = poljeCena.getText();
        
//        if(id==null || id.isEmpty()){
//            naocareForm.getTextId().setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//        }
        if(marka==null || marka.isEmpty()){
            naocareForm.getTextMarka().setText("Marka cannot be empty!");
            error += "Marka cannot be empty!\n";
        }
        if(model==null || model.isEmpty()){
            naocareForm.getTextModel().setText("Model cannot be empty!");
            error += "Model cannot be empty!\n";
        }
        if(kolicnina==null || kolicnina.isEmpty()){
            naocareForm.getTextKolicina().setText("Quantity cannot be empty!");
            error += "Quantity cannot be empty!\n";
        }
        if(Integer.parseInt(kolicnina) <=0 ){
            naocareForm.getTextKolicina().setText("Quantity cannot be zero or negative number!");
            error += "Quantity cannot be zero or negative number!\n";
        }
        if(Double.parseDouble(cena) <=0 ){
            naocareForm.getTextCena().setText("Price cannot be zero or negative number!");
            error += "Price cannot be zero or negative number!\n";
        }
        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }
    public void openForm(FormMode formMode) {
        naocareForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView(formMode);
        naocareForm.setVisible(true);
    }

    private void prepareView(FormMode formMode) {
//        try {
//            fillCbGrad();
//        } catch (Exception ex) {
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        setupComponents(formMode);
    }
}
