/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.coordinator;

import form.FormSettings;
import form.MainForm;
import form.controller.MainController;
import form.controller.SettingsController;

/**
 *
 * @author Laza Laki Lakosta
 */
public class MainCoordinator {
    private static MainCoordinator instanca;
    private final MainController mainController;

    public MainCoordinator() {
        mainController = new MainController(new MainForm());
    }
    
    public static MainCoordinator getInstance() {
        if(instanca == null){
            instanca = new MainCoordinator();
        }
        return instanca;
    }
    
    public void openMainForm(){
        mainController.openForm();
    }
    
    public void openSettingsForm() {
        SettingsController settingsController = new SettingsController(new FormSettings(mainController.getMainForm(), true));
        settingsController.openForm();
    }

    public MainController getMainController() {
        return mainController;
    }
}
