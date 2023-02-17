/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Opticar implements Serializable,GenericEntity{
    int opticarId;
    String ime;
    String prezime;
    int kontaktTelefon;

    public Opticar() {
    }

    
    public Opticar(int opticarId, String ime, String prezime, int kontaktTelefon) {
        this.opticarId = opticarId;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
    }

    public int getOpticarId() {
        return opticarId;
    }

    public void setOpticarId(int opticarId) {
        this.opticarId = opticarId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(int kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String getAttributeList() {
        return "opticarId,ime,prezime,telefon";
    }

    @Override
    public String getClassName() {
        return "opticari";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getIme()).append("','").append(getPrezime())
                .append("',").append(getKontaktTelefon());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "opticarId="+getId();
    }

    @Override
    public void setId(int id) {
        opticarId=id;
    }

    @Override
    public int getId() {
        return opticarId;
    }

    @Override
    public String setAttributeValues() {
        return "opticarId="+getId()+","
                +"ime='"+getIme()+"',"+
                "prezime='"+getPrezime()+"',"+
                "telefon="+getKontaktTelefon();
    }

    @Override
    public String setForeignId(int vrsta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Opticar(resultSet.getInt("opticarId"),
                resultSet.getString("ime"), 
                resultSet.getString("prezime"), 
                resultSet.getInt("telefon"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT opticarId,ime,prezime,telefon FROM opticari";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
