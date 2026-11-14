package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.Expediente;

/**
 * Lista Doble Circular vista en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Cancion a Expediente
 * y el criterio de ordenamiento pasa de identificador a cédula (de menor a mayor).
 * Los métodos adicionales del proyecto están en la clase hija ExpedienteUnico.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class ListaDobleCircular {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDobleCircular() {
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Método que inserta elementos en la lista doble circular utilizando un
     * criterio de ordenamiento (cédula de menor a mayor).
     *
     * @param expediente expediente del paciente que se inserta en la lista
     */
    public void insertarOrdenado(Expediente expediente){
        NodoDoble nuevoNodo = new NodoDoble(expediente);
        if (this.getPrimero() == null ){        // CASO 1: La lista está vacía
            primero = nuevoNodo;                // Paso 2: Apuntar la cabeza a la cajita recién creada.
            ultimo = primero;              // Paso 3: Apuntar el último a la cajita recién creada.
            ultimo.setSiguiente(primero);  // Paso 4: Apunta el sgte del último a la cabeza.
            primero.setAnterior(ultimo);    // Paso 5: Apunta el anterior de la cabeza al último
        }
        else if (expediente.getCedulaNumerica() <= primero.getDato().getCedulaNumerica()){  // CASO 2: Cuando quiero insertar un elemento menor.
            nuevoNodo.setSiguiente(primero);        // Paso 2: Poner la nueva cajita de primero amarrada a la cabeza.
            primero.setAnterior(nuevoNodo);// Paso 3: Poner el anterior de la cabeza amarrado a la nueva cajita.
            primero = nuevoNodo; // Paso 4: Mover la cabeza al nuevo elemento para que ya no quede de segunda.
            // Ahora hagámoslo circular de nuevo.
            primero.setAnterior(ultimo);    // Paso 5: Amarra la cabeza al último. (La hacen circular)
            ultimo.setSiguiente(primero);  // Paso 6: Amarra el último a la nueva cabeza. (La hacen circular)
        }
        else if (expediente.getCedulaNumerica() >= ultimo.getDato().getCedulaNumerica()){ // CASO 3: Cuando quiero insertar un elemento mayor o igual al último
            ultimo.setSiguiente(nuevoNodo);     // Paso 2: Poner el sgte del último apuntando a la nueva cajita.
            nuevoNodo.setAnterior(ultimo);       // Paso 3: Poner el anterior de la nueva cajita apuntando al último
            ultimo = nuevoNodo;                 // Paso 4: Mover el último a la nueva cajita.
            // Ahora hagámoslo circular de nuevo.
            ultimo.setSiguiente(primero);// Paso 5: Hacerla Circular desde el último a la cabeza.
            primero.setAnterior(ultimo);// Paso 6: Hacerla Circular desde la cabeza al último.
        }else {     // CASO 4: Insertar en el medio.
            NodoDoble aux = primero;      // Creo un nodo aux y lo apunto a la cabeza
            while (aux.getSiguiente().getDato().getCedulaNumerica() < expediente.getCedulaNumerica()){  // recorrer para encontrar un lugar
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());  // Paso 2: Amarrar la nueva cajita al sgte de la lista.
            nuevoNodo.setAnterior(aux);                    // Paso 3: Amarro la nueva cajita para atrás.

            aux.setSiguiente(nuevoNodo);             // Paso 4: Amarramos el aux a la nueva cajita.
            nuevoNodo.getSiguiente().setAnterior(nuevoNodo);     // Paso 5: Amarrar la caja sgte para atrás a la nueva cajita.
        }

    }

}
