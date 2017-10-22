/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;

/**
 *
 * @author Koe
 */
public class LIMITAR_LARGO {

    public static Boolean LimitarLargo(java.awt.event.KeyEvent evt, String texto, int largo) {
        Boolean Limite = true;
        if (texto.length() >= largo) {
            Limite = false;
        }
        return Limite;
    }

}
