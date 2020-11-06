package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComprasWriter {
    //creacion de archivos que tomaran los productos
    private File archivoAcom = null;
    private final String ARCHIVO_COMPRA = "acom.txt";
    private File archivoPupa = new File("pupas.txt");
    private File archivoEsp = new File("esp.txt");
    //funcion que permite escribir compras
    public ComprasWriter() {
        if (archivoAcom == null) {
            archivoAcom = new File(ARCHIVO_COMPRA);
            try {
                archivoAcom.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //escritura de compras de acompañamientos
    public void EscribirAcom(String valores) {
        if (archivoAcom.exists()) {
            archivoAcom.delete();
            archivoAcom = new File("acom.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(archivoAcom.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(valores);
                bw.newLine();
                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
        }
    }
    //escritura de compras de pupusas
    public void EscribirPupa(String valores) {
        if (!archivoPupa.exists()) {
            archivoPupa = new File("pupas.txt");
            try {
                archivoPupa.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (archivoPupa.exists()) {
            archivoPupa = new File("pupas.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(archivoPupa.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(valores);
                bw.newLine();
                bw.close();
                fw.close();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
        }
    }
    //escritura de compras de pupusas especiales
    public void EscribirEsp(String valores) {
        if (!archivoEsp.exists()) {
            archivoEsp = new File("esp.txt");
            try {
                archivoEsp.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (archivoEsp.exists()) {
            archivoEsp = new File("esp.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(archivoEsp.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(valores);
                bw.newLine();
                bw.close();
                fw.close();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
        }
    }

    public List<String> Leer() {
        List<String> listCompras = null;
        if (archivoAcom.exists()) {
            String fila = "";
            FileReader in = null;
            try {
                in = new FileReader(ARCHIVO_COMPRA);
                BufferedReader br = new BufferedReader(in);
                listCompras = new ArrayList<String>();
                while ((fila = br.readLine()) != null && fila != "\n") {
                    listCompras.add(fila);
                }
                
                in.close();
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return listCompras;
    }
    //elimincacion de archivo que se quiera eliminar en cierta parte del proceso
    public void EliminarArchivos() {
        try {
            File fichero = new File("acom.txt");
            File fichero2 = new File("pupas.txt");
            File fichero3 = new File("esp.txt");
            if (fichero.delete()) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero no puede ser borrado");
            }
            if (fichero2.delete()) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero no puede ser borrado");
            }
            if (fichero3.delete()) {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero no puede ser borrado");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
