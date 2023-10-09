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
    
    public static int contarLineasArchivo(String name){
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        int numLineas = 0;
        try{
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            // Contar las lineas que contiene el archivo 👍
            while( (linea = bufer.readLine())!= null ){
                numLineas++;
            }
            reader.close();
        } catch(Exception e ){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLineas;
    }

    public static String[] fileToStringArray(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recupera info. del archivo
        String linea;
        String[] array = null;
        int t;
        int i =0;
        
        try{
            // Obtenemos el tamaño del archivo para contruit arreglos
            t = contarLineasArchivo(name);
            // Con el tramaño del archivo, contruimos el arreglo
            array = new String[t];
            // Crear un apuntador al archivo físico
            archivo = new File("C:\\archivos\\" + name + ".txt");
            // Abrir el archivo para Lectura
            reader = new FileReader(archivo);
            // Configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            // Lectura del contenido del archivo
            while( (linea = bufer.readLine())!= null ){
                //System.out.println("Linea lida: "+linea);
                array[i] = linea;
                i++;
            }
            reader.close();
        } catch(Exception e ){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int t;
        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        fileToStringArray(fileName);
        t = contarLineasArchivo(fileName);
        System.out.println("Lineas en el archivo "+ fileName +": "+ t);
        
        
    }

}
