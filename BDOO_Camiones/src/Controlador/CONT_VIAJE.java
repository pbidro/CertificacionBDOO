/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Metodo.METODOS_TABLAS;
import Modelo.OAD_CAMION;
import Modelo.OAD_CHOFER;
import Modelo.OAD_UBICACION;
import Modelo.OAD_VIAJE;
import Vista.CRUD_VIAJE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Koe
 */
public class CONT_VIAJE implements ActionListener, KeyListener, MouseListener {

    CRUD_VIAJE VISTA = new CRUD_VIAJE();
    OAD_VIAJE MODELO = new OAD_VIAJE();

    public CONT_VIAJE(CRUD_VIAJE VISTA, OAD_VIAJE MODELO) {
        this.MODELO = MODELO;
        this.VISTA = VISTA;
        this.VISTA.btnCRUD.addActionListener(this);
        this.VISTA.btnVOLVER.addActionListener(this);
        this.VISTA.btnpCAMION.addActionListener(this);
        this.VISTA.btnpCHOFER.addActionListener(this);
        this.VISTA.btnpDESTINO.addActionListener(this);
        this.VISTA.btnpORIGEN.addActionListener(this);
        this.VISTA.btndCAMION.addActionListener(this);
        this.VISTA.btndCHOFER.addActionListener(this);
        this.VISTA.txtbCAMION.addKeyListener(this);
        this.VISTA.txtbCHOFER.addKeyListener(this);
        this.VISTA.txtbORIGEN.addKeyListener(this);
        this.VISTA.txtbDESTINO.addKeyListener(this);
        this.VISTA.txtCARGA.addKeyListener(this);
        this.VISTA.RB_AGREGAR.addMouseListener(this);
        this.VISTA.RB_EDITAR.addMouseListener(this);
        this.VISTA.RB_ELIMINAR.addMouseListener(this);
        cargar_tablas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == VISTA.btnpCHOFER) {
                if (VISTA.btnpCHOFER.getText().equals("ESCOGER")) {
                    int fsel = VISTA.jtCHOFER.getSelectedRow();
                    if (fsel == -1) {
                    } else {
                        VISTA.txtbCHOFER.setText(VISTA.jtCHOFER.getValueAt(fsel, 0).toString());
                        VISTA.txtbCHOFER.setEnabled(false);
                        VISTA.btnpCHOFER.setText("LIBERAR");
                    }
                } else {
                    VISTA.txtbCHOFER.setEnabled(true);
                    VISTA.btnpCHOFER.setText("ESCOGER");
                }

            }

            if (e.getSource() == VISTA.btnpCAMION) {
                if (VISTA.btnpCAMION.getText().equals("ESCOGER")) {
                    int fsel = VISTA.jtCAMION.getSelectedRow();

                    if (fsel == -1) {

                    } else {
                        VISTA.txtbCAMION.setText(VISTA.jtCAMION.getValueAt(fsel, 0).toString());
                        VISTA.txtbCAMION.setEnabled(false);
                        VISTA.btnpCAMION.setText("LIBERAR");
                    }
                } else {
                    VISTA.txtbCAMION.setEnabled(true);
                    VISTA.btnpCAMION.setText("ESCOGER");
                }
            }

            if (e.getSource() == VISTA.btnpORIGEN) {
                if (VISTA.btnpORIGEN.getText().equals("ESCOGER")) {
                    int fsel = VISTA.jtORIGEN.getSelectedRow();
                    if (fsel == -1) {
                    } else {
                        VISTA.txtbORIGEN.setText(VISTA.jtORIGEN.getValueAt(fsel, 0).toString());
                        VISTA.txtbORIGEN.setEnabled(false);
                        VISTA.btnpORIGEN.setText("LIBERAR");
                    }
                } else {
                    VISTA.txtbORIGEN.setEnabled(true);
                    VISTA.btnpORIGEN.setText("ESCOGER");
                }
            }

