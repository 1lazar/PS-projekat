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
import java.util.Objects;

/**
 *
 * @author Laza Laki Lakosta
 */
public class StavkePregleda implements Serializable,GenericEntity{
    private int id;
    private TerminPregleda terminPregleda;
    private Usluga usluga;

    public StavkePregleda() {
    }

    public StavkePregleda(int id, TerminPregleda terminPregleda, Usluga usluga) {
        this.id = id;
        this.terminPregleda = terminPregleda;
        this.usluga = usluga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TerminPregleda getTerminPregleda() {
        return terminPregleda;
    }
    
    public int getTerminPregledaId() {
        return terminPregleda.getId();
    }

    public void setTerminPregleda(TerminPregleda terminPregleda) {
        this.terminPregleda = terminPregleda;
    }

    public Usluga getUsluga() {
        return usluga;
    }
    
    public int getUslugaId() {
        return usluga.getId();
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
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
        final StavkePregleda other = (StavkePregleda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.terminPregleda, other.terminPregleda)) {
            return false;
        }
        return Objects.equals(this.usluga, other.usluga);
    }

    @Override
    public String toString() {
        return terminPregleda + " " + usluga;
    }


    @Override
    public String getAttributeList() {
        return "id,terminPregledaId";
    }

    @Override
    public String getClassName() {
        return "stavkepregleda";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",").append(getTerminPregledaId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public String setAttributeValues() {
        return "id="+getId()+","+
                "terminPregledaId="+getTerminPregledaId();
    }

    @Override
    public String setForeignId(int vrsta) {
        return "terminPregledaId";
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,terminPregledaId,uslugaId FROM stavkepregleda";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            int tpId = resultSet.getInt("terminPregledaId");
            int uId = resultSet.getInt("uslugaId");
            
            TerminPregleda tp = new TerminPregleda();
            tp.setId(tpId);
            Usluga s = new Usluga();
            s.setId(uId);
            
            entity = new StavkePregleda(id, tp,s);
            return entity;
        }
        return null;
    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        List<GenericEntity> entity = new ArrayList<>();
        while(resultSet.next()){
                int id = resultSet.getInt("id");
                //Date datum= resultSet.getDate("datumVreme");
                int pacijentId= resultSet.getInt("terminPregledaId");
                int uslugaId =  resultSet.getInt("uslugaId");
                
                TerminPregleda termin = new TerminPregleda();
                termin.setId(id);
                Usluga usluga = new Usluga();
                usluga.setId(uslugaId);
                
                System.out.println(id+ " SP "+ pacijentId);
                entity.add(new StavkePregleda(id, termin, usluga)) ;
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
