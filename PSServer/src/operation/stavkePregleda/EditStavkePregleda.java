/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stavkePregleda;

import domain.StavkePregleda;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class EditStavkePregleda extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof StavkePregleda)){
            throw new Exception("Invalid data overview items");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((StavkePregleda)param);
    }
}
