import time
def ordenar_por_shell_recursivo(lista_numeros, intervalo=None):
    # Inicializar el intervalo en la primera llamada
    if intervalo is None:
        intervalo = len(lista_numeros) // 2

    # Caso base: cuando el intervalo es 0, la lista ya está ordenada
    if intervalo == 0:
        return lista_numeros

    # Aplicamos Inserción con el intervalo actual usando while estructurado como for
    for indice_actual in range(intervalo, len(lista_numeros)):
        valor_actual = lista_numeros[indice_actual]
        indice_comparacion = indice_actual

        # Usamos un while con una sola condición, moviendo la otra dentro
        while indice_comparacion > intervalo - 1:  # Similar a range(indice_actual, intervalo - 1, -intervalo)
            if lista_numeros[indice_comparacion - intervalo] > valor_actual:
                lista_numeros[indice_comparacion] = lista_numeros[indice_comparacion - intervalo]
                indice_comparacion -= intervalo  # Decremento manual
            else:
                break  # Romper el bucle si la condición ya no se cumple

        lista_numeros[indice_comparacion] = valor_actual  # Insertar el valor en su posición correcta

    # Llamada recursiva con un intervalo más pequeño
    return ordenar_por_shell_recursivo(lista_numeros, intervalo // 2)

# Función para leer datos desde un archivo y convertirlos en una lista de enteros
def leer_datos_desde_archivo(ruta_archivo):
    with open(ruta_archivo, "r") as archivo:
        lista_numeros = [int(linea.strip()) for linea in archivo]  # Convertimos cada línea en número entero
    return lista_numeros

# Ruta del archivo en Fedora (ajusta según tu usuario)
ruta_archivo = "C:\\Users\\jhord\\Downloads\\Examen grupal\\Datos\\DatosCargados.txt"

# Leer los datos desde el archivo
lista_numeros = leer_datos_desde_archivo(ruta_archivo)

# Definir cuántos datos queremos probar (Ejemplo: 10,000)
limite_datos = min(50, len(lista_numeros))  # Ajusta el tamaño si hay menos datos
datos_a_ordenar = lista_numeros[:limite_datos]  # Tomar solo una parte de los datos

# Medir el tiempo de ejecución del algoritmo de ordenamiento ShellSort
inicio_tiempo = time.perf_counter()
lista_ordenada = ordenar_por_shell_recursivo(datos_a_ordenar)
fin_tiempo = time.perf_counter()

# Calcular el tiempo total
tiempo_total_segundos = fin_tiempo - inicio_tiempo

# Imprimir el tiempo de ejecución
print(f"Tiempo de ejecución para {limite_datos} datos: {tiempo_total_segundos:.6f} segundos")

# Si hay pocos datos, imprimir la lista ordenada
if limite_datos <= 50:
    print("Lista ordenada:", lista_ordenada)

