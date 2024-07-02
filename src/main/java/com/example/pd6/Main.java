package com.example.pd6;

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

            long startTime = System.nanoTime();
            TClasificador clasificador = new TClasificador();
            int[] datosOrdenados = clasificador.clasificar(Arrays.copyOf(datos, datos.length),
                    TClasificador.METODO_CLASIFICACION_HEAPSORT, cascara);
            long endTime = System.nanoTime();

            long tiempoEjecucion = (endTime - startTime) / 1000000;

            System.out.println("Datos después de ordenar:");
            imprimirArray(datosOrdenados);

            System.out.println("Tiempo de ejecución para tamaño " + size + ": " + tiempoEjecucion + " ms");
            System.out.println("Profundidad máxima de llamada recursiva: " + clasificador.getMaxDepth());
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

