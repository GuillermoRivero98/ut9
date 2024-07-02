package com.example.pd4;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        int[] sizes = {300, 10000}; 
        int[] methodTypes = {TClasificador.METODO_CLASIFICACION_QUICKSORT}; 
        boolean[] cascaraOptions = {true, false}; 

        for (int size : sizes) {
            for (int method : methodTypes) {
                for (boolean cascara : cascaraOptions) {
                    int[] datos = generarVector(size, "ascendente"); 

                    long startTime = System.nanoTime();
                    TClasificador clasificador = new TClasificador();
                    int[] datosOrdenados = clasificador.clasificar(datos, method, cascara);
                    long endTime = System.nanoTime();
                    long tiempoEjecucion = (endTime - startTime) / 1000000;

                    System.out.println("Tamaño del conjunto de datos: " + size);
                    System.out.println("Método de clasificación: " + method);
                    System.out.println("Cáscara: " + cascara);
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " ms");
                    System.out.println("Profundidad máxima de llamada recursiva: " + clasificador.getMaxDepth());
                    System.out.println();
                }
            }
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
                    arr[i] = rand.nextInt(size);
                }
                break;
        }

        return arr;
    }
}
