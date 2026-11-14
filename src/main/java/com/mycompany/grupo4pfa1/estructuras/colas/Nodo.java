package com.mycompany.grupo4pfa1.estructuras.colas;

import com.mycompany.grupo4pfa1.modelo.Paciente;

/**
 * Nodo de la Cola visto en clase (proyecto Colas12Oct26 del profesor).
 * Ajuste realizado para el proyecto: el dato almacenado pasa de int a Paciente.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class Nodo {
    private Paciente dato;  // Dato almacenado en el nodo.
    private Nodo siguiente; // Referencia al siguiente nodo de la Cola.

    public Nodo() {
    }

    public Nodo(Paciente dato) {
        this.dato = dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

}
