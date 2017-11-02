/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Driver.CONEXION;
import Metodo.SOLO_LETRAS;
import Metodo.VAL_RUT;
import Modelo.OAD_CHOFER;
import Vista.CRUD_CHOFER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Koe
 */
public class CONT_CHOFER implements ActionListener, KeyListener {

    CRUD_CHOFER VISTA = new CRUD_CHOFER();
    OAD_CHOFER MODELO = new OAD_CHOFER();

    public CONT_CHOFER(CRUD_CHOFER VISTA, OAD_CHOFER MODELO) {
        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnINSERTAR.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        this.VISTA.txtRUT.addKeyListener(this);
        this.VISTA.txtNOMBRE.addKeyListener(this);
        this.VISTA.txtAPELLIDO.addKeyListener(this);
        this.VISTA.txtBUSQUEDA.addKeyListener(this);
        initComponents();
    }

    private void initComponents() {
        cargar_tabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String error = validar_campos_vacios();
        if (e.getSource() == VISTA.btnINSERTAR) {

            if (error.equals("")) {
                insertar_registro();
            } else {
                JOptionPane.showMessageDialog(null, error);
            }
        }

        if (e.getSource() == VISTA.btnVOLVER) {
            VISTA.dispose();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == VISTA.txtRUT) {
            if (VAL_RUT.SOLO_RUT(e, VISTA.txtRUT.getText()) == true) {

            } else {
                e.consume();
            }
        }

        if (e.getSource() == VISTA.txtNOMBRE) {
            if (SOLO_LETRAS.SoloLetras(e, VISTA.txtNOMBRE.getText(), 5) == true) {
            } else {
                e.consume();

            }
        }

        if (e.getSource() == VISTA.txtAPELLIDO) {
            if (SOLO_LETRAS.SoloLetras(e, VISTA.txtAPELLIDO.getText(), 5) == true) {
            } else {
                e.consume();

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


    }

    @Override
    public void keyReleased(KeyEvent e) {
     
        if (e.getSource() == VISTA.txtBUSQUEDA) {
            if (SOLO_LETRAS.SoloLetras(e, VISTA.txtBUSQUEDA.getText(), 5) == true) {
                cargar_tabla();
            } else {
                e.consume();

            }
        }        
//   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected String validar_campos_vacios() {

        String error = "";
        if (VISTA.txtRUT.getText().trim().equals("")) {
            error += "\n Debe ingresar un RUT";

        } else if (VAL_RUT.validarRut(VISTA.txtRUT.getText()) == false) {
            error += "\n Debe ingresar un RUT válido";
        }
        if (VISTA.txtNOMBRE.getText().trim().equals("")) {
            error += "\n Debe ingresar un nombre";
        }
        if (VISTA.txtAPELLIDO.getText().trim().equals("")) {
            error += "\n Debe ingresar un Apellido";
        }

        return error;

    }

    protected void insertar_registro() {
        try {

            if (VAL_RUT.validarRut(VISTA.txtRUT.getText()) == true) {
                if (Modelo.OAD_CHOFER.PROCEDIMIENTO(1, VISTA.txtRUT.getText(), VISTA.txtNOMBRE.getText(), VISTA.txtAPELLIDO.getText(), null) == true) {
                    JOptionPane.showMessageDialog(null, "REGISTRO INSERTADO");
                } else {
                    JOptionPane.showMessageDialog(null, "EL CHOFER YA ESTÁ REGISTRADO");

                }

            } else {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el registro");
        }

    }

    public void cargar_tabla() {
        VISTA.jtLISTA.setModel(OAD_CHOFER.CARGARDATOS(VISTA.txtBUSQUEDA.getText()));
    }

}
