
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
import vistas.PerfilDeUsuario;
/**
 *
 * @author lando
 */
public class Operador extends javax.swing.JFrame {

    /**
     * Creates new form Operador
     */
    public Operador() {
        initComponents();
    }
    private String Seleccionar = "Select o.Cod_Orden, Concat(Prim_nom,' ',Seg_nom,' ',Prim_ape,' ',Seg_ape) as 'Usuario',CreadaEl,ProcesoOrden,d.Direccion\n" +
"from Ordenes as o inner join Usuarios as u on o.Cod_Usuario=u.Cod_Usuario inner join direcciones as d on\n" +
"o.Cod_Direccion=d.Cod_direc\n" +
"where Status like 'Activa';";
    private docWriter dw = new docWriter();
    private Connection cnn;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbOperador = new javax.swing.JTable();
        jlbOperador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtbOperador.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jtbOperador.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbOperador);

        jlbOperador.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jlbOperador.setText("OPERADOR DE ORDENES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jlbOperador)
                .addGap(370, 370, 370))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jlbOperador)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        CargarOrdenes();
    }//GEN-LAST:event_formWindowOpened

    
    
    /**
     * @param args the command line arguments
     */
    
     public void CargarOrdenes() {
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            int cont = 0;
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(this.Seleccionar);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Cod_Orden");
            modelo.addColumn("Nombre");
            modelo.addColumn("Fecha");
            modelo.addColumn("ProcesoOrden");
            modelo.addColumn("Direccion");
            jtbOperador.setModel(modelo);
            while (rs.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i + 1 == 4) {
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
            java.util.logging.Logger.getLogger(Operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Operador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbOperador;
    private javax.swing.JTable jtbOperador;
    // End of variables declaration//GEN-END:variables
}
