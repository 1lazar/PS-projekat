/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.administator;

import domain.Administrator;
import domain.GenericEntity;
import operation.AbstractGenericOperation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class UlogujAdministratora extends AbstractGenericOperation{
    private GenericEntity genericEntity;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Administrator)) {
            throw new Exception("Invalid parameter");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Administrator k = (Administrator) param;
        System.out.println(k.getPassword());
        genericEntity = repository.uloguj(k, k.getUsername(), k.getPassword());
    }
    public GenericEntity getGenericEntity() {
        return genericEntity;
    }
    
}
