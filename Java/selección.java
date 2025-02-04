package Java;

import java.io.*;
import java.util.*;

public class selección {

    public static List<Integer> leerDatosDelArchivo(String nombreArchivo, int cantidad) {
        List<Integer> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null && datos.size() < cantidad) {
                datos.add(Integer.parseInt(linea.trim()));  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos; 
    }

    public static List<Integer> ordenarPorSeleccion(List<Integer> lista) {
        int cantidadDatos = lista.size();
        
        // Algoritmo de ordenamiento por selección
        for (int indiceInicio = 0; indiceInicio < cantidadDatos - 1; indiceInicio++) {
            int indiceMinimo = indiceInicio;
            
            // Buscar el índice del valor mínimo en el resto de la lista
            for (int indiceComparar = indiceInicio + 1; indiceComparar < cantidadDatos; indiceComparar++) {
                if (lista.get(indiceComparar) < lista.get(indiceMinimo)) {
                    indiceMinimo = indiceComparar;
                }
            }
            
            // Intercambiar el valor en indiceInicio con el valor mínimo encontrado
            if (indiceMinimo != indiceInicio) {
                // Intercambiar los elementos en la lista
                Integer temp = lista.get(indiceInicio);
                lista.set(indiceInicio, lista.get(indiceMinimo));
                lista.set(indiceMinimo, temp);
            }
        }
        
        return lista;  // Retornar la lista ordenada
    }
    
    public static void main(String[] args) {
        String archivoDatos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\DatosCargados.txt";

        int cantidadDatosAProbar = 10000;  

        List<Integer> numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);

        long inicioTemporal = System.nanoTime();
        List<Integer> listaOrdenada = ordenarPorSeleccion(numeros); 
        long finTemporal = System.nanoTime();

        double tiempoTotalSegundos = (finTemporal - inicioTemporal) / 1_000_000_000.0;

        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);

        if (cantidadDatosAProbar <= 50) {
            System.out.println("Lista ordenada: " + listaOrdenada);
        }
    }
}
