package com.example.pd1;

public class Main {
    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();

        int[] vectorPrueba = { 3, 1, 4, 1, 5 };
        int[] resPrueba = clasif.clasificar(vectorPrueba, TClasificador.METODO_CLASIFICACION_INSERCION);
        for (int i : resPrueba) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(gdg.estaOrdenado(resPrueba));

        int[] vectorAleatorio = gdg.generarDatosAleatorios(100);
        int[] vectorAscendente = gdg.generarDatosAscendentes(100);
        int[] vectorDescendente = gdg.generarDatosDescendentes(100);

        int[] resAleatorio = clasif.clasificar(vectorAleatorio, TClasificador.METODO_CLASIFICACION_INSERCION);
        System.out.println("Aleatorio: " + gdg.estaOrdenado(resAleatorio));

        int[] resAscendente = clasif.clasificar(vectorAscendente, TClasificador.METODO_CLASIFICACION_INSERCION);
        System.out.println("Ascendente: " + gdg.estaOrdenado(resAscendente));

        int[] resDescendente = clasif.clasificar(vectorDescendente, TClasificador.METODO_CLASIFICACION_INSERCION);
        System.out.println("Descendente: " + gdg.estaOrdenado(resDescendente));
    }
}
