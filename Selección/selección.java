package Selección;

import java.io.*;
import java.util.*;

public class selección {
    
    // Función para leer una cantidad específica de datos desde el archivo
    public static List<Integer> leerDatosDelArchivo(String nombreArchivo, int cantidad) {
        List<Integer> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null && datos.size() < cantidad) {
                datos.add(Integer.parseInt(linea.trim()));  // Convertimos cada línea en número entero
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;  // Retornamos los datos leídos
    }
    
    // Algoritmo de Ordenamiento por Selección (modificado)
    public static List<Integer> ordenarPorSeleccion(List<Integer> listaDatos) {
        int cantidadDatos = listaDatos.size();
        
        for (int indiceInicio = 0; indiceInicio < cantidadDatos - 1; indiceInicio++) {
            int indiceMinimo = indiceInicio;
            
            for (int indiceComparar = indiceInicio + 1; indiceComparar < cantidadDatos; indiceComparar++) {
                if (listaDatos.get(indiceComparar) < listaDatos.get(indiceMinimo)) {
                    indiceMinimo = indiceComparar;
                }
            }
            
            // Realizar el intercambio sin usar una variable temporal
            Collections.swap(listaDatos, indiceInicio, indiceMinimo);
        }
        
        return listaDatos;
    }
    
    public static void main(String[] args) {
        // Nombre del archivo con todos los datos
        String archivoDatos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt";
        
        // Definir cuántos datos queremos probar (por ejemplo, 10,000)
        int cantidadDatosAProbar = 40;  // Puedes cambiarlo a 5000, 15000, 20000, etc.
        
        // Leer los datos desde el archivo con el límite deseado
        List<Integer> numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);
        
        // Medir el tiempo de ejecución del algoritmo de ordenamiento
        long inicioTemporal = System.nanoTime();
        List<Integer> listaOrdenada = ordenarPorSeleccion(numeros);  // Ordenar los datos
        long finTemporal = System.nanoTime();
        
        // Calcular el tiempo total
        double tiempoTotalSegundos = (finTemporal - inicioTemporal) / 1_000_000_000.0;
        
        // Imprimir el tiempo de ejecución
        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);
        
        // Si hay pocos datos, imprimir la lista ordenada
        if (cantidadDatosAProbar <= 50) {
            System.out.println("Lista ordenada: " + listaOrdenada);
        }
    }
}
