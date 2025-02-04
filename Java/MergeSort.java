package Java;

import java.io.*;
import java.util.*;

public class MergeSort {

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

    public static List<Integer> merge(List<Integer> listaIzquierda, List<Integer> listaDerecha) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < listaIzquierda.size() && j < listaDerecha.size()) {
            if (listaIzquierda.get(i) < listaDerecha.get(j)) {
                resultado.add(listaIzquierda.get(i));
                i++;
            } else {
                resultado.add(listaDerecha.get(j));
                j++;
            }
        }

        // Si queda algún elemento en la lista izquierda o derecha, agregarlo
        resultado.addAll(listaIzquierda.subList(i, listaIzquierda.size()));
        resultado.addAll(listaDerecha.subList(j, listaDerecha.size()));

        return resultado;
    }

    // Algoritmo de MergeSort
    public static List<Integer> mergeSort(List<Integer> listaDatos) {
        if (listaDatos.size() <= 1) {
            return listaDatos;
        }

        int mitad = listaDatos.size() / 2;
        List<Integer> izquierda = mergeSort(listaDatos.subList(0, mitad)); 
        List<Integer> derecha = mergeSort(listaDatos.subList(mitad, listaDatos.size())); 

        return merge(izquierda, derecha);
    }

    public static void main(String[] args) {

        String archivoDatos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt";

        int cantidadDatosAProbar = 40;  

        List<Integer> numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);

        long inicioTemporal = System.nanoTime();
        List<Integer> listaOrdenada = mergeSort(numeros); 
        long finTemporal = System.nanoTime();

        double tiempoTotalSegundos = (finTemporal - inicioTemporal) / 1_000_000_000.0;

        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);

        if (cantidadDatosAProbar <= 50) {
            System.out.println("Lista ordenada: " + listaOrdenada);
        }
    }
}
