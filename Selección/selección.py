import time

# Función para leer una cantidad específica de datos desde el archivo
def leer_datos_del_archivo(nombre_archivo, cantidad):
    with open(nombre_archivo, "r") as archivo:
        datos = [int(linea.strip()) for linea in archivo]  # Convertimos cada línea en número entero
    return datos[:cantidad]  # Retornamos solo la cantidad deseada

# Algoritmo de Ordenamiento por Selección (modificado)
def ordenar_por_seleccion(lista_datos):
    cantidad_datos = len(lista_datos)
    
    for indice_inicio in range(cantidad_datos - 1):
        indice_minimo = indice_inicio
        
        for indice_comparar in range(indice_inicio + 1, cantidad_datos):
            if lista_datos[indice_comparar] < lista_datos[indice_minimo]:
                indice_minimo = indice_comparar
        
        # Realizar el intercambio sin usar una variable temporal
        lista_datos[indice_inicio], lista_datos[indice_minimo] = lista_datos[indice_minimo], lista_datos[indice_inicio]

    return lista_datos

# Nombre del archivo con todos los datos
archivo_datos = "C:\\Users\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt"

# Definir cuántos datos queremos probar (por ejemplo, 10,000)
cantidad_datos_a_probar = 40  # Puedes cambiarlo a 5000, 15000, 20000, etc.

# Leer los datos desde el archivo con el límite deseado
numeros = leer_datos_del_archivo(archivo_datos, cantidad_datos_a_probar)

# Medir el tiempo de ejecución del algoritmo de ordenamiento
inicio_temporal = time.perf_counter()
lista_ordenada = ordenar_por_seleccion(numeros)  # Ordenar los datos
fin_temporal = time.perf_counter()

# Calcular el tiempo total
tiempo_total_segundos = fin_temporal - inicio_temporal

# Imprimir el tiempo de ejecución
print(f"Tiempo de ejecución para {cantidad_datos_a_probar} datos: {tiempo_total_segundos:.3f} segundos")

# Si hay pocos datos, imprimir la lista ordenada
if cantidad_datos_a_probar <= 50:
    print("Lista ordenada:", lista_ordenada)
