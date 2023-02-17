/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.usluga;

import domain.Usluga;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class MaxIDUsluga extends AbstractGenericOperation{
    private int id;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Usluga)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Usluga tp = (Usluga) param;
        id = repository.vratiMaksIndeks(tp);
    }

    public int getId() {
        return id;
    }
}
