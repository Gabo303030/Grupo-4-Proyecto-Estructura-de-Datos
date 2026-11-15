package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.CitaBitacora;

/**
 * Nodo de la Lista Simple visto en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Contacto a CitaBitacora.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class Nodo {
    private CitaBitacora dato;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(CitaBitacora dato) {
        this.dato = dato;
    }

    public void setDato(CitaBitacora dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public CitaBitacora getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

}
