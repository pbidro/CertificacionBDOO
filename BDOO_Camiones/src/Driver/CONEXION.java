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
    
        public CONEXION() {
    }
        
          public Statement conn(){
        try{  
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("Conectando con la base de datos...");
        Connection connection = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE",/*ESQUEMA*/"PROYECTO",/*CONTRASEÑA*/"12345");
        Statement statement = connection.createStatement();
        return statement;
        }catch(Exception e){
        System.out.println("Hay un problema en:" + e);
        return null;  
        }
        
    }
          
          
          
    
}
