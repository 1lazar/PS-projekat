/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.naocare;

import domain.Naocare;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllNaocare extends AbstractGenericOperation{

    List<Naocare> naocare;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        naocare = repository.getAll((Naocare)param);
    }

    public List<Naocare> getNaocare() {
        return naocare;
    }
}
