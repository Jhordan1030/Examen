package Java.src;
import java.io.*;
import java.util.*;

public class ShellSortRecursivo {
    public static void main(String[] args) {
        String rutaArchivo = "/home/jmhueran/Descargas/Examen_grupal/Datos/DatosCargados.txt";
        List<Integer> listaNumeros = leerDatosDesdeArchivo(rutaArchivo);

        if (listaNumeros == null) {
            System.out.println("Error al leer el archivo.");
            return;
        }

        int limiteDatos = Math.min(10000, listaNumeros.size());
        Integer[] datosAOrdenar = listaNumeros.subList(0, limiteDatos).toArray(new Integer[0]);
        
        long inicioTiempo = System.nanoTime();
        ordenarPorShellRecursivo(datosAOrdenar, datosAOrdenar.length / 2);
        long finTiempo = System.nanoTime();
        
        double tiempoTotalSegundos = (finTiempo - inicioTiempo) / 1e9;
        System.out.printf("Tiempo de ejecución para %d datos: %.6f segundos%n", limiteDatos, tiempoTotalSegundos);
        
        if (limiteDatos <= 50) {
            System.out.println("Lista ordenada: " + Arrays.toString(datosAOrdenar));
        }
    }

    public static void ordenarPorShellRecursivo(Integer[] array, int intervalo) {
        if (intervalo == 0) {
            return;
        }

        for (int i = intervalo; i < array.length; i++) {
            int valorActual = array[i];
            int j = i;
            while (j >= intervalo && array[j - intervalo] > valorActual) {
                array[j] = array[j - intervalo];
                j -= intervalo;
            }
            array[j] = valorActual;
        }

        ordenarPorShellRecursivo(array, intervalo / 2);
    }

    public static List<Integer> leerDatosDesdeArchivo(String rutaArchivo) {
        List<Integer> listaNumeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                listaNumeros.add(Integer.parseInt(linea.trim()));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        return listaNumeros;
    }
}
