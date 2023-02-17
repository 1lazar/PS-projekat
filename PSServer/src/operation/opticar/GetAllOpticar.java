/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.opticar;

import domain.Administrator;
import domain.Opticar;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllOpticar extends AbstractGenericOperation{

    List<Opticar> opticari;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        opticari = repository.getAll((Opticar)param);
    }

    public List<Opticar> getOpticari() {
        return opticari;
    }
}
