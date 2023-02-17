/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.usluga;

import domain.Usluga;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllUsluga extends AbstractGenericOperation{

    List<Usluga> usluge;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Usluga)){
            throw new Exception("Invalid data pacijent");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        usluge = repository.getAll((Usluga)param);
        System.out.println(usluge+"asdasdf");
    }

    public List<Usluga> getUsluge() {
        return usluge;
    }
}
