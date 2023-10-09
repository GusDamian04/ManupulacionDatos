/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipulacionarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dell
 */
public class ManipulacionArchivos {

    public static void leerArchivo(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recupera info. del archivo
        String linea;
        
        try{
            // Crear un apuntador al archivo físico
            archivo = new File("C:\\archivos\\" + name + ".txt");
            // Abrir el archivo para Lectura
            reader = new FileReader(archivo);
            // Configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            // Lectura del contenido del archivo
            while( (linea = bufer.readLine())!= null ){
                System.out.println("Linea lida: "+linea);
            }
            reader.close();
        } catch(Exception e ){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        leerArchivo(fileName);
    }

}
