package org.didierdominguez;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CodificarHuffman codificarHuffman = new CodificarHuffman();

        String miCadena = "Bueno pues esta es la prueba mas larga para los reportes\n con esto que pasa";
        System.out.println(Colors.ANSI_CYAN + "Texto a codificar: " + Colors.ANSI_RESET + miCadena);
        codificarHuffman.codificar(miCadena);

        List<String> listaCaracteres = Arrays.asList(miCadena.split("(?!^)"));
        for (int i = 0; i < listaCaracteres.size(); i++) {
            String caracter = listaCaracteres.get(i);
            listaCaracteres.set(i, TablaCodificacion.getInstancia().getCodigo(caracter));
        }
        miCadena = String.join(" ", listaCaracteres);
        System.out.println(Colors.ANSI_CYAN + "Texto codificado: " + Colors.ANSI_RESET + miCadena);

        listaCaracteres = Arrays.asList(miCadena.split(" "));
        for (int i = 0; i < listaCaracteres.size(); i++) {
            String codigo = listaCaracteres.get(i);
            listaCaracteres.set(i, TablaCodificacion.getInstancia().getCaracter(codigo));
        }
        miCadena = String.join("", listaCaracteres);
        System.out.println(Colors.ANSI_CYAN + "Texto decodificado: " + Colors.ANSI_RESET + miCadena);
    }
}
