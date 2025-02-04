package Java;

import java.io.*;

public class MergeSort {

    public static int[] leerDatosDelArchivo(String nombreArchivo, int cantidad) {
        int[] datos = new int[cantidad];
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null && i < cantidad) {
                datos[i] = Integer.parseInt(linea.trim());  
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;  
    }

    public static int[] merge(int[] izquierda, int[] derecha) {
        int[] resultado = new int[izquierda.length + derecha.length];
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] < derecha[j]) {
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < izquierda.length) {
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length) {
            resultado[k] = derecha[j];
            j++;
            k++;
        }

        return resultado; 
    }

    public static int[] mergeSort(int[] arr, int inicio, int fin) {
        if (fin - inicio <= 1) {
            return new int[]{arr[inicio]}; 
        }

        int mitad = (inicio + fin) / 2;
    
        int[] izquierda = mergeSort(arr, inicio, mitad);
    
        int[] derecha = mergeSort(arr, mitad, fin);
    
        return merge(izquierda, derecha);
    } 

    public static void main(String[] args) {
 
        String archivoDatos = "/home/jmhueran/Descargas/Examen_grupal/Datos/DatosCargados.txt";

        int cantidadDatosAProbar = 10000; 

        int[] numeros = leerDatosDelArchivo(archivoDatos, cantidadDatosAProbar);

        long inicioTemporizador = System.nanoTime();
        int[] listaOrdenada = mergeSort(numeros, 0 ,cantidadDatosAProbar);
        long finTemporizador = System.nanoTime();

        double tiempoTotalSegundos = (finTemporizador - inicioTemporizador) / 1_000_000_000.0;

        System.out.printf("Tiempo de ejecución para %d datos: %.3f segundos%n", cantidadDatosAProbar, tiempoTotalSegundos);

        if (cantidadDatosAProbar <= 50) {
            System.out.print("Lista ordenada: ");
            for (int num : listaOrdenada) {
                System.out.print( num + " | " );
            }
            System.out.println();
        }
    }
}