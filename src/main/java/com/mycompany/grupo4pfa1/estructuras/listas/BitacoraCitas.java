package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.CitaBitacora;

/**
 * Bitácora de Citas del día: citas atendidas en la sesión, ordenadas por
 * cédula de menor a mayor.
 * Hereda de la ListaSimple vista en clase y reutiliza insertarOrdenado.
 *
 * @author Mathias Solan
 */
public class BitacoraCitas extends ListaSimple {

    public BitacoraCitas() {
        super();
    }

    /**
     * Agrega una cita atendida a la bitácora respetando el orden por cédula.
     *
     * @param cita cita que acaba de concluir
     */
    public void registrarCita(CitaBitacora cita){
        this.insertarOrdenado(cita);    // Reutiliza insertarOrdenado del profesor.
    }

    /**
     * Indica si todavía no se ha atendido ninguna cita en la sesión.
     *
     * @return true si la bitácora no tiene citas
     */
    public boolean estaVacia(){
        return this.getCabeza() == null;
    }

    /**
     * Cuenta las citas atendidas recorriendo la lista.
     *
     * @return cantidad de citas en la bitácora
     */
    public int contarCitas(){
        int cuenta = 0;
        Nodo auxiliar = this.getCabeza();
        while (auxiliar != null){
            cuenta = cuenta + 1;
            auxiliar = auxiliar.getSiguiente();
        }
        return cuenta;
    }

}
