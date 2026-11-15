package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.modelo.Queja;
import com.mycompany.grupo4pfa1.servicio.GestionAbandono;

/**
 * Pantalla de la opción Abandonar Cola de Pacientes: pide la ficha y el
 * motivo, elimina al paciente de la cola y registra la queja en la pila.
 *
 * @author Gabriel Alvarez
 */
public class PantallaAbandono {

    private Consola consola;
    private GestionAbandono gestionAbandono;

    public PantallaAbandono(Consola consola, GestionAbandono gestionAbandono) {
        this.consola = consola;
        this.gestionAbandono = gestionAbandono;
    }

    /**
     * Registra el abandono de un paciente y su motivo de salida.
     */
    public void abandonarCola() {
        System.out.println("\n===== ABANDONAR COLA DE PACIENTES =====");
        String ficha = consola.leerObligatorio("Numero de ficha que se retira (ejemplo R1 o P1): ");
        String motivo = consola.leerObligatorio("Motivo de salida: ");

        Queja queja = gestionAbandono.abandonar(ficha, motivo);
        if (queja == null) {
            System.out.println("No se encontro una ficha pendiente con ese numero.");
        } else {
            System.out.println("Ficha # " + queja.getNumeroFicha() + " con cedula " + queja.getCedula()
                    + " abandona la cola sin ser atendido (a).");
        }
    }
}
