/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Administrator implements GenericEntity, Serializable{
    private int administratorId;
    private String username;
    private String password;
    private String ime;
    private String prezime;

    public Administrator() {
    }
    
    public Administrator(int administratorId, String username, String password, String ime, String prezime) {
        this.administratorId = administratorId;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.administratorId;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.ime);
        hash = 67 * hash + Objects.hashCode(this.prezime);
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
        final Administrator other = (Administrator) obj;
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Administrator{" + "administratorId=" + administratorId + ", username=" + username + ", password=" + password + ", ime=" + ime + ", prezime=" + prezime + '}';
    }

    @Override
    public String getAttributeList() {
        return "id,username,password,ime,prezime";
    }

    @Override
    public String getClassName() {
        return "administratori";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getUsername()).append("','").append(getPassword())
                .append("','").append(getIme()).append("','").append(getPrezime()).append("'");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public void setId(int id) {
        administratorId = id;
    }

    @Override
    public int getId() {
        return administratorId;
    }

    @Override
    public String setAttributeValues() {
        return "id="+getId()+","
                +"username='"+getUsername()+"',"+
                "password='"+getPassword()+"',"+
                "ime='"+getIme()+"',"+
                "prezime='"+getPrezime()+"'";
    }

    @Override
    public GenericEntity getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Administrator(
                resultSet.getInt("id")
                , resultSet.getString("username")
                , resultSet.getString("password")
                , resultSet.getString("ime")
                , resultSet.getString("prezime"));
    }
    
    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
                int id = resultSet.getInt("id");
                String username= resultSet.getString("username");
                String password= resultSet.getString("password");
                String ime =  resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                
                
                entity = new Administrator(id, username, password, ime, prezime);
                return entity;
        }
        return null;
    }    

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,username,password,ime,prezime FROM administratori";
    }

    @Override
    public List<GenericEntity> getResultt(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setForeignId(int vrsta) {
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
