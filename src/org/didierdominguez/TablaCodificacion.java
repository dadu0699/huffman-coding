package org.didierdominguez;

import java.util.ArrayList;

public class TablaCodificacion {

    private static TablaCodificacion instancia;
    private ArrayList<Nodo> nodos;

    public TablaCodificacion() {
        nodos = new ArrayList<>();
    }

    public static TablaCodificacion getInstancia() {
        return (instancia == null)
                ? instancia = new TablaCodificacion()
                : instancia;
    }

    public void agregar(Nodo nodo) {
        nodos.add(nodo);
    }

    public void obtenerDatos() {
        for (Nodo nod : nodos) {
            System.out.println("DATO: " + nod.getLetra()
                    + ", FRECUENCIA: " + nod.getFrecuencia()
                    + ", CODIGO: " + nod.getCodigo());
        }
    }

    public String getCodigo(String caracter) {
        for (Nodo nodo : nodos) {
            if (nodo.getLetra().equals(caracter)) {
                return nodo.getCodigo();
            }
        }
        return "";
    }

    public String getCaracter(String codigo) {
        for (Nodo nodo : nodos) {
            if (nodo.getCodigo().equals(codigo)) {
                return nodo.getLetra();
            }
        }
        return "";
    }
}
