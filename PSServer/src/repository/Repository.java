/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.GenericEntity;
import java.util.List;

/**
 *
 * @author Laza Laki Lakosta
 */
public interface Repository<T> {
    List<T> getAll(T param) throws Exception;
    void add(T param) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;
    public GenericEntity uloguj(GenericEntity entity, String username, String password) throws Exception;
    List<T> getAll();
    public List<GenericEntity> filter(GenericEntity entity) throws Exception;
    public int vratiMaksIndeks(GenericEntity entity) throws Exception;
    public List<T> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception;

}
