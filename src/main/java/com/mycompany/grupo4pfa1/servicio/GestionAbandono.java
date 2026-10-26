package com.mycompany.grupo4pfa1.servicio;

import com.mycompany.grupo4pfa1.estructuras.Cola;
import com.mycompany.grupo4pfa1.estructuras.Nodo;
import com.mycompany.grupo4pfa1.estructuras.Pila;
import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.modelo.Queja;

/**
 * Retira pacientes que abandonan la cola y registra su queja en la pila.
 * Usa las mismas colas de GestorAtencion para no duplicar pacientes.
 */
public class GestionAbandono {

    private final GestorAtencion gestor;
    private final Pila<Queja> pilaQuejas;

    public GestionAbandono(GestorAtencion gestor) {
        this.gestor = gestor;
        this.pilaQuejas = new Pila<>();
    }

    /**
     * Retira de su cola al paciente con la ficha indicada y apila la queja.
     *
     * @return la queja registrada, o null si no hay una ficha pendiente con ese número
     */
    public Queja abandonar(String ficha, String motivo) {
        if (ficha == null || motivo == null) {
            return null;
        }
        Paciente paciente = retirarPorFicha(gestor.getColaRegular(), ficha);
        if (paciente == null) {
            paciente = retirarPorFicha(gestor.getColaPreferencial(), ficha);
        }
        if (paciente == null) {
            return null;
        }
        Queja queja = new Queja(paciente, motivo.trim());
        pilaQuejas.apilar(queja);
        return queja;
    }

    /**
     * Busca la ficha recorriendo la cola sin modificarla.
     */
    private Paciente buscarPorFicha(Cola<Paciente> cola, String ficha) {
        Nodo<Paciente> actual = cola.getFrente();
        while (actual != null) {
            Paciente paciente = actual.getDato();
            if (paciente != null && ficha.trim().equalsIgnoreCase(paciente.getNumeroFicha())) {
                return paciente;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Retira al paciente rotando la cola una vuelta completa: cada paciente se
     * desencola y se vuelve a encolar, excepto el que abandona. Así se conserva
     * el orden de los demás usando solo operaciones FIFO.
     */
    private Paciente retirarPorFicha(Cola<Paciente> cola, String ficha) {
        Paciente encontrado = buscarPorFicha(cola, ficha);
        if (encontrado == null) {
            return null;
        }
        int cantidad = cola.getTamano();
        for (int i = 0; i < cantidad; i++) {
            Paciente paciente = cola.desencolar();
            if (paciente != encontrado) {
                cola.encolar(paciente);
            }
        }
        return encontrado;
    }

    public Pila<Queja> getPilaQuejas() {
        return pilaQuejas;
    }
}
