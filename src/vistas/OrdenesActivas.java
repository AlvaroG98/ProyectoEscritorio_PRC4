package vistas;

import controlador.docWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;

public class OrdenesActivas extends javax.swing.JFrame {

    public OrdenesActivas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private String Seleccionar = "select * from encabezadoordenes where Email = '";
    private docWriter dw = new docWriter();
    private Connection cnn;
    private String Email;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTable();
        btnDetalle = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Ordenes Activas");

        tbOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tbOrdenes);

        btnDetalle.setText("Ver detalle");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDetalle)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(445, 445, 445))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(lblTitulo)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalle)
                    .addComponent(btnSalir))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.Email = dw.Leer();
        this.Seleccionar += this.Email + "';";
        CargarOrdenes();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        PerfilDeUsuario ventana = new PerfilDeUsuario();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        // TODO add your handling code here:
        if (tbOrdenes.getRowCount() > 0) {
            int row = -1;
            row = tbOrdenes.getSelectedRow();
            if (row > -1) {
                String value = tbOrdenes.getModel().getValueAt(row, 0).toString();
                dw.escribirId(value);
                DetalleOrden ventana = new DetalleOrden();
                ventana.setVisible(true);
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una orden para continuar", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay ninguna orden activa", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDetalleActionPerformed

    public void CargarOrdenes() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            int cont = 0;
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.Seleccionar);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Cod_Orden");
            modelo.addColumn("Status");
            modelo.addColumn("Nombre");
            modelo.addColumn("Email");
            modelo.addColumn("Fecha");
            modelo.addColumn("ProcesoOrden");
            modelo.addColumn("Direccion");
            tbOrdenes.setModel(modelo);
            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < 7; i++) {
                    if (i + 1 == 6) {
                        switch (Integer.parseInt(rs.getObject(i + 1).toString())) {
                            case 1: {
                                fila[i] = "Cocinando";
                                break;
                            }
                            case 2: {
                                fila[i] = "Listo";
                                break;
                            }
                            case 3: {
                                fila[i] = "Enviado";
                                break;
                            }
                            case 4: {
                                fila[i] = "Entregado";
                                break;
                            }
                            default:
                                fila[i] = rs.getObject(i + 1);
                                break;
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                modelo.addRow(fila);
                cont++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenesActivas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbOrdenes;
    // End of variables declaration//GEN-END:variables
}
