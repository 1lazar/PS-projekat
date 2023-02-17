/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Stakla implements Serializable,GenericEntity {
    private int id;
    private String naziv;
    private String vrsta;
    private double dioptrija;
    private int kolicina;
    private double cena;

    public Stakla() {
    }

    public Stakla(int id, String naziv, String vrsta, double dioptrija, int kolicina, double cena) {
        this.id = id;
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.dioptrija = dioptrija;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public double getDioptrija() {
        return dioptrija;
    }

    public void setDioptrija(double dioptrija) {
        this.dioptrija = dioptrija;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Stakla other = (Stakla) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.dioptrija) != Double.doubleToLongBits(other.dioptrija)) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return Objects.equals(this.vrsta, other.vrsta);
    }

    @Override
    public String toString() {
        return naziv + " " + vrsta + " " + dioptrija;
    }

    @Override
    public String getAttributeList() {
        return "id,naziv,vrsta,dioptrija,kolicina,cena";
    }

    @Override
    public String getClassName() {
        return "stakla";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getNaziv()).append("','").append(getVrsta())
                .append("',").append(getDioptrija()).append(",").append(getKolicina()).append(",").append(getCena());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public String setAttributeValues() {
        return "id="+getId()+","
                +"naziv='"+getNaziv()+"',"+
                "vrsta='"+getVrsta()+"',"+
                "dioptrija="+getDioptrija()+","+
                "kolicina="+getKolicina()+","+
                "cena="+getCena();
    }

    @Override
    public String setForeignId(int vrsta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Stakla(resultSet.getInt("id"),
                resultSet.getString("naziv"), 
                resultSet.getString("vrsta"), 
                resultSet.getDouble("dioptrija"), 
                resultSet.getInt("kolicina"),
                resultSet.getDouble("cena"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,naziv,vrsta,dioptrija,kolicina,cena FROM stakla";
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
