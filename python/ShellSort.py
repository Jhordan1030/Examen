import time

def ordenar_por_shell_recursivo(lista_numeros, intervalo=None):
    if intervalo is None:
        intervalo = len(lista_numeros) // 2
    if intervalo == 0:
        return lista_numeros
    for indice_actual in range(intervalo, len(lista_numeros)):
        valor_actual = lista_numeros[indice_actual]
        indice_comparacion = indice_actual
        while indice_comparacion > intervalo - 1:
            if lista_numeros[indice_comparacion - intervalo] > valor_actual:
                lista_numeros[indice_comparacion] = lista_numeros[indice_comparacion - intervalo]
                indice_comparacion -= intervalo
            else:
                break
        lista_numeros[indice_comparacion] = valor_actual
    return ordenar_por_shell_recursivo(lista_numeros, intervalo // 2)

def leer_datos_desde_archivo(ruta_archivo):
    with open(ruta_archivo, "r") as archivo:
        lista_numeros = [int(linea.strip()) for linea in archivo]
    return lista_numeros

# Ruta del archivo en Fedora (ajusta según tu usuario)
ruta_archivo = "/home/jmhueran/Descargas/Examen grupal/Datos/DatosCargados.txt"

lista_numeros = leer_datos_desde_archivo(ruta_archivo)
limite_datos = min(10000, len(lista_numeros))
datos_a_ordenar = lista_numeros[:limite_datos]

inicio_tiempo = time.perf_counter()
lista_ordenada = ordenar_por_shell_recursivo(datos_a_ordenar)
fin_tiempo = time.perf_counter()

tiempo_total_segundos = fin_tiempo - inicio_tiempo
print(f"Tiempo de ejecución para {limite_datos} datos: {tiempo_total_segundos:.6f} segundos")

if limite_datos <= 50:
    print("Lista ordenada:", lista_ordenada)
