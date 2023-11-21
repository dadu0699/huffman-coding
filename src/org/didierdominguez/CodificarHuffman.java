package org.didierdominguez;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodificarHuffman {
    public CodificarHuffman() {
    }

    public void codificar(String contenido) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(1, new ComparadorNodo());

        // SEPARAR EN CARACTERES
        List<String> listaCaracteres = Arrays.asList(contenido.split("(?!^)"));
        Map<String, Long> conteoCaracteres = listaCaracteres
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // ORDENAR DESCENDENTE
        Map<String, Long> conteoDescendente = new LinkedHashMap<>();
        conteoCaracteres
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> conteoDescendente.put(e.getKey(), e.getValue()));
        System.out.println(Colors.ANSI_CYAN + "Conteo ascendente: " + Colors.ANSI_RESET + conteoDescendente);

        // AGREGAR A COLA DE PRIORIDAD COMO NODOS
        conteoDescendente
                .entrySet()
                .forEach((entry) -> {
                    int valor = entry.getValue().intValue();
                    cola.add(new Nodo(String.valueOf(entry.getKey().charAt(0)), valor));
                });

        // CREAR ARBOL DE HUFFMAN CON COLA DE PRIORIDAD DE NODOS Y RECORRERLO PARA
        // OBTENER CODIFICACION DE CADA CARACTER (0, 1)
        while (cola.size() > 1) {
            // OBTENER LOS DOS NODOS CON MENOR FRECUENCIA
            Nodo ramaCero = cola.peek();
            cola.poll();

            Nodo ramaUno = cola.peek();
            cola.poll();

            // CREAR NUEVO NODO CON LA SUMA DE LAS FRECUENCIAS DE LOS DOS NODOS ANTERIORES
            cola.add(new Nodo(ramaCero, ramaUno));
        }
        System.out.println(Colors.ANSI_CYAN + "Codificacion: " + Colors.ANSI_RESET);

        cola.peek().recorrer("");
        TablaCodificacion.getInstancia().obtenerDatos();
    }
}
