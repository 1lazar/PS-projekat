/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import coordinator.MainCoordinator;
import form.FormMain;
import form.LoginForma;
import form.MainForm;
import java.sql.SQLException;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        MainCoordinator.getInstanca().openLoginForm();

    }
}
