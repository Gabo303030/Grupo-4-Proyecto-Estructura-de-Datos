package com.mycompany.grupo4pfa1.estructuras;

/**
 * Cola enlazada FIFO: se inserta por el final y se retira por el frente.
 */
public class Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Cola() {
        frente = null;
        fin = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamano() {
        return tamano;
    }

    /**
     * Inserta un elemento al final de la cola.
     */
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        tamano++;
    }

    /**
     * Retira y devuelve el elemento del frente, o null si la cola está vacía.
     */
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamano--;
        return dato;
    }

    /**
     * Devuelve el elemento del frente sin retirarlo, o null si la cola está vacía.
     */
    public T verFrente() {
        return estaVacia() ? null : frente.getDato();
    }

    /**
     * Primer nodo de la cola, para recorrerla sin eliminar elementos.
     */
    public Nodo<T> getFrente() {
        return frente;
    }
}
