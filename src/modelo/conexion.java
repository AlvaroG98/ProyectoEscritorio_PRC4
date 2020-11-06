
package modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class conexion {
    //Parametros para poder hacer la conexion a la base de datos 
    private final static Logger log = LogManager.getLogger(conexion.class);
    static String user = "root";
    static String pass = "matias123.";
    static String url = "jdbc:mysql://localhost/pupuseria_final";
    static Connection cnn;
    private Statement s = null;
    private ResultSet rs = null;
    
    public conexion()
    {
        Conectar();
    }
    //establecer la conexion con la base en la parte que se le solicite
    public static Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException cnfex) {
            JOptionPane.showMessageDialog(null, "ConexionMySQL:" + cnfex.getMessage());
            log.error("ConexionMySQL " + cnfex.getMessage());
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "ConexionMySQL:" + sqlex.getMessage());
            log.error("ConexionMySQL " + sqlex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ConexionMySQL:" + ex.getMessage());
            log.error("ConexionMySQL " + ex.getMessage());
        }
        return cnn;
    }

    public void cerrarConexion() {
        try {
            cnn.close();
        } catch (SQLException ex) {
            log.error("ConexionMySQL " + ex.getMessage());
        }
    }
    public ResultSet GetRs(){
        return rs;
    }
    //ingreso de query de parte de la base 
    public void setRs(String consulta){
        try{
            s = cnn.createStatement();
            this.rs = s.executeQuery(consulta);
        } catch(SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
            log.error("Fallo en MySQL " + e2.getMessage());
        }
    }
    
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
