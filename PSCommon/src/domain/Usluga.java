/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Usluga implements Serializable,GenericEntity{
    private int uslugaId;
    private Naocare naocare;
    private Stakla stakla;
    private VrsteUsluga vrsteUsluge;

    public Usluga() {
    }

    public Usluga(int uslugaId, Naocare naocare, Stakla stakla, VrsteUsluga vrsteUsluge) {
        this.uslugaId = uslugaId;
        this.naocare = naocare;
        this.stakla = stakla;
        this.vrsteUsluge = vrsteUsluge;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(int uslugaId) {
        this.uslugaId = uslugaId;
    }

    public Naocare getNaocare() {
        return naocare;
    }
    public int getNaocareId() {
        return naocare.getId();
    }

    public void setNaocare(Naocare naocare) {
        this.naocare = naocare;
    }

    public Stakla getStakla() {
        return stakla;
    }
    
    public int getStaklaId() {
        return stakla.getId();
    }

    public void setStakla(Stakla stakla) {
        this.stakla = stakla;
    }

    public VrsteUsluga getVrsteUsluge() {
        return vrsteUsluge;
    }
    
    public int getVrsteUslugeId() {
        return vrsteUsluge.getId();
    }

    public void setVrsteUsluge(VrsteUsluga vrsteUsluge) {
        this.vrsteUsluge = vrsteUsluge;
    }

    @Override
    public int hashCode() {
        int hash = 4;
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
        final Usluga other = (Usluga) obj;
        if (this.uslugaId != other.uslugaId) {
            return false;
        }
        if (!Objects.equals(this.naocare, other.naocare)) {
            return false;
        }
        if (!Objects.equals(this.stakla, other.stakla)) {
            return false;
        }
        return Objects.equals(this.vrsteUsluge, other.vrsteUsluge);
    }

    @Override
    public String toString() {
        return "Usluga{" + "uslugaId=" + uslugaId + ", naocare=" + naocare + ", stakla=" + stakla + ", vrsteUsluge=" + vrsteUsluge + '}';
    }

    @Override
    public String getAttributeList() {
        return "id,naocareId,staklaId,vrsteUslugeId";
    }

    @Override
    public String getClassName() {
        return "usluge";
    }

    @Override
    public String getAttributeValues() {
         StringBuilder sb = new StringBuilder();
        sb.append(getUslugaId()).append(",").append(getNaocareId()).append(",").append(getStaklaId()).append(",").append(getVrsteUslugeId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public void setId(int id) {
        uslugaId=id;
    }

    @Override
    public int getId() {
        return uslugaId;
    }

    @Override
    public String setAttributeValues() {
        return "id="+getUslugaId()+","+
                "naocareId="+getNaocareId()+","+
                "staklaId='"+getStaklaId()+","+
                "vrsteUslugeId='"+getVrsteUslugeId();
    }

    @Override
    public String setForeignId(int vrsta) {
        switch (vrsta) {
            case 0:
                return "naocareId";
            case 1:
                return "staklaId";
            default:
                return "vrsteUslugeId";
        }
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
//        return new Usluga(resultSet.getInt("id"),
//                resultSet.getInt("naocareId"), 
//                resultSet.getInt("staklaId"), 
//                resultSet.getInt("vrsteUslugeId"));
return null;
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT * FROM usluge";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            int naocareId = resultSet.getInt("naocareId");
            int staklaId = resultSet.getInt("staklaId");
            int vrsteId = resultSet.getInt("vrsteUslugeId");
            
            Naocare n = new Naocare();
            n.setId(naocareId);
            Stakla s = new Stakla();
            s.setId(staklaId);
            VrsteUsluga vu = new VrsteUsluga();
            vu.setId(vrsteId);
            
            entity = new Usluga(id, naocare, stakla, vrsteUsluge);
            
            return entity;
        }
        
        return null;

    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        List<GenericEntity> entity = new ArrayList<>();
        while(resultSet.next()){
                int id = resultSet.getInt("id");
                int naocareid= resultSet.getInt("naocareId");
                int staklaid= resultSet.getInt("staklaId");
                int vuid =  resultSet.getInt("vrsteUslugeId");
                
                Naocare n = new Naocare();
                n.setId(naocareid);
                Stakla s = new Stakla();
                s.setId(staklaid);
                VrsteUsluga vu = new VrsteUsluga();
                vu.setId(vuid);
                
                System.out.println(id);
                entity.add(new Usluga(id, n, s, vu));
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
