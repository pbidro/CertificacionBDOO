/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Driver.CONEXION;
import Metodo.*;
import Modelo.OAD_CHOFER;
import Vista.CRUD_CHOFER;
import java.awt.Event;
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
/**
 *
 * @author Koe
 */
public class CONT_CHOFER implements ActionListener, KeyListener, MouseListener {

    CRUD_CHOFER VISTA = new CRUD_CHOFER();
    OAD_CHOFER MODELO = new OAD_CHOFER();

    public CONT_CHOFER(CRUD_CHOFER VISTA, OAD_CHOFER MODELO) {
        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnCRUD.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        this.VISTA.txtRUT.addKeyListener(this);
        this.VISTA.txtNOMBRE.addKeyListener(this);
        this.VISTA.txtAPELLIDO.addKeyListener(this);
        this.VISTA.txtBUSQUEDA.addKeyListener(this);
        this.VISTA.RB_AGREGAR.addMouseListener(this);
        this.VISTA.RB_EDITAR.addMouseListener(this);
        this.VISTA.RB_ELIMINAR.addMouseListener(this);
        initComponents();
    }

    public CONT_CHOFER() {
    }

    private void initComponents() {
        cargar_tabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String error = validar_campos_vacios();
        if (e.getSource() == VISTA.btnCRUD) {

            if (error.equals("")) {

                if (VISTA.btnCRUD.getText().equals("AGREGAR")) {
                    insertar_registro();
                }
                if (VISTA.btnCRUD.getText().equals("EDITAR")) {
                    editar_registro();
                    JOptionPane.showMessageDialog(null, "REGISTRO EDITADO");

                }
                if (VISTA.btnCRUD.getText().equals("ELIMINAR")) {
                    eliminar_registro();
                }

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
            if (METODOS_TEXTFIELD.SOLO_RUT(e, VISTA.txtRUT.getText()) == true) {

            } else {
                e.consume();
            }
        }

        if (e.getSource() == VISTA.txtNOMBRE) {
            if (METODOS_TEXTFIELD.SoloLetras(e, VISTA.txtNOMBRE.getText(), 5) == true) {
            } else {
                e.consume();

            }
        }

        if (e.getSource() == VISTA.txtAPELLIDO) {
            if (METODOS_TEXTFIELD.SoloLetras(e, VISTA.txtAPELLIDO.getText(), 5) == true) {
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
        try {
            if (e.getSource() == VISTA.txtBUSQUEDA) {

                METODOS_TABLAS.filtrar_tabla(VISTA.jtLISTA, VISTA.txtBUSQUEDA.getText(), VISTA.jcbPARAMETRO.getSelectedIndex());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    protected String validar_campos_vacios() {
        String error = "";
        if (VISTA.txtRUT.getText().trim().equals("")) {
            error += "\n Debe ingresar un RUT";
        } else if (METODOS_TEXTFIELD.validarRut(VISTA.txtRUT.getText()) == false) {
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

            if (METODOS_TEXTFIELD.validarRut(VISTA.txtRUT.getText()) == true) {
                if (Modelo.OAD_CHOFER.VERIFICAR_CHOFER(VISTA.txtRUT.getText()) == true) {

                    if (Modelo.OAD_CHOFER.PROCEDIMIENTO(1, VISTA.txtRUT.getText(), VISTA.txtNOMBRE.getText(), VISTA.txtAPELLIDO.getText(), VISTA.txtINGRESO.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "REGISTRO INSERTADO");
                        CONEXION.commit();
                        cargar_tabla();
                        limpiacampos();
                    } else {
                        {
                            JOptionPane.showMessageDialog(null, "EL CHOFER INGRESADO YA SE ENCUENTRA EN NUESTRA BASE DE DATOS");
                        }

                    }

                } else {
                    editar_registro();
                    JOptionPane.showMessageDialog(null, "REGISTRO RESTAURADO E INSERTADO");
                    CONEXION.commit();
                    cargar_tabla();
                    limpiacampos();
                    

                }

            } else {

                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN RUT VÁLIDO");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el registro");
        }
    }

    protected boolean editar_registro() {
        boolean validar = false;
        try {

            if (Modelo.OAD_CHOFER.PROCEDIMIENTO(2, VISTA.txtRUT.getText(), VISTA.txtNOMBRE.getText(), VISTA.txtAPELLIDO.getText(), VISTA.txtINGRESO.getText()) == true) {
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();
                validar = true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL EDITAR REGITRO");

        }
        return validar;
    }

    protected void eliminar_registro() {
        try {

            if (Modelo.OAD_CHOFER.PROCEDIMIENTO(3, VISTA.txtRUT.getText(), VISTA.txtNOMBRE.getText(), VISTA.txtAPELLIDO.getText(), null) == true) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
        }
    }

    public void cargar_tabla() {
        VISTA.jtLISTA.setModel(OAD_CHOFER.CARGARDATOS(VISTA.txtBUSQUEDA.getText()));
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

    public void limpiacampos() {
        VISTA.txtNOMBRE.setText(" ");
        VISTA.txtAPELLIDO.setText(" ");
        VISTA.txtRUT.setText(" ");
        VISTA.txtNOMBRE.setText("");
        VISTA.txtAPELLIDO.setText("");
        VISTA.txtRUT.setText("");
    }

    public void MenuOpciones() {

        if (VISTA.RB_EDITAR.isSelected()) {
            VISTA.btnCRUD.setText("EDITAR");
            VISTA.txtRUT.disable();
            VISTA.txtNOMBRE.enable();
            VISTA.txtAPELLIDO.enable();
            limpiacampos();
            setear();
        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
                VISTA.btnCRUD.setText("AGREGAR");
                VISTA.txtRUT.enable();
                VISTA.txtNOMBRE.enable();
                VISTA.txtAPELLIDO.enable();
                limpiacampos();

            } else {
                VISTA.btnCRUD.setText("ELIMINAR");
                VISTA.txtRUT.disable();
                VISTA.txtNOMBRE.disable();
                VISTA.txtAPELLIDO.disable();
                limpiacampos();
                setear();
            }
        }

    }

    public void setear() {
        int fsel = VISTA.jtLISTA.getSelectedRow();

        if (fsel == -1) {

        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
            } else {
                VISTA.txtRUT.setText(VISTA.jtLISTA.getValueAt(fsel, 0).toString());
                VISTA.txtNOMBRE.setText(VISTA.jtLISTA.getValueAt(fsel, 1).toString());
                VISTA.txtAPELLIDO.setText(VISTA.jtLISTA.getValueAt(fsel, 2).toString());
            }
        }
    }

}
