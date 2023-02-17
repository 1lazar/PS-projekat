/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Laza Laki Lakosta
 */
public interface GenericEntity extends Serializable {

    public abstract String getAttributeList();
    public abstract String getClassName();
    public abstract String getAttributeValues();
    public abstract String getQueryCondition();
    
    public abstract void setId(int id);

    public abstract int getId();
    
    public abstract String setAttributeValues();
    
    public abstract String setForeignId(int vrsta);
    
    public abstract GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException;
    
    public abstract GenericEntity getResult(ResultSet resultSet) throws Exception;
    public abstract List<GenericEntity> getResultt(ResultSet resultSet) throws Exception;
    
    public abstract String getStatementSelectAllQuery();
    public String getCondition(GenericEntity entity);
    public String getOrderCondition();
}
