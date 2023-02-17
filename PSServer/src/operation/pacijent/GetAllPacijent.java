/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pacijent;

import domain.Pacijent;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllPacijent extends AbstractGenericOperation{

    List<Pacijent> pacijenti;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Pacijent)){
            throw new Exception("Invalid data pacijent");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pacijenti = repository.getAll((Pacijent)param);
    }

    public List<Pacijent> getPacijenti() {
        return pacijenti;
    }
}