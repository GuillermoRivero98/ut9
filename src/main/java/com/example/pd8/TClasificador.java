package com.example.pd8;

import java.util.Arrays;

public class TClasificador {
    public static final int METODO_CLASIFICACION_BURBUJA = 0;
    public static final int METODO_CLASIFICACION_QUICKSORT = 1;
    public static final int METODO_CLASIFICACION_SELECCION_DIRECTA = 2;
    public static final int METODO_CLASIFICACION_HEAPSORT = 3;

    private long comparaciones = 0;
    private long movimientos = 0;

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuicksort(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            case METODO_CLASIFICACION_SELECCION_DIRECTA:
                return ordenarPorSeleccionDirecta(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            default:
                return datosParaClasificar; 
        }
    }

    public int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (datosParaClasificar[j] > datosParaClasificar[j+1]) {
                    int temp = datosParaClasificar[j];
                    datosParaClasificar[j] = datosParaClasificar[j+1];
                    datosParaClasificar[j+1] = temp;
                    movimientos++;
                }
                comparaciones++;
            }
        }
        return datosParaClasificar;
    }

    public int[] ordenarPorQuicksort(int[] datosParaClasificar) {
        return ordenarPorQuicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
    }

    private int[] ordenarPorQuicksort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(arr, inicio, fin);
            ordenarPorQuicksort(arr, inicio, pivote - 1);
            ordenarPorQuicksort(arr, pivote + 1, fin);
        }
        return arr;
    }

    private int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                movimientos++;
            }
            comparaciones++;
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        movimientos++;
        return i + 1;
    }

    public int[] ordenarPorSeleccionDirecta(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (datosParaClasificar[j] < datosParaClasificar[min]) {
                    min = j;
                }
                comparaciones++;
            }
            int temp = datosParaClasificar[min];
            datosParaClasificar[min] = datosParaClasificar[i];
            datosParaClasificar[i] = temp;
            movimientos++;
        }
        return datosParaClasificar;
    }

    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = datosParaClasificar.length / 2 - 1; i >= 0; i--) {
            armaHeap(datosParaClasificar, i, datosParaClasificar.length);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            int temp = datosParaClasificar[0];
            datosParaClasificar[0] = datosParaClasificar[i];
            datosParaClasificar[i] = temp;
            armaHeap(datosParaClasificar, 0, i);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int indiceRaiz, int longitud) {
        int mayor = indiceRaiz;
        int izquierda = 2 * indiceRaiz + 1;
        int derecha = 2 * indiceRaiz + 2;

        if (izquierda < longitud && datosParaClasificar[izquierda] > datosParaClasificar[mayor]) {
            mayor = izquierda;
        }
        if (derecha < longitud && datosParaClasificar[derecha] > datosParaClasificar[mayor]) {
            mayor = derecha;
        }

        if (mayor != indiceRaiz) {
            int temp = datosParaClasificar[indiceRaiz];
            datosParaClasificar[indiceRaiz] = datosParaClasificar[mayor];
            datosParaClasificar[mayor] = temp;
            armaHeap(datosParaClasificar, mayor, longitud);
        }
    }

    public long getComparaciones() {
        return comparaciones;
    }

    public long getMovimientos() {
        return movimientos;
    }
}

