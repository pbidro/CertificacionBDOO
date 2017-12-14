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
public class OAD_VIAJE {

    public static int CODIGO;
    public static String FECHAINICIO;
    public static String FECHALLEGADA;
    public static String CARGA;
    public static String ORIGEN;
    public static String DESTINO;
    public static String CHOFER;
    public static String CAMION;

    public static boolean PROCEDIMIENTO(int OPT, int CODIGO, String FECHAINICIO, String FECHALLEGADA, String CARGA, int ORIGEN, int DESTINO, String CHOFER, String CAMION) {
        try {
            CallableStatement PROCEDURE = CONEXION.conectar().prepareCall("{call VIAJE_CRUD(?,?,?,?,?,?,?,?,?)}");
            PROCEDURE.setInt(1, OPT);
            PROCEDURE.setInt(2, CODIGO);
            PROCEDURE.setString(3, FECHAINICIO);
            PROCEDURE.setString(4, FECHALLEGADA);
            PROCEDURE.setString(5, CARGA);
            PROCEDURE.setInt(6, ORIGEN);
            PROCEDURE.setInt(7, DESTINO);
            PROCEDURE.setString(8, CHOFER);
            PROCEDURE.setString(9, CAMION);
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
        String sql = "SELECT A.CODIGO AS A, TO_CHAR(A.FECHA_INICIO,'DD/MM/YYYY') AS B, TO_CHAR(A.FECHA_LLEGADA,'DD/MM/YYYY') AS C, A.CARGA AS D, A.ORIGEN.CODIGO AS E, A.DESTINO.CODIGO AS F, A.CHOFER.RUT AS G, A.CAMION.PATENTE AS H FROM VIAJE A WHERE A.ESTADO = 1";
        String[] titulos = {"CODIGO", "IDA", "REGRESO", "CARGA", "ORIGEN", "DESTINO", "CHOFER", "CAMION"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String[] fila = new String[8];
        try {
            Statement st = CONEXION.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                fila[0] = rs.getString("A");
                fila[1] = rs.getString("B");
                fila[2] = rs.getString("C");
                fila[3] = rs.getString("D");
                fila[4] = rs.getString("E");
                fila[5] = rs.getString("F");
                fila[6] = rs.getString("G");
                fila[7] = rs.getString("H");
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
