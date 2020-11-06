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
import modelo.conexion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author gerso
 */
public class NuevaDireccion extends javax.swing.JFrame {
    private final static Logger log = LogManager.getLogger(NuevaDireccion.class);
    private String Insertar = "CALL InsertarDireccion(?,?,?,?,?)";
    private Connection cnn;

    public NuevaDireccion() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public String getInsertar() {
        return Insertar;
    }

    public String InsertarDireccion(String Municipio, String Direccion, String Punto, String Telefono, String Email) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(getInsertar());
            cmst.setString(1, Municipio);
            cmst.setString(2, Direccion);
            cmst.setString(3, Punto);
            cmst.setInt(4, Integer.parseInt(Telefono));
            cmst.setString(5, Email);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblContraActual = new javax.swing.JLabel();
        txbMunicipio = new javax.swing.JTextField();
        lblContraActual1 = new javax.swing.JLabel();
        txbDireccion = new javax.swing.JTextField();
        lblContraActual2 = new javax.swing.JLabel();
        txbPuntoReferencia = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblContraActual3 = new javax.swing.JLabel();
        txbTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Nueva Dirección");

        lblContraActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual.setText("Municipio");

        lblContraActual1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual1.setText("Dirección");

        lblContraActual2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual2.setText("Punto de referencia");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblContraActual3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraActual3.setText("Teléfono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblContraActual2)
                                .addComponent(txbMunicipio, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(txbDireccion)
                                .addComponent(lblContraActual1)
                                .addComponent(lblContraActual)
                                .addComponent(txbPuntoReferencia)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(lblContraActual3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addComponent(btnAgregar)
                            .addGap(18, 18, 18)
                            .addComponent(btnCerrar))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual)
                .addGap(18, 18, 18)
                .addComponent(txbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual1)
                .addGap(18, 18, 18)
                .addComponent(txbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual2)
                .addGap(18, 18, 18)
                .addComponent(txbPuntoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraActual3)
                .addGap(18, 18, 18)
                .addComponent(txbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCerrar))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txbTelefono.getText().length() == 8) {
            try {
                docWriter dw = new docWriter();
                javax.swing.JOptionPane.showMessageDialog(this, InsertarDireccion(txbMunicipio.getText(), txbDireccion.getText(), txbPuntoReferencia.getText(), txbTelefono.getText(), dw.Leer()), "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                log.error("No se realizo la operacion " + ex.getMessage());
            }

        } else {
            ///No es el formato correcto de numero
            javax.swing.JOptionPane.showMessageDialog(this, "El telefono debe ir sin guiones ni espacios", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        PerfilDeUsuario ventana = new PerfilDeUsuario();
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
            java.util.logging.Logger.getLogger(NuevaDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaDireccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lblContraActual;
    private javax.swing.JLabel lblContraActual1;
    private javax.swing.JLabel lblContraActual2;
    private javax.swing.JLabel lblContraActual3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txbDireccion;
    private javax.swing.JTextField txbMunicipio;
    private javax.swing.JTextField txbPuntoReferencia;
    private javax.swing.JTextField txbTelefono;
    // End of variables declaration//GEN-END:variables
}
