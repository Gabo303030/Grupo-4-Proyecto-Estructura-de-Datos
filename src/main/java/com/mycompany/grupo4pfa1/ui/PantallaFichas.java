package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.servicio.GestorAtencion;
import java.util.Date;

/**
 * Pantalla de la opción Seleccionar Ficha: asigna la ficha consecutiva
 * (R1, R2... o P1, P2...) e inserta al paciente en la cola respectiva.
 * El grupo decidió usar secuencia separada para cada tipo de ficha.
 *
 * @author Daniela Villegas
 */
public class PantallaFichas {

    private Consola consola;
    private GestorAtencion gestor;

    private int contadorRegular = 0;        // Consecutivo de las fichas R.
    private int contadorPreferencial = 0;   // Consecutivo de las fichas P.

    public PantallaFichas(Consola consola, GestorAtencion gestor) {
        this.consola = consola;
        this.gestor = gestor;
    }

    /**
     * Pide el tipo de paciente, la cédula y el nombre; genera la ficha y
     * encola al paciente con su fecha y hora de llegada.
     */
    public void seleccionarFicha() {
        System.out.println("\n===== SELECCIONAR FICHA =====");
        System.out.println("1. Paciente Regular");
        System.out.println("2. Paciente Preferencial");
        int tipo = consola.leerEntero("Seleccione el tipo de paciente: ", 1, 2);
        String cedula = consola.leerCedula("Numero de cedula del paciente: ");
        String nombre = consola.leerObligatorio("Nombre del paciente: ");

        Paciente paciente = new Paciente();
        paciente.setCedula(cedula);
        paciente.setNombre(nombre);
        paciente.setFechaHoraLlegada(new Date());   // Calculado por el sistema.

        if (tipo == 1) {
            contadorRegular++;
            paciente.setTipoPaciente(Paciente.REGULAR);
            paciente.setNumeroFicha("R" + contadorRegular);
        } else {
            contadorPreferencial++;
            paciente.setTipoPaciente(Paciente.PREFERENCIAL);
            paciente.setNumeroFicha("P" + contadorPreferencial);
        }
        gestor.agregarPaciente(paciente);

        System.out.println("Su numero de ficha es la: " + paciente.getNumeroFicha());
    }
}
