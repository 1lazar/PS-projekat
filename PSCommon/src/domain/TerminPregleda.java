/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laza Laki Lakosta
 */
public class TerminPregleda implements GenericEntity{
    private int terminId;
    private Date datum;
    private int pacijentId;
    private int opticarId;

    public TerminPregleda() {
    }

    
    
    public TerminPregleda(int terminId, Date datum, int pacijentId, int opticarId) {
        this.terminId = terminId;
        this.datum = datum;
        this.pacijentId = pacijentId;
        this.opticarId = opticarId;
    }

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(int pacijentId) {
        this.pacijentId = pacijentId;
    }

    public int getOpticarId() {
        return opticarId;
    }

    public void setOpticarId(int opticarId) {
        this.opticarId = opticarId;
    }

    @Override
    public String toString() {
        return "TerminPregleda{" + "terminId=" + terminId + ", datum=" + datum + ", pacijentId=" + pacijentId + ", opticarId=" + opticarId + '}';
    }

    
    
    @Override
    public String getAttributeList() {
        return "terminId,datumVreme,pacijentId,opticarId";
    }

    @Override
    public String getClassName() {
        return "terminpregleda";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" , ").append(getDatum()).append(" , ").append(getPacijentId())
                .append(" , ").append(getOpticarId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "terminId="+getId();
    }

    @Override
    public void setId(int id) {
        terminId=id;
    }

    @Override
    public int getId() {
        return terminId;
    }

    @Override
    public String setAttributeValues() {
        return "terminId="+getId()+","
                +"datumVreme="+new java.sql.Date(getDatum().getTime())+","+
                "pacijentId="+getPacijentId()+","+
                "opticarId="+getOpticarId();
    }

    @Override
    public String setForeignId(int vrsta) {
        return "pacijentId";
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
//        return new TerminPregleda(resultSet.getInt("terminId"),
//                resultSet.getString("datumVreme"), 
//                resultSet.getString("pacijentId"), 
//                resultSet.getString("opticarId"));
throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT terminId,datumVreme,pacijentId,opticarId FROM terminpregleda";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
                int id = resultSet.getInt("terminId");
                //Date datum= resultSet.getDate("datumVreme");
                int pacijentId= resultSet.getInt("pacijentId");
                int opticarId =  resultSet.getInt("opticarId");
                
                
                entity = new TerminPregleda(id, datum, pacijentId, opticarId);
                return entity;
        }
        return null;
    }
    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        List<GenericEntity> entity = new ArrayList<>();
        while(resultSet.next()){
                int id = resultSet.getInt("terminId");
                //Date datum= resultSet.getDate("datumVreme");
                int pacijentId= resultSet.getInt("pacijentId");
                int opticarId =  resultSet.getInt("opticarId");
                
                System.out.println(id);
                entity.add(new TerminPregleda(id, datum, pacijentId, opticarId)) ;
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
