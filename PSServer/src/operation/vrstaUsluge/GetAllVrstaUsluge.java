/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.vrstaUsluge;

import domain.VrsteUsluga;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllVrstaUsluge extends AbstractGenericOperation{

    List<VrsteUsluga> vrste;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vrste = repository.getAll((VrsteUsluga)param);
    }

    public List<VrsteUsluga> getVrsteUsluga() {
        return vrste;
    }
}
