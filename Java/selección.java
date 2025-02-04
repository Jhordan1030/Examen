package Java;

import java.io.*;
import java.util.*;

public class selección {

    public static int[] leerDatosDelArchivo(String nombreArchivo, int cantidad) {
        int[] datos = new int[cantidad];  // Usamos un array en lugar de una lista
        int indice = 0;
    
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null && indice < cantidad) {
                datos[indice] = Integer.parseInt(linea.trim());
                indice++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public static int[] ordenarPorSeleccion(int[] datos) {
        int cantidadDatos = datos.length;
        
        // Algoritmo de ordenamiento por selección
        for (int indiceInicio = 0; indiceInicio < cantidadDatos - 1; indiceInicio++) {
            int indiceMinimo = indiceInicio;
            
            // Buscar el índice del valor mínimo en el resto del array
            for (int indiceComparar = indiceInicio + 1; indiceComparar < cantidadDatos; indiceComparar++) {
                if (datos[indiceComparar] < datos[indiceMinimo]) {
                    indiceMinimo = indiceComparar;
                }
            }
            
            // Intercambiar el valor en indiceInicio con el valor mínimo encontrado
            if (indiceMinimo != indiceInicio) {
                int temp = datos[indiceInicio];
                datos[indiceInicio] = datos[indiceMinimo];
                datos[indiceMinimo] = temp;
            }
        }
        
        return datos;  // Retornar el array ordenado
    }
    
    public static void main(String[] args) {
        String archivoDatos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\DatosCargados.txt";
    
        int cantidadDatosAProbar = 10;  
    
        int[] numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);
    
        long inicioTemporal = System.nanoTime();
        int[] arrayOrdenado = ordenarPorSeleccion(numeros); 
        long finTemporal = System.nanoTime();
    
        double tiempoTotalSegundos = (finTemporal - inicioTemporal) / 1_000_000_000.0;
    
        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);
    
        if (cantidadDatosAProbar <= 50) {
            // Imprimir los datos ordenados
            for (int i = 0; i < arrayOrdenado.length; i++) {
                System.out.print(arrayOrdenado[i] + " | ");
            }
            System.out.println();
        }
    }    
}
