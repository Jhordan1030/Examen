import time

# Implementación de QuickSort Recursivo
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]  # Se elige el pivote
    left = [x for x in arr if x < pivot]  # Elementos menores
    middle = [x for x in arr if x == pivot]  # Elementos iguales
    right = [x for x in arr if x > pivot]  # Elementos mayores
    return quick_sort(left) + middle + quick_sort(right)

# Función para leer datos desde un archivo y convertirlos en una lista de enteros
def leer_datos_desde_archivo(ruta_archivo):
    with open(ruta_archivo, "r") as archivo:
        lista_numeros = [int(linea.strip()) for linea in archivo]  # Convertimos cada línea en número entero
    return lista_numeros

# Ruta del archivo en Fedora (ajusta según tu usuario)
ruta_archivo = "/home/jmhueran/Descargas/Examen grupal/Datos/DatosCargados.txt"

# Leer los datos desde el archivo
lista_numeros = leer_datos_desde_archivo(ruta_archivo)

# Definir cuántos datos queremos probar (Ejemplo: 10,000)
limite_datos = min(10000, len(lista_numeros))  # Ajusta el tamaño si hay menos datos
datos_a_ordenar = lista_numeros[:limite_datos]  # Tomar solo una parte de los datos

# Medir el tiempo de ejecución del algoritmo de ordenamiento QuickSort
inicio_tiempo = time.perf_counter()
lista_ordenada = quick_sort(datos_a_ordenar)
fin_tiempo = time.perf_counter()

# Calcular el tiempo total
tiempo_total_segundos = fin_tiempo - inicio_tiempo

# Imprimir el tiempo de ejecución
print(f"Tiempo de ejecución para {limite_datos} datos: {tiempo_total_segundos:.6f} segundos")

# Si hay pocos datos, imprimir la lista ordenada
if limite_datos <= 50:
    print("Lista ordenada:", lista_ordenada)
