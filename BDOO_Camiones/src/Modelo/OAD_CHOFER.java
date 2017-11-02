/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Driver.CONEXION;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public static DefaultTableModel CARGARDATOS(String FILTRO) {
        String sql = "SELECT A.FULLNAME() AS NOMBRE, A.CATEGORIA() AS CARGO, A.TOTALVIAJES() AS VIAJES FROM CHOFER A WHERE A.FULLNAME() LIKE LOWER('%" + FILTRO + "%') OR A.FULLNAME() LIKE UPPER('%" + FILTRO + "%')";
        String[] titulos = {"Nombre", "Cargo", "Viajes"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String[] fila = new String[3];
        try {
            Statement st = CONEXION.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                fila[0] = rs.getString("NOMBRE");
                fila[1] = rs.getString("CARGO");
                fila[2] = rs.getString("VIAJES");
                model.addRow(fila);
            }
            CONEXION.desconectar();
            return model;

        } catch (SQLException ex) {
            Logger.getLogger(OAD_CHOFER.class.getName()).log(Level.SEVERE, null, ex);
            CONEXION.desconectar();
            return model;

        }
    }

}
