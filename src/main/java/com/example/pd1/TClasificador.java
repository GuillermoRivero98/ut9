package com.example.pd1;

public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            default:
                System.err.println("Este código no debería haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0 && datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                        intercambiar(datosParaClasificar, j, j + inc);
                        j = j - inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int key = datosParaClasificar[i];
                int j = i - 1;
                while (j >= 0 && datosParaClasificar[j] > key) {
                    datosParaClasificar[j + 1] = datosParaClasificar[j];
                    j--;
                }
                datosParaClasificar[j + 1] = key;
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
            }
        }
        return datosParaClasificar;
    }
}
