/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;

import com.sun.glass.events.KeyEvent;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Koe
 */
public class SOLO_LETRAS {

    public static Boolean SoloLetras(java.awt.event.KeyEvent evt, String texto) {
        Boolean Validar = true;
        char tecla;
        tecla = evt.getKeyChar();

        if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACKSPACE) {
            Validar = false;
        }

        return Validar;
    }

}
