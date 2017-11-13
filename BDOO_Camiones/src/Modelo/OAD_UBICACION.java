/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Driver.CONEXION;
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
public class OAD_UBICACION {
    public static int CODIGO;
    public static int UBICACION;
    
        public static DefaultTableModel CARGARDATOS() {
        String sql = "SELECT A.CODIGO AS A, A.DESCRIPCION AS B FROM UBICACION A WHERE A.ESTADO = 1";
        String[] titulos = {"CODIGO", "DESCRIPCION"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String[] fila = new String[2];
        try {
            Statement st = CONEXION.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                fila[0] = rs.getString("A");
                fila[1] = rs.getString("B");
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
