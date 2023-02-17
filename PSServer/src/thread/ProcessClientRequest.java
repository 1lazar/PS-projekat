/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Sender;
import controller.Controller;
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
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.Operation;
import static operation.Operation.LOGIN;
import server.Server;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Laza Laki Lakosta
 */
public class ProcessClientRequest extends Thread {

    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    private Administrator administratori;
    private boolean kraj = false;

    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!kraj) {
            try {
                Request request = (Request) receiver.receive();
                Response response = null;
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Administrator admin = (Administrator) request.getArgument();
                            System.out.println(admin.getPassword());
                            GenericEntity entity = Controller.getInstance().login(admin.getUsername(), admin.getPassword());
                            if(entity == null){
                                Exception e = new Exception("Administrator nema pravo pristupa");
                                response = new Response(null, e);
                            }else{
                                if (!Controller.getInstance().getPrijavljeniKorisnici().contains(entity)) {
                                    Controller.getInstance().getPrijavljeniKorisnici().add(entity);
                                    response = new Response(entity, null);
                                } else {
                                    Exception e = new Exception("Korisnik je već prijavljen");
                                    response = new Response(null, e);
                                }
                            }
                            
                            break;
                        case GET_ALL_PACIJENTE:
//                            List<Pacijent> pacijenti = Controller.getInstance().getAllPacijent();
//                            response = new Response(pacijenti, null);
                            response = new Response(Controller.getInstance().getAllPacijent(), null);
                            break;
                        case SAVE_PACIJENT:
                            Pacijent pacijent = (Pacijent) request.getArgument();
                            Controller.getInstance().savePacijent(pacijent);
                            response = new Response(pacijent, null);
                            break;
                        case UPDATE_PACIJENTI:
                            Pacijent pacijenti1 =  (Pacijent) request.getArgument();
                            Controller.getInstance().updatePacijente(pacijenti1);
                            response = new Response(pacijenti1, null);
                            break;
                        case DELETE_PACIJENT:
                            Pacijent pacijent1 = (Pacijent) request.getArgument();
                            Controller.getInstance().deletePacijent(pacijent1);
                            response = new Response(pacijent1, null);
                            break;
                        case GET_ALL_NAOCARE:
                            List<Naocare> naocare1 = Controller.getInstance().getAllNaocare();
                            response = new Response(naocare1, null);
                            break;
                        case SAVE_NAOCARE:
                            Naocare naocare = (Naocare) request.getArgument();
                            Controller.getInstance().saveNaocare(naocare);
                            response = new Response(naocare, null);
                            break;
                        case UPDATE_NAOCARE:
                            List<Naocare> naocare2 =  (List<Naocare>) request.getArgument();
                            Controller.getInstance().updateNocare(naocare2);
                            response = new Response(naocare2, null);
                            break;
                        case GET_ALL_TERMIN_PREGLEDA:
                            List<TerminPregleda> tp2 = Controller.getInstance().getAllTerminPregleda();
                            response = new Response(tp2, null);
                            break;
                        case SAVE_TERMIN_PREGLEDA:
                            TerminPregleda tp = (TerminPregleda) request.getArgument();
                            Controller.getInstance().saveTerminPregleda(tp);
                            response = new Response(tp, null);
                            break;
                        case DELETE_TERMIN_PREGLEDA:
                            TerminPregleda tp1 = (TerminPregleda) request.getArgument();
                            Controller.getInstance().deleteTerminPregleda(tp1);
                            response = new Response(tp1, null);
                            break;
                        case SAVE_USLUGA:
                            Usluga usluga = (Usluga) request.getArgument();
                            Controller.getInstance().saveUsluge(usluga);
                            response = new Response(usluga, null);
                            break;
                        case GET_ALL_USLUGE:
                            List<Usluga> usluge = Controller.getInstance().getAllUsluge();
                            response = new Response(usluge, null);
                            break;
                        case DELETE_USLUGA:
                            Usluga usluga1 = (Usluga) request.getArgument();
                            Controller.getInstance().deleteUsluga(usluga1);
                            response = new Response(usluga1, null);
                            break;
                        case SAVE_STATISTIKA_OD_USLUGA:
                            StatistikaOdUsluga statistika =  (StatistikaOdUsluga) request.getArgument();
                            Controller.getInstance().saveStatistikaOdUsluge(statistika);
                            response = new Response(statistika, null);
                            break;
                        case GET_ALL_STATISTIKA_OD_USLUGA:
                            List<StatistikaOdUsluga> statistike = Controller.getInstance().getAllStatistikaOdUsluge();
                            response = new Response(statistike, null);
                            break;
                        case DELETE_STATISTIKA_OD_USLUGE:
                            StatistikaOdUsluga sou =  (StatistikaOdUsluga) request.getArgument();
                            Controller.getInstance().deleteStatistikaOdUsluge(sou);
                            response = new Response(sou, null);
                            break;
                        case DELETE_STAKLA:
                            Stakla staklo =  (Stakla) request.getArgument();
                            Controller.getInstance().deleteStakla(staklo);
                            response = new Response(staklo, null);
                            break;
                        case GET_ALL_STAKLA:
                            List<Stakla> stakla1 = Controller.getInstance().getAllStakla();
                            response = new Response(stakla1, null);
                            break;
                        case SAVE_STAKLA:
                            Stakla stakla2 = (Stakla) request.getArgument();
                            Controller.getInstance().saveStakla(stakla2);
                            response = new Response(stakla2, null);
                            break;
                        case SAVE_VRSTA_USLUGE:
                            VrsteUsluga vrsta =  (VrsteUsluga) request.getArgument();
                            Controller.getInstance().saveVrsteUsluge(vrsta);
                            response = new Response(vrsta, null);
                            break;
                        case GET_ALL_VRSTA_USLUGE:
                            List<VrsteUsluga> vrste = Controller.getInstance().getAllVrsteUsluge();
                            response = new Response(vrste, null);
                            break;
                        case DELETE_VRSTA_USLUGE:
                            VrsteUsluga vu =  (VrsteUsluga) request.getArgument();
                            Controller.getInstance().deleteVrsteUsluge(vu);
                            response = new Response(vu, null);
                            break;
                        case UPDATE_VRSTA_USLUGE:
                            List<VrsteUsluga> vu2 =  (List<VrsteUsluga>) request.getArgument();
                            Controller.getInstance().updateVrsteUsluge(vu2);
                            response = new Response(vu2, null);
                            break;
                        case GET_ALL_OPTICAR:
                            List<Opticar> opticar = Controller.getInstance().getAllOpticar();
                            response = new Response(opticar, null);
                            break;
                        case MAX_ID_TERMIN_PREGLEDA:
                            int idTP = Controller.getInstance().maxIdTP();
                            response = new Response(idTP, null);
                            break;
                        case MAX_ID_USLUGA:
                            int idU = Controller.getInstance().maxIdTP();
                            response = new Response(idU, null);
                            break;
                        case VRATI_TERMIN_PREGLEDA_ID:
                            int id = (int) request.getArgument();
                            List<TerminPregleda> tpp = Controller.getInstance().dajTerminPregleda(id);
                            if (tpp == null) {
                                Exception e = new Exception("Ne postoji termin sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tpp, null);
                            }
                            break;
                        case VRATI_STAVKE_PREGLEDA_ID:
                            int idsp = (int) request.getArgument();
                            List<StavkePregleda> tpsp = Controller.getInstance().dajStavkePregleda(idsp);
                            if (tpsp == null) {
                                Exception e = new Exception("Ne postoji stavka sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tpsp, null);
                            }
                            break;
                        case VRATI_USLUGA_NAOCARA_ID:
                            int idu = (int) request.getArgument();
                            List<Usluga> tpu = Controller.getInstance().dajUslugaNaocare(idu);
                            if (tpu == null) {
                                Exception e = new Exception("Ne postoji usluga sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tpu, null);
                            }
                            break;
                        case VRATI_USLUGA_STAKLA_ID:
                            int ids = (int) request.getArgument();
                            List<Usluga> tps = Controller.getInstance().dajUslugaStakla(ids);
                            if (tps == null) {
                                Exception e = new Exception("Ne postoji usluga sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tps, null);
                            }
                            break;
                        case VRATI_USLUGA_VRSTE_USLUGA_ID:
                            int idvu = (int) request.getArgument();
                            List<Usluga> tpvu = Controller.getInstance().dajUslugaVrstaUsluge(idvu);
                            if (tpvu == null) {
                                Exception e = new Exception("Ne postoji usluga sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tpvu, null);
                            }
                            break;
                        case VRATI_STATISTIKA_OD_USLUGA_ID:
                            int idsou = (int) request.getArgument();
                            List<StatistikaOdUsluga> tpsou = Controller.getInstance().dajStatistikuOdUsluga(idsou);
                            if (tpsou == null) {
                                Exception e = new Exception("Ne postoji usluga sa prosledjenim id-jem");
                                response = new Response(null, e);
                            } else {
                                response = new Response(tpsou, null);
                            }
                            break;
                        case DELETE_STAVKE_PREGLEDA:
                            StavkePregleda sp =  (StavkePregleda) request.getArgument();
                            Controller.getInstance().deleteStavkePregleda(sp);
                            response = new Response(sp, null);
                            break;
                        case DELETE_NAOCARE:
                            Naocare naocaree =  (Naocare) request.getArgument();
                            Controller.getInstance().deleteNaocare(naocaree);
                            response = new Response(naocaree, null);
                            break;
                        case VRATI_PACIJENTE_IME_PREZIME:
                            ArrayList<String> imePrezime = (ArrayList<String>) request.getArgument();
                            List<GenericEntity> pacijenti = Controller.getInstance().filterPacijente(imePrezime.get(0), imePrezime.get(1));
                            System.out.println(pacijenti);
                            response = new Response(pacijenti, null);
                            break;
                        case KRAJ_RADA_KORISNIKA:
                            Administrator k = (Administrator) request.getArgument();
                            Controller.getInstance().getPrijavljeniKorisnici().remove(k);
                            kraj = true;
                            break;
                        case KRAJ_RADA_LOGIN:
                            kraj = true;
                            break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response = new Response(null, ex);
                }
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public Socket getSocket() {
        return socket;
    }

    public Administrator getAdministratori() {
        return administratori;
    }
    public void kraj() {
        kraj = true;
    }
    
    
}