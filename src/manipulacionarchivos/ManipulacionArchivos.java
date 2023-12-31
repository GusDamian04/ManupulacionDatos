/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipulacionarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Dell
 */
public class ManipulacionArchivos {
    
    public static int countFileLines(String name){
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        int numLineas = 0;
        try{
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            // Contar las lineas que contiene el archivo 👍
            while( (bufer.readLine())!= null ){
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
            t = countFileLines(name);
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
    
    public static int[] fileToIntArray(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recupera info. del archivo
        String linea;
        int[] array = null;
        int t;
        int i =0;
        
        try{
            t = countFileLines(name);
            array = new int[t];
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            while( (linea = bufer.readLine())!= null ){
                array[i] = Integer.parseInt(linea);
                i++;
            }
            reader.close();
        } catch(Exception e ){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }
    
        public static double[] fileToDoubleArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        double[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLines(name);
            array = new double[t];

            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = Double.parseDouble(linea);
                i++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }

    public static boolean[] fileToBooleanArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        boolean[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLines(name);
            array = new boolean[t];

            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = Boolean.parseBoolean(linea);
                i++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }
    
    public static void writeKeyboardtoFile(String name) throws IOException{
        // Un apuntador a un fisico del dd
        FileWriter archivo;
        // La llave de acceso para escribir el archivo
        PrintWriter writer;
        // Para escribir de teclado al dd
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        
        try{
            //apuntador al archivo que se va a crear
            archivo = new FileWriter("C:\\archivos\\" + name +".txt");
            writer = new PrintWriter(archivo);
            do {
                System.out.println("Escribe algo para guardar en el archivo: ");
                entrada = bufer.readLine();
                //Guardar lo recuperado desde telcado al archivo
                writer.println(entrada);
                System.out.println("Escribe x para parar, cualquier otra tecla para continuar: ");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            }while(respuesta != 'x');
            archivo.close();
        } catch( Exception e ){
            System.out.println("Error al escribir al archivo "+ e.toString());
        }
    }
    
    // Crear un archivo con informacion de un arreglo :)
    public static void writeArraytoFile(String name, int[] array){
        FileWriter archivo;
        PrintWriter writer;
        
        try{
            archivo = new FileWriter("C:\\archivos\\" + name +".txt");
            writer = new PrintWriter(archivo);
            // Guaardar el arreglo a un archivo 
            for(int unDato: array){
                writer.println(unDato);
            }
            archivo.close();
        } catch( Exception e ){
            System.out.println("Error al escribir al archivo "+ e.toString());
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] textos;
        int[] numeros;
        double[] doubles;
        boolean[] booleans;
        int[] numerosX3;
        
        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        textos = fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de textos: ");
        for(String unTexto : textos){
            System.out.println(unTexto);
        }
        System.out.println("Lectura de datos numericos 👍");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        numeros = fileToIntArray(fileName);
        System.out.println("Contenido del atteglo de numeros:");
        for(int unNumero : numeros){
            System.out.println(unNumero);
        }
        System.out.println("Lectura de datos doubles");
        System.out.println("Escribe el nombre del archivo");
        fileName = bufer.readLine();
        doubles = fileToDoubleArray(fileName);
        System.out.println("Contenido del arreglo doubles");
        for (double unDouble : doubles) {
            System.out.println(unDouble);
        }

        System.out.println("Lectura de datos booleans");
        System.out.println("Escribe el nombre del archivo");
        fileName = bufer.readLine();
        booleans = fileToBooleanArray(fileName);
        System.out.println("Contenido del arreglo de valores booleans");
        for (boolean unBoolean : booleans) {
            System.out.println(unBoolean);
        }
        
        // Crear y lenar el arreglo numerosX3
        System.out.println("Numeros Por 3");
        numerosX3 = new int[numeros.length];
        for (int i = 0;i < numeros.length;i++){
            numerosX3[i] = numeros[i] * 3;
            System.out.println("Numeros3["+ i +"] = "+ numerosX3[i]);
        }
        System.out.println("Escribe el nombre del archivo de numeros X3");
        fileName = bufer.readLine();
        writeArraytoFile(fileName, numerosX3);
        /*
        System.out.println("Crear un archivo de texto");
        System.out.println("Escribe el nombre del archivo a crear: ");
        fileName = bufer.readLine();
        writeKeyboardtoFile(fileName);*/
    }

}