package vistas;

import modelo.conexion;
import controlador.docWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerfilDeUsuario extends javax.swing.JFrame {

    private String Seleccionar = "select * from seleccionardatosusuario where Email = '";
    private String Actualizar = "CALL ActualizarNombreUsuario(?,?,?,?,?)";
    private String Direcciones = "select concat(Direccion, ', ', Municipio, ', Punto referencia: ', Punto_referen) as Direccion from pupuseria_final.direcciones where Cod_Usuario = (select Cod_Usuario from pupuseria_final.usuarios where Email = '";
    private String Email;
    private String Nombre;
    private String Nombre2;
    private String Apellido;
    private String Apellido2;
    private String Direccion;
    private docWriter dw = new docWriter();
    private Connection cnn;

    public String getActualizar() {
        return Actualizar;
    }

    public PerfilDeUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txbEmail = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnCambiarContrasena = new javax.swing.JButton();
        txbNombre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnNuevaDireccion = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lstDirecciones = new java.awt.List();
        txbNombre2 = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        txbApellido = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        txbApellido2 = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Email");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txbEmail.setEditable(false);
        txbEmail.setBackground(new java.awt.Color(204, 204, 204));
        txbEmail.setForeground(new java.awt.Color(0, 0, 0));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Perfil de Usuario");

        btnCambiarContrasena.setText("Cambiar contraseña");
        btnCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContrasenaActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEmail.setText("Email");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre.setText("Primer Nombre");

        btnNuevaDireccion.setText("Nueva dirección");
        btnNuevaDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaDireccionActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        lblNombre1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre1.setText("Segundo Nombre");

        lblNombre2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre2.setText("Primer Apellido");

        lblNombre3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre3.setText("Segundo Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre2)
                            .addComponent(txbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txbEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(txbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre1)
                                    .addComponent(txbNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre3)
                                    .addComponent(txbApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnActualizar)
                                    .addComponent(lstDirecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCambiarContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevaDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre1)
                        .addGap(18, 18, 18)
                        .addComponent(txbNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre2)
                        .addGap(18, 18, 18)
                        .addComponent(txbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre3)
                        .addGap(18, 18, 18)
                        .addComponent(txbApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiarContrasena)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstDirecciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevaDireccion)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrarSesion)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    private void btnCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContrasenaActionPerformed
        // TODO add your handling code here:
        CambioContra ventana = new CambioContra();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnCambiarContrasenaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Identificate ventana = new Identificate();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.Email = dw.Leer();
        this.Seleccionar += this.Email + "';";
        txbEmail.setText(this.Email);
        this.Direcciones += this.Email + "')";
        CargarNombre();
        CargarDirecciones();
    }//GEN-LAST:event_formWindowOpened

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (txbNombre.getText().equals(this.Nombre) && txbNombre2.getText().equals(this.Nombre2) && txbApellido.getText().equals(this.Apellido) && txbApellido2.getText().equals(this.Apellido2)) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay nada que actualizar", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                javax.swing.JOptionPane.showMessageDialog(this, ActualizarNombre(txbEmail.getText(), txbNombre.getText(), txbNombre2.getText(), txbApellido.getText(), txbApellido2.getText()), "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                CargarNombre();
            } catch (Exception ex) {
                Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, "Error", ex);
            }

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevaDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaDireccionActionPerformed
        // TODO add your handling code here:
        NuevaDireccion ventana = new NuevaDireccion();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNuevaDireccionActionPerformed

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
            java.util.logging.Logger.getLogger(PerfilDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilDeUsuario().setVisible(true);

            }
        });
    }

    public void CargarNombre() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            int cont = 0;
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.Seleccionar);
            rs.next();
            this.Nombre = rs.getString(2);
            this.Nombre2 = rs.getString(3);
            this.Apellido = rs.getString(4);
            this.Apellido2 = rs.getString(5);
            txbNombre.setText(this.Nombre);
            txbNombre2.setText(this.Nombre2);
            txbApellido.setText(this.Apellido);
            txbApellido2.setText(this.Apellido2);
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarDirecciones() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            int cont = 0;
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.Direcciones);
            while (rs.next()) {
                this.Direccion = rs.getString(1);
                lstDirecciones.add(this.Direccion, cont);
                cont++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ActualizarNombre(String email, String nombre, String nombre2, String apellido, String apellido2) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(getActualizar());
            cmst.setString(1, email);
            cmst.setString(2, nombre);
            cmst.setString(3, nombre2);
            cmst.setString(4, apellido);
            cmst.setString(5, apellido2);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCambiarContrasena;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnNuevaDireccion;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblTitulo;
    private java.awt.List lstDirecciones;
    private javax.swing.JTextField txbApellido;
    private javax.swing.JTextField txbApellido2;
    private javax.swing.JTextField txbEmail;
    private javax.swing.JTextField txbNombre;
    private javax.swing.JTextField txbNombre2;
    // End of variables declaration//GEN-END:variables
}
