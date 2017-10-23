/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Metodo.SOLO_LETRAS;
import Modelo.OAD_CHOFER;
import Vista.CRUD_CHOFER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Koe
 */
public class CONT_CHOFER implements ActionListener {

    CRUD_CHOFER VISTA = new CRUD_CHOFER();
    OAD_CHOFER MODELO = new OAD_CHOFER();

    public CONT_CHOFER(CRUD_CHOFER VISTA, OAD_CHOFER MODELO) {
        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnINSERTAR.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        //this.VISTA.txtRUT.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VISTA.btnINSERTAR) {
            VISTA.txtRUT.setText("");
            JOptionPane.showMessageDialog(null, "LIMPIADO");

        }

        if (e.getSource() == VISTA.btnVOLVER) {
            JOptionPane.showMessageDialog(null, "BOTON VOLVER");
        }

    }

    public void keyTyped(KeyEvent e) {

        if (e.getSource() == VISTA.txtRUT) {

        }

        if (e.getSource() == VISTA.txtNOMBRE) {
            if (SOLO_LETRAS.SoloLetras(e, VISTA.txtNOMBRE.getText(), 5) == true) {
            } else {
                e.consume();

            }
        }

        if (e.getSource() == VISTA.txtAPELLIDO) {

        }

    }

}
