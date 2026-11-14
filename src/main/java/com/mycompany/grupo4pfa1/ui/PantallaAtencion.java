package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.modelo.Expediente;
import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.servicio.GestorAtencion;
import com.mycompany.grupo4pfa1.servicio.GestorCitas;
import java.util.Date;

/**
 * Pantalla de la opción Atender Paciente. Saca de la cola al paciente que
 * corresponde (Avance 1) y continúa con el flujo de la cita del doctor:
 * expediente, datos de la cita y medicamentos prescritos (Avance 2).
 *
 * @author Jonathan Umaña Rivera
 */
public class PantallaAtencion {

    private Consola consola;
    private GestorAtencion gestor;
    private GestorCitas gestorCitas;

    public PantallaAtencion(Consola consola, GestorAtencion gestor, GestorCitas gestorCitas) {
        this.consola = consola;
        this.gestor = gestor;
        this.gestorCitas = gestorCitas;
    }

    /**
     * Flujo completo de la cita: recibe al paciente, muestra o crea su
     * expediente, registra la cita y los medicamentos, y guarda todo en las
     * estructuras de datos.
     */
    public void atenderPaciente() {
        System.out.println("\n===== ATENDER PACIENTE =====");
        Paciente paciente = gestor.atenderPaciente();   // Saca de la cola al que corresponde (P, P, R).
        if (paciente == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        Date fechaAtencion = new Date();    // Momento en que el doctor recibe al paciente.

        System.out.println("Ficha # " + paciente.getNumeroFicha() + " con cedula " + paciente.getCedula()
                + " pasar a consulta medica.");

        // a. Datos registrados al seleccionar la ficha.
        System.out.println("\n--- Datos de la ficha ---");
        System.out.println("Numero de ficha: " + paciente.getNumeroFicha());
        System.out.println("Cedula: " + paciente.getCedula());
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Fecha y hora de llegada: " + consola.formatearFecha(paciente.getFechaHoraLlegada()));

        // b y c. Revisar si el paciente ya tiene expediente.
        Expediente expediente = gestorCitas.buscarExpediente(paciente.getCedula());
        if (expediente == null) {
            System.out.println("\nPaciente " + paciente.getNombre() + " asiste a consulta por primera vez.");
            System.out.println("--- Datos para crear el expediente ---");
            int edad = consola.leerEntero("Edad: ", 0, 120);
            String genero = leerGenero();
            expediente = gestorCitas.crearExpediente(paciente, edad, genero);
        } else {
            System.out.println("\n--- Expediente del paciente ---");
            System.out.println("Numero de cedula: " + expediente.getCedula());
            System.out.println("Nombre: " + expediente.getNombre());
            System.out.println("Edad: " + expediente.getEdad());
            System.out.println("Genero: " + expediente.getGenero());
        }

        // d. Datos de la cita actual.
        System.out.println("\n--- Datos de la cita ---");
        String nombreDoctor = consola.leerObligatorio("Nombre del doctor (a) que atiende: ");
        String diagnostico = consola.leerObligatorio("Diagnostico: ");

        // e. Guardar la cita en el expediente y en la bitácora del día.
        gestorCitas.registrarCita(paciente, expediente, fechaAtencion, nombreDoctor, diagnostico);

        // d. Medicamentos prescritos (puede ser ninguno, uno o varios).
        System.out.println("\n--- Medicamentos prescritos ---");
        String medicamento = consola.leerTexto("Medicamento (deje vacio y presione Enter para terminar): ");
        while (!medicamento.isEmpty()) {
            gestorCitas.registrarMedicamento(expediente, medicamento);
            medicamento = consola.leerTexto("Otro medicamento (deje vacio y presione Enter para terminar): ");
        }

        // g. Mensaje final.
        System.out.println("\nPaciente " + paciente.getNombre() + ", su cita ha concluido.");
    }

    /**
     * Pide el género del paciente con un menú corto.
     *
     * @return el género seleccionado
     */
    private String leerGenero() {
        System.out.println("Genero: 1. Masculino  2. Femenino  3. Otro");
        int opcion = consola.leerEntero("Seleccione el genero: ", 1, 3);
        if (opcion == 1) {
            return "Masculino";
        } else if (opcion == 2) {
            return "Femenino";
        }
        return "Otro";
    }
}
