import time

def leer_datos_del_archivo(nombre_archivo, cantidad):
    with open(nombre_archivo, "r") as archivo:
        datos = [int(linea.strip()) for linea in archivo] 
    return datos[:cantidad] 

def merge(lista_izquierda, lista_derecha):
    resultado = []
    i = 0
    j = 0
    while i < len(lista_izquierda) and j < len(lista_derecha):
        if lista_izquierda[i] < lista_derecha[j]:
            resultado.append(lista_izquierda[i])
            i += 1
        else:
            resultado.append(lista_derecha[j])
            j += 1
    
    resultado.extend(lista_izquierda[i:])
    resultado.extend(lista_derecha[j:])
    
    return resultado

# Algoritmo de MergeSort
def merge_sort(lista_datos):
    if len(lista_datos) <= 1:
        return lista_datos

    mitad = len(lista_datos) // 2
    izquierda = merge_sort(lista_datos[:mitad]) 
    derecha = merge_sort(lista_datos[mitad:])  

    return merge(izquierda, derecha)

archivo_datos = "C:\\Users\\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt"

cantidad_datos_a_probar = 40  

numeros = leer_datos_del_archivo(archivo_datos, cantidad_datos_a_probar)

inicio_temporal = time.perf_counter()
lista_ordenada = merge_sort(numeros) 
fin_temporal = time.perf_counter()

tiempo_total_segundos = fin_temporal - inicio_temporal

print(f"Tiempo de ejecución para {cantidad_datos_a_probar} datos: {tiempo_total_segundos:.3f} segundos")

if cantidad_datos_a_probar <= 50:
    print("Lista ordenada:", lista_ordenada)
