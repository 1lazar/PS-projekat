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
public class Pacijent implements Serializable,GenericEntity{
    private int pacijentId;
    private String ime;
    private String prezime;
    private int kontaktTelefon;
    private double dioptrijaLevogOka;
    private double dioptrijaDesnogOka;
    private double PD;

    public Pacijent() {
    }

    public Pacijent(int pacijentId, String ime, String prezime, int kontaktTelefon, double dioptrijaLevogOka, double dioptrijaDesnogOka, double PD) {
        this.pacijentId = pacijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.dioptrijaLevogOka = dioptrijaLevogOka;
        this.dioptrijaDesnogOka = dioptrijaDesnogOka;
        this.PD = PD;
    }

    public int getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(int pacijentId) {
        this.pacijentId = pacijentId;
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

    public double getDioptrijaLevogOka() {
        return dioptrijaLevogOka;
    }

    public void setDioptrijaLevogOka(double dioptrijaLevogOka) {
        this.dioptrijaLevogOka = dioptrijaLevogOka;
    }

    public double getDioptrijaDesnogOka() {
        return dioptrijaDesnogOka;
    }

    public void setDioptrijaDesnogOka(double dioptrijaDesnogOka) {
        this.dioptrijaDesnogOka = dioptrijaDesnogOka;
    }

    public double getPD() {
        return PD;
    }

    public void setPD(double PD) {
        this.PD = PD;
    }

    @Override
    public String toString() {
        return ime + " " + prezime ;
    }

    @Override
    public String getAttributeList() {
        return "pacijentId,ime,prezime,telefon,dioptrijaLevogOka,dioptrijaDesnogOka,PD";
    }

    @Override
    public String getClassName() {
        return "pacijenti";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getIme()).append("','").append(getPrezime())
                .append("',").append(getKontaktTelefon()).append(",").append(getDioptrijaLevogOka()).append(",").append(getDioptrijaDesnogOka()).append(",").append(getPD());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "pacijentId="+getId();
    }

    @Override
    public void setId(int id) {
        pacijentId=id;
    }

    @Override
    public int getId() {
        return pacijentId;
    }

    @Override
    public String setAttributeValues() {
        return "pacijentId="+getId()+","
                +"ime='"+getIme()+"',"+
                "prezime='"+getPrezime()+"',"+
                "telefon="+getKontaktTelefon()+","+
                "dioptrijaLevogOka="+getDioptrijaLevogOka()+","+
                "dioptrijaDesnogOka="+getDioptrijaDesnogOka()+","+
                "PD="+getPD();
    }

    @Override
    public String setForeignId(int vrsta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Pacijent(resultSet.getInt("pacijentId"),
                resultSet.getString("ime"), 
                resultSet.getString("prezime"), 
                resultSet.getInt("telefon"), 
                resultSet.getDouble("dioptrijaLevogOka"), 
                resultSet.getDouble("dioptrijaDesnogOka"), 
                resultSet.getDouble("PD"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT pacijentId,ime,prezime,telefon,dioptrijaLevogOka,dioptrijaDesnogOka,PD FROM pacijenti";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        List<GenericEntity> entity = new ArrayList<>();
        while(resultSet.next()){
                int id = resultSet.getInt("pacijentId");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                int telefon= resultSet.getInt("telefon");
                double dioptirjaL =  resultSet.getDouble("dioptrijaLevogOka");
                double dioptirijaD =  resultSet.getDouble("dioptrijaDesnogOka");
                double PD =  resultSet.getDouble("PD");
                
                
                System.out.println(id);
                entity.add(new Pacijent(id, ime, prezime, telefon, dioptirjaL, dioptirijaD, PD)) ;
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        Pacijent pacijent = (Pacijent) entity;
        return "ime LIKE '" + pacijent.getIme() + "%' AND prezime LIKE '" + pacijent.getPrezime() + "%'";
    }

    @Override
    public String getOrderCondition() {
        return "ime";
    }
    


    
    
}
