package com.example.pd7;

import java.util.Arrays;

public class TClasificador {
    public static final int METODO_CLASIFICACION_HEAPSORT = 2;
    public static final int METODO_CLASIFICACION_CUENTA = 3; 

    private int maxDepth = 0;
    private long comparaciones = 0;
    private long movimientos = 0;

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            case METODO_CLASIFICACION_CUENTA:
                return ordenarPorCuentaPorDistribucion(Arrays.copyOf(datosParaClasificar, datosParaClasificar.length));
            default:
                return datosParaClasificar; 
        }
    }

    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
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

    protected int[] ordenarPorCuentaPorDistribucion(int[] datosParaClasificar) {
        int maximo = Arrays.stream(datosParaClasificar).max().orElse(0);
        int[] contador = new int[maximo + 1];

        for (int dato : datosParaClasificar) {
            contador[dato]++;
        }

        int indice = 0;
        for (int i = 0; i <= maximo; i++) {
            while (contador[i] > 0) {
                datosParaClasificar[indice++] = i;
                contador[i]--;
                movimientos++;
            }
        }
        return datosParaClasificar;
    }

    public long getComparaciones() {
        return comparaciones;
    }

    public long getMovimientos() {
        return movimientos;
    }

    public String getMaxDepth() {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxDepth'");
    }
}
