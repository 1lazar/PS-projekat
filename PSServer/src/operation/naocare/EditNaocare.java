/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.naocare;

import domain.Naocare;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class EditNaocare extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof Naocare)){
            throw new Exception("Invalid data glasses");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Naocare)param);
    }
}
