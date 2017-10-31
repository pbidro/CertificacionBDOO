/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Driver.CONEXION;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Koe
 */
public class OAD_CHOFER {

    public static String RUT;
    public static String NOMBRE;
    public static String APELLIDO;
    public static String FECHA;
    public static String CATEGORIA;
    public static String FULLNAME;
    public static int TOTALVIAJES;

    public static boolean PROCEDIMIENTO(int OPT, String RUT, String NOMBRE, String APELLIDO, String FECHA) {
        try {
            CallableStatement PROCEDURE = CONEXION.conectar().prepareCall("{call CRUD_CHOFER (?,?,?,?,?)}");
            PROCEDURE.setInt(1, OPT);
            PROCEDURE.setString(2, RUT);
            PROCEDURE.setString(3, NOMBRE);
            PROCEDURE.setString(4, APELLIDO);
            PROCEDURE.setString(5, FECHA);
            PROCEDURE.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("EL ERROR ES:" + ex);
            return false;
        }

    }

    public static void CARGARDATOS(String FILTRO, JTable Tabla) {
        String consultar = "SELECT A.FULLNAME(), A.CARGO(), A.TOTALVIAJES() FROM CHOFER A";
        CONEXION.Consultar(consultar);
    }

    public static void FILTRARDATOS() {
        String consultar = "SELECT A.FULLNAME(), A.CARGO(), A.TOTALVIAJES() FROM CHOFER A";
        CONEXION.Consultar(consultar);
    }

}
