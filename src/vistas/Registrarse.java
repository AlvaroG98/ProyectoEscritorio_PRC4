/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CheckPassword;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vistas.Identificate;

public class Registrarse extends javax.swing.JFrame {
    private final static Logger log = LogManager.getLogger(Registrarse.class);
    /**
     * Creates new form Registrarse
     */
    public Registrarse() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private String Insertar = "CALL InsertarUsuario(?,?,?,?,?,?)";
    private Connection cnn;

    public String getInsertar() {
        return Insertar;
    }

    public String InsertarUsuario(String Prim_nom, String Seg_nom, String Prim_ape, String Seg_ape, String Email, String Contraseña) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(getInsertar());
            cmst.setString(1, Prim_nom);
            cmst.setString(2, Seg_nom);
            cmst.setString(3, Prim_ape);
            cmst.setString(4, Seg_ape);
            cmst.setString(5, Email);
            cmst.setString(6, Contraseña);
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo la operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo la operacion " + ex.getMessage());
        }
        return resultado;
    }

    public void setInsertar(String Insertar) {
        this.Insertar = Insertar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txbContra = new javax.swing.JPasswordField();
        txbConfContra = new javax.swing.JPasswordField();
        txbPriNom = new javax.swing.JTextField();
        txbEmail = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblNombre2 = new javax.swing.JLabel();
        txbSegNom = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txbPriApe = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        txbSegApe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblNombre.setText("Primer Nombre");

        lblEmail.setText("Email");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Confirma Contraseña");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblNombre2.setText("Segundo Nombre");

        lblApellido1.setText("Primer Apellido");

        lblApellido2.setText("Segundo Apellido");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registro");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellido1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txbSegNom)
                    .addComponent(txbPriApe)
                    .addComponent(txbPriNom, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(txbEmail)
                    .addComponent(txbContra)
                    .addComponent(txbConfContra)
                    .addComponent(txbSegApe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(239, 239, 239))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txbPriNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(txbSegNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbPriApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbSegApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txbContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txbConfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCerrar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txbPriNom.getText().equals("") || (txbSegNom.getText().equals("")) || (txbPriApe.getText().equals("")) || (txbSegApe.getText().equals(""))
                || (txbEmail.getText().equals("")) || (txbContra.getText().equals("")) || (txbConfContra.getText().equals(""))) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txbPriNom.requestFocus();
        } else {
            if (txbContra.getText().equals(txbConfContra.getText())) {
                try {
                    javax.swing.JOptionPane.showMessageDialog(this, InsertarUsuario(txbPriNom.getText(), txbSegNom.getText(), txbPriApe.getText(), txbSegApe.getText(), txbEmail.getText(), txbContra.getText()), "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {

                    log.error("Error SQL " + ex.getMessage());
                }
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas deben coincidir", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txbContra.setText("");
                txbConfContra.setText("");
                txbContra.requestFocus();
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        Identificate ventana = new Identificate();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JPasswordField txbConfContra;
    private javax.swing.JPasswordField txbContra;
    private javax.swing.JTextField txbEmail;
    private javax.swing.JTextField txbPriApe;
    private javax.swing.JTextField txbPriNom;
    private javax.swing.JTextField txbSegApe;
    private javax.swing.JTextField txbSegNom;
    // End of variables declaration//GEN-END:variables
}
