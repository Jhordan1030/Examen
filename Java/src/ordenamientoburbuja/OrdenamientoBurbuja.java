/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Java.src.ordenamientoburbuja;
import java.io.*;
import java.util.*;

/**
 *
 * @author Giuliana Espinoza
 */
public class OrdenamientoBurbuja {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Giuliana Espinoza\\Documents\\Análisis de algoritmos\\DatosCargados.txt";
        
        int[] listaNumeros = leerDatosDesdeArchivo(rutaArchivo);
        if (listaNumeros == null) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        int limiteDatos = Math.min(2000, listaNumeros.length);
        int[] datosAOrdenar = Arrays.copyOfRange(listaNumeros, 0, limiteDatos); // Tomar solo una parte de los datos

        long inicioTiempo = System.nanoTime();
        int[] listaOrdenada = ordenarPorBurbuja(datosAOrdenar);
        long finTiempo = System.nanoTime();

        double tiempoSegundos = (finTiempo - inicioTiempo) / 1e9;
        System.out.println("Tiempo de ejecución para " + limiteDatos + " datos: " + tiempoSegundos + " segundos");

        if (limiteDatos <= 50) {
            System.out.println("Lista ordenada: " + Arrays.toString(listaOrdenada));
        }
    }

    public static int[] leerDatosDesdeArchivo(String nombreArchivo) {
        List<Integer> listaTemporal = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextInt()) {
                listaTemporal.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + nombreArchivo);
            return null;
        }

        int[] listaNumeros = new int[listaTemporal.size()];
        for (int i = 0; i < listaTemporal.size(); i++) {
            listaNumeros[i] = listaTemporal.get(i);
        }
        return listaNumeros;
    }

    public static int[] ordenarPorBurbuja(int[] listaNumeros) {
        int n = listaNumeros.length;
        for (int i = 0; i < n - 1; i++) {
            // Bandera para mejorar la eficiencia: si no se hicieron intercambios, ya está ordenado
            boolean intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (listaNumeros[j] > listaNumeros[j + 1]) {
                    // Intercambiar los elementos
                    int temp = listaNumeros[j];
                    listaNumeros[j] = listaNumeros[j + 1];
                    listaNumeros[j + 1] = temp;
                    intercambio = true;
                }
            }
            // Si no hubo intercambio, la lista ya está ordenada
            if (!intercambio) {
                break;
            }
        }
        return listaNumeros;
    }
}
