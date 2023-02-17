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
public class Naocare implements Serializable,GenericEntity{
    private int id;
    private String marka;
    private String model;
    private int kolicina;
    private double cena;

    public Naocare() {
    }

    public Naocare(int id, String marka, String model, int kolicina, double cena) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        final Naocare other = (Naocare) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.marka, other.marka)) {
            return false;
        }
        return Objects.equals(this.model, other.model);
    }

    @Override
    public String toString() {
        return "marka=" + marka + ", model=" + model;
    }

    @Override
    public String getAttributeList() {
        return "id,marka,model,kolicina,cena";
    }

    @Override
    public String getClassName() {
        return "naocare";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getMarka()).append("','").append(getModel())
                .append("',").append(getKolicina()).append(",").append(getCena());
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
                +"marka='"+getMarka()+"',"+
                "model='"+getModel()+"',"+
                "kolicina="+getKolicina()+","+
                "cena="+getCena();
    }

    @Override
    public String setForeignId(int vrsta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
                return new Naocare(resultSet.getInt("id"),
                resultSet.getString("marka"), 
                resultSet.getString("model"), 
                resultSet.getInt("kolicina"), 
                resultSet.getDouble("cena"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,marka,model,kolicina,cena FROM naocare";
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
