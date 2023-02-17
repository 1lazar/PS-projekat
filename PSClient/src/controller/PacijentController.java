/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Naocare;
import domain.Pacijent;
import domain.Stakla;
import domain.StavkePregleda;
import domain.TerminPregleda;
import form.PacijentForm;
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
public class PacijentController {
    private final PacijentForm pacijentForm;

    public PacijentController(PacijentForm pacijentForm) {
        this.pacijentForm = pacijentForm;
        addActionListener();
    }

    private void addActionListener() {
        pacijentForm.addSacuvajBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                save();
                
            }

            private void save(){
                try {
                    Pacijent pacijent = new Pacijent();
                    pacijent.setIme(pacijentForm.getPoljeIme().getText().trim());
                    pacijent.setPrezime(pacijentForm.getPoljePrezime().getText().trim());
                    pacijent.setKontaktTelefon(Integer.parseInt(pacijentForm.getPoljeTelefon().getText().trim()));
                    pacijent.setDioptrijaDesnogOka(Double.parseDouble(pacijentForm.getPoljeDioptrijaDesnogOka().getText().trim()));
                    pacijent.setDioptrijaLevogOka(Double.parseDouble(pacijentForm.getPoljeDioptrijaLevogOka().getText().trim()));
                    pacijent.setPD(Double.parseDouble(pacijentForm.getPoljePD().getText().trim()));
                    if(validacija()){
                        JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da zapamti pacijneta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Communication.getInstance().addPacijent(pacijent);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem je zapamtio pacijenta", "Čuvanje pacijneta", JOptionPane.INFORMATION_MESSAGE);
                    pacijentForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(PacijentController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da zapamti pacijneta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);

                }
                
            }
        });
        pacijentForm.addOmoguciIzmeneBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }

        });
        pacijentForm.addOtkaziBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacijentForm.dispose();
            }
        });
        pacijentForm.addObrisiBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                try {
                    Pacijent pacijent = makePacijentFromForm();
                    if (pacijent == null) {
                        JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da obriše pacijenta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    System.out.println("afdsdafbfkhb");
                    List<TerminPregleda> tppp = Communication.getInstance().vratiTPID(pacijent.getId());
//                    System.out.println(tppp.size());
                    int a=0;
                    for(int i=0;i<tppp.size();i++){
                        List<StavkePregleda> tpsp = Communication.getInstance().vratiStavkeID(tppp.get(i).getId());
                        Communication.getInstance().deleteStavkePregleda(tpsp.get(0));
                        System.out.println(tpsp.get(0).getId());
                                                
                    }
                    for(int i=0;i<tppp.size();i++){
                        Communication.getInstance().deleteTerminPregleda(tppp.get(i));
                    }
                    Communication.getInstance().deletePacijent(pacijent);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem je obrisao podatke o pacijentu", "Brisanje pacijenta", JOptionPane.INFORMATION_MESSAGE);
                    pacijentForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(PacijentController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da obriše pacijenta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        pacijentForm.addIzmeniBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

            private void edit() {
                try {
                    Pacijent pacijent = makePacijentFromForm();
                    if (pacijent == null) {
                        JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da zapamti pacijenta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Communication.getInstance().editPacijent(pacijent);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem je zapamtio pacijenta", "Izmena pacijenta", JOptionPane.INFORMATION_MESSAGE);
                    pacijentForm.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(StaklaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(pacijentForm, "Sistem ne može da zapamti pacijenta", "Pacijent greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_ADD:
                pacijentForm.getBtnOtkazi().setEnabled(true);
                pacijentForm.getBtnIzbrisi().setEnabled(false);
                pacijentForm.getBtnIzmeni().setEnabled(false);
                pacijentForm.getBtnOmoguciIzmene().setEnabled(false);
                pacijentForm.getBtnSacuvaj().setEnabled(true);

                pacijentForm.getPoljeId().setEnabled(false);
                pacijentForm.getPoljeIme().setEnabled(true);
                pacijentForm.getPoljePrezime().setEnabled(true);
                pacijentForm.getPoljeTelefon().setEnabled(true);
                pacijentForm.getPoljeDioptrijaDesnogOka().setEnabled(true);
                pacijentForm.getPoljeDioptrijaLevogOka().setEnabled(true);
                pacijentForm.getPoljePD().setEnabled(true);
                break;
            case FORM_VIEW:
                pacijentForm.getBtnOtkazi().setEnabled(true);
                pacijentForm.getBtnIzbrisi().setEnabled(true);
                pacijentForm.getBtnIzmeni().setEnabled(false);
                pacijentForm.getBtnOmoguciIzmene().setEnabled(true);
                pacijentForm.getBtnSacuvaj().setEnabled(false);

                pacijentForm.getPoljeId().setEnabled(false);
                pacijentForm.getPoljeIme().setEnabled(false);
                pacijentForm.getPoljePrezime().setEnabled(false);
                pacijentForm.getPoljeTelefon().setEnabled(false);
                pacijentForm.getPoljeDioptrijaDesnogOka().setEnabled(false);
                pacijentForm.getPoljeDioptrijaLevogOka().setEnabled(false);
                pacijentForm.getPoljePD().setEnabled(false);

                Pacijent pacijent = (Pacijent) MainCoordinator.getInstanca().getParam(Constant.PARAM_PACIJENTI);
                pacijentForm.getPoljeId().setText(pacijent.getId() + "");
                pacijentForm.getPoljeIme().setText(pacijent.getIme());
                pacijentForm.getPoljePrezime().setText(pacijent.getPrezime());
                pacijentForm.getPoljeTelefon().setText(String.valueOf(pacijent.getKontaktTelefon()));
                pacijentForm.getPoljeDioptrijaDesnogOka().setText(String.valueOf(pacijent.getDioptrijaDesnogOka()));
                pacijentForm.getPoljeDioptrijaLevogOka().setText(String.valueOf(pacijent.getDioptrijaLevogOka()));
                pacijentForm.getPoljePD().setText(String.valueOf(pacijent.getPD()));
                JOptionPane.showMessageDialog(pacijentForm, "Sistem je učitao pacijenta");
                break;
            case FORM_EDIT:
                pacijentForm.getBtnOtkazi().setEnabled(true);
                pacijentForm.getBtnIzbrisi().setEnabled(true);
                pacijentForm.getBtnIzmeni().setEnabled(true);
                pacijentForm.getBtnOmoguciIzmene().setEnabled(false);
                pacijentForm.getBtnSacuvaj().setEnabled(false);

                pacijentForm.getPoljeId().setEnabled(false);
                pacijentForm.getPoljeIme().setEnabled(true);
                pacijentForm.getPoljePrezime().setEnabled(true);
                pacijentForm.getPoljeTelefon().setEnabled(true);
                pacijentForm.getPoljeDioptrijaDesnogOka().setEnabled(true);
                pacijentForm.getPoljeDioptrijaLevogOka().setEnabled(true);
                pacijentForm.getPoljePD().setEnabled(true);
                break;
        }        
    }
    private Pacijent makePacijentFromForm() throws ParseException, Exception {
        Pacijent pacijent = new Pacijent();
        pacijent.setId(Integer.parseInt(pacijentForm.getPoljeId().getText().trim()));
        pacijent.setIme(pacijentForm.getPoljeIme().getText().trim());
        pacijent.setPrezime(pacijentForm.getPoljePrezime().getText().trim());
        pacijent.setKontaktTelefon(Integer.parseInt(pacijentForm.getPoljeTelefon().getText().trim()));
        pacijent.setDioptrijaDesnogOka(Double.parseDouble(pacijentForm.getPoljeDioptrijaDesnogOka().getText().trim()));
        pacijent.setDioptrijaLevogOka(Double.parseDouble(pacijentForm.getPoljeDioptrijaLevogOka().getText().trim()));
        pacijent.setPD(Double.parseDouble(pacijentForm.getPoljePD().getText().trim()));
//        if (gost.getIme().isEmpty() || gost.getPrezime().isEmpty() || gost.getDatumRodjenja() == null || gost.getGrad() == null) {
//            return null;
//        }
        if(validacija()){
            return null;
        }
        return pacijent;
    }
    public boolean validacija() throws Exception {
        String error="";
        String id = pacijentForm.getPoljeId().getText();
        String ime = pacijentForm.getPoljeIme().getText();
        String prezime = pacijentForm.getPoljePrezime().getText();
        String telefon = pacijentForm.getPoljeTelefon().getText();
        String dioptirjaLevogOka = pacijentForm.getPoljeDioptrijaLevogOka().getText();
        String dioptrijaDesnogOka = pacijentForm.getPoljeDioptrijaDesnogOka().getText();
        String pd = pacijentForm.getPoljePD().getText();
        boolean fali = false;
        
//        if(id==null || id.isEmpty()){
//            pacijentForm.getTextId().setText("Id cannot be empty!");
//            error += "Id cannot be empty!\n";
//            fali=true;
//        }
        if(ime==null || ime.isEmpty()){
            pacijentForm.getTextIme().setText("Name cannot be empty!");
            error += "Ime cannot be empty!\n";
            fali=true;
        }
        if(prezime==null || prezime.isEmpty()){
            pacijentForm.getTextPrezime().setText("Lastname cannot be empty!");
            error += "Id cannot be empty!\n";
            fali=true;
        }
        if(telefon==null || telefon.isEmpty()){
            pacijentForm.getTextKT().setText("Phone cannot be empty!");
            error += "Phone cannot be empty!\n";
            fali=true;
        }
        if(dioptrijaDesnogOka==null || dioptrijaDesnogOka.isEmpty()){
            pacijentForm.getTextDioptrijaDesnogOka().setText("Dioptrija cannot be empty!");
            error += "Dioptrija cannot be empty!\n";
            fali=true;
        }
        if(dioptirjaLevogOka==null || dioptirjaLevogOka.isEmpty()){
            pacijentForm.getTextDioptrijaDesnogOka().setText("Dioptrija cannot be empty!");
            error += "Dioptrija cannot be empty!\n";
            fali=true;
        }
        if(pd==null || pd.isEmpty()){
            pacijentForm.getTextDioptrijaDesnogOka().setText("PD cannot be empty!");
            error += "PD cannot be empty!\n";
            fali=true;
        }
        if (!error.isEmpty()) {
            throw new Exception(error);
        }
        return fali;
    }
    public void openForm(FormMode formMode) {
        pacijentForm.setLocationRelativeTo(MainCoordinator.getInstanca().getMainController().getFormMain());
        prepareView(formMode);
        pacijentForm.setVisible(true);
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
