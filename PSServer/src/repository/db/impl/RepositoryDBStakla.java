/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Pacijent;
import domain.Stakla;
import domain.Usluga;
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
public class RepositoryDBStakla implements DBRepository<Stakla>{

    @Override
    public List<Stakla> getAll(Stakla param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Stakla stakla) throws Exception {
        try {
            //uspostavi konekciju

            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Uspostavila se konekcija");

            String query = "INSERT INTO stakla VALUES (?,?,?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stakla.getId());
            preparedStatement.setString(2, stakla.getNaziv());
            preparedStatement.setString(3, stakla.getVrsta());
            preparedStatement.setDouble(4, stakla.getDioptrija());
            //izvsi upit
            int result = preparedStatement.executeUpdate();
            System.out.println("Result = " + result);

            preparedStatement.close();

           
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(Stakla staklo) throws Exception {
        try {
            String sql = "UPDATE pacijenti SET "
                    + "ime='" + staklo.getNaziv()+ "', "
                    + "prezime='" + staklo.getVrsta()+ "', "
                    + "dioptrija='" + staklo.getDioptrija()+ "' "
                    + "WHERE id=" + staklo.getId();
            System.out.println(sql);
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update product DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public void delete(Stakla stakla) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM stakla WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,stakla.getId());
            ps.executeUpdate();
            System.out.println("Staklo je izbrisana!");
        }
    }

    @Override
    public List<Stakla> getAll() {
        List<Stakla> stakla = new ArrayList<>();
        
        Connection conn;
        try {
            conn = DBConnection.getInstance().getConnection();
        
        
            String query = "SELECT id,naziv,vrsta,dioptrija,cena FROM stakla";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                String naziv = rs.getString(2);
                String vrsta = rs.getString(3);
                double dioptrija = rs.getDouble(4);
                double cena = rs.getDouble(5);
                stakla.add(new Stakla(id, naziv, vrsta, dioptrija,0,cena));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBStakla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stakla;

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
    public List<Stakla> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
}
