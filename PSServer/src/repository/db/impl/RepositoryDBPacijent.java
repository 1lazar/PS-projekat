/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Pacijent;
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
public class RepositoryDBPacijent implements DBRepository<Pacijent>{


    @Override
    public void delete(Pacijent pacijent) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM pacijenti WHERE pacijentId = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,pacijent.getPacijentId());
            ps.executeUpdate();
            System.out.println("Pacijent je izbrisan!");
        }
    }



    @Override
    public List<Pacijent> getAll(Pacijent param) throws Exception {
//        List<Pacijent> pacijente = new ArrayList<>();
//        
//        Connection conn = null;
//        try {
//            conn = DBConnection.getInstance().getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Uspostavila se konekcija");
//
//        String query = "SELECT pacijentId,ime,prezime,telefon,dioptrija from pacijenti";
//        
//        try (Statement statement = conn.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String ime = resultSet.getString(2);
//                String prezime = resultSet.getString(3);
//                int telefon = resultSet.getInt(4);
//                double dioptrija = resultSet.getDouble(5);
//                pacijente.add(new Pacijent(id,ime,prezime,telefon,dioptrija));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return pacijente;
return null;
    }

    @Override
    public void add(Pacijent pacijent) throws Exception {
        try {
            //uspostavi konekciju

            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Uspostavila se konekcija");

            String query = "INSERT INTO pacijenti VALUES (?,?,?,?,?,?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, pacijent.getPacijentId());
            preparedStatement.setString(2, pacijent.getIme());
            preparedStatement.setString(3, pacijent.getPrezime());
            preparedStatement.setInt(4, pacijent.getKontaktTelefon());
            preparedStatement.setDouble(5, pacijent.getDioptrijaLevogOka());
            preparedStatement.setDouble(6, pacijent.getDioptrijaDesnogOka());
            preparedStatement.setDouble(5, pacijent.getPD());
            //izvsi upit
            int result = preparedStatement.executeUpdate();
            System.out.println("Result = " + result);

            preparedStatement.close();

           
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(Pacijent pacijent) throws Exception {
        try {
            String sql = "UPDATE pacijenti SET "
                    + "ime='" + pacijent.getIme() + "', "
                    + "prezime='" + pacijent.getPrezime() + "', "
                    + "telefon=" + pacijent.getKontaktTelefon() + ","
                    + "dioptrijaLevogOka='" + pacijent.getDioptrijaLevogOka()+ "' "
                    + "dioptrijaDesnogOka='" + pacijent.getDioptrijaDesnogOka()+ "' "
                    + "PD='" + pacijent.getPD()+ "' "
                    + "WHERE pacijentId=" + pacijent.getPacijentId();
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
    public List<Pacijent> getAll() {
        List<Pacijent> pacijente = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Uspostavila se konekcija");

        String query = "SELECT pacijentId,ime,prezime,telefon,dioptrijaLevogOka,dioptrijaDesnogOka,PD from pacijenti";
        
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                int telefon = resultSet.getInt(4);
                double dioptrijaLO = resultSet.getDouble(5);
                double dioptrijaDO = resultSet.getDouble(6);
                double pd = resultSet.getDouble(7);
                
                pacijente.add(new Pacijent(id,ime,prezime,telefon,dioptrijaLO,dioptrijaDO,pd));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacijente;
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
    public List<Pacijent> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
    
    
}
