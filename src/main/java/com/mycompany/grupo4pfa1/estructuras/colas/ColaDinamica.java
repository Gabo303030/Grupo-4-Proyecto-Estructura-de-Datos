package com.mycompany.grupo4pfa1.estructuras.colas;

import com.mycompany.grupo4pfa1.modelo.Paciente;

/**
 * Cola dinámica vista en clase (proyecto Colas12Oct26 del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de int a Paciente.
 * Cualquier método adicional que ocupe el proyecto NO se agrega aquí,
 * se agrega en la clase hija ColaPacientes (herencia).
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class ColaDinamica {
    private Nodo frente;  // Referencia que apunta al primer elemento de la cola.
    private Nodo fin;     // Referencia que apunta al último elemento de la cola.

    public ColaDinamica() {
        this.frente = null;
        this.fin = null;
    }

    public Nodo getFrente() {
        return frente;
    }

    public Nodo getFin() {
        return fin;
    }

    /**
     * Operación encolar permite insertar elementos en la cola.
     *
     * @param dato paciente que se inserta al final de la cola
     */
    public void encolar(Paciente dato){
        // Primero creamos la caja Nodo.
        Nodo nuevoNodo = new Nodo(dato);

        if (this.fin != null){      // Significa que la cola no está vacía.
            // Si no está vacía enlazo el fin a la nueva caja.
            this.fin.setSiguiente(nuevoNodo);       // Apunto el fin (último elemento) al nuevo nodo.
        }
        fin = nuevoNodo;        // Actualizo el puntero al nuevo último. Lo muevo.

        if (this.estaVacia()){   // Si la cola está vacía.
            this.frente = nuevoNodo;    // El nuevo Nodo es también primer nodo cuando la cola estaba vacía.
        }
    }

    /**
     * Operación para eliminar un elemento de la cola.
     *
     * @return el paciente que estaba en el frente de la cola
     * @throws Exception si la cola está vacía
     */
    public Paciente desencolar() throws Exception{

        if (this.estaVacia()){ // Verificar si la cola está vacía.
            throw new Exception("La cola está vacía");  // Lanzar una excepción si no hay elementos.
        }
        Paciente antiguoFrente = frente.getDato();   // Guardo el frente en una variable temporal.
        frente = frente.getSiguiente(); // Muevo el puntero del frente al siguiente nodo.
        if (this.estaVacia()){  // Si frente queda nulo después de eliminar un elemento (tenía 1)
            fin = null;         // Ponga fin nulo.
        }
        return antiguoFrente;

    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si no hay elementos en la cola
     */
    public boolean estaVacia(){
        return frente == null;
    }

    /**
     * Recorre la cola e imprime sus elementos sin alterarla.
     */
    public void imprimirCola(){
        Nodo temp = this.frente;
        while (temp != null){
            System.out.println(temp.getDato()+ "  ");
            temp = temp.getSiguiente();
        }

    }

}
