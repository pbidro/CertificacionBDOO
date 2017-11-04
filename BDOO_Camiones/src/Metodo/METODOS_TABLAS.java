package Metodo;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Koe
 */
public class METODOS_TABLAS {

    public static boolean validar_tabla_seleccionada(JTable tbl) {
        int fsel = tbl.getSelectedRow();
            if (fsel == -1) {
                return true;
            } else {
                return false;
            }        
    }

    public static void ocultarColumnas(JTable tbl, int columna[]) {
        for (int i = 0; i < columna.length; i++) {
            tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
        }

    }

    public static void filtrar_tabla(JTable tbl, String flt) {
        TableRowSorter trsFiltro = new TableRowSorter(tbl.getModel());
        tbl.setRowSorter(trsFiltro);
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + flt, 0));
    }

}
