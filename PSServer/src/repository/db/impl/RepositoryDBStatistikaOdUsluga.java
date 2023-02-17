/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.StatistikaOdUsluga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DBConnection;
import repository.db.DBRepository;

/**
 *
 * @author Laza Laki Lakosta
 */
public class RepositoryDBStatistikaOdUsluga implements DBRepository<StatistikaOdUsluga>{ 


    @Override
    public void delete(StatistikaOdUsluga sou) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM statistikaodusluga WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,sou.getBrojUsluga());
            ps.executeUpdate();
            System.out.println("Statistika od usluga je izbrisana!");
        }
    }

    @Override
    public List<StatistikaOdUsluga> getAll(StatistikaOdUsluga param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(StatistikaOdUsluga statistikaOdUsluga) throws Exception {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "INSERT INTO statistikaodusluga VALUES(?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, statistikaOdUsluga.getBrojUsluga());
            preparedStatement.setInt(2, statistikaOdUsluga.getOpticarId());
            preparedStatement.setInt(3, statistikaOdUsluga.getUslugaId());
            
            int result = preparedStatement.executeUpdate();
            System.out.println("Result "+result);
            preparedStatement.close();
            System.out.println("Sacuvan je");
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(StatistikaOdUsluga param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StatistikaOdUsluga> getAll() {
        List<StatistikaOdUsluga> sou = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        
        
            String query = "SELECT id,opticarId,uslugaId FROM statistikaodusluga";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                int idOpticar = rs.getInt(2);
                int idusluga = rs.getInt(3);
                sou.add(new StatistikaOdUsluga(id, idOpticar, idusluga));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBStatistikaOdUsluga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBStatistikaOdUsluga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sou;
    }

    @Override
    public GenericEntity uloguj(GenericEntity entity, String username, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int vratiMaksIndeks(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StatistikaOdUsluga> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
