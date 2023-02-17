/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.statistikaOdUsluga;

import domain.StatistikaOdUsluga;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class DeleteStatistikaOdUsluga extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof StatistikaOdUsluga)){
            throw new Exception("Invalid data statistics from services");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((StatistikaOdUsluga)param);
    }
}
