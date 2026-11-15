package com.mycompany.grupo4pfa1.estructuras.pilas;

import com.mycompany.grupo4pfa1.modelo.Queja;

/**
 * Pila dinámica vista en clase (proyecto Sem5Pilas05Oct del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de int a Queja.
 * Cualquier método adicional que ocupe el proyecto NO se agrega aquí,
 * se agrega en la clase hija PilaQuejas (herencia).
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class PilaDinamica {
    private Nodo cima;

    public PilaDinamica() {
        this.cima = null;   //Inicializamos en nulo para indicar que la pila está vacía.
    }

    // Sección de los métodos que definen la especificación formal de la pila.

    /**
     * Método apilar permite insertar un elemento en la pila (push).
     *
     * @param valor queja que se inserta en la cima
     */
    public void apilar( Queja valor){
        // Crear la nueva cajita a insertar en la pila.
        Nodo miNodo = new Nodo(valor);

        // Caso 1: Cuando la pila está vacía.
        if (this.cima == null){
            cima = miNodo;  //La cima deja de estar vacía y apunta al nuevo Nodo creado.
        }
        else{
            // Caso 2: (Contrario) Cuando la pila tiene elementos.
            miNodo.setAbajo(cima);      // Amarro mi nuevo Nodo a la cima de la pila.
            cima = miNodo;              //Muevo la cima para que apunte al nuevo elemento que acabo de ingresar.
        }
    }

    /**
     * Método desapilar, permite sacar un elemento de la pila (pop).
     *
     * @return el nodo que estaba en la cima, o null si la pila está vacía
     */
    public Nodo desapilar(){
        // Caso 1: Cuando la pila está vacía.
        if (this.cima == null){         // Stack underflow.
            System.out.println("Error, la pila está vacía, no se puede desapilar");
            return null;
        }
        else{
            // Caso 2: (Contrario) Cuando la pila tiene elementos.
            Nodo nodoTemporal = cima;   // La cima guardada en la variable temporal
            cima = cima.getAbajo(); // Sobreescribe la cima y como consecuencia elimina el elemento que estaba en el top (cima).
            return nodoTemporal;
        }

    }

    /**
     * Método retornaCima, retorna la cima de la pila sin eliminarla (peek).
     *
     * @return el nodo de la cima, o null si la pila está vacía
     */
    public Nodo retornaCima(){
        return cima;
    }

    /**
     * Retorna un boolean que indica si la pila está vacía o no.
     *
     * @return true si la pila no tiene elementos
     */
    public boolean esVacia(){
        return cima == null;
    }

    /**
     * Método iterativo que recorre la pila (con un ciclo)
     * e imprime sus elementos sin alterar la estructura de la pila.
     */
    public void imprimirPila(){
        if (esVacia()){
            System.out.println("La pila está vacía");
        }
        else{
            Nodo actual = cima;  // Creo una variable temporal y la igualo al top.
            while (actual != null){
                System.out.println(actual.getDato());
                actual = actual.getAbajo();
            }
        }
   }

    /**
     * Recorre la pila y cuenta sus elementos sin alterar la estructura.
     *
     * @return cantidad de elementos de la pila
     */
    public int retornaTamaño(){
        if (esVacia()){
            return 0;
        }
        else{
            Nodo actual = cima;  // Creo una variable temporal y la igualo al top.
            int cuenta = 0;
            while (actual != null){
                cuenta = cuenta + 1;
                actual = actual.getAbajo();
            }
            return cuenta;
        }
   }

}
