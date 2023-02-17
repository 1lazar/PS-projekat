/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import operation.Operation;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Request implements Serializable{
    
    private final Object argument;
    private final Operation operation;

    public Request(Object argument, Operation operation) {
        this.argument = argument;
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public Operation getOperation() {
        return operation;
    }
    
    
}
