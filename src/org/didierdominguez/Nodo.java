package org.didierdominguez;

public class Nodo {
    private String letra;
    private int frecuencia;
    private String codigo;
    private Nodo ramaCero;
    private Nodo ramaUno;

    public Nodo(String letra) {
        this.letra = letra;
        this.frecuencia = -1;
        this.codigo = "";
        this.ramaCero = null;
        this.ramaUno = null;
    }

    public Nodo(String letra, int frecuencia) {
        this.letra = letra;
        this.frecuencia = frecuencia;
        this.codigo = "";
        this.ramaCero = null;
        this.ramaUno = null;
    }

    public Nodo(Nodo ramaCero, Nodo ramaUno) {
        this.letra = "";
        this.frecuencia = ramaCero.getFrecuencia() + ramaUno.getFrecuencia();
        this.codigo = "";
        this.ramaCero = ramaCero;
        this.ramaUno = ramaUno;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Nodo getRamaCero() {
        return ramaCero;
    }

    public void setRamaCero(Nodo ramaCero) {
        this.ramaCero = ramaCero;
    }

    public Nodo getRamaUno() {
        return ramaUno;
    }

    public void setRamaUno(Nodo ramaUno) {
        this.ramaUno = ramaUno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void recorrer(String codigo) {
        if (ramaCero != null) {
            ramaCero.recorrer(codigo + '0');
            ramaUno.recorrer(codigo + '1');
        } else {
            this.codigo = codigo;
            TablaCodificacion.getInstancia().agregar(this);
        }
    }
}
