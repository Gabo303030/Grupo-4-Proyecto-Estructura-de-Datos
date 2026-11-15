package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.CitaHistorica;

/**
 * Histórico de Citas de un paciente (lista interna del expediente).
 * Hereda de la ListaCircular vista en clase y reutiliza insertarOrdenado.
 *
 * @author Gabriel Alvarez
 */
public class HistoricoCitas extends ListaCircular {

    public HistoricoCitas() {
        super();
    }

    /**
     * Agrega una cita realizada al histórico del paciente.
     *
     * @param cita cita con fecha, doctor y diagnóstico
     */
    public void agregarCita(CitaHistorica cita){
        this.insertarOrdenado(cita);    // Reutiliza insertarOrdenado del profesor.
    }

    /**
     * Indica si el paciente todavía no tiene citas registradas.
     *
     * @return true si el histórico está vacío
     */
    public boolean estaVacia(){
        return this.getPrimero() == null;
    }

    /**
     * Cuenta las citas dándole una vuelta completa a la lista circular.
     *
     * @return cantidad de citas del histórico
     */
    public int contarCitas(){
        if (this.estaVacia()){
            return 0;
        }
        int cuenta = 1;                         // Cuenta el primero.
        NodoSimple aux = this.getPrimero();
        while (aux != this.getUltimo()){        // Se detiene al llegar al último para no dar vueltas infinitas.
            cuenta = cuenta + 1;
            aux = aux.getSiguiente();
        }
        return cuenta;
    }

}
