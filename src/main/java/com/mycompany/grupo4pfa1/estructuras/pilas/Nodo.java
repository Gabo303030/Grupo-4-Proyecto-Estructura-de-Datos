package com.mycompany.grupo4pfa1.estructuras.pilas;

import com.mycompany.grupo4pfa1.modelo.Queja;

/**
 * Nodo de la Pila visto en clase (proyecto Sem5Pilas05Oct del profesor).
 * Ajuste realizado para el proyecto: el dato almacenado pasa de int a Queja.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class Nodo {

    private Queja dato;

    private Nodo abajo; // Referencia al nodo que está debajo de este

    public Nodo() {
    }

    public Nodo(Queja dato) {
        this.dato = dato;
    }

    public Queja getDato() {
        return dato;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setDato(Queja dato) {
        this.dato = dato;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

}
