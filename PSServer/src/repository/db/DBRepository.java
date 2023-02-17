/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author Cartman
 * @param <T>
 */
public interface DBRepository<T>  extends Repository<T>{
    default public void connect() throws Exception{
        DBConnection.getInstance().getConnection();
    }
    
    default public void disconnect() throws Exception{
        DBConnection.getInstance().getConnection().close();
    }
    
    default public void commit() throws Exception{
        DBConnection.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws Exception{
        DBConnection.getInstance().getConnection().rollback();
    }
}
