/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Communication.Communication;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Administrator;
import form.LoginForma;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laza Laki Lakosta
 */
public class LoginController {
    private final LoginForma loginForm;

    public LoginController(LoginForma loginForm) {
        this.loginForm = loginForm;
        addActionListener();
    }
    
    public void openForm(){
        loginForm.setVisible(true);
        loginForm.setTitle("Prijava");
    }
    
    private void addActionListener() {
        loginForm.loginAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loginKorisnik(e);
            }

            private void loginKorisnik(ActionEvent e) {
                resetujFormu();
                try {
                    String username = loginForm.getTxtUsername().getText().trim();
                    String password = String.copyValueOf(loginForm.getTxtPassword().getPassword());
                    validateLogin(username, password);
                    //System.out.println(password);
                    Administrator admin = Communication.getInstance().login(username, password);
                    JOptionPane.showMessageDialog(loginForm, "Dobrodošli " + admin.getIme() + " " + admin.getPrezime(), "Prijava", JOptionPane.INFORMATION_MESSAGE);
                    loginForm.dispose();
                    MainCoordinator.getInstanca().addParam(Constant.CURRENT_USER, admin);
                    MainCoordinator.getInstanca().openMainForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(loginForm, ex.getMessage(), "Login greška", JOptionPane.ERROR_MESSAGE);
                }
            }
            private void resetujFormu() {
                loginForm.getLabelaUsernameGreska().setText("");
                loginForm.getLabelaPassGreska().setText("");
            }
            private void validateLogin(String username, String password) throws Exception {
                String error = "";
                if(username == null || username.isEmpty()){
                    loginForm.getLabelaUsernameGreska().setText("Username cannot be empty!");
                    loginForm.getLabelaUsernameGreska().setForeground(Color.red);
                    error += "Username cannot be empty!\n";
                }
                if (password == null || password.length() < 3) {
                    loginForm.getLabelaPassGreska().setText("Password must contain at least three chars!");
                    loginForm.getLabelaPassGreska().setForeground(Color.red);
                    error += "Password must contain at least three chars!\n";
                }
                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }
        });
//        loginForm.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                try {
//                    Komunikacija.getInstanca().krajRadaLogin();
//                } catch (Exception ex) {
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//        });
    }
}
