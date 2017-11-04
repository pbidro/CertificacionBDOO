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
public class METODOS_TEXTFIELD {

    public static Boolean LimitarLargo(java.awt.event.KeyEvent evt, String texto, int largo) {
        Boolean Limite = true;
        if (texto.length() >= largo) {
            Limite = false;
        }
        return Limite;
    }

    public static Boolean SoloLetras(java.awt.event.KeyEvent evt, String texto, int largo) {
        Boolean Validar = true;
        char tecla;
        tecla = evt.getKeyChar();

        if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACKSPACE) {
            Validar = false;

        }
        if (LimitarLargo(evt, texto, largo) == false) {
            Validar = false;

        }
        return Validar;
    }

    public static Boolean SoloNumeros(java.awt.event.KeyEvent evt, String texto, int largo) {
        Boolean Validar = true;
        char teclaE;
        teclaE = evt.getKeyChar();

        if (!Character.isDigit(teclaE) && teclaE != KeyEvent.VK_BACKSPACE) {
            Validar = false;
        }

        if (LimitarLargo(evt, texto, largo) == false) {
            Validar = false;
        }
        return Validar;
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public static Boolean SOLO_RUT(java.awt.event.KeyEvent evt, String rut) {

        Boolean Validar = true;
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != java.awt.event.KeyEvent.VK_BACK_SPACE)
                && (c != 'K') && (c != 'k')) {
            Validar = false;
        }
        if ((c == 'K' || c == 'k') && rut.length() <= 7) {
            Validar = false;
        }
        if ((c == 'K' || c == 'k') && (rut.contains("K") || rut.contains("k"))) {
            Validar = false;
        }
        if ((c == 'K' || c == 'k') && rut.trim().equals("")) {
            Validar = false;
        }
        if (rut.length() >= 9) {
            Validar = false;
        }
        if (rut.length() >= 7 && (rut.contains("K") || rut.contains("k"))) {
            Validar = false;
        }
        return Validar;
    }

}
