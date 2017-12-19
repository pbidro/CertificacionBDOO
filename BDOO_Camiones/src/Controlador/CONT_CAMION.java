/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Driver.CONEXION;
import Metodo.METODOS_TABLAS;
import Metodo.METODOS_TEXTFIELD;
import Modelo.OAD_CAMION;
import Modelo.OAD_CHOFER;
import Vista.CRUD_CAMION;
import Vista.CRUD_CHOFER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Koe
 */
public class CONT_CAMION implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    int xMouse;
    int yMouse;
    CRUD_CAMION VISTA = new CRUD_CAMION();
    OAD_CAMION MODELO = new OAD_CAMION();

    public CONT_CAMION(CRUD_CAMION VISTA, OAD_CAMION MODELO) {

        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnCRUD.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        this.VISTA.txtPATENTE.addKeyListener(this);
        this.VISTA.txtAÑO.addKeyListener(this);
        this.VISTA.txtMARCA.addKeyListener(this);
        this.VISTA.txtEJES.addKeyListener(this);
        this.VISTA.txtBUSQUEDA.addKeyListener(this);
        this.VISTA.RB_AGREGAR.addMouseListener(this);
        this.VISTA.RB_EDITAR.addMouseListener(this);
        this.VISTA.RB_ELIMINAR.addMouseListener(this);
        this.VISTA.MDRAG.addMouseListener(this);
        this.VISTA.MDRAG.addMouseMotionListener(this);
        initComponents();

    }

    public CONT_CAMION() {
    }

    private void initComponents() {
        cargar_tabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String error = "";
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

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            if (e.getSource() == VISTA.txtBUSQUEDA) {

                METODOS_TABLAS.filtrar_tabla(VISTA.jtLISTA, VISTA.txtBUSQUEDA.getText(), 0);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VISTA.MDRAG) {
            xMouse = e.getX();
            yMouse = e.getY();
        }
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

    public void cargar_tabla() {
        VISTA.jtLISTA.setModel(OAD_CAMION.CARGARDATOS());
    }

    public void MenuOpciones() {

        if (VISTA.RB_EDITAR.isSelected()) {
            VISTA.btnCRUD.setText("EDITAR");
            VISTA.txtPATENTE.disable();
            VISTA.txtAÑO.setEnabled(true);
            VISTA.txtDESCRIPCION.enable();
            VISTA.txtEJES.setEnabled(true);
            VISTA.txtMARCA.enable();
            limpiacampos();
            setear();
        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
                VISTA.btnCRUD.setText("AGREGAR");
                VISTA.txtPATENTE.enable();
                VISTA.txtAÑO.setEnabled(true);
                VISTA.txtDESCRIPCION.enable();
                VISTA.txtEJES.setEnabled(true);
                VISTA.txtMARCA.enable();
                limpiacampos();
                setear();
            } else {
                VISTA.btnCRUD.setText("ELIMINAR");
                VISTA.txtPATENTE.disable();
                VISTA.txtAÑO.setEnabled(false);
                VISTA.txtDESCRIPCION.disable();
                VISTA.txtEJES.setEnabled(false);
                VISTA.txtMARCA.disable();
                limpiacampos();
                setear();
            }
        }

    }

    public void limpiacampos() {
        VISTA.txtPATENTE.setText(" ");
        VISTA.txtAÑO.setYear(2016);
        VISTA.txtDESCRIPCION.setText(" ");
        VISTA.txtEJES.setValue(1);
        VISTA.txtMARCA.setText(" ");

        VISTA.txtPATENTE.setText("");
        VISTA.txtAÑO.setYear(2017);
        VISTA.txtDESCRIPCION.setText("");
        VISTA.txtEJES.setValue(0);
        VISTA.txtMARCA.setText("");

    }

    public void setear() {
        int fsel = VISTA.jtLISTA.getSelectedRow();

        if (fsel == -1) {

        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
            } else {
                VISTA.txtPATENTE.setText(VISTA.jtLISTA.getValueAt(fsel, 0).toString());
                VISTA.txtAÑO.setYear(0 + Integer.parseInt(VISTA.jtLISTA.getValueAt(fsel, 1).toString()));
                try {
                    VISTA.txtDESCRIPCION.setText(VISTA.jtLISTA.getValueAt(fsel, 2).toString());
                } catch (Exception ex) {
                    VISTA.txtDESCRIPCION.setText("");
                }
                try {
                    VISTA.txtMARCA.setText(VISTA.jtLISTA.getValueAt(fsel, 3).toString());

                } catch (Exception ex) {
                    VISTA.txtMARCA.setText("");
                }
                VISTA.txtEJES.setValue(0 + Integer.parseInt(VISTA.jtLISTA.getValueAt(fsel, 4).toString()));
            }
        }
    }

    protected void insertar_registro() {
        try {

            if (Modelo.OAD_CAMION.VERIFICAR_CAMION(VISTA.txtPATENTE.getText()) == true) {

                if (Modelo.OAD_CAMION.PROCEDIMIENTO(1, VISTA.txtPATENTE.getText(), VISTA.txtAÑO.getValue(), VISTA.txtDESCRIPCION.getText(), VISTA.txtMARCA.getText(), Integer.parseInt(VISTA.txtEJES.getValue().toString())) == true) {
                    JOptionPane.showMessageDialog(null, "REGISTRO INSERTADO");
                    CONEXION.commit();
                    cargar_tabla();
                    limpiacampos();
                } else {
                    {
                        JOptionPane.showMessageDialog(null, "EL CAMIÓN INGRESADO YA SE ENCUENTRA EN NUESTRA BASE DE DATOS");

                    }

                }

            } else {
                editar_registro();
                JOptionPane.showMessageDialog(null, "REGISTRO RESTAURADO E INSERTADO");
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el registro");
        }
    }

    protected boolean editar_registro() {
        boolean validar = false;
        try {

            if (Modelo.OAD_CAMION.PROCEDIMIENTO(2, VISTA.txtPATENTE.getText(), VISTA.txtAÑO.getValue(), VISTA.txtDESCRIPCION.getText(), VISTA.txtMARCA.getText(), Integer.parseInt(VISTA.txtEJES.getValue().toString())) == true) {
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

            if (Modelo.OAD_CAMION.PROCEDIMIENTO(3, VISTA.txtPATENTE.getText(), VISTA.txtAÑO.getValue(), VISTA.txtDESCRIPCION.getText(), VISTA.txtMARCA.getText(), Integer.parseInt(VISTA.txtEJES.getValue().toString())) == true) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
                CONEXION.commit();
                cargar_tabla();
                limpiacampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == VISTA.MDRAG) {

            int x = e.getXOnScreen();
            int y = e.getYOnScreen();

            VISTA.setLocation(x-xMouse, y-yMouse);
        }    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
