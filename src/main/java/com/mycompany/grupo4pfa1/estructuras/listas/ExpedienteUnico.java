package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.Expediente;

/**
 * Expediente Único de Pacientes: un expediente por paciente, ordenados por
 * cédula de menor a mayor. Cada expediente lleva sus listas internas
 * (histórico de citas e histórico de medicamentos).
 * Hereda de la ListaDobleCircular vista en clase y reutiliza insertarOrdenado.
 *
 * @author Daniela Villegas
 */
public class ExpedienteUnico extends ListaDobleCircular {

    public ExpedienteUnico() {
        super();
    }

    /**
     * Agrega el expediente de un paciente que asiste por primera vez.
     *
     * @param expediente expediente nuevo
     */
    public void registrarExpediente(Expediente expediente){
        this.insertarOrdenado(expediente);  // Reutiliza insertarOrdenado del profesor.
    }

    /**
     * Indica si todavía no hay expedientes registrados.
     *
     * @return true si la lista no tiene expedientes
     */
    public boolean estaVacia(){
        return this.getPrimero() == null;
    }

    /**
     * Busca el expediente de un paciente dándole una vuelta a la lista circular.
     *
     * @param cedula cédula del paciente
     * @return el expediente, o null si el paciente no tiene expediente
     */
    public Expediente buscarPorCedula(String cedula){
        if (this.estaVacia()){
            return null;
        }
        NodoDoble aux = this.getPrimero();
        while (aux != this.getUltimo()){    // Revisa del primero al penúltimo.
            if (aux.getDato().getCedula().equals(cedula)){
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        if (aux.getDato().getCedula().equals(cedula)){  // Revisa el último.
            return aux.getDato();
        }
        return null;
    }

    /**
     * Cuenta los expedientes dándole una vuelta completa a la lista circular.
     *
     * @return cantidad de expedientes registrados
     */
    public int contarExpedientes(){
        if (this.estaVacia()){
            return 0;
        }
        int cuenta = 1;                     // Cuenta el primero.
        NodoDoble aux = this.getPrimero();
        while (aux != this.getUltimo()){    // Se detiene al llegar al último para no dar vueltas infinitas.
            cuenta = cuenta + 1;
            aux = aux.getSiguiente();
        }
        return cuenta;
    }

}
