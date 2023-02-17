/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Naocare;
import domain.Stakla;
import domain.VrsteUsluga;
//import domain.ReceiptItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DBConnection;
import repository.db.DBRepository;

/**
 *
 * @author Laza Laki Lakosta
 */
public class RepositoryDBGeneric implements DBRepository<GenericEntity>{

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> genericEntity= new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String query = param.getStatementSelectAllQuery();
        ResultSet rs =statement.executeQuery(query);
        while(rs.next()){
                genericEntity.add(param.getEntityFromResultSet(rs));
        }
       // DBConnection.getInstance().
        return genericEntity;
    }

    @Override
    public void add(GenericEntity param) throws Exception {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(param.getClassName())
                    .append(" (")
                    .append(param.getAttributeList())
                    .append(")")
                    .append(" VALUES (")
                    .append(param.getAttributeValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                int id = rsKey.getInt(1);
                param.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(param.getClassName())
                    .append(" SET ")
                    .append(param.setAttributeValues())
                    .append(" WHERE ")
                    .append(param.getQueryCondition());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
                
            
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(param.getClassName())
                    .append(" WHERE ")
                    .append(param.getQueryCondition());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public void addComplex(GenericEntity t) throws Exception {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            StringBuilder sb = new StringBuilder();
//            sb.append("INSERT INTO ")
//                    .append(t.getClassName())
//                    .append(" (").append(t.getAttributeList()).append(")")
//                    .append(" VALUES (")
//                    .append(t.getAttributeValues())
//                    .append(")");
//            String query = sb.toString();
//            System.out.println(query);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//            ResultSet rsKey = statement.getGeneratedKeys();
//            if (rsKey.next()) {
//                Long id = rsKey.getLong(1);
//                t.setId(id);
//                
//                for(int j=0; j<t.getNumberOfBountObject(); j++){
//                AbstractDO abstractDO;
//                for(int i=0; i<t.getNumberOfAttributesBoundObjects(); i++){
//                    abstractDO=(AbstractDO) t.getBoundObject(j,i);
//                    System.out.println(abstractDO.toString());
//                    abstractDO.setForeignId(id);
//                    StringBuilder sbBoundObject = new StringBuilder();
//                    sbBoundObject.append("INSERT INTO ")
//                            .append(abstractDO.getClassName())
//                            .append(" (").append(abstractDO.getAttributeList()).append(")")
//                            .append(" VALUES (")
//                            .append(abstractDO.getAttributeValues())
//                            .append(")");
//                    String queryBound = sbBoundObject.toString();
//                    System.out.println(queryBound);
//                    statement.executeUpdate(queryBound);
//                }
//                
//                 }
//            }
//
//            
//        } catch (SQLException ex) {
//            throw ex;
//        }
//    }
//
//    @Override
//    public void editComplex(GenericEntity oldT, GenericEntity newT) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<GenericEntity> getByQuery(GenericEntity t, String query) throws Exception {
//        List<GenericEntity> abstractDOs= new ArrayList<>();
//            Connection connection= DBConnection.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            System.out.println(t.getStatementSelectAllQuery()+query);
//            ResultSet resultSet = statement.executeQuery(t.getStatementSelectAllQuery()+query);
//            while(resultSet.next()){
//                abstractDOs.add(t.getEntityFromResultSet(resultSet));
//            }
//        
//            return abstractDOs;
//    }
//
//    @Override
//    public GenericEntity get(GenericEntity t, String string) throws Exception {
//        GenericEntity abstractDO=null;
//            Connection connection= DBConnection.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(t.getStatementSelectAllQuery()+string);
//            while(resultSet.next()){
//                abstractDO=t.getEntityFromResultSet(resultSet);
//            }
//        
//            return abstractDO;
//    }
//
//    @Override
//    public void addBoundObjects(ReceiptItem receipt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public GenericEntity uloguj(GenericEntity entity, String username, String password) throws Exception {
        GenericEntity genericEntity = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getClassName()+ " WHERE username='" + username + "' AND password='" + password + "'";
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            genericEntity = entity.getResult(resultSet);
            resultSet.close();
            statement.close();
            return genericEntity;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public int vratiMaksIndeks(GenericEntity entity) throws Exception {
        int maksIndeks = 0;
        try {
            String query = "SELECT MAX(terminId) AS maks FROM " + entity.getClassName();
            Statement statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                maksIndeks = resultSet.getInt("maks");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return maksIndeks + 1;
    }
    @Override
    public List<GenericEntity> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        if(entity2 instanceof Naocare){
            List<GenericEntity> genericEntity = null;
            try {
                System.out.println("USAOOOO ");
                Connection connection = DBConnection.getInstance().getConnection();
                String query = "SELECT * FROM " + entity.getClassName() + " WHERE "+ entity.setForeignId(0) +"=" + id;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                genericEntity = (List<GenericEntity>) entity.getResultt(resultSet);
                resultSet.close();
                statement.close();
                return genericEntity;
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        else if(entity2 instanceof Stakla){
            List<GenericEntity> genericEntity = null;
            try {
                System.out.println("USAOOOO S");
                Connection connection = DBConnection.getInstance().getConnection();
                String query = "SELECT * FROM " + entity.getClassName() + " WHERE "+ entity.setForeignId(1) +"=" + id;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                genericEntity = (List<GenericEntity>) entity.getResultt(resultSet);
                resultSet.close();
                statement.close();
                return genericEntity;
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        else if(entity2 instanceof VrsteUsluga){
            List<GenericEntity> genericEntity = null;
            try {
                System.out.println("USAOOOO VU");
                Connection connection = DBConnection.getInstance().getConnection();
                String query = "SELECT * FROM " + entity.getClassName() + " WHERE "+ entity.setForeignId(2) +"=" + id;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                genericEntity = (List<GenericEntity>) entity.getResultt(resultSet);
                resultSet.close();
                statement.close();
                return genericEntity;
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        else{
            List<GenericEntity> genericEntity = null;
            try {
                Connection connection = DBConnection.getInstance().getConnection();
                String query = "SELECT * FROM " + entity.getClassName() + " WHERE "+ entity.setForeignId(2) +"=" + id;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                genericEntity = (List<GenericEntity>) entity.getResultt(resultSet);
                resultSet.close();
                statement.close();
                return genericEntity;
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        
    }
    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        List<GenericEntity> list = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getClassName() + " WHERE " + entity.getCondition(entity) + " ORDER BY " + entity.getOrderCondition();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getResultt(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
