/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.docWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion;

public class CambioContra extends javax.swing.JFrame {

    public CambioContra() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public String getActualizar() {
        return Actualizar;
    }

    private String Actualizar = "CALL ActualizarContrasena(?,?)";
    private docWriter dw = new docWriter();
    private Connection cnn;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txbContra = new javax.swing.JTextField();
        lblContraActual = new javax.swing.JLabel();
        lblContraActual1 = new javax.swing.JLabel();
        txbContraNueva = new javax.swing.JTextField();
        lblContraActual2 = new javax.swing.JLabel();
        txbContraConfirm = new javax.swing.JTextField();
        btnCambiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Cambio de contraseña");

        lblContraActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual.setText("Actual contraseña");

        lblContraActual1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual1.setText("Nueva contraseña");

        lblContraActual2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual2.setText("Confirmar contraseña");

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblTitulo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContraActual2)
                            .addComponent(txbContra, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(txbContraNueva)
                            .addComponent(lblContraActual1)
                            .addComponent(lblContraActual)
                            .addComponent(txbContraConfirm)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnCambiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual)
                .addGap(18, 18, 18)
                .addComponent(txbContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual1)
                .addGap(18, 18, 18)
                .addComponent(txbContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual2)
                .addGap(18, 18, 18)
                .addComponent(txbContraConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnCerrar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
        if (dw.LeerContra().equals(txbContra.getText())) {
            if (txbContraNueva.getText().equals(txbContraConfirm.getText())) {
                try {
                    javax.swing.JOptionPane.showMessageDialog(this, ActualizarContra(txbContraNueva.getText(), dw.Leer()), "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, "Error", ex);
                }
            } else {
                ///No se pudo
                javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            ///No es la misma contraseña
            javax.swing.JOptionPane.showMessageDialog(this, "Error, la contraseña de usuario no es correcta", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnCambiarActionPerformed

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
            java.util.logging.Logger.getLogger(CambioContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambioContra().setVisible(true);
            }
        });
    }

    public String ActualizarContra(String contra, String email) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(getActualizar());
            cmst.setString(1, contra);
            cmst.setString(2, email);
            cmst.execute();
            resultado = " Los datos se actualizaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
        }
        return resultado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lblContraActual;
    private javax.swing.JLabel lblContraActual1;
    private javax.swing.JLabel lblContraActual2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txbContra;
    private javax.swing.JTextField txbContraConfirm;
    private javax.swing.JTextField txbContraNueva;
    // End of variables declaration//GEN-END:variables
}
