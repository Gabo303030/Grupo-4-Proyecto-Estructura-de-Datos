package com.mycompany.grupo4pfa1.servicio;

import com.mycompany.grupo4pfa1.estructuras.colas.ColaPacientes;
import com.mycompany.grupo4pfa1.modelo.Paciente;

/**
 * Administra las dos colas de pacientes (regulares y preferenciales)
 * y el orden de atención: cada 2 pacientes preferenciales se atiende
 * un paciente regular (P, P, R).
 *
 * @author Jonathan Umaña Rivera
 */
public class GestorAtencion {

    private static final int PREFERENCIALES_POR_REGULAR = 2;

    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;
    private int preferencialesSeguidos;     // Preferenciales atendidos desde el último regular.

    public GestorAtencion() {
        colaRegular = new ColaPacientes();
        colaPreferencial = new ColaPacientes();
        preferencialesSeguidos = 0;
    }

    /**
     * Inserta al paciente al final de la cola que le corresponde.
     *
     * @param paciente paciente con su ficha ya asignada
     */
    public void agregarPaciente(Paciente paciente) {
        if (paciente.isPreferencial()) {
            colaPreferencial.encolar(paciente);
        } else {
            colaRegular.encolar(paciente);
        }
    }

    /**
     * Indica si queda algún paciente esperando en cualquiera de las dos colas.
     *
     * @return true si hay pacientes pendientes
     */
    public boolean hayPacientes() {
        return !colaPreferencial.estaVacia() || !colaRegular.estaVacia();
    }

    /**
     * Saca de su cola al siguiente paciente según la regla P, P, R.
     * La regla aplica cuando hay pacientes mezclados: si una de las colas
     * está vacía, se atiende de la otra. El doctor no sabe de cuál cola viene.
     *
     * @return el paciente que pasa a consulta, o null si no hay pacientes en espera
     */
    public Paciente atenderPaciente() {
        boolean hayPreferencial = !colaPreferencial.estaVacia();
        boolean hayRegular = !colaRegular.estaVacia();

        if (hayPreferencial && (preferencialesSeguidos < PREFERENCIALES_POR_REGULAR || !hayRegular)) {
            preferencialesSeguidos++;
            return colaPreferencial.atenderSiguiente();
        }
        if (hayRegular) {
            preferencialesSeguidos = 0;
            return colaRegular.atenderSiguiente();
        }
        return null;
    }

    public ColaPacientes getColaRegular() {
        return colaRegular;
    }

    public ColaPacientes getColaPreferencial() {
        return colaPreferencial;
    }
}
