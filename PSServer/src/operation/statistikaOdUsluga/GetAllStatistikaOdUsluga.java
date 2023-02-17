/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.statistikaOdUsluga;

import domain.StatistikaOdUsluga;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllStatistikaOdUsluga extends AbstractGenericOperation{

    List<StatistikaOdUsluga> sou;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        sou = repository.getAll((StatistikaOdUsluga)param);
    }

    public List<StatistikaOdUsluga> getStatistikaOdUsluga() {
        return sou;
    }
}
