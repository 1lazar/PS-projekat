/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Communication;

import communication.Receiver;
import communication.Sender;
import constant.Constant;
import coordinator.MainCoordinator;
import domain.Administrator;
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
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import operation.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Communication {
    
    private static Communication instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Communication() {
        try {
            this.socket = new Socket("localhost", 1803);
            this.sender = new Sender(socket);
            this.receiver = new Receiver(socket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }
    
    public void krajRada() throws Exception{
        Request request = new Request(MainCoordinator.getInstanca().getParam(Constant.CURRENT_USER), Operation.KRAJ_RADA_KORISNIKA);
        sender.send(request);
    }
    
    public Administrator login(String username, String password) throws Exception {
        Administrator user=new Administrator();
        user.setUsername(username);
        user.setPassword(password);
        
        Request request=new Request( user,Operation.LOGIN);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Administrator)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void addPacijent(Pacijent pacijent) throws Exception {
        Request request=new Request(pacijent,Operation.SAVE_PACIJENT);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<Pacijent> getAllPacijent() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_PACIJENTE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Pacijent>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void editPacijent(Pacijent pacijent) throws Exception{
        Request request=new Request(pacijent,Operation.UPDATE_PACIJENTI);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void addNaocare(Naocare naocare) throws Exception {
        Request request=new Request(naocare,Operation.SAVE_NAOCARE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<Naocare> getAllNaocare() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_NAOCARE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Naocare>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void editNaocare(Naocare naocare) throws Exception{
        Request request=new Request(naocare,Operation.UPDATE_NAOCARE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void addStakla(Stakla stakla) throws Exception {
        Request request=new Request(stakla,Operation.SAVE_STAKLA);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<Stakla> getAllStakla() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_STAKLA);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Stakla>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void editStakla(Stakla stakla) throws Exception{
        Request request=new Request(stakla,Operation.UPDATE_STAKLA);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void addVrstaUsluge(VrsteUsluga vrsta) throws Exception {
        Request request=new Request(vrsta,Operation.SAVE_VRSTA_USLUGE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<VrsteUsluga> getAllVrstaUsluge() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_VRSTA_USLUGE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<VrsteUsluga>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void editVrstaUsluge(VrsteUsluga vrsta) throws Exception{
        Request request=new Request(vrsta,Operation.UPDATE_VRSTA_USLUGE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void deleteNaocare(Naocare naocare) throws Exception {
        Request request = new Request(naocare,Operation.DELETE_NAOCARE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public void deletePacijent(Pacijent pacijent) throws Exception {
        Request request = new Request(pacijent,Operation.DELETE_PACIJENT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public void deleteStakla(Stakla stakla) throws Exception {
        Request request = new Request(stakla,Operation.DELETE_STAKLA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public void deleteVrsteUsluga(VrsteUsluga vu) throws Exception {
        Request request = new Request(vu,Operation.DELETE_VRSTA_USLUGE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    public void deleteStavkePregleda(StavkePregleda sp) throws Exception {
        Request request = new Request(sp,Operation.DELETE_STAVKE_PREGLEDA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    
    public List<Opticar> getAllOpticari() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_OPTICAR);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Opticar>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<StavkePregleda> getAllStavkePregelda() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_STAVKE_PREGLEDA);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<StavkePregleda>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Usluga> getAllUsluga() throws Exception {
        Request request=new Request(null, Operation.GET_ALL_USLUGE);
        sender.send(request);
        Response response=(Response)receiver.receive();
        System.out.println(response.getResult());
        if(response.getException()==null){
            System.out.println("asdfns");
            return (List<Usluga>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public int maxIdTP() throws Exception {
        Request request = new Request(null, Operation.MAX_ID_TERMIN_PREGLEDA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (int) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public int maxIdUsluga() throws Exception {
        Request request = new Request(null, Operation.MAX_ID_USLUGA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (int) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public void addTerminPregleda(TerminPregleda tp) throws Exception {
        Request request=new Request(tp,Operation.SAVE_TERMIN_PREGLEDA);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<TerminPregleda> vratiTPID(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_TERMIN_PREGLEDA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<TerminPregleda>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    public List<StavkePregleda> vratiStavkeID(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_STAVKE_PREGLEDA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<StavkePregleda>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public List<Usluga> vratiUslugeNID(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_USLUGA_NAOCARA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Usluga>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    public List<Usluga> vratiUslugeSID(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_USLUGA_STAKLA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Usluga>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    public List<Usluga> vratiUslugeVUID(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_USLUGA_VRSTE_USLUGA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Usluga>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    public List<StatistikaOdUsluga> vratiStatistikuOdUsluga(int idp) throws Exception {
        Request request = new Request(idp, Operation.VRATI_STATISTIKA_OD_USLUGA_ID);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<StatistikaOdUsluga>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    public void deleteTerminPregleda(TerminPregleda tp) throws Exception {
        Request request = new Request(tp,Operation.DELETE_TERMIN_PREGLEDA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public void deleteUsluga(Usluga tp) throws Exception {
        Request request = new Request(tp,Operation.DELETE_USLUGA);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public void deleteStatistikaOdUsluga(StatistikaOdUsluga sou) throws Exception {
        Request request = new Request(sou,Operation.DELETE_STATISTIKA_OD_USLUGE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
    public List<Pacijent> vratiPacijenteImePrezime(String ime, String prezime) throws Exception {
        List<String> imePrezime = new ArrayList<>();
        imePrezime.add(ime);
        imePrezime.add(prezime);
        Request request = new Request(imePrezime, Operation.VRATI_PACIJENTE_IME_PREZIME);
        sender.send(request);
        Response response = (Response) receiver.receive();
        System.out.println(response);
        if (response.getException() == null) {
            return (List<Pacijent>) response.getResult();
        } else {
            throw response.getException();
        }
    }
}
