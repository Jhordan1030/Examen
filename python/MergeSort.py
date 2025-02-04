import time

def leer_datos_del_archivo(nombre_archivo, cantidad):
    with open(nombre_archivo, "r") as archivo:
        datos = [int(linea.strip()) for linea in archivo] 
    return datos[:cantidad]

def merge(lista_izquierda, lista_derecha):
    i = 0
    j = 0
    k = 0
    resultado = [0] * (len(lista_izquierda) + len(lista_derecha)) 

    while i < len(lista_izquierda) and j < len(lista_derecha):
        if lista_izquierda[i] < lista_derecha[j]:
            resultado[k] = lista_izquierda[i]
            i += 1
        else:
            resultado[k] = lista_derecha[j]
            j += 1
        k += 1
    
    while i < len(lista_izquierda):
        resultado[k] = lista_izquierda[i]
        i += 1
        k += 1

    while j < len(lista_derecha):
        resultado[k] = lista_derecha[j]
        j += 1
        k += 1
    
    return resultado

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    
    mitad = len(arr) // 2
    izquierda = merge_sort(arr[:mitad]) 
    derecha = merge_sort(arr[mitad:])   

    return merge(izquierda, derecha)


archivo_datos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\DatosCargados.txt"

cantidad_datos_a_probar = 10000  

numeros = leer_datos_del_archivo(archivo_datos, cantidad_datos_a_probar)

inicio_temporal = time.perf_counter()
lista_ordenada = merge_sort(numeros) 
fin_temporal = time.perf_counter()

tiempo_total_segundos = fin_temporal - inicio_temporal

print(f"Tiempo de ejecución para {cantidad_datos_a_probar} datos: {tiempo_total_segundos:.3f} segundos")

if cantidad_datos_a_probar <= 50:
    print("Lista ordenada:", lista_ordenada)
