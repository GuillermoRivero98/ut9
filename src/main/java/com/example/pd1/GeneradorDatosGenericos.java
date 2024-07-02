package com.example.pd1;
import java.util.Random;

public class GeneradorDatosGenericos {
/* 
	// tiempo de ejecucion es O(n)
	// n siendo tamaño maximo del arreglo
	private static int TAMANIO_MAX = 32000; // 3200 elementos por defecto
	// modificar los métodos para aceptar un parámetro de tamaño

	public int[] generarDatosAleatorios() {
		Random rnd = new Random();
		int[] datosGenerados = new int[TAMANIO_MAX];
		boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
		for (int i = 0; i < datosGenerados.length; i++) {
			int j = rnd.nextInt(TAMANIO_MAX);
			while (datosUtilizados[j]) {
				j = (j + 1) % TAMANIO_MAX;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}

	// genera un vector ascendente
	// Crea un arreglo de tamaño max y lo llena con valores desde 0 hasta
	// TAMANIO_MAX - 1 en orden desendente
	public int[] generarDatosAscendentes() {
		int[] copiaAscendente = new int[TAMANIO_MAX];
		for (int i = 0; i < TAMANIO_MAX; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}

	// genera un vector descendente
	// Crea un arreglo de tamaño max y lo llena con valores desde TAMANIO_MAX hasta
	// 1
	// en orden desendente
	public int[] generarDatosDescendentes() {
		int[] copiaDescendente = new int[TAMANIO_MAX];
		for (int i = 0; i < TAMANIO_MAX; i++) {
			copiaDescendente[i] = TAMANIO_MAX - i;
		}
		return copiaDescendente;
	}

	//algoritmo para saber si esta ordenado
	//tiempo de ejecucion es O(n)
	public boolean estaOrdenado(int[] datos) {
		for (int i = 0; i < datos.length - 1; i++) {
			if (datos[i] > datos[i + 1]) {
				return false;
			}
		}
		return true;
	}
*/
    private static int TAMANIO_MAX = 32000; // tamaño máximo por defecto

    // Genera datos aleatorios
    public int[] generarDatosAleatorios(int tamanio) {
        Random rnd = new Random();
        int[] datosGenerados = new int[tamanio];
        boolean[] datosUtilizados = new boolean[tamanio];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(tamanio);
            while (datosUtilizados[j]) {
                j = (j + 1) % tamanio;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    // Genera un vector ascendente
    public int[] generarDatosAscendentes(int tamanio) {
        int[] copiaAscendente = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    // Genera un vector descendente
    public int[] generarDatosDescendentes(int tamanio) {
        int[] copiaDescendente = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            copiaDescendente[i] = tamanio - i;
        }
        return copiaDescendente;
    }

    // Algoritmo para saber si está ordenado
    public boolean estaOrdenado(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] > datos[i + 1]) {
                return false;
            }
        }
        return true;
    }
}





