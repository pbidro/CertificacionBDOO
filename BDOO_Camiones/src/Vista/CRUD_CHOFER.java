/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodo.SOLO_LETRAS;

/**
 *
 * @author Koe
 */
public class CRUD_CHOFER extends javax.swing.JFrame {

    /**
     * Creates new form CHOFER
     */
    public CRUD_CHOFER() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRUT = new javax.swing.JTextField();
        btnINSERTAR = new javax.swing.JButton();
        btnVOLVER = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNOMBRE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAPELLIDO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtINGRESO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RUT:");

        txtRUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUTActionPerformed(evt);
            }
        });

        btnINSERTAR.setText("INSERTAR");

        btnVOLVER.setText("VOLVER");
        btnVOLVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOLVERActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE:");

        txtNOMBRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNOMBREKeyTyped(evt);
            }
        });

        jLabel3.setText("APELLIDO:");

        txtAPELLIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPELLIDOActionPerformed(evt);
            }
        });

        jLabel4.setText("INGRESO:");

        txtINGRESO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtINGRESOActionPerformed(evt);
            }
        });

        jLabel5.setText("REGISTRO DE CHOFER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnVOLVER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnINSERTAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(txtRUT, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNOMBRE, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAPELLIDO, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtINGRESO, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(txtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(txtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(txtINGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnINSERTAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVOLVER)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUTActionPerformed

    private void txtAPELLIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPELLIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPELLIDOActionPerformed

    private void txtINGRESOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtINGRESOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtINGRESOActionPerformed

    private void txtNOMBREKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNOMBREKeyTyped



        // TODO add your handling code here:
    }//GEN-LAST:event_txtNOMBREKeyTyped

    private void btnVOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLVERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVOLVERActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD_CHOFER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_CHOFER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_CHOFER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_CHOFER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_CHOFER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnINSERTAR;
    public javax.swing.JButton btnVOLVER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtAPELLIDO;
    public javax.swing.JTextField txtINGRESO;
    public javax.swing.JTextField txtNOMBRE;
    public javax.swing.JTextField txtRUT;
    // End of variables declaration//GEN-END:variables
}
