/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laza Laki Lakosta
 */
public class StatistikaOdUsluga implements Serializable,GenericEntity{
    private int brojUsluga;
    private int opticarId;
    private int uslugaId;

    public StatistikaOdUsluga() {
    }

    
    
    public StatistikaOdUsluga(int brojUsluga, int opticarId, int uslugaId) {
        this.brojUsluga = brojUsluga;
        this.opticarId = opticarId;
        this.uslugaId = uslugaId;
    }

    public int getBrojUsluga() {
        return brojUsluga;
    }

    public void setBrojUsluga(int brojUsluga) {
        this.brojUsluga = brojUsluga;
    }

    public int getOpticarId() {
        return opticarId;
    }

    public void setOpticarId(int opticarId) {
        this.opticarId = opticarId;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(int uslugaId) {
        this.uslugaId = uslugaId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.brojUsluga;
        hash = 31 * hash + this.opticarId;
        hash = 31 * hash + this.uslugaId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StatistikaOdUsluga other = (StatistikaOdUsluga) obj;
        return true;
    }

    @Override
    public String toString() {
        return "StatistikaOdUsluga{" + "brojUsluga=" + brojUsluga + ", opticarId=" + opticarId + ", uslugaId=" + uslugaId + '}';
    }

    @Override
    public String getAttributeList() {
        return "id,opticarId,uslugaId";
    }

    @Override
    public String getClassName() {
        return "statistikaodusluga";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBrojUsluga()).append(",").append(getOpticarId()).append(",").append(getUslugaId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public void setId(int id) {
        brojUsluga=id;
    }

    @Override
    public int getId() {
        return brojUsluga;
    }

    @Override
    public String setAttributeValues() {
        return "id="+getBrojUsluga()+","
                +"opticarId="+getOpticarId()+","+
                "uslugaId="+getUslugaId();
    }

    @Override
    public String setForeignId(int vrsta) {
        return "uslugaId";
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new StatistikaOdUsluga(resultSet.getInt("id"),
                resultSet.getInt("opticarId"), 
                resultSet.getInt("uslugaId"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,opticarId,uslugaId FROM statistikaodusluga";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        List<GenericEntity> entity = new ArrayList<>();
        while(resultSet.next()){
                int id = resultSet.getInt("id");
                int opticarId= resultSet.getInt("opticarId");
                int uslugaId =  resultSet.getInt("uslugaId");
                
                System.out.println(id);
                entity.add(new StatistikaOdUsluga(id,opticarId,uslugaId)) ;
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getOrderCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
