package com.example.pd7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000}; 
        boolean cascara = false; 

        for (int size : sizes) {
            int[] datos = generarVector(size, "aleatorio");

            System.out.println("Datos antes de ordenar:");
            imprimirArray(datos);

            //Heapsort
            System.out.println("Ordenando con Heapsort:");
            long startTimeHeap = System.nanoTime();
            TClasificador clasificadorHeap = new TClasificador();
            int[] datosOrdenadosHeap = clasificadorHeap.clasificar(Arrays.copyOf(datos, datos.length),
                    TClasificador.METODO_CLASIFICACION_HEAPSORT, cascara);
            long endTimeHeap = System.nanoTime();
            long tiempoEjecucionHeap = (endTimeHeap - startTimeHeap) / 1000000;

            System.out.println("Datos después de ordenar con Heapsort:");
            imprimirArray(datosOrdenadosHeap);
            System.out.println("Tiempo de ejecución para tamaño " + size + " con Heapsort: " + tiempoEjecucionHeap + " ms");
            System.out.println("Profundidad máxima de llamada recursiva con Heapsort: " + clasificadorHeap.getMaxDepth());
            System.out.println();

            //Distribución
            System.out.println("Ordenando con Cuenta por Distribución:");
            long startTimeCuenta = System.nanoTime();
            TClasificador clasificadorCuenta = new TClasificador();
            int[] datosOrdenadosCuenta = clasificadorCuenta.clasificar(Arrays.copyOf(datos, datos.length),
                    TClasificador.METODO_CLASIFICACION_CUENTA, cascara);
            long endTimeCuenta = System.nanoTime();
            long tiempoEjecucionCuenta = (endTimeCuenta - startTimeCuenta) / 1000000;

            System.out.println("Datos después de ordenar con Cuenta por Distribución:");
            imprimirArray(datosOrdenadosCuenta);
            System.out.println("Tiempo de ejecución para tamaño " + size + " con Cuenta por Distribución: " + tiempoEjecucionCuenta + " ms");
            System.out.println();

            System.out.println("Comparaciones y movimientos:");
            System.out.println("Comparaciones Heapsort: " + clasificadorHeap.getComparaciones());
            System.out.println("Movimientos Heapsort: " + clasificadorHeap.getMovimientos());
            System.out.println("Comparaciones Cuenta por Distribución: " + clasificadorCuenta.getComparaciones());
            System.out.println("Movimientos Cuenta por Distribución: " + clasificadorCuenta.getMovimientos());

            System.out.println();
        }
    }

    private static int[] generarVector(int size, String tipoOrden) {
        int[] arr = new int[size];
        Random rand = new Random();

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
                    arr[i] = rand.nextInt(size * 10); 
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
}
