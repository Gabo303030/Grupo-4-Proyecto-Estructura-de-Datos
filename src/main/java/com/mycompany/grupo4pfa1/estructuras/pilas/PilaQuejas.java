package com.mycompany.grupo4pfa1.estructuras.pilas;

import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.modelo.Queja;

/**
 * Pila de Quejas del hospital "Su Salud": guarda a los pacientes que
 * abandonaron la cola sin ser atendidos.
 * Hereda de la PilaDinamica vista en clase y reutiliza apilar y retornaCima.
 *
 * @author Gabriel Alvarez
 */
public class PilaQuejas extends PilaDinamica {

    public PilaQuejas() {
        super();
    }

    /**
     * Crea la queja del paciente que abandona y la apila.
     * La fecha y hora del abandono la calcula el sistema.
     *
     * @param paciente paciente que se retira de la cola
     * @param motivo motivo de salida indicado por el paciente
     * @return la queja que quedó en la cima de la pila
     */
    public Queja registrarAbandono(Paciente paciente, String motivo){
        Queja queja = new Queja(paciente, motivo);
        this.apilar(queja);                 // Reutiliza apilar del profesor.
        return queja;
    }

    /**
     * Retorna la última queja recibida sin sacarla de la pila.
     *
     * @return la queja de la cima, o null si no hay quejas
     */
    public Queja ultimaQueja(){
        if (this.esVacia()){
            return null;
        }
        return this.retornaCima().getDato(); // Reutiliza retornaCima del profesor.
    }

}
