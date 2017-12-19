/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Driver.CONEXION;
import Modelo.OAD_CAMION;
import Modelo.OAD_UBICACION;
import Vista.CRUD_CAMION;
import Vista.CRUD_UBICACION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Koe
 */
public class CONT_UBICACION implements ActionListener, KeyListener, MouseListener {

    CRUD_UBICACION VISTA = new CRUD_UBICACION();
    OAD_UBICACION MODELO = new OAD_UBICACION();

    public CONT_UBICACION(CRUD_UBICACION VISTA, OAD_UBICACION MODELO) {

        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnCRUD.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        this.VISTA.txtDESCRIPCION.addKeyListener(this);
        this.VISTA.RB_AGREGAR.addMouseListener(this);
        this.VISTA.RB_ELIMINAR.addMouseListener(this);
        initComponents();

    }

    private void initComponents() {
        cargar_tabla();
    }

    public void cargar_tabla() {
        VISTA.jtLISTA.setModel(OAD_UBICACION.CARGARDATOS());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
                String error = "";
                if(VISTA.txtDESCRIPCION.getText().equals("")){
                    error += "no debe haber campos vacíos";
                }
                
        if (e.getSource() == VISTA.btnCRUD) {

            if (error.equals("")) {

                if (VISTA.btnCRUD.getText().equals("AGREGAR")) {
                    insertar_registro();
                }

                if (VISTA.btnCRUD.getText().equals("ELIMINAR")) {
                    eliminar_registro();
                }

            } else {
                JOptionPane.showMessageDialog(null, error);
            }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MenuOpciones();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void MenuOpciones() {

        if (VISTA.RB_AGREGAR.isSelected()) {
            VISTA.btnCRUD.setText("AGREGAR");
            VISTA.txtDESCRIPCION.enable();
            limpiacampos();
            setear();
        } else {
            VISTA.btnCRUD.setText("ELIMINAR");
            VISTA.txtDESCRIPCION.disable();
            limpiacampos();
            setear();
        }

    }

    public void limpiacampos() {
        VISTA.txtDESCRIPCION.setText(" ");
        VISTA.txtDESCRIPCION.setText("");
    }

    public void setear() {
        int fsel = VISTA.jtLISTA.getSelectedRow();

        if (fsel == -1) {

        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
            } else {

                try {
                    VISTA.txtDESCRIPCION.setText(VISTA.jtLISTA.getValueAt(fsel, 2).toString());
                } catch (Exception ex) {
                    VISTA.txtDESCRIPCION.setText("");
                }
            }
        }
    }

    protected void insertar_registro() {
        try {

            if (Modelo.OAD_UBICACION.PROCEDIMIENTO(1, 1, VISTA.txtDESCRIPCION.getText()) == true) {
                JOptionPane.showMessageDialog(null, "REGISTRO INSERTADO");
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();
            } else {
                {
                    JOptionPane.showMessageDialog(null, "ERROR");

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el registro");
        }
    }

    protected void eliminar_registro() {
        try {

            if (Modelo.OAD_UBICACION.PROCEDIMIENTO(3, Integer.parseInt(VISTA.txtCODIGO.getText()), VISTA.txtDESCRIPCION.getText()) == true) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();
            } else {
                {
                    JOptionPane.showMessageDialog(null, "ERROR");

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
        }
    }

}
