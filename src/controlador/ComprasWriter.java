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

    private File archivoCompras = null;
    private final String ARCHIVO_COMPRA = "compras.txt";

    public ComprasWriter() {
        if (archivoCompras == null) {
            archivoCompras = new File(ARCHIVO_COMPRA);
            try {
                archivoCompras.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Escribir(String valores) {
        if (archivoCompras.exists()) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(archivoCompras.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(valores);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<String> Leer() {
        List<String> listCompras = null;
        if (archivoCompras.exists()) {
            String fila = "";
            FileReader in = null;
            try {
                in = new FileReader(ARCHIVO_COMPRA);
                BufferedReader br = new BufferedReader(in);
                listCompras = new ArrayList<String>();
                while ((fila = br.readLine()) != null) {                    
                    listCompras.add(fila);
                }
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return listCompras;
    }
}
