/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinator;

import controller.LoginController;
import controller.MainController;
import controller.NaocareController;
import controller.NaocareViewController;
import controller.PacijentController;
import controller.PacijentViewController;
import controller.StaklaController;
import controller.StaklaViewController;
import controller.TerminPregledaController;
import controller.VrstaUslugeController;
import controller.VrstaUslugeViewController;
import form.FormMain;
import form.LoginForma;
import form.MainForm;
import form.NaocareForm;
import form.NaocareViewForm;
import form.PacijentForm;
import form.PacijentiViewForm;
import form.StaklaForm;
import form.StaklaViewForm;
import form.TerminPregledaForm;
import form.TerminPregledaProba;
import form.VrstaUslugeForm;
import form.VrstaUslugeViewForm;
import form.util.FormMode;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laza Laki Lakosta
 */
public class MainCoordinator {
    private static MainCoordinator instanca;

    private final MainController mainController;
    private final Map<String, Object> params;

    public MainCoordinator() {
        this.mainController = new MainController(new FormMain());
        this.params = new HashMap<>();
    }

    public static MainCoordinator getInstanca() {
        if(instanca == null){
            instanca = new MainCoordinator();
        }
        return instanca;
    }
    
    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }

    public MainController getMainController() {
        return mainController;
    }
    
    public void openLoginForm() {
        LoginController loginController;
        try {
            loginController = new LoginController(new LoginForma());
            loginController.openForm();
        } catch (SQLException ex) {
            Logger.getLogger(MainCoordinator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void openMainForm() {
        mainController.openForm();
    }
    
    public void opernAddNaocareForm(){
        NaocareController nc = new NaocareController(new NaocareForm(mainController.getFormMain(), true));
        nc.openForm(FormMode.FORM_ADD);
    }
    public void openNaocareDetailsForm() {
        NaocareForm naocareForm = new NaocareForm(mainController.getFormMain(), true);
        NaocareController roomController = new NaocareController(naocareForm);
        roomController.openForm(FormMode.FORM_VIEW);
    }
    public void openNaocareViewForm() {
        NaocareViewForm nvf = new NaocareViewForm(mainController.getFormMain(), true);
        NaocareViewController nvc = new NaocareViewController(nvf);
        nvc.openForm();
    }
    public void opernAddPacijentForm(){
        PacijentController pc = new PacijentController(new PacijentForm(mainController.getFormMain(), true));
        pc.openForm(FormMode.FORM_ADD);
    }
    public void openPacijentViewForm() {
        PacijentiViewForm pvf = new PacijentiViewForm(mainController.getFormMain(), true);
        PacijentViewController pvc = new PacijentViewController(pvf);
        pvc.openForm();
    }
    public void openPacijentDetailsForm() {
        PacijentForm pacijentForm = new PacijentForm(mainController.getFormMain(), true);
        PacijentController pController = new PacijentController(pacijentForm);
        pController.openForm(FormMode.FORM_VIEW);
    }
    public void opernAddStaklaForm(){
        StaklaController sc = new StaklaController(new StaklaForm(mainController.getFormMain(), true));
        sc.openForm(FormMode.FORM_ADD);
    }
    public void openStaklatDetailsForm() {
        StaklaForm staklaForm = new StaklaForm(mainController.getFormMain(), true);
        StaklaController sController = new StaklaController(staklaForm);
        sController.openForm(FormMode.FORM_VIEW);
    }
    public void openStaklaViewForm() {
        StaklaViewForm svf = new StaklaViewForm(mainController.getFormMain(), true);
        StaklaViewController svc = new StaklaViewController(svf);
        svc.openForm();
    }
    public void opernAddVrstaUslugeForm(){
        VrstaUslugeController vuc = new VrstaUslugeController(new VrstaUslugeForm(mainController.getFormMain(), true));
        vuc.openForm(FormMode.FORM_ADD);
    }
    public void openVrstaUslugeDetailsForm() {
        VrstaUslugeForm vuForm = new VrstaUslugeForm(mainController.getFormMain(), true);
        VrstaUslugeController vuController = new VrstaUslugeController(vuForm);
        vuController.openForm(FormMode.FORM_VIEW);
    }
    public void openVrstaUslugeViewForm() {
        VrstaUslugeViewForm vuvf = new VrstaUslugeViewForm(mainController.getFormMain(), true);
        VrstaUslugeViewController vuvc = new VrstaUslugeViewController(vuvf);
        vuvc.openForm();
    }
    public void opernAddVrstaTerminpregledaForm(){
        TerminPregledaController tpc = new TerminPregledaController(new TerminPregledaProba(mainController.getFormMain(), true));
        tpc.openForm(FormMode.FORM_ADD);
    }
//    public void openVrstaTerminpregledaDetailsForm() {
//        TerminPregledaForm tpForm = new TerminPregledaForm(mainController.getFormMain(), true);
//        TerminPregledaController tpController = new TerminPregledaController(tpForm);
//        tpController.openForm(FormMode.FORM_VIEW);
//    }
    
}
