package Java.src.ordenamientoinsercion;

import java.io.*;
import java.util.*;

public class Inserción {

    public static void main(String[] args) {
        // Ruta correcta para Visual Studio Code, con ruta relativa
        String rutaArchivo = "DatosCargados.txt";  // Ajusta la ruta según la ubicación del archivo
        
        int[] listaNumeros = leerDatosDesdeArchivo(rutaArchivo);
        if (listaNumeros == null) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        int limiteDatos = Math.min(10000, listaNumeros.length);
        int[] datosAOrdenar = Arrays.copyOfRange(listaNumeros, 0, limiteDatos); // Tomar solo una parte de los datos

        long inicioTiempo = System.nanoTime();
        int[] listaOrdenada = ordenarPorInsercion(datosAOrdenar);
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

    public static int[] ordenarPorInsercion(int[] listaNumeros) {
        for (int i = 1; i < listaNumeros.length; i++) {
            int valorActual = listaNumeros[i];
            int indiceComparacion = i - 1;

            // Mover los elementos mayores que el valorActual una posición a la derecha
            while (indiceComparacion >= 0 && listaNumeros[indiceComparacion] > valorActual) {
                listaNumeros[indiceComparacion + 1] = listaNumeros[indiceComparacion];
                indiceComparacion--;
            }

            // Colocar el valorActual en la posición correcta
            listaNumeros[indiceComparacion + 1] = valorActual;
        }
        return listaNumeros;
    }
}
