/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.terminpregelda;

import domain.GenericEntity;
import domain.Pacijent;
import domain.TerminPregleda;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class FindTerminPregleda extends AbstractGenericOperation{
    
    List<TerminPregleda> tp;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Pacijent)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Pacijent tpp = (Pacijent) param;
        TerminPregleda t = new TerminPregleda();
        tp = (List<TerminPregleda>) repository.find(t, tpp.getId(),tpp);
        System.out.println(tp);
    }

    public List<TerminPregleda> getGenericEntity() {
        return tp;
    }
    
}