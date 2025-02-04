package Java.src;

import java.io.*;
import java.util.*;

public class ExamenGrupal {
    public static void main(String[] args) {
        // Ruta del archivo (ajústala según tu sistema)
        String rutaArchivo = "/home/jmhueran/Descargas/Examen_grupal/Datos/DatosCargados.txt";

        // Leer los datos desde el archivo
        List<Integer> listaNumeros = leerDatosDesdeArchivo(rutaArchivo);

        // Convertir la lista a un array
        int limiteDatos = Math.min(1000, listaNumeros.size());
        int[] datosAOrdenar = new int[limiteDatos];
        for (int i = 0; i < limiteDatos; i++) {
            datosAOrdenar[i] = listaNumeros.get(i);
        }

        // Medir el tiempo de ejecución de QuickSort
        long inicioTiempo = System.nanoTime();
        quickSort(datosAOrdenar, 0, datosAOrdenar.length - 1);
        long finTiempo = System.nanoTime();

        // Calcular el tiempo total
        double tiempoTotalSegundos = (finTiempo - inicioTiempo) / 1e9;

        // Imprimir el tiempo de ejecución
        System.out.printf("Tiempo de ejecución para %d datos: %.6f segundos%n", limiteDatos, tiempoTotalSegundos);

        // Si hay pocos datos, imprimir la lista ordenada
        if (limiteDatos <= 50) {
            System.out.println("Lista ordenada: " + Arrays.toString(datosAOrdenar));
        }
    }

    public static List<Integer> leerDatosDesdeArchivo(String rutaArchivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    // Asegurarse de que cada línea contenga un número válido
                    numeros.add(Integer.parseInt(linea.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Se ignoró una línea no válida: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return numeros;
    }

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = particion(arr, inicio, fin);
            quickSort(arr, inicio, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin]; // El pivote es el último elemento
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivote) {
                i++;
                intercambiar(arr, i, j); // Intercambiar elementos
            }
        }
        // Intercambiar el pivote con el elemento en la posición i + 1
        intercambiar(arr, i + 1, fin);
        return i + 1; // Retornar el índice del pivote
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
