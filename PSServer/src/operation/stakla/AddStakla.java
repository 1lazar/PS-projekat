/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stakla;

import domain.Stakla;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class AddStakla extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof Stakla)){
            throw new Exception("Invalid data glass");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Stakla)param);
    }
}
