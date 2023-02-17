/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Naocare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class RepositoryDBNaocare implements DBRepository<Naocare>{

    @Override
    public void delete(Naocare naocare) throws Exception {
        try {
            String sql = "DELETE FROM naocare WHERE id=" + naocare.getId();
            System.out.println(sql);
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Delete product DB error: \n" + ex.getMessage());
        }
    }



    @Override
    public List<Naocare> getAll(Naocare param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Naocare naocare) throws Exception {
        try {
            //uspostavi konekciju

            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Uspostavila se konekcija");

            String query = "INSERT INTO naocare VALUES (?,?,?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, naocare.getId());
            preparedStatement.setString(2, naocare.getMarka());
            preparedStatement.setString(3, naocare.getModel());
            preparedStatement.setInt(4, naocare.getKolicina());
            //izvsi upit
            int result = preparedStatement.executeUpdate();
            System.out.println("Result = " + result);

            preparedStatement.close();

           
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(Naocare naocare) throws Exception {
        try {
            String sql = "UPDATE naocare SET "
                    + "marka='" + naocare.getMarka() + "', "
                    + "model='" + naocare.getModel() + "', "
                    + "kolicina=" + naocare.getKolicina()+ " "
                    + "WHERE id=" + naocare.getId();
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
    public List<Naocare> getAll() {
        List<Naocare> naocare = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        
        
            String query = "SELECT id,marka,model,kolicina,cena from naocare";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String marka = rs.getString(2);
                String model = rs.getString(3);
                int kolicina = rs.getInt(4);
                double cena = rs.getDouble(5);
                
                naocare.add(new Naocare(id, marka,model, kolicina,cena));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBStatistikaOdUsluga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBNaocare.class.getName()).log(Level.SEVERE, null, ex);
        }
        return naocare;
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
    public List<Naocare> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
