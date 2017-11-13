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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Koe
 */
public class OAD_CAMION {

    public static String PATENTE;
    public static int AÑO;
    public static String DESCRIPCION;
    public static String MARCA;
    public static int EJES;
    public static int TOTALVIAJES;

    public static boolean PROCEDIMIENTO(int OPT, String PAT, int ANO, String DESC, String MARCA, int EJES) {
        try {
            CallableStatement PROCEDURE = CONEXION.conectar().prepareCall("{call CRUD_CHOFER (?,?,?,?,?,?)}");
            PROCEDURE.setInt(1, OPT);
            PROCEDURE.setString(2, PAT);
            PROCEDURE.setInt(3, ANO);
            PROCEDURE.setString(4, DESC);
            PROCEDURE.setString(5, MARCA);
            PROCEDURE.setInt(6, EJES);
            PROCEDURE.execute();
            CONEXION.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("EL ERROR ES:" + ex);
            CONEXION.desconectar();
            return false;
        }

    }

    public static DefaultTableModel CARGARDATOS() {
        String sql = "SELECT A.PATENTE, A.ANO, A.DESCRIPCION, A.MARCA, A.EJES, A.TOTALVIAJES() AS CARGO, A.TOTALVIAJES() AS VIAJES FROM CAMION A WHERE A.ESTADO = 1";
        String[] titulos = {"PAT", "AÑO", "DESCRIPCION", "MARCA", "EJES", "VIAJES"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String[] fila = new String[6];
        try {
            Statement st = CONEXION.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                fila[0] = rs.getString("PATENTE");
                fila[1] = rs.getString("ANO");
                fila[2] = rs.getString("DESCRIPCION");
                fila[3] = rs.getString("MARCA");
                fila[4] = rs.getString("EJES");
                fila[5] = rs.getString("VIAJES");
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

    public static boolean VERIFICAR_CHOFER(String FILTRO) {
        String sql = "SELECT A.PATENTE FROM CAMION A WHERE A.ESTADO = 0 AND A.PATENTE='" + FILTRO + "'";
        boolean verificar = true;
        try {
            Statement st = CONEXION.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                verificar = false;
            }
            CONEXION.desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(OAD_CHOFER.class.getName()).log(Level.SEVERE, null, ex);
            CONEXION.desconectar();
        }
        return verificar;
    }

}
