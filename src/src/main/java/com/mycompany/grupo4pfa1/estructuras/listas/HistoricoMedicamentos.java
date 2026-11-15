package com.mycompany.grupo4pfa1.estructuras.listas;

import com.mycompany.grupo4pfa1.modelo.MedicamentoPrescrito;

/**
 * Histórico de Medicamentos Prescritos de un paciente (lista interna del expediente).
 * Hereda de la ListaCircular vista en clase y reutiliza insertarOrdenado.
 *
 * @author Gabriel Alvarez
 */
public class HistoricoMedicamentos extends ListaCircular {

    public HistoricoMedicamentos() {
        super();
    }

    /**
     * Agrega un medicamento prescrito al histórico del paciente.
     *
     * @param medicamento medicamento con su fecha de prescripción
     */
    public void agregarMedicamento(MedicamentoPrescrito medicamento){
        this.insertarOrdenado(medicamento);    // Reutiliza insertarOrdenado del profesor.
    }

    /**
     * Indica si al paciente todavía no se le han prescrito medicamentos.
     *
     * @return true si el histórico está vacío
     */
    public boolean estaVacia(){
        return this.getPrimero() == null;
    }

    /**
     * Cuenta los medicamentos dándole una vuelta completa a la lista circular.
     *
     * @return cantidad de medicamentos del histórico
     */
    public int contarMedicamentos(){
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
