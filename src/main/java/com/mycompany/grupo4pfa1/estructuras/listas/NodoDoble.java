package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.Expediente;

/**
 * Nodo Doble visto en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Cancion a Expediente.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class NodoDoble {
    private NodoDoble anterior;
    private Expediente dato;
    private NodoDoble siguiente;

    public NodoDoble() {
    }

    public NodoDoble(Expediente dato) {
        this.dato = dato;
        this.siguiente = this.anterior = null;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public Expediente getDato() {
        return dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public void setDato(Expediente dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

}
