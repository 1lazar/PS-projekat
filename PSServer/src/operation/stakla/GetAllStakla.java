/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stakla;

import domain.Stakla;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllStakla extends AbstractGenericOperation{

    List<Stakla> stakla;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stakla = repository.getAll((Stakla)param);
    }

    public List<Stakla> getStakla() {
        return stakla;
    }
}
