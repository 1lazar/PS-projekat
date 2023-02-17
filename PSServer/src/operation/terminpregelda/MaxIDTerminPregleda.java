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
public class MaxIDTerminPregleda extends AbstractGenericOperation{
    private int id;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof TerminPregleda)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        TerminPregleda tp = (TerminPregleda) param;
        id = repository.vratiMaksIndeks(tp);
    }

    public int getId() {
        return id;
    }
}
