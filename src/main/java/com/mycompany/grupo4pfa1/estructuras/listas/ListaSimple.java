package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.CitaBitacora;

/**
 * Lista Enlazada Simple vista en clase (proyecto 02NovListasMejoradas del profesor).
 * Ajuste realizado para el proyecto: el dato pasa de Contacto a CitaBitacora
 * y el criterio de ordenamiento pasa de teléfono a cédula (de menor a mayor).
 * Los métodos adicionales del proyecto están en la clase hija BitacoraCitas.
 *
 * @author GO-0140 (clase del profesor) - ajuste del dato: Grupo 4
 */
public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Método de la definición formal de Lista Enlazada Simple que permite
     * insertar bajo un criterio de ordenamiento establecido (cédula de menor a mayor).
     *
     * @param cita cita atendida que se inserta en la lista
     */
    public void insertarOrdenado(CitaBitacora cita){
        Nodo nuevoNodo = new Nodo(cita);
        // Casos:
        if (this.getCabeza() == null){ // Caso 1: Cuando la lista está vacía.
            cabeza = nuevoNodo;
        }else if (this.getCabeza().getDato().getCedulaNumerica() > cita.getCedulaNumerica()){
            // Caso 2: Cuando la lista no está vacía y
            // el elemento a insertar es menor al primero.
            nuevoNodo.setSiguiente(cabeza);    // Amarro el nuevo nodo a la lista apuntando a la cabeza.
            cabeza = nuevoNodo;
        }else{
            // Caso 3: Cuando la lista no está vacía y el elemento a insertar es mayor o igual al primero.
            // Recorrer la lista.
            Nodo auxiliar = cabeza;
            while (auxiliar.getSiguiente() != null &&
                   auxiliar.getSiguiente().getDato().getCedulaNumerica() < cita.getCedulaNumerica()){
                    // Un ciclo que busca el lugar donde insertar el elemento
                auxiliar = auxiliar.getSiguiente();
            }
            nuevoNodo.setSiguiente(auxiliar.getSiguiente()); // Amarro la nueva cajita con el siguiente de la lista.
            auxiliar.setSiguiente(nuevoNodo); // Amarro la lista a la nueva caja.
        }

    }

    /**
     * Elimina de la lista la primera cita que tenga el número de ficha indicado.
     *
     * @param fichaEliminar número de ficha de la cita a eliminar
     */
    public void eliminarNodo(String fichaEliminar){
        Nodo actual = cabeza;
        Nodo anterior = null;
        while ((actual != null) &&
                !(actual.getDato().getNumeroFicha().equals(fichaEliminar))){
            anterior = actual;  // Me permite tener un puntero al elemento anterior.
            actual = actual.getSiguiente();  // Puntero al elemento a eliminar.
        }

        // Caso 1: No encontré el elemento a eliminar, es decir, no está en la lista.
        if (actual == null)  // Significa que llegó al final de la lista y no lo encontró.
            return;
        // Caso 2: Eliminar el primer elemento de la lista.
        if (anterior == null)   // Significa que quiero eliminar el primer elemento de la lista.
            cabeza = actual.getSiguiente();
        else
        // Caso 3: Quiero eliminar otro elemento diferente al primero de la lista.
        anterior.setSiguiente(actual.getSiguiente());  // Saltarse la caja que quiero eliminar.

    }

    /**
     * Indica si en la lista hay alguna cita del paciente con la cédula indicada.
     *
     * @param cedula cédula a buscar
     * @return true si la encuentra
     */
    public boolean buscarCita(String cedula){
        Nodo auxiliar = cabeza;
        while (auxiliar != null){
            if (auxiliar.getDato().getCedula().equals(cedula))
                return true;
            else
                auxiliar = auxiliar.getSiguiente();
        }
        return false;
    }

    /**
     * Recorre la lista e imprime sus elementos.
     */
    public void recorrerLista(){
        Nodo auxiliar = cabeza;
        while (auxiliar != null){
            System.out.println("Cedula: " + auxiliar.getDato().getCedula() + " Nombre: " + auxiliar.getDato().getNombre());
            auxiliar = auxiliar.getSiguiente();
        }

    }
}
