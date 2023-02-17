/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.Pacijent;
import domain.StavkePregleda;
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
public class RepositoryDBStavkePregleda implements DBRepository<StavkePregleda>{

    @Override
    public List<StavkePregleda> getAll(StavkePregleda param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(StavkePregleda sp) throws Exception {
        try {
            //uspostavi konekciju

            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Uspostavila se konekcija");

            String query = "INSERT INTO stavkepregleda VALUES (?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, sp.getId());
            preparedStatement.setInt(2, sp.getTerminPregledaId());
            //izvsi upit
            int result = preparedStatement.executeUpdate();
            System.out.println("Result = " + result);

            preparedStatement.close();

           
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(StavkePregleda sp) throws Exception {
        try {
            String sql = "UPDATE stavkepregleda SET "
                    + "terminPregledaId='" + sp.getTerminPregledaId()+ "' "
                    + "WHERE id=" + sp.getId();
            System.out.println(sql);
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update stavka DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public void delete(StavkePregleda sp) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM stavkepregleda WHERE id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,sp.getId());
            ps.executeUpdate();
            System.out.println("Stavke je izbrisana!");
        }
    }

    @Override
    public List<StavkePregleda> getAll() {
//        List<StavkePregleda> stavke = new ArrayList<>();
//        
//        Connection conn = null;
//        try {
//            conn = DBConnection.getInstance().getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(RepositoryDBStavkePregleda.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Uspostavila se konekcija");
//
//        String query = "SELECT id,uslugaId from stavkepregleda";
//        
//        try (Statement statement = conn.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                int naziv = resultSet.getInt(2);
//                stavke.add(new StavkePregleda(id, naziv));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(RepositoryDBPacijent.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
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
    public List<StavkePregleda> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
