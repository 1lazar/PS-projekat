/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.statistikaOdUsluga;

import domain.StatistikaOdUsluga;
import domain.Usluga;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class FindStatistikaOdUsluga extends AbstractGenericOperation{
    
    List<StatistikaOdUsluga> tp;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Usluga)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Usluga tpp = (Usluga) param;
        StatistikaOdUsluga t = new StatistikaOdUsluga();
        tp = (List<StatistikaOdUsluga>) repository.find(t, tpp.getId(),tpp);
    }

    public List<StatistikaOdUsluga> getGenericEntity() {
        return tp;
    }
}
