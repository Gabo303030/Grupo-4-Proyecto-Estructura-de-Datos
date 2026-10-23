package com.mycompany.grupo4pfa1.servicio;

import com.mycompany.grupo4pfa1.estructuras.Cola;
import com.mycompany.grupo4pfa1.modelo.Paciente;

/**
 * Administra las colas de pacientes regulares y preferenciales
 * y el orden de atención: Preferencial → Preferencial → Regular.
 */
public class GestorAtencion {

    private static final int PREFERENCIALES_POR_REGULAR = 2;

    private Cola<Paciente> colaRegular;
    private Cola<Paciente> colaPreferencial;
    private int preferencialesSeguidos;

    public GestorAtencion() {
        colaRegular = new Cola<>();
        colaPreferencial = new Cola<>();
        preferencialesSeguidos = 0;
    }

    /**
     * Inserta al paciente al final de la cola que le corresponde.
     */
    public void agregarPaciente(Paciente paciente) {
        if (paciente.isPreferencial()) {
            colaPreferencial.encolar(paciente);
        } else {
            colaRegular.encolar(paciente);
        }
    }

    /**
     * Retira de su cola al siguiente paciente según la regla P → P → R.
     * Si una de las colas está vacía, se atiende de la otra.
     *
     * @return el paciente atendido, o null si no hay pacientes en espera
     */
    public Paciente atenderPaciente() {
        boolean hayPreferencial = !colaPreferencial.estaVacia();
        boolean hayRegular = !colaRegular.estaVacia();

        if (hayPreferencial && (preferencialesSeguidos < PREFERENCIALES_POR_REGULAR || !hayRegular)) {
            preferencialesSeguidos++;
            return colaPreferencial.desencolar();
        }
        if (hayRegular) {
            preferencialesSeguidos = 0;
            return colaRegular.desencolar();
        }
        return null;
    }

    /**
     * Atiende al siguiente paciente y devuelve el mensaje a mostrar.
     */
    public String atenderPacienteMensaje() {
        Paciente paciente = atenderPaciente();
        if (paciente == null) {
            return "No hay pacientes en espera.";
        }
        return "Ficha #" + paciente.getFicha() + " con cédula " + paciente.getCedula()
                + " pasar a consulta médica.";
    }

    public Cola<Paciente> getColaRegular() {
        return colaRegular;
    }

    public Cola<Paciente> getColaPreferencial() {
        return colaPreferencial;
    }
}
