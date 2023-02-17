/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import domain.TerminPregleda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
public class RepositoryDBTerminPregleda implements DBRepository<TerminPregleda>{


    @Override
    public void delete(TerminPregleda tp) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println("Uspostavila se konekcija");
        
        String query = "DELETE FROM terminpregleda WHERE terminId = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,tp.getTerminId());
            ps.executeUpdate();
            System.out.println("Termin je izbrisana!");
        }
    }


    @Override
    public List<TerminPregleda> getAll(TerminPregleda param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(TerminPregleda tp) throws Exception {
        try {
            //uspostavi konekciju

            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Uspostavila se konekcija");

            String query = "INSERT INTO terminpregleda VALUES (?,?,?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, tp.getTerminId());
            preparedStatement.setDate(2, (Date) tp.getDatum());
            preparedStatement.setInt(3, tp.getPacijentId());
            preparedStatement.setInt(4, tp.getOpticarId());
            //izvsi upit
            int result = preparedStatement.executeUpdate();
            System.out.println("Result = " + result);

            preparedStatement.close();

           
        } catch (SQLException ex) {
            System.out.println("Desila se greska: " + ex.getMessage());
        }
    }

    @Override
    public void edit(TerminPregleda param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TerminPregleda> getAll() {
       List<TerminPregleda> tp = new ArrayList<>();
        
        Connection conn;
        try {
            conn = DBConnection.getInstance().getConnection();
        
        
            String query = "SELECT terminId,datumVreme,pacijentId,opticarId FROM terminpregleda";

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                Date datum = rs.getDate(2);
                //LocalDate ld = datum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ld = null;
                int idp = rs.getInt(3);
                int ido = rs.getInt(4);
                tp.add(new TerminPregleda(id, null, idp, ido));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDBTerminPregleda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBTerminPregleda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
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
    public List<TerminPregleda> find(GenericEntity entity, int id,GenericEntity entity2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> filter(GenericEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