            if (e.getSource() == VISTA.btnpDESTINO) {
                if (VISTA.btnpDESTINO.getText().equals("ESCOGER")) {
                    int fsel = VISTA.jtDESTINO.getSelectedRow();

                    if (fsel == -1) {

                    } else {
                        VISTA.txtbDESTINO.setText(VISTA.jtDESTINO.getValueAt(fsel, 0).toString());
                        VISTA.txtbDESTINO.setEnabled(false);
                        VISTA.btnpDESTINO.setText("LIBERAR");
                    }
                } else {
                    VISTA.txtbDESTINO.setEnabled(true);
                    VISTA.btnpDESTINO.setText("ESCOGER");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
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

    public void cargar_tablas() {
        VISTA.jtLISTA.setModel(OAD_VIAJE.CARGARDATOS());
        VISTA.jtCHOFER.setModel(OAD_CHOFER.CARGARDATOS(""));
        METODOS_TABLAS.ocultarColumnas(VISTA.jtCHOFER, new int[]{1, 2, 3, 4, 5});
        VISTA.jtCAMION.setModel(OAD_CAMION.CARGARDATOS());
        METODOS_TABLAS.ocultarColumnas(VISTA.jtCAMION, new int[]{1, 2, 3, 4, 5});
        VISTA.jtORIGEN.setModel(OAD_UBICACION.CARGARDATOS());
        METODOS_TABLAS.ocultarColumnas(VISTA.jtORIGEN, new int[]{0});
        VISTA.jtDESTINO.setModel(OAD_UBICACION.CARGARDATOS());
        METODOS_TABLAS.ocultarColumnas(VISTA.jtDESTINO, new int[]{0});
    }

    public void MenuOpciones() {

        if (VISTA.RB_EDITAR.isSelected()) {
            VISTA.btnCRUD.setText("EDITAR");
            VISTA.btnpCAMION.setEnabled(true);
            VISTA.btnpCHOFER.setEnabled(true);
            VISTA.btnpDESTINO.setEnabled(true);
            VISTA.btnpORIGEN.setEnabled(true);
            VISTA.btndCAMION.setEnabled(true);
            VISTA.btndCHOFER.setEnabled(true);
            VISTA.txtbCAMION.setEnabled(true);
            VISTA.txtbCHOFER.setEnabled(true);
            VISTA.txtbORIGEN.setEnabled(true);
            VISTA.txtbDESTINO.setEnabled(true);
            VISTA.txtCARGA.setEnabled(true);
            VISTA.dtINICIO.setEnabled(true);
            VISTA.dtLLEGADA.setEnabled(true);
        } else {
            if (VISTA.RB_AGREGAR.isSelected()) {
                VISTA.btnCRUD.setText("AGREGAR");
                VISTA.btnpCAMION.setEnabled(true);
                VISTA.btnpCHOFER.setEnabled(true);
                VISTA.btnpDESTINO.setEnabled(true);
                VISTA.btnpORIGEN.setEnabled(true);
                VISTA.btndCAMION.setEnabled(true);
                VISTA.btndCHOFER.setEnabled(true);
                VISTA.txtbCAMION.setEnabled(true);
                VISTA.txtbCHOFER.setEnabled(true);
                VISTA.txtbORIGEN.setEnabled(true);
                VISTA.txtbDESTINO.setEnabled(true);
                VISTA.txtCARGA.setEnabled(true);
                VISTA.dtINICIO.setEnabled(true);
                VISTA.dtLLEGADA.setEnabled(true);

            } else {
                VISTA.btnCRUD.setText("ELIMINAR");
                VISTA.btnpCAMION.setEnabled(false);
                VISTA.btnpCHOFER.setEnabled(false);
                VISTA.btnpDESTINO.setEnabled(false);
                VISTA.btnpORIGEN.setEnabled(false);
                VISTA.btndCAMION.setEnabled(false);
                VISTA.btndCHOFER.setEnabled(false);
                VISTA.txtbCAMION.setEnabled(false);
                VISTA.txtbCHOFER.setEnabled(false);
                VISTA.txtbORIGEN.setEnabled(false);
                VISTA.txtbDESTINO.setEnabled(false);
                VISTA.txtCARGA.setEnabled(false);
                VISTA.dtINICIO.setEnabled(false);
                VISTA.dtLLEGADA.setEnabled(false);
            }
        }

    }

}
