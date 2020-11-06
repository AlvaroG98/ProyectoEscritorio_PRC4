package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vistas.PerfilDeUsuario;

public class LectorPedido {
    private final static Logger log = LogManager.getLogger(LectorPedido.class);
    private File archivoAcom = new File("acom.txt");
    private File archivoPupa = new File("pupas.txt");
    private File archivoEsp = new File("esp.txt");
    private String[][] dbAcom = new String[5][3];
    private String[][] dbPupa = new String[18][4];
    private String[][] dbIngred = new String[9][3];
    private int cont;
    private String InsertarDetAcom = "CALL InsertarDetAcom(?,?,?)";
    private String InsertarDetPup = "CALL InsertarDetPupa(?,?,?,?)";
    private String InsertarPupaEsp = "CALL InsertarPupaEsp(?)";
    private String InsertarDetPupaEsp = "CALL InsertarDetPupaEsp(?,?)";
    private String InsertarOrdenDetEsp = "CALL InsertarDetEsp(?,?,?)";
    private Connection cnn;
    //Lector que permitira leer los txt a partir de matrices hechas segun cada producto
    public LectorPedido() {
        this.cont = 0;
        this.dbAcom[0][0] = "1";
        this.dbAcom[1][0] = "2";
        this.dbAcom[2][0] = "3";
        this.dbAcom[3][0] = "4";
        this.dbAcom[4][0] = "5";
        this.dbAcom[0][1] = "BebidaCocacola";
        this.dbAcom[1][1] = "BebidaPepsi";
        this.dbAcom[2][1] = "BebidaHorchata";
        this.dbAcom[3][1] = "PostreTresLeches";
        this.dbAcom[4][1] = "PostreBudin";
        this.dbAcom[0][2] = "0";
        this.dbAcom[1][2] = "0";
        this.dbAcom[2][2] = "0";
        this.dbAcom[3][2] = "0";
        this.dbAcom[4][2] = "0";
        BasePupa();
        llenarBaseIngredientes();
    }
    //Insertar Acompañamiento dentro del txt creado en una clase previa
    public void InsertarAcom(String codOrden) {
        if (archivoAcom.exists()) {
            String fila = "";
            FileReader in = null;
            try {
                in = new FileReader("acom.txt");
                BufferedReader br = new BufferedReader(in);
                boolean encontrado = false;
                while ((fila = br.readLine()) != null && fila != "\n") //el while leera todo el documento
                {
                    String[] palabra = fila.split(","); // dividir en palabras delimitadas por espacios
                    //aca abajo se rellena la matriz de usuarios
                    while (this.cont < 5 && !encontrado) {
                        if (palabra[0].equals(this.dbAcom[this.cont][1])) {
                            this.dbAcom[this.cont][2] = palabra[1];
                            encontrado = true;
                        }
                        this.cont++;
                    }
                    encontrado = false;
                }
                this.cont = 0;
                in.close();
                br.close();
                while (this.cont < 5) {
                    //Insercion del txt con el dbAcom a la funcion que esta segun la base de MySQL
                    if (!this.dbAcom[this.cont][2].equals("0")) {
                        InsertarDetaAcom(this.dbAcom[this.cont][0], codOrden, this.dbAcom[this.cont][2]);
                    }
                    this.cont++;
                }
                this.cont = 0;
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error("Excepcion " + ex.getMessage());
            }
        }
    }
    //Insercion  segun la base de MySQL los datos del programa 
    public String InsertarDetaAcom(String cod_acom, String cod_orden, String cantidad) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(this.InsertarDetAcom);
            cmst.setInt(1, Integer.parseInt(cod_acom));
            cmst.setInt(2, Integer.parseInt(cod_orden));
            cmst.setInt(3, Integer.parseInt(cantidad));
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion " + ex.getMessage());
        }
        System.out.print(resultado);
        return resultado;
    }
    //NUEVAS BASE PARA PUPUSAS
    public void BasePupa(){
        for(int i=0; i<18; i++){
            this.dbPupa[i][0] = String.valueOf(i+1);
        }
        for(int i=0; i<18; i++){
            this.dbPupa[i][3] = "0";
        }
        for(int i=0; i<18; i++){
            this.dbPupa[i][2] = "1";
        }
        this.dbPupa[0][1] = "pupusaQueso";
        this.dbPupa[1][1] = "pupusaQueso";
        this.dbPupa[2][1] = "pupusaFrijol";
        this.dbPupa[3][1] = "pupusaFrijol";
        this.dbPupa[4][1] = "pupusaChicharron";
        this.dbPupa[5][1] = "pupusaChicharron";
        this.dbPupa[6][1] = "pupusaLoroco";
        this.dbPupa[7][1] = "pupusaLoroco";
        this.dbPupa[8][1] = "pupusaAyote";
        this.dbPupa[9][1] = "pupusaAyote";
        this.dbPupa[10][1] = "pupusaAjo";
        this.dbPupa[11][1] = "pupusaAjo";
        this.dbPupa[12][1] = "pupusaPollo";
        this.dbPupa[13][1] = "pupusaPollo";
        this.dbPupa[14][1] = "pupusaCamaron";
        this.dbPupa[15][1] = "pupusaCamaron";
        this.dbPupa[16][1] = "pupusaJalapeño";
        this.dbPupa[17][1] = "pupusaJalapeño";
        
    }
     public void InsertarPupa(String codOrden) {
        if (archivoAcom.exists()) {
            String fila = "";
            FileReader in = null;
            try {
                in = new FileReader("pupas.txt");
                BufferedReader br = new BufferedReader(in);
                boolean encontrado = false;
                while ((fila = br.readLine()) != null && fila != "\n") //el while leera todo el documento
                {
                    this.cont=0;
                    String[] palabra = fila.split(","); // dividir en palabras delimitadas por espacios
                    //aca abajo se rellena la matriz de usuarios
                    while (this.cont < 18 && !encontrado) {
                        if (palabra[0].equals(this.dbPupa[this.cont][0])) {
                            this.dbPupa[this.cont][3] = palabra[3];
                            encontrado = true;
                            if(palabra[2].equals("Arroz")){
                                this.dbPupa[this.cont][2]="2";
                            }
                        }
                        this.cont++;
                    }
                    encontrado = false;
                }
                this.cont = 0;
                in.close();
                br.close();
                while (this.cont < 18) {
                    if (!this.dbPupa[this.cont][3].equals("0")) {
                        InsertarDetaPupa(this.dbPupa[this.cont][0], this.dbPupa[this.cont][3], "0", codOrden);
                    }
                    this.cont++;
                }
                this.cont = 0;
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error("Excepcion " + ex.getMessage());
            }
        }
    }
     //Insercion  segun la base de MySQL los datos del programa 
    public String InsertarDetaPupa(String cod_pupa, String cantidad, String descuento, String cod_orden) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(this.InsertarDetPup);
            cmst.setInt(1, Integer.parseInt(cod_pupa));
            cmst.setInt(2, Integer.parseInt(cantidad));
            cmst.setInt(3, Integer.parseInt(descuento));
            cmst.setInt(4, Integer.parseInt(cod_orden));
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion " + ex.getMessage());
        }
        System.out.print(resultado);
        return resultado;
    }
    //NUEVAS BASE PARA PUPUSAS ESPECIALES USANDO LOS INGREDIENTES DE LAS NORMALES
     private void llenarBaseIngredientes(){
        
        for(int i=0; i<9; i++){
            this.dbIngred[i][0] = String.valueOf(i+1);
        }
        this.dbIngred[0][1] = "Queso";
        this.dbIngred[1][1] = "Frijol";
        this.dbIngred[2][1] = "Chicharron";
        this.dbIngred[3][1] = "Loroco";
        this.dbIngred[4][1] = "Ayote";
        this.dbIngred[5][1] = "Ajo";
        this.dbIngred[6][1] = "Pollo";
        this.dbIngred[7][1] = "Camaron";
        this.dbIngred[8][1] = "Jalapeño";
        this.dbIngred[0][2] = "0.5";
        this.dbIngred[1][2] = "0.5";
        this.dbIngred[2][2] = "0.75";
        this.dbIngred[3][2] = "0.75";
        this.dbIngred[4][2] = "0.75";
        this.dbIngred[5][2] = "0.75";
        this.dbIngred[6][2] = "1.5";
        this.dbIngred[7][2] = "2";
        this.dbIngred[8][2] = "0.8";
    }
     public void InsertarPupaEsp(String codOrden) {
        /*
            1-Insertar en pupusa especial (Harina solo)
            2-Insertar detalle de pupa esp (cod esp(hacer un select al último cod ingresado), cod de la tabla ingre)
            3-Insertar en detalle de orden la ultima pupa esp ingresada
        */
        if (archivoEsp.exists()) {
            String fila = "";
            String ingrediente="";
            FileReader in = null;
            try {
                in = new FileReader("esp.txt");
                BufferedReader br = new BufferedReader(in);
                boolean encontrado = false;
                while ((fila = br.readLine()) != null && fila != "\n") //el while leera todo el documento
                {
                    String[] palabra = fila.split(","); // dividir en palabras delimitadas por espacios
                    //aca abajo se rellena la matriz de usuarios
                    InsertarEncaEsp(palabra[palabra.length-2]);
                    int j=1;
                    while(j < (palabra.length-2)){
                        int k = 0;
                        while(k < 9 && !encontrado){
                            if(this.dbIngred[k][1].equals(palabra[j])){
                                ingrediente = this.dbIngred[k][0];
                                encontrado=true;
                            }
                            k++;
                        }
                        encontrado = false;
                        InsertarDetaEsp(UltimaPupaEsp(), ingrediente);
                        j++;
                    }
                    ///Agregar aqui la pupusa al detalle de la orden
                    InsertarOrdenDetaEsp(UltimaPupaEsp(), codOrden, palabra[palabra.length-1]);
                    encontrado = false;
                }
                this.cont = 0;
                in.close();
                br.close();
                while (this.cont < 5) {
                    if (!this.dbAcom[this.cont][2].equals("0")) {
                        InsertarDetaAcom(this.dbAcom[this.cont][0], codOrden, this.dbAcom[this.cont][2]);
                    }
                    this.cont++;
                }
                this.cont = 0;
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error("Excepcion " + ex.getMessage());
            }
        }
    }
    
    public String InsertarEncaEsp(String harina) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(this.InsertarPupaEsp);
            if(harina.equals("Arroz")){
                harina = "2";
            }
            else{
                harina = "1";
            }
            cmst.setInt(1, Integer.parseInt(harina));
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion " + ex.getMessage());
        }
        System.out.print(resultado);
        return resultado;
    }
    //Insercion  segun la base de MySQL los datos del programa 
    public String InsertarDetaEsp(String cod_esp, String cod_Ingre) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(this.InsertarDetPupaEsp);
            cmst.setInt(1, Integer.parseInt(cod_esp));
            cmst.setInt(2, Integer.parseInt(cod_Ingre));
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion " + ex.getMessage());
        }
        System.out.print(resultado);
        return resultado;
    }
    public String UltimaPupaEsp(){
        String resultado = "";
        try {
            Connection cnn;
            cnn = conexion.Conectar();
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery("select max(Cod_Especial) from pupusa_especial;");
            rs.next();
            resultado = rs.getString(1);
            cnn.close();
        } catch (SQLException ex) {
            log.error("Excepcion SQL " + ex.getMessage());
        }
        return resultado;
    }
    //Insercion  segun la base de MySQL los datos del programa 
    public String InsertarOrdenDetaEsp(String cod_esp, String cod_Orden, String cantidad) {
        String resultado;
        try {
            cnn = conexion.Conectar();
            CallableStatement cmst = cnn.prepareCall(this.InsertarOrdenDetEsp);
            cmst.setInt(1, Integer.parseInt(cod_esp));
            cmst.setInt(2, Integer.parseInt(cod_Orden));
            cmst.setInt(3, Integer.parseInt(cantidad));
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
            log.error("No se realizo operacion " + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
            log.error("No se realizo operacion " + ex.getMessage());
        }
        System.out.print(resultado);
        return resultado;
    }
}
