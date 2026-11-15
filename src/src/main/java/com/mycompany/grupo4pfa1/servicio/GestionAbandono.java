package com.mycompany.grupo4pfa1.servicio;

import com.mycompany.grupo4pfa1.estructuras.pilas.PilaQuejas;
import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.modelo.Queja;

/**
 * Retira de la cola a los pacientes que abandonan sin ser atendidos y
 * registra su queja en la Pila de Quejas.
 * Usa las mismas colas de GestorAtencion para no duplicar pacientes.
 *
 * @author Gabriel Alvarez
 */
public class GestionAbandono {

    private GestorAtencion gestor;
    private PilaQuejas pilaQuejas;

    public GestionAbandono(GestorAtencion gestor) {
        this.gestor = gestor;
        this.pilaQuejas = new PilaQuejas();
    }

    /**
     * Elimina de su cola al paciente con la ficha indicada y apila la queja.
     * Los demás pacientes de la cola quedan sin alteración.
     *
     * @param ficha número de ficha que se está retirando
     * @param motivo motivo de salida
     * @return la queja registrada, o null si no hay una ficha pendiente con ese número
     */
    public Queja abandonar(String ficha, String motivo) {
        Paciente paciente = gestor.getColaRegular().eliminarPorFicha(ficha);
        if (paciente == null) {
            paciente = gestor.getColaPreferencial().eliminarPorFicha(ficha);
        }
        if (paciente == null) {
            return null;
        }
        return pilaQuejas.registrarAbandono(paciente, motivo);
    }

    public PilaQuejas getPilaQuejas() {
        return pilaQuejas;
    }
}
