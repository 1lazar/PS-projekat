/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.usluga;

import domain.Naocare;
import domain.Stakla;
import domain.StavkePregleda;
import domain.TerminPregleda;
import domain.Usluga;
import domain.VrsteUsluga;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class FindUsluga extends AbstractGenericOperation{
    
    List<Usluga> usluge;
    
    @Override
    protected void preconditions(Object param) throws Exception {
//        if (param == null || !(param instanceof Usluga)) {
//            throw new Exception("Invalid parameter");
//        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        if(param instanceof Naocare){
            Naocare tpp = (Naocare) param;
            Usluga t = new Usluga();
            usluge = (List<Usluga>) repository.find(t, tpp.getId(),tpp);
            System.out.println(usluge);
        }
        else if(param instanceof Stakla){
            Stakla tpp = (Stakla) param;
            Usluga t = new Usluga();
            usluge = (List<Usluga>) repository.find(t, tpp.getId(),tpp);
        }
        else{
            VrsteUsluga tpp = (VrsteUsluga) param;
            Usluga t = new Usluga();
            usluge = (List<Usluga>) repository.find(t, tpp.getId(),tpp);
        }
    }

    public List<Usluga> getGenericEntity() {
        return usluge;
    }
}
