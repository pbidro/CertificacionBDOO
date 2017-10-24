/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;

import com.sun.glass.events.KeyEvent;

/**
 *
 * @author Koe
 */
public class SOLO_NUMEROS {

    public static Boolean SoloNumeros(java.awt.event.KeyEvent evt, String texto, int largo) {
        Boolean Validar = true;
        char teclaE;
        teclaE = evt.getKeyChar();

        if (!Character.isDigit(teclaE) && teclaE != KeyEvent.VK_BACKSPACE) {
            Validar = false;
        }

        if (LIMITAR_LARGO.LimitarLargo(evt, texto, largo) == false) {
            Validar = false;
        }
        return Validar;
    }

}
