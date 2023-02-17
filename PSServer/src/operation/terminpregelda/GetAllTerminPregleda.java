/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.terminpregelda;

import domain.TerminPregleda;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllTerminPregleda extends AbstractGenericOperation{

    List<TerminPregleda> tp;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tp = repository.getAll((TerminPregleda)param);
    }

    public List<TerminPregleda> getTerminPregleda() {
        return tp;
    }
}
