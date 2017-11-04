/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koe
 */
public class CONEXION {

    public static Connection conectar() {
        Connection cn = null;

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "PROYECTO", "12345");
            return cn;
        } catch (Exception e) {
            System.out.println("Hay un problema en:" + e);
            return cn;

        }

    }

    public static void desconectar() {
        try {
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "PROYECTO", "12345").close();
        } catch (Exception SQLException) {
        }
    }

    public static void commit() {
        String sql = "commit";
        try {
            CONEXION.conectar().createStatement().executeQuery(sql);
            System.out.println("se ha hecho commit");
        } catch (SQLException ex) {
            Logger.getLogger(CONEXION.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no se hizo commit");
        }
    }

}
