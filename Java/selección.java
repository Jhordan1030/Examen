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

    public static List<Integer> ordenarPorSeleccion(List<Integer> listaDatos) {
        int cantidadDatos = listaDatos.size();
        
        for (int indiceInicio = 0; indiceInicio < cantidadDatos - 1; indiceInicio++) {
            int indiceMinimo = indiceInicio;
            
            for (int indiceComparar = indiceInicio + 1; indiceComparar < cantidadDatos; indiceComparar++) {
                if (listaDatos.get(indiceComparar) < listaDatos.get(indiceMinimo)) {
                    indiceMinimo = indiceComparar;
                }
            }

            Collections.swap(listaDatos, indiceInicio, indiceMinimo);
        }  
        return listaDatos;
    }
    
    public static void main(String[] args) {
        String archivoDatos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt";

        int cantidadDatosAProbar = 40;  

        List<Integer> numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);

        long inicioTemporal = System.nanoTime();
        List<Integer> listaOrdenada = ordenarPorSeleccion(numeros);  // Ordenar los datos
        long finTemporal = System.nanoTime();

        double tiempoTotalSegundos = (finTemporal - inicioTemporal) / 1_000_000_000.0;

        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);

        if (cantidadDatosAProbar <= 50) {
            System.out.println("Lista ordenada: " + listaOrdenada);
        }
    }
}
