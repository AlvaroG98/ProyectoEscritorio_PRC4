package vistas;

import controlador.ComprasWriter;
import controlador.LectorPedido;
import controlador.docWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class carrito extends javax.swing.JFrame {
    private final static Logger log = LogManager.getLogger(carrito.class);
    private final String ruta = System.getProperties().getProperty("user.dir");
    private ComprasWriter cw = new ComprasWriter();
    private String SeleccionarIdUsuario = "select Cod_Usuario from usuarios where Email = '";
    private String SeleccionarIdDireccion = "select max(Cod_direc) from direcciones where Cod_Usuario = ";
    private String SeleccionarCodOrden = "select max(Cod_Orden) from ordenes;";
    private String Insertar = "CALL InsertarOrden(?,?,?,?,?)";
    private Connection cnn;
    private String Email;
    private String Cod_Orden;
    private int Cod_Usuario;
    private int Cod_Direccion;
    private docWriter dw = new docWriter();

    public String getInsertar() {
        return Insertar;
    }

    public carrito() {
        initComponents();
        setLocationRelativeTo(null);
        CargarDatos();
    }

    void CargarDatos() {
        File archivo = null;
        FileReader FileR = null;
        BufferedReader BufferedR = null;
        try {
            //Colocar el nombre del TXT
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Mostrar Productos");
            TablaProductos.setModel(tabla);
            String informacion;
            try {
                archivo = new File(ruta + "//acom.txt");
                FileR = new FileReader(archivo);
                BufferedR = new BufferedReader(FileR);                
                //Colocamos la informacion
                while ((informacion = BufferedR.readLine()) != null) {
                    System.out.println(informacion);
                    tabla.addRow(new String[]{informacion});
                }
                FileR.close();
                BufferedR.close();
            } catch (Exception ex) {
                log.error("No se realizo la operacion " + ex.getMessage());
            }

            try {
                archivo = new File(ruta + "//pupas.txt");
                FileR = new FileReader(archivo);
                BufferedR = new BufferedReader(FileR);
                //Colocamos la informacion
                while ((informacion = BufferedR.readLine()) != null) {
                    System.out.println(informacion);
                    tabla.addRow(new String[]{informacion});
                }
                FileR.close();
                BufferedR.close();
            } catch (Exception ex) {
                log.error("No se realizo la operacion " + ex.getMessage());
            }

            try {
                archivo = new File(ruta + "//esp.txt");
                FileR = new FileReader(archivo);
                BufferedR = new BufferedReader(FileR);
                //Colocamos la informacion
                while ((informacion = BufferedR.readLine()) != null) {
                    System.out.println(informacion);
                    tabla.addRow(new String[]{informacion});
                }
                FileR.close();
                BufferedR.close();
            } catch (Exception ex) {
                log.error("No se realizo la operacion " + ex.getMessage());
            }
            TablaProductos.setModel(tabla);
        } catch (Exception e) {
            log.error("No se realizo la operacion " + e.getMessage());
        } finally {
            try {
                if (null != FileR) {
                    FileR.close();
                }
            } catch (IOException e2) {
                log.error("No se realizo la operacion " + e2.getMessage());
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        btnVaciarCarrito = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Eras Medium ITC", 2, 18)); // NOI18N
        jLabel1.setText("Carrito de Compras");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito-de-compras (1).png"))); // NOI18N

        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL:");

        btnComprar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnComprar.setText("Hacer compra");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaProductos);

        btnVaciarCarrito.setText("Vaciar carrito");
        btnVaciarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarCarritoActionPerformed(evt);
            }
        });

        jMenu1.setText("Pupusas");

        jMenuItem1.setText("Ajo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ayote");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Camaron");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Chicharron");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Frijol");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Jalapeño");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Loroco");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Pollo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Queso");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Especialidades");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Carrito");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Perfil de usuario");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComprar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(587, 587, 587)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVaciarCarrito))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVaciarCarrito)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComprar)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        if(TablaProductos.getRowCount()>0){
            /*
                1-insertar nueva orden
                2-insertar acompañamientos
                3-insertar pupusa tradicional
                4-insertar en pupusa_especial
                5-insertar en detalle de pupa especial
                6-insertar en detalle orden especial
            */
            insertarOrden();
            CargarCodOrden();
            LectorPedido lp = new LectorPedido();
            lp.InsertarAcom(this.Cod_Orden);
            lp.InsertarPupa(this.Cod_Orden);
            lp.InsertarPupaEsp(this.Cod_Orden);
            javax.swing.JOptionPane.showMessageDialog(this, "El pedido se realizo exitosamente", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            cw.EliminarArchivos();
            CargarDatos();
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Agregue elementos al carrito para hacer un pedido", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            log.error("No se agrego productos al carrito ");
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    public void CargarIdUsuario() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.SeleccionarIdUsuario);
            rs.next();
            this.Cod_Usuario = Integer.parseInt(rs.getString(1));
            this.SeleccionarIdDireccion += this.Cod_Usuario + ";";
            cnn.close();
        } catch (SQLException ex) {
            log.error("Erro SQL " + ex.getMessage());
        }
    }
    
    public void CargarIdDireccion() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.SeleccionarIdDireccion);
            rs.next();
            this.Cod_Direccion = Integer.parseInt(rs.getString(1));
            cnn.close();
        } catch (SQLException ex) {
            log.error("Erro SQL " + ex.getMessage());
        }
    }
    
    public void CargarCodOrden() {
        String resultado = "";
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.SeleccionarCodOrden);
            rs.next();
            this.Cod_Orden = rs.getString(1);
            cnn.close();
        } catch (SQLException ex) {
            log.error("Erro SQL " + ex.getMessage());
        }
    }
    
    void insertarOrden(){
        String resultado = "";
        try {
            CargarIdUsuario();
            CargarIdDireccion();
            Calendar calendario = Calendar.getInstance();
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(getInsertar());
            cmst.setString(1, "Activa");
            cmst.setInt(2, this.Cod_Usuario);
            cmst.setString(3, String.valueOf(calendario.get(Calendar.YEAR)) + "-" + String.valueOf(calendario.get(Calendar.MONTH)+1) + "-" + String.valueOf(calendario.get(Calendar.DATE)));
            cmst.setInt(4, 1);
            cmst.setInt(5, this.Cod_Direccion);
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion ");
        }
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        PupusaAjo pa = new PupusaAjo();
        pa.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        PupusaAyote pay = new PupusaAyote();
        pay.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        PupusaCamaron pc = new PupusaCamaron();
        pc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        PupusaChicharron pch = new PupusaChicharron();
        pch.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        PupusaFrijol pf = new PupusaFrijol();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        PupusaJalapeno pj = new PupusaJalapeno();
        pj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        PupusaLoroco pl = new PupusaLoroco();
        pl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        PupusaPollo pp = new PupusaPollo();
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        PupusaQueso pq = new PupusaQueso();
        pq.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        menu men = new menu();
        men.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        Especialidades esp = new Especialidades();
        esp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        carrito ca = new carrito();
        ca.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        PerfilDeUsuario pdu = new PerfilDeUsuario();
        pdu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void btnVaciarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCarritoActionPerformed
        // TODO add your handling code here:
        cw.EliminarArchivos();
        CargarDatos();
    }//GEN-LAST:event_btnVaciarCarritoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.Email = dw.Leer();
        this.SeleccionarIdUsuario += this.Email + "';";
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVaciarCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
