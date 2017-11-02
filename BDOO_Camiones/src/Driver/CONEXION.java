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
import java.sql.Statement;
import java.util.LinkedList;

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

}
