/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CheckPassword;
import modelo.conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.PerfilDeUsuario;
import vistas.Registrarse;
import controlador.docWriter;

public class Identificate extends javax.swing.JFrame {

    public Identificate() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txbEmail = new javax.swing.JTextField();
        txbContrasena = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmail.setText("Email");

        lblContrasena.setText("Contraseña");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Olvido contraseña?");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Inicio de sesión");

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmail)
                            .addComponent(lblContrasena)
                            .addComponent(txbContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txbEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnRegistrarse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id_tipo = "";
        String usuario = "";
        String pass = "";
        docWriter dw = new docWriter();
        try {
            CheckPassword verificar = new CheckPassword();
            char passArray[] = txbContrasena.getPassword();
            if (verificar.verificarPassword(passArray)) {
                String pas = new String(passArray);
                //creando objeto de conexion
                conexion con = new conexion();
                //consulta
                con.setRs("SELECT Cod_Usuario, Email, Contraseña FROM pupuseria_final.usuarios where Email ='" + txbEmail.getText() + "';");
                //se obtienen los valores
                ResultSet valor = (ResultSet) con.GetRs();
                //Se mueve al unico registro devuelto
                if (valor.next()) {
                    usuario = valor.getString(2);
                    pass = valor.getString(3);
                    if (usuario.equals(txbEmail.getText()) && pass.equals(txbContrasena.getText())) {
                        PerfilDeUsuario ventana = new PerfilDeUsuario();
                        ventana.setVisible(true);
                        dw.escribir(usuario);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Error, usuario o contraseña no coinciden");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Error, usuario o contraseña no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El password contiene caracteres invalidos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identificate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
        Registrarse ventana = new Registrarse();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

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
            java.util.logging.Logger.getLogger(Identificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Identificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Identificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Identificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Identificate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txbContrasena;
    private javax.swing.JTextField txbEmail;
    // End of variables declaration//GEN-END:variables
}
