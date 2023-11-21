package org.didierdominguez;

import java.util.Comparator;

public class ComparadorNodo implements Comparator<Nodo> {
    public int compare(Nodo s1, Nodo s2) {
        if (s1.getFrecuencia() > s2.getFrecuencia()) {
            return 1;
        } else if (s1.getFrecuencia() < s2.getFrecuencia()) {
            return -1;
        }
        return 0;
    }
}
