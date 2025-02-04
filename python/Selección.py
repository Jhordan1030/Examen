import time

def leer_datos_del_archivo(nombre_archivo, cantidad):
    with open(nombre_archivo, "r") as archivo:
        datos = [int(linea.strip()) for linea in archivo] 
    return datos[:cantidad] 

def ordenar_por_seleccion(lista_datos):
    cantidad_datos = len(lista_datos)
    
    for indice_inicio in range(cantidad_datos - 1):
        indice_minimo = indice_inicio
        
        for indice_comparar in range(indice_inicio + 1, cantidad_datos):
            if lista_datos[indice_comparar] < lista_datos[indice_minimo]:
                indice_minimo = indice_comparar
        
        lista_datos[indice_inicio], lista_datos[indice_minimo] = lista_datos[indice_minimo], lista_datos[indice_inicio]

    return lista_datos

archivo_datos = "C:\\Users\Marcelo Chiriboga\\Documentos\\Materias 5to Semestre - Software\\Análisis de Algoritmos\\Examen\\numeros_aleatorios.txt"

cantidad_datos_a_probar = 40 

numeros = leer_datos_del_archivo(archivo_datos, cantidad_datos_a_probar)

inicio_temporal = time.perf_counter()
lista_ordenada = ordenar_por_seleccion(numeros)  
fin_temporal = time.perf_counter()

tiempo_total_segundos = fin_temporal - inicio_temporal

print(f"Tiempo de ejecución para {cantidad_datos_a_probar} datos: {tiempo_total_segundos:.3f} segundos")

if cantidad_datos_a_probar <= 50:
    print("Lista ordenada:", lista_ordenada)
