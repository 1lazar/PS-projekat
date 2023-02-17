/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.controller;

import form.FormSettings;
import form.coordinator.MainCoordinator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.Settings;

/**
 *
 * @author Laza Laki Lakosta
 */
public class SettingsController {
    private final FormSettings formSettings;

    public SettingsController(FormSettings formSettings) {
        this.formSettings = formSettings;
        addActionListener();
    }
    public void openForm() {
        formSettings.setLocationRelativeTo(MainCoordinator.getInstance().getMainController().getMainForm());
        formSettings.setTitle("Podešavanja");
        formSettings.setVisible(true);
    }

    private void addActionListener() {
        formSettings.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = formSettings.getTxtURL().getText().trim();
                String username = formSettings.getTxtUsername().getText().trim();
                String password = new String(formSettings.getTxtPassword().getPassword()).trim();

                if (url.isEmpty() || username.isEmpty()) {
                    try {
                        validateTxt(url, username, password);
                    } catch (Exception ex) {
                        Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(formSettings, "Url i username moraju biti uneti");
                    return;
                }

                Settings.getInstanca().setURL(url);
                Settings.getInstanca().setUsername(username);
                Settings.getInstanca().setPassword(password);
                Settings.getInstanca().sacuvaj();

                formSettings.dispose();
            }
        });
    }
    private void validateTxt(String url, String username, String password) throws Exception {
        String errorMessage = "";
        formSettings.getLblPassword().setText("");
        formSettings.getLblurl().setText("");
        formSettings.getLblUsername().setText("");
        if (url.isEmpty()) {
            errorMessage += "URL can not be empty!\n";
            formSettings.getLblurl().setText("Username can not be empty!\n");
        }
        if (username.isEmpty()) {
            errorMessage += "Username can not be empty!\n";
            formSettings.getLblUsername().setText("Username can not be empty!\n");
        }
//        if (password.isEmpty()) {
//            errorMessage += "Password can not be empty!\n";
//            formSettings.getLblPassword().setText("Password can not be empty!\n");
//        }
        if (!errorMessage.isEmpty()) {
            throw new Exception("You must fill username and password");
        }
    }
}
