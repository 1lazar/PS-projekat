/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stavkePregleda;

import domain.StavkePregleda;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllStavkePregleda extends AbstractGenericOperation{

    List<StavkePregleda> stavke;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stavke = repository.getAll((StavkePregleda)param);
    }

    public List<StavkePregleda> getStavke() {
        return stavke;
    }
}
