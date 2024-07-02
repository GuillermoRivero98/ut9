package com.example.pd8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {300, 3000, 30000}; 
        String[] ordenes = {"ascendente", "descendente", "aleatorio"}; 

        for (int size : sizes) {
            for (String orden : ordenes) {
                int[] datos = generarVector(size, orden);

                System.out.println("Datos antes de ordenar:");
                imprimirArray(datos);

                // Medición y ejecución con cada método de clasificación
                ejecutarYMedir(datos, size);
                
                System.out.println();
            }
        }
    }

    private static void ejecutarYMedir(int[] datos, int size) {
        TClasificador clasificador = new TClasificador();

        // Burbuja
        long startTimeBurbuja = System.nanoTime();
        int[] datosOrdenadosBurbuja = clasificador.clasificar(Arrays.copyOf(datos, datos.length), TClasificador.METODO_CLASIFICACION_BURBUJA);
        long endTimeBurbuja = System.nanoTime();
        long tiempoEjecucionBurbuja = (endTimeBurbuja - startTimeBurbuja) / 1000000;
        System.out.println("Ordenando con Burbuja:");
        imprimirResultado(datosOrdenadosBurbuja, tiempoEjecucionBurbuja, size, "Burbuja", clasificador);

        // Quicksort
        long startTimeQuicksort = System.nanoTime();
        int[] datosOrdenadosQuicksort = clasificador.clasificar(Arrays.copyOf(datos, datos.length), TClasificador.METODO_CLASIFICACION_QUICKSORT);
        long endTimeQuicksort = System.nanoTime();
        long tiempoEjecucionQuicksort = (endTimeQuicksort - startTimeQuicksort) / 1000000;
        System.out.println("Ordenando con Quicksort:");
        imprimirResultado(datosOrdenadosQuicksort, tiempoEjecucionQuicksort, size, "Quicksort", clasificador);

        // Selección Directa
        long startTimeSeleccionDirecta = System.nanoTime();
        int[] datosOrdenadosSeleccionDirecta = clasificador.clasificar(Arrays.copyOf(datos, datos.length), TClasificador.METODO_CLASIFICACION_SELECCION_DIRECTA);
        long endTimeSeleccionDirecta = System.nanoTime();
        long tiempoEjecucionSeleccionDirecta = (endTimeSeleccionDirecta - startTimeSeleccionDirecta) / 1000000;
        System.out.println("Ordenando con Selección Directa:");
        imprimirResultado(datosOrdenadosSeleccionDirecta, tiempoEjecucionSeleccionDirecta, size, "Selección Directa", clasificador);

        // Heapsort
        long startTimeHeapsort = System.nanoTime();
        int[] datosOrdenadosHeapsort = clasificador.clasificar(Arrays.copyOf(datos, datos.length), TClasificador.METODO_CLASIFICACION_HEAPSORT);
        long endTimeHeapsort = System.nanoTime();
        long tiempoEjecucionHeapsort = (endTimeHeapsort - startTimeHeapsort) / 1000000;
        System.out.println("Ordenando con Heapsort:");
        imprimirResultado(datosOrdenadosHeapsort, tiempoEjecucionHeapsort, size, "Heapsort", clasificador);
    }

    private static int[] generarVector(int size, String tipoOrden) {
        int[] arr = new int[size];
        switch (tipoOrden) {
            case "ascendente":
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                break;
            case "descendente":
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                break;
            case "aleatorio":
                for (int i = 0; i < size; i++) {
                    arr[i] = (int) (Math.random() * size * 10);
                }
                break;
        }
        return arr;
    }

    private static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void imprimirResultado(int[] arr, long tiempoEjecucion, int size, String algoritmo, TClasificador clasificador) {
        System.out.println("Datos después de ordenar con " + algoritmo + ":");
        imprimirArray(arr);
        System.out.println("Tiempo de ejecución para tamaño " + size + " con " + algoritmo + ": " + tiempoEjecucion + " ms");
        System.out.println("Comparaciones: " + clasificador.getComparaciones());
        System.out.println("Movimientos: " + clasificador.getMovimientos());
        System.out.println();
    }
}
