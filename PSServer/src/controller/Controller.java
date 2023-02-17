/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.GenericEntity;
import domain.Naocare;
import domain.Opticar;
import domain.Pacijent;
import domain.Stakla;
import domain.StatistikaOdUsluga;
import domain.StavkePregleda;
import domain.TerminPregleda;
import domain.Usluga;
import domain.VrsteUsluga;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import operation.administator.UlogujAdministratora;
import operation.naocare.AddNaocare;
import operation.naocare.DeleteNaocare;
import operation.naocare.EditNaocare;
import operation.naocare.GetAllNaocare;
import operation.opticar.GetAllOpticar;
import operation.pacijent.AddPacijent;
import operation.pacijent.DeletePacijent;
import operation.pacijent.EditPacijent;
import operation.pacijent.FiltirajPacijente;
import operation.pacijent.GetAllPacijent;
import operation.stakla.AddStakla;
import operation.stakla.DeleteStakla;
import operation.stakla.GetAllStakla;
import operation.statistikaOdUsluga.AddStatistinaOdUsluga;
import operation.statistikaOdUsluga.DeleteStatistikaOdUsluga;
import operation.statistikaOdUsluga.FindStatistikaOdUsluga;
import operation.statistikaOdUsluga.GetAllStatistikaOdUsluga;
import operation.stavkePregleda.DeleteStavkePregleda;
import operation.stavkePregleda.FindStavkePregleda;
import operation.stavkePregleda.GetAllStavkePregleda;
import operation.terminpregelda.AddTerminPregleda;
import operation.terminpregelda.DeleteTerminPregleda;
import operation.terminpregelda.FindTerminPregleda;
import operation.terminpregelda.GetAllTerminPregleda;
import operation.terminpregelda.MaxIDTerminPregleda;
import operation.usluga.AddUsluga;
import operation.usluga.DeleteUsluga;
import operation.usluga.FindUsluga;
import operation.usluga.GetAllUsluga;
import operation.vrstaUsluge.AddVrstaUsluge;
import operation.vrstaUsluge.DeleteVrstaUsluge;
import operation.vrstaUsluge.EditVrstaUsluge;
import operation.vrstaUsluge.GetAllVrstaUsluge;
import repository.Repository;
import repository.db.DBRepository;
import repository.db.impl.RepositoryDBAdministrator;
import repository.db.impl.RepositoryDBGeneric;
import repository.db.impl.RepositoryDBNaocare;
import repository.db.impl.RepositoryDBPacijent;
import repository.db.impl.RepositoryDBStakla;
import repository.db.impl.RepositoryDBStatistikaOdUsluga;
import repository.db.impl.RepositoryDBStavkePregleda;
import repository.db.impl.RepositoryDBTerminPregleda;
import repository.db.impl.RepositoryDBUsluge;
import server.Server;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Controller {
     
    private final Repository repositoryGeneric;
    private final RepositoryDBUsluge repositoryUsluge;
    private final RepositoryDBTerminPregleda repositoryTerminPregleda;
    private Server server;
    private static Controller controller;
    public List<GenericEntity> prijavljeniKorisnici;
    
    public Controller() {
       repositoryGeneric = new RepositoryDBGeneric();
       repositoryUsluge = new RepositoryDBUsluge();
       repositoryTerminPregleda = new RepositoryDBTerminPregleda();
       prijavljeniKorisnici = new ArrayList<>();
    }

    public static Controller getInstance() {
        if(controller==null)
            controller = new Controller();
        return controller;
    }
    
    public void startujServer() throws IOException {
        if (server == null || !server.isAlive()) {
            server = new Server();
            server.start();
        }
    }

    public void stopServer() {
        server.kraj();
    }
    
    public List<GenericEntity> getPrijavljeniKorisnici() {
        return prijavljeniKorisnici;
    }
    public void setPrijavljeniKorisnici(List<GenericEntity> prijavljeniKorisnici) {
        this.prijavljeniKorisnici = prijavljeniKorisnici;
    }
    
    public GenericEntity login(String username, String password) throws Exception {
        Administrator admin = new Administrator();
        admin.setUsername(username);
        admin.setPassword(password);
        
        AbstractGenericOperation operation = new UlogujAdministratora();
        operation.execute(admin);
        return ((UlogujAdministratora) operation).getGenericEntity();
        
    }
    
    public void savePacijent(Pacijent pacijent) throws Exception{
//        try {
//            ( (DBRepository) repositoryPacijent).connect();
//            repositoryPacijent.add(pacijent);
//            //( (DBRepository) repositoryPacijent).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new AddPacijent();
        operation.execute(pacijent);
    }
    public List<Pacijent> getAllPacijent() throws Exception{
//        List<Pacijent> pacijenti = null;
//        try {
////            ( (DBRepository) repositoryPacijent).connect();
//            pacijenti = repositoryPacijent.getAll();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return pacijenti;
        AbstractGenericOperation operation = new GetAllPacijent();
        operation.execute(new Pacijent());
        return ((GetAllPacijent)operation).getPacijenti();
    }
    public void updatePacijente(Pacijent pacijenti) throws Exception{
//        try {
//            ( (DBRepository) repositoryPacijent).connect();
//            repositoryPacijent.edit(pacijenti);
//            ( (DBRepository) repositoryPacijent).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new EditPacijent();
        operation.execute(pacijenti);
    }
    public void deletePacijent(Pacijent pacijent) throws Exception{
//        try {
//            ( (DBRepository) repositoryPacijent).connect();
//            repositoryPacijent.delete(pacijent);
//            //( (DBRepository) repositoryPacijent).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new DeletePacijent();
        operation.execute(pacijent);
    }
    
    public void saveNaocare (Naocare naocare) throws Exception{
//        try {
//            ( (DBRepository) repositoryNaocare).connect();
//            repositoryNaocare.add(naocare);
//            ( (DBRepository) repositoryNaocare).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new AddNaocare();
        operation.execute(naocare);
    }
    public List<Naocare> getAllNaocare() throws Exception{
//        System.out.println("sandkabh");
//        List<Naocare> naocare = null;
//        try {
//            ( (DBRepository) repositoryNaocare).connect();
//            naocare = repositoryNaocare.getAll();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return naocare;
        AbstractGenericOperation operation = new GetAllNaocare();
        operation.execute(new Naocare());
        return ((GetAllNaocare)operation).getNaocare();
    }
    public void updateNocare(List<Naocare> naocare) throws Exception{
//        try {
//            ( (DBRepository) repositoryNaocare).connect();
//            repositoryNaocare.edit(naocare);
//            ( (DBRepository) repositoryNaocare).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new EditNaocare();
        operation.execute(naocare);
    }
    
    public void saveTerminPregleda (TerminPregleda tp) throws Exception{
//        try {
//            ( (DBRepository) repositoryTerminPregleda).connect();
//            repositoryTerminPregleda.add(tp);
//            //( (DBRepository) repositoryTerminPregleda).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new AddTerminPregleda();
        operation.execute(tp);
    } 
    public void deleteTerminPregleda(TerminPregleda tp) throws Exception{
//        try {
//            ( (DBRepository) repositoryTerminPregleda).connect();
//            repositoryTerminPregleda.delete(tp);
//            //( (DBRepository) repositoryTerminPregleda).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new DeleteTerminPregleda();
        operation.execute(tp);
    }
    public List<TerminPregleda> getAllTerminPregleda() throws Exception{
//        List<TerminPregleda> tp = null;
//        
//        try {
//            ((DBRepository) repositoryTerminPregleda).connect();
//            tp = repositoryTerminPregleda.getAll();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(tp);
//        return tp;
        AbstractGenericOperation operation = new GetAllTerminPregleda();
        operation.execute(new TerminPregleda());
        return ((GetAllTerminPregleda)operation).getTerminPregleda();
    }
    
    public void saveUsluge (Usluga usluga) throws Exception{
//        try {
//            ( (DBRepository) repositoryUsluge).connect();
//            repositoryUsluge.add(usluga);
//            ( (DBRepository) repositoryUsluge).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("sacuven");
        AbstractGenericOperation operation = new AddUsluga();
        operation.execute(usluga);
    }
    
    public List<Usluga> getAllUsluge() throws Exception{
        List<Usluga> usluge = null;
        
        try {
            ((DBRepository) repositoryUsluge).connect();
            usluge = repositoryUsluge.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(usluge);
        return usluge;
//        AbstractGenericOperation operation = new GetAllUsluga();
//        System.out.println(((GetAllUsluga)operation).getUsluge());
//        operation.execute(new Usluga());
//        return ((GetAllUsluga)operation).getUsluge();
    }
    
    public void deleteUsluga(Usluga usluga) throws Exception{
//        try {
//            ( (DBRepository) repositoryUsluge).connect();
//            repositoryUsluge.delete(usluga);
//            //( (DBRepository) repositoryUsluge).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new DeleteUsluga();
        operation.execute(usluga);
    }
    
    public void saveStatistikaOdUsluge (StatistikaOdUsluga usluga) throws Exception{
//        try {
//            ( (DBRepository) repositoryStatistikaOdUsluga).connect();
//            repositoryStatistikaOdUsluga.add(usluga);
//            ( (DBRepository) repositoryStatistikaOdUsluga).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }  
        AbstractGenericOperation operation = new AddStatistinaOdUsluga();
        operation.execute(usluga);
    }
    
    public List<StatistikaOdUsluga> getAllStatistikaOdUsluge() throws Exception{
//        List<StatistikaOdUsluga> statistika = null;
//        
//        try {
//            ((DBRepository) repositoryStatistikaOdUsluga).connect();
//            statistika = repositoryStatistikaOdUsluga.getAll();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return statistika;
        AbstractGenericOperation operation = new GetAllStatistikaOdUsluga();
        operation.execute(new StatistikaOdUsluga());
        return ((GetAllStatistikaOdUsluga)operation).getStatistikaOdUsluga();
    }
    
    public void deleteStatistikaOdUsluge(StatistikaOdUsluga statistika) throws Exception{
//        try {
//            ( (DBRepository) repositoryStatistikaOdUsluga).connect();
//            repositoryStatistikaOdUsluga.delete(statistika);
//            //( (DBRepository) repositoryStatistikaOdUsluga).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new DeleteStatistikaOdUsluga();
        operation.execute(statistika);
    }
    
    public void saveStakla (Stakla stakla) throws Exception{
//        try {
//            ( (DBRepository) repositoryStakla).connect();
//            repositoryStakla.add(stakla);
//            ( (DBRepository) repositoryStakla).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new AddStakla();
        operation.execute(stakla);
    }
    
    public List<Stakla> getAllStakla() throws Exception{
//        List<Stakla> stakla = null;
//        
//        try {
//            ((DBRepository) repositoryStakla).connect();
//            stakla = repositoryStakla.getAll();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return stakla;
        AbstractGenericOperation operation = new GetAllStakla();
        operation.execute(new Stakla());
        return ((GetAllStakla)operation).getStakla();
    }
    
    public void deleteStakla(Stakla stakla) throws Exception{
//        try {
//            ( (DBRepository) repositoryStakla).connect();
//            repositoryStakla.delete(stakla);
//            //( (DBRepository) repositoryStatistikaOdUsluga).commit();
//        } catch (Exception ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AbstractGenericOperation operation = new DeleteStakla();
        operation.execute(stakla);
    }
    public void saveVrsteUsluge (VrsteUsluga vrsta) throws Exception{

        AbstractGenericOperation operation = new AddVrstaUsluge();
        operation.execute(vrsta);
    }
    
    public List<VrsteUsluga> getAllVrsteUsluge() throws Exception{

        AbstractGenericOperation operation = new GetAllVrstaUsluge();
        operation.execute(new VrsteUsluga());
        return ((GetAllVrstaUsluge)operation).getVrsteUsluga();
    }
    
    public void deleteVrsteUsluge(VrsteUsluga vrsta) throws Exception{

        AbstractGenericOperation operation = new DeleteVrstaUsluge();
        operation.execute(vrsta);
    }
        public void updateVrsteUsluge(List<VrsteUsluga> vrste) throws Exception{

        AbstractGenericOperation operation = new EditVrstaUsluge();
        operation.execute(vrste);
    }
        
    public List<Opticar> getAllOpticar() throws Exception{
        AbstractGenericOperation operation = new GetAllOpticar();
        operation.execute(new Opticar());
        return ((GetAllOpticar)operation).getOpticari();
    }
    
    public List<StavkePregleda> getAllStavkePregleda() throws Exception{
        AbstractGenericOperation operation = new GetAllStavkePregleda();
        operation.execute(new StavkePregleda());
        return ((GetAllStavkePregleda)operation).getStavke();
    }
    
    public List<Usluga> getAllUsluga() throws Exception{
        AbstractGenericOperation operation = new GetAllUsluga();
        operation.execute(new Usluga());
        return ((GetAllUsluga)operation).getUsluge();
    }
    
    public int maxIdTP() throws Exception {
        AbstractGenericOperation operation = new MaxIDTerminPregleda();
        operation.execute(new TerminPregleda());
        return ((MaxIDTerminPregleda) operation).getId();
    }
    
    public int maxIdUsluga() throws Exception {
        AbstractGenericOperation operation = new MaxIDTerminPregleda();
        operation.execute(new TerminPregleda());
        return ((MaxIDTerminPregleda) operation).getId();
    }
    
    public List<TerminPregleda> dajTerminPregleda(int id) throws Exception {
        Pacijent p = new Pacijent();
        p.setId(id);
        AbstractGenericOperation operation = new FindTerminPregleda();
        operation.execute(p);
        List<TerminPregleda> tp = (List<TerminPregleda>) ((FindTerminPregleda) operation).getGenericEntity();
        return tp;
    }
    public List<StavkePregleda> dajStavkePregleda(int id) throws Exception {
        TerminPregleda p = new TerminPregleda();
        p.setId(id);
        AbstractGenericOperation operation = new FindStavkePregleda();
        operation.execute(p);
        List<StavkePregleda> tp = (List<StavkePregleda>) ((FindStavkePregleda) operation).getGenericEntity();
        return tp;
    }
    
    public List<Usluga> dajUslugaNaocare(int id) throws Exception {
        Naocare p = new Naocare();
        p.setId(id);
        AbstractGenericOperation operation = new FindUsluga();
        operation.execute(p);
        List<Usluga> tp = (List<Usluga>) ((FindUsluga) operation).getGenericEntity();
        return tp;
    }
    
    public List<Usluga> dajUslugaStakla(int id) throws Exception {
        Stakla p = new Stakla();
        p.setId(id);
        AbstractGenericOperation operation = new FindUsluga();
        operation.execute(p);
        List<Usluga> tp = (List<Usluga>) ((FindUsluga) operation).getGenericEntity();
        return tp;
    }
    
    public List<Usluga> dajUslugaVrstaUsluge(int id) throws Exception {
        VrsteUsluga p = new VrsteUsluga();
        p.setId(id);
        AbstractGenericOperation operation = new FindUsluga();
        operation.execute(p);
        List<Usluga> tp = (List<Usluga>) ((FindUsluga) operation).getGenericEntity();
        return tp;
    }
    
    public List<StatistikaOdUsluga> dajStatistikuOdUsluga(int id) throws Exception {
        Usluga p = new Usluga();
        p.setId(id);
        AbstractGenericOperation operation = new FindStatistikaOdUsluga();
        operation.execute(p);
        List<StatistikaOdUsluga> tp = (List<StatistikaOdUsluga>) ((FindStatistikaOdUsluga) operation).getGenericEntity();
        return tp;
    }
    
    public void deleteStavkePregleda(StavkePregleda sp) throws Exception{
        AbstractGenericOperation operation = new DeleteStavkePregleda();
        operation.execute(sp);
    }
        public void deleteNaocare(Naocare naocare) throws Exception{

        AbstractGenericOperation operation = new DeleteNaocare();
        operation.execute(naocare);
    }
    public List<GenericEntity> filterPacijente(String ime, String prezime) throws Exception {
        Pacijent pacijent = new Pacijent();
        pacijent.setIme(ime);
        pacijent.setPrezime(prezime);
        AbstractGenericOperation operation = new FiltirajPacijente();
        operation.execute(pacijent);
        List<GenericEntity> gosti = ((FiltirajPacijente) operation).getList();
//        for (GenericEntity genericEntity : gosti) {
//            Pacijent p = (Pacijent) genericEntity;
//            p.setGrad((Pacijent) dajGrad(g.getGrad().getGradID()));
//        }
        return gosti;
    }
}
