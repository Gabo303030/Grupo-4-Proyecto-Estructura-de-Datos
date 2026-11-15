package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.RegistroHistorico;

/**
 * Nodo de la Lista Circular visto en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Cancion a RegistroHistorico
 * (clase padre de las citas y de los medicamentos del expediente).
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class NodoSimple {
    private RegistroHistorico dato;
    private NodoSimple siguiente;

    public NodoSimple() {
    }

    public NodoSimple(RegistroHistorico dato) {
        this.dato = dato;
    }

    public void setDato(RegistroHistorico dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

    public RegistroHistorico getDato() {
        return dato;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

}
