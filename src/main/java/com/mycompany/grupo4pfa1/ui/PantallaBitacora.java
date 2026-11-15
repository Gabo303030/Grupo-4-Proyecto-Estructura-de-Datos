package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.estructuras.listas.Nodo;
import com.mycompany.grupo4pfa1.modelo.CitaBitacora;
import com.mycompany.grupo4pfa1.servicio.GestorCitas;

/**
 * Pantalla de la Consulta de Bitácora de Citas del día: lista las citas
 * atendidas en la sesión (Lista Simple ordenada por cédula) y las pinta
 * según el tiempo que esperó el paciente.
 *
 * @author Mathias Solan
 */
public class PantallaBitacora {

    private Consola consola;
    private GestorCitas gestorCitas;

    public PantallaBitacora(Consola consola, GestorCitas gestorCitas) {
        this.consola = consola;
        this.gestorCitas = gestorCitas;
    }

    /**
     * Imprime la bitácora: verde hasta 30 segundos de espera, amarillo más
     * de 30 segundos y menos de 1 minuto, rojo de 1 minuto en adelante.
     */
    public void mostrarBitacora() {
        System.out.println("\n===== BITACORA DE CITAS DEL DIA =====");
        if (gestorCitas.getBitacora().estaVacia()) {
            System.out.println("No se han atendido citas en esta sesion.");
            return;
        }
        System.out.println("Tiempo de espera: " + consola.pintar("[VERDE] hasta 30 s", Consola.VERDE) + "  "
                + consola.pintar("[AMARILLO] mas de 30 s y menos de 1 min", Consola.AMARILLO) + "  "
                + consola.pintar("[ROJO] 1 min o mas", Consola.ROJO));

        Nodo auxiliar = gestorCitas.getBitacora().getCabeza();
        while (auxiliar != null) {
            CitaBitacora cita = auxiliar.getDato();
            long segundos = cita.getSegundosEspera();
            String distintivo;
            String color;
            if (segundos <= 30) {
                distintivo = "[VERDE]";
                color = Consola.VERDE;
            } else if (segundos < 60) {
                distintivo = "[AMARILLO]";
                color = Consola.AMARILLO;
            } else {
                distintivo = "[ROJO]";
                color = Consola.ROJO;
            }
            System.out.println(consola.pintar(distintivo + " Cedula: " + cita.getCedula()
                    + " - Nombre: " + cita.getNombre()
                    + " - Ficha # " + cita.getNumeroFicha()
                    + " - Llegada: " + consola.formatearFecha(cita.getFechaLlegada())
                    + " - Atencion: " + consola.formatearFecha(cita.getFechaAtencion())
                    + " - Espera: " + segundos + " s", color));
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("Total de citas atendidas: " + gestorCitas.getBitacora().contarCitas());
    }
}
