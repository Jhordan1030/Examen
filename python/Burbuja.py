import time

def main():
    ruta_archivo = "C:\\Users\\Giuliana Espinoza\\Documents\\Análisis de algoritmos\\DatosCargados.txt"
    
    lista_numeros = leer_datos_desde_archivo(ruta_archivo)
    if lista_numeros is None:
        print("Error al leer el archivo.")
        return

    limite_datos = min(1000, len(lista_numeros))
    datos_a_ordenar = lista_numeros[:limite_datos]  # Tomar solo una parte de los datos

    inicio_tiempo = time.time()
    lista_ordenada = ordenar_por_burbuja(datos_a_ordenar)
    fin_tiempo = time.time()

    tiempo_segundos = fin_tiempo - inicio_tiempo
    print(f"Tiempo de ejecución para {limite_datos} datos: {tiempo_segundos:.6f} segundos")

    if limite_datos <= 50:
        print("Lista ordenada:", lista_ordenada)

def leer_datos_desde_archivo(nombre_archivo):
    lista_temporal = []
    try:
        with open(nombre_archivo, 'r') as archivo:
            for linea in archivo:
                lista_temporal.append(int(linea.strip()))  # Leer cada número y agregarlo a la lista
    except FileNotFoundError:
        print(f"Error: No se encontró el archivo {nombre_archivo}")
        return None
    return lista_temporal

def ordenar_por_burbuja(lista_numeros):
    n = len(lista_numeros)
    for i in range(n - 1):
        intercambio = False
        for j in range(n - 1 - i):
            if lista_numeros[j] > lista_numeros[j + 1]:
                # Intercambiar los elementos
                lista_numeros[j], lista_numeros[j + 1] = lista_numeros[j + 1], lista_numeros[j]
                intercambio = True
        if not intercambio:  # Si no hubo intercambio, la lista ya está ordenada
            break
    return lista_numeros

if __name__ == "__main__":
    main()
