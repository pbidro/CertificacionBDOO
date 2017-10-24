/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Driver.CONEXION;
import java.sql.CallableStatement;
import java.sql.SQLException;

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

    public OAD_CHOFER() {
    }

    public static String getRUT() {
        return RUT;
    }

    public static void setRUT(String RUT) {
        OAD_CHOFER.RUT = RUT;
    }

    public static String getNOMBRE() {
        return NOMBRE;
    }

    public static void setNOMBRE(String NOMBRE) {
        OAD_CHOFER.NOMBRE = NOMBRE;
    }

    public static String getAPELLIDO() {
        return APELLIDO;
    }

    public static void setAPELLIDO(String APELLIDO) {
        OAD_CHOFER.APELLIDO = APELLIDO;
    }

    public static String getFECHA() {
        return FECHA;
    }

    public static void setFECHA(String FECHA) {
        OAD_CHOFER.FECHA = FECHA;
    }

    public static String getCATEGORIA() {
        return CATEGORIA;
    }

    public static void setCATEGORIA(String CATEGORIA) {
        OAD_CHOFER.CATEGORIA = CATEGORIA;
    }

    public static String getFULLNAME() {
        return FULLNAME;
    }

    public static void setFULLNAME(String FULLNAME) {
        OAD_CHOFER.FULLNAME = FULLNAME;
    }

    public static int getTOTALVIAJES() {
        return TOTALVIAJES;
    }

    public static void setTOTALVIAJES(int TOTALVIAJES) {
        OAD_CHOFER.TOTALVIAJES = TOTALVIAJES;
    }

    public static void PROCEDIMIENTO(int OPT, String RUT, String NOMBRE, String APELLIDO, String FECHA) {
        try {
            CallableStatement PROCEDURE = CONEXION.conn().prepareCall("{call CRUD_CHOFER (?,?,?,?,?)}");
            PROCEDURE.setInt(1, OPT);
            PROCEDURE.setString(2, RUT);
            PROCEDURE.setString(3, NOMBRE);
            PROCEDURE.setString(4, APELLIDO);
            PROCEDURE.setString(5, FECHA);
            PROCEDURE.execute();
        } catch (SQLException ex) {
            System.out.println("EL ERROR ES:" + ex);
        }

    }

}
