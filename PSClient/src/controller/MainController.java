/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Administrator;
import form.FormMain;
import form.PacijentForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laza Laki Lakosta
 */
public class MainController {
    private final FormMain formMain;

    public MainController(FormMain formMain) {
        this.formMain = formMain;
        addActionListener();
    }

    public void openForm() {
//        Korisnik korisnik = (Korisnik) MainCoordinator.getInstanca().getParam(Konstante.CURRENT_USER);
//        frmMain.getLabelaUlogovaniKorisnik().setText(korisnik.getIme() + " " + korisnik.getPrezime());
        formMain.setVisible(true);
    }
    
    private void addActionListener() {
        formMain.jmiDodajPacijentaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().opernAddPacijentForm();
            }
            
        });
        formMain.jmiPretraziPacijentaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().openPacijentViewForm();
            }    
        });
        formMain.jmiDodajNaocareAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().opernAddNaocareForm();
            }
            
        });
        formMain.jmiPretraziNaocareAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().openNaocareViewForm();
            }    
        });
        formMain.jmiDodajStaklaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().opernAddStaklaForm();
            }
            
        });
        formMain.jmiPretraziStaklaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().openStaklaViewForm();
            }    
        });
        formMain.jmiDodajVrsteUslugaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().opernAddVrstaUslugeForm();
            }
            
        });
        formMain.jmiPretraziVrsteUslugaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().openVrstaUslugeViewForm();
            }    
        });
        formMain.jmiPretraziVrsteTerminPregledaAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstanca().opernAddVrstaTerminpregledaForm();
            }    
        });
        formMain.jmiSoftverAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(formMain, "Softver je napravio student Lazar Grebović. Vezan je za optiku, gde mozete da unesete pacijenta,naocare,stakla i vrste usluga. Mozete naravno i da zakazete termin pregleda. Nadam se da ce Vam se svideti.");
            }
            
        });
        formMain.addKrajBtnAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Communication.getInstance().krajRada();
                    Administrator admin = (Administrator) MainCoordinator.getInstanca().getParam(Constant.CURRENT_USER);
                    JOptionPane.showMessageDialog(formMain, "Doviđenja, " + admin.getIme() + " " + admin.getPrezime() + ". Prijatan dan!");
                    System.exit(0);
                } catch (Exception ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public FormMain getFormMain() {
        return formMain;
    }
}
