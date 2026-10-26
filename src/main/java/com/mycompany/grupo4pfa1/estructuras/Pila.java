package com.mycompany.grupo4pfa1.estructuras;

/**
 * Pila enlazada LIFO: se inserta y se retira por la cima.
 * Reutiliza el mismo Nodo de la Cola.
 */
public class Pila<T> {

    private Nodo<T> cima;
    private int tamano;

    public Pila() {
        cima = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamano() {
        return tamano;
    }

    /**
     * Inserta un elemento en la cima de la pila.
     */
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamano++;
    }

    /**
     * Retira y devuelve el elemento de la cima, o null si la pila está vacía.
     */
    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        tamano--;
        return dato;
    }

    /**
     * Primer nodo de la pila (el más reciente), para recorrerla sin desapilar.
     */
    public Nodo<T> getCima() {
        return cima;
    }
}
