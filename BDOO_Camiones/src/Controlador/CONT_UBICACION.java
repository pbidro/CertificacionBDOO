/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

/**
 *
 * @author Koe
 */
public class CONT_UBICACION implements ActionListener, KeyListener, MouseListener{

    
    
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
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
