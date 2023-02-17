/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.vrstaUsluge;

import domain.VrsteUsluga;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class EditVrstaUsluge extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof VrsteUsluga)){
            throw new Exception("Invalid data glas");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((VrsteUsluga)param);
    }
}
