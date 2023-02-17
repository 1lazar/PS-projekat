/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.administator;

import domain.Administrator;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class GetAllAdministratori extends AbstractGenericOperation{

    List<Administrator> administratori;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        administratori = repository.getAll((Administrator)param);
    }

    public List<Administrator> getAdministatori() {
        return administratori;
    }
}
