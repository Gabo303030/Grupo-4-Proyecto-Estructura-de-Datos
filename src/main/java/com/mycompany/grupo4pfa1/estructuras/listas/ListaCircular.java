package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.RegistroHistorico;

/**
 * Lista Simple Circular vista en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Cancion a RegistroHistorico
 * y el criterio de ordenamiento pasa de identificador a la fecha (timestamp).
 * Los métodos adicionales del proyecto están en las clases hijas
 * HistoricoCitas e HistoricoMedicamentos.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class ListaCircular {
    private NodoSimple primero;
    private NodoSimple ultimo;

    public ListaCircular() {
    }

    public NodoSimple getPrimero() {
        return primero;
    }

    public NodoSimple getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoSimple primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoSimple ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Método que inserta elementos en la lista circular utilizando un criterio de
     * ordenamiento (fecha del registro, del más antiguo al más reciente).
     *
     * @param registro cita o medicamento que se inserta en el histórico
     */
    public void insertarOrdenado(RegistroHistorico registro){
       // Creamos la cajita.
         NodoSimple nuevoNodo = new NodoSimple(registro);
        if (this.getPrimero() == null){
        // Caso 1: La lista está vacía.
        // Paso 1.2: Inicializar el primero.
        primero = nuevoNodo;
        // Paso 1.3: Inicializar el último.
        ultimo = nuevoNodo;

        // Paso 1.4: Poner el siguiente del último a apuntar al primero.
        ultimo.setSiguiente(primero);
        }else if (registro.getMarcaTiempo() <= primero.getDato().getMarcaTiempo()){
            // Caso 2: El elemento a insertar es menor al primero. Lo inserto a la izquierda del primero.
            // Paso 2.2 Ligar el último al nuevo primero.
            ultimo.setSiguiente(nuevoNodo);
            // Paso 2.3 Amarrar la cajita al resto de la lista.
            nuevoNodo.setSiguiente(primero);
            // Paso 2.4 Mover el primero.
            primero = nuevoNodo;
        }else if (registro.getMarcaTiempo() >= ultimo.getDato().getMarcaTiempo()){
            // Caso 3: El elemento a insertar es mayor al último.
            // Lo inserto a la derecha del último. Ayuda por temas de desempeño.
            // Cuando hay muchos elementos no tengo que recorrer toda la lista.
            // Paso 3.2 Amarramos el último a la nueva cajita.
            ultimo.setSiguiente(nuevoNodo);
            // Paso 3.3 Movemos el último para que apunte a la nueva cajita
            ultimo = nuevoNodo;
            // Paso 3.4 Ligar el nuevo último al primero.
            ultimo.setSiguiente(primero);
        }else{
            // Caso 4: El elemento a insertar va en una posición interna de la lista.
            //         Vamos a iterar (recorrer) la lista para encontrar un lugar donde se inserta.
            NodoSimple aux = primero;
            while (aux.getSiguiente().getDato().getMarcaTiempo() < registro.getMarcaTiempo()){
                aux = aux.getSiguiente();
            }
            // Paso 4.2 Amarrar la nueva cajita al resto de la lista.
            nuevoNodo.setSiguiente(aux.getSiguiente());
            // Paso 4.3 Amarrar el auxiliar al nuevo siguiente
            aux.setSiguiente(nuevoNodo);
        }
    }
}
