package com.example.pd4;

import java.util.Random;

public class TClasificador {
    public static final int METODO_CLASIFICACION_QUICKSORT = 1;

    private int maxDepth = 0; 

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_QUICKSORT:
                if (cascara) {
                    return ordenarPorQuicksortCascara(datosParaClasificar);
                } else {
                    return ordenarPorQuicksort(datosParaClasificar);
                }
            default:
                return datosParaClasificar;
        }
    }

    protected int[] ordenarPorQuicksort(int[] datosParaClasificar) {
        if (datosParaClasificar == null) {
            return null;
        }
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, 1);
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuicksortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar == null) {
            return null;
        }
        return datosParaClasificar;
    }

    private void quicksort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            if (depth > maxDepth) {
                maxDepth = depth; 
            }
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1, depth + 1);
            quicksort(arr, pi + 1, high, depth + 1);
        }
    }

    private int partition(int[] arr, int low, int high) {
        //pivote utilizando mediana de tres
        int mid = low + (high - low) / 2;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        swap(arr, mid, high - 1);
        return arr[high - 1];
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
}
