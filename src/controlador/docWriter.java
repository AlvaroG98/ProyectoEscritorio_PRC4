package controlador;

import java.io.*;
import java.util.*;
import java.util.Scanner;
public class docWriter {
    private Scanner scn = new Scanner(System.in);
    
    public void escribir(String contenido) {
        //se crea el archivo txt dentro del directorio y se valida si existe
        try {
            File file = new File("tmp.txt");
            if(file.exists())
            {
                file.delete();
                file = new File("tmp.txt");
            }
            file.createNewFile();
            //se creal el archivo y se escribe dentro de el lo que contiene 
            //variable contenido
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String Leer()
    {
        String resultado = "";
        FileReader in = null;
        try {
            in = new FileReader("tmp.txt");
            BufferedReader br = new BufferedReader(in);

            resultado = br.readLine();
            
            in.close();
        } catch (IOException e) {
            e.getCause();
        }
        return resultado;
    }
    public String LeerContra()
    {
        String resultado = "";
        FileReader in = null;
        try {
            in = new FileReader("tmp.txt");
            BufferedReader br = new BufferedReader(in);

            br.readLine();
            resultado = br.readLine();
            
            in.close();
        } catch (IOException e) {
            e.getCause();
        }
        return resultado;
    }
}
