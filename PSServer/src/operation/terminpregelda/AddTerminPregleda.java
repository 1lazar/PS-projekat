/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.terminpregelda;

import domain.TerminPregleda;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class AddTerminPregleda extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param==null || !(param instanceof TerminPregleda)){
            throw new Exception("Invalid data review date");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((TerminPregleda)param);
    }
}
