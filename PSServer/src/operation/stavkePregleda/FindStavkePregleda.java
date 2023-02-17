/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stavkePregleda;

import domain.Pacijent;
import domain.StavkePregleda;
import domain.TerminPregleda;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class FindStavkePregleda extends AbstractGenericOperation{
    
    List<StavkePregleda> tp;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof TerminPregleda)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        TerminPregleda tpp = (TerminPregleda) param;
        StavkePregleda t = new StavkePregleda();
        tp = (List<StavkePregleda>) repository.find(t, tpp.getId(),tpp);
    }

    public List<StavkePregleda> getGenericEntity() {
        return tp;
    }
}
