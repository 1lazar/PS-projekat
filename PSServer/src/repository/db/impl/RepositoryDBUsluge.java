/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Naocare;
import domain.Stakla;
import domain.TerminPregleda;
import domain.Usluga;
import domain.VrsteUsluga;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Repository;
import repository.db.DBConnection;
import repository.db.DBRepository;

/**
 *
 * @author Laza Laki Lakosta
 */
public class RepositoryDBUsluge implements DBRepository<Usluga>{

    @Override
    public void delete(Usluga usluga) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM usluge WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,usluga.getUslugaId());
            ps.executeUpdate();
            System.out.println("Usluga je izbrisana!");
        }
    }


    @Override
    public List<Usluga> getAll(Usluga param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Usluga usluge) throws Exception {
//        try {
//            //uspostavi konekciju
//
//            Connection connection = DBConnection.getInstance().getConnection();
//            System.out.println("Uspostavila se konekcija");
//
//            String query = "INSERT INTO usluge VALUES (?,?,?)";
//            System.out.println(query);
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, usluge.getUslugaId());
//            preparedStatement.setString(2, usluge.get);
//            preparedStatement.setDouble(3, usluge.getCenaUsluge());
//            //izvsi upit
//            int result = preparedStatement.executeUpdate();
//            System.out.println("Result = " + result);
//
//            preparedStatement.close();
//
//           
//        } catch (SQLException ex) {
//            System.out.println("Desila se greska: " + ex.getMessage());
//        }
    }

    @Override
    public void edit(Usluga param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usluga> getAll() {
       List<Usluga> usluga = new ArrayList<>();
        
        Connection conn;
        try {
            conn = DBConnection.getInstance().getConnection();
        
        
            String query = "SELECT * FROM usluge";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                int naocareId = rs.getInt(2);
                int staklaId = rs.getInt(3);
                int vuId = rs.getInt(4);
                VrsteUsluga vu = new VrsteUsluga();
                vu.setId(vuId);
                Naocare n = new Naocare();
                n.setId(naocareId);
                Stakla s = new Stakla();
                s.setId(staklaId);
                
                usluga.add(new Usluga(id, n, s,vu));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usluga;
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
    public List<Usluga> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
