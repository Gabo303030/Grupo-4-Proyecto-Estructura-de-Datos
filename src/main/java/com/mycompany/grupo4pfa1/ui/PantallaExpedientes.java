package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.estructuras.listas.ExpedienteUnico;
import com.mycompany.grupo4pfa1.estructuras.listas.ListaCircular;
import com.mycompany.grupo4pfa1.estructuras.listas.NodoDoble;
import com.mycompany.grupo4pfa1.estructuras.listas.NodoSimple;
import com.mycompany.grupo4pfa1.modelo.Expediente;
import com.mycompany.grupo4pfa1.servicio.GestorCitas;

/**
 * Pantalla de la Consulta de Expediente Único de Pacientes: muestra los
 * expedientes uno por uno y, por ser una Lista Doble Circular, permite
 * avanzar al siguiente y devolverse al anterior.
 *
 * @author Daniela Villegas
 */
public class PantallaExpedientes {

    private Consola consola;
    private GestorCitas gestorCitas;

    public PantallaExpedientes(Consola consola, GestorCitas gestorCitas) {
        this.consola = consola;
        this.gestorCitas = gestorCitas;
    }

    /**
     * Navega los expedientes hacia adelante y hacia atrás hasta que el
     * usuario elija Regresar.
     */
    public void consultarExpedientes() {
        System.out.println("\n===== EXPEDIENTE UNICO DE PACIENTES =====");
        ExpedienteUnico expedientes = gestorCitas.getExpedienteUnico();
        if (expedientes.estaVacia()) {
            System.out.println("No hay expedientes registrados.");
            return;
        }
        int total = expedientes.contarExpedientes();
        NodoDoble actual = expedientes.getPrimero();    // Empieza en la cédula menor.
        int posicion = 1;

        String opcion = "";
        while (!opcion.equals("3")) {
            System.out.println("\n--- Expediente " + posicion + " de " + total + " ---");
            mostrarExpediente(actual.getDato());

            System.out.println("\n1. Siguiente   2. Anterior   3. Regresar");
            opcion = consola.leerTexto("Seleccione una opcion: ");
            if (opcion.equals("1")) {
                actual = actual.getSiguiente();     // Del último pasa al primero (circular).
                posicion = posicion + 1;
                if (posicion > total) {
                    posicion = 1;
                }
            } else if (opcion.equals("2")) {
                actual = actual.getAnterior();      // Del primero pasa al último (circular).
                posicion = posicion - 1;
                if (posicion < 1) {
                    posicion = total;
                }
            } else if (!opcion.equals("3")) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    /**
     * Muestra la información plana del paciente y sus dos listas internas.
     *
     * @param expediente expediente a mostrar
     */
    private void mostrarExpediente(Expediente expediente) {
        System.out.println("Numero de cedula: " + expediente.getCedula());
        System.out.println("Nombre: " + expediente.getNombre());
        System.out.println("Edad: " + expediente.getEdad());
        System.out.println("Genero: " + expediente.getGenero());

        System.out.println("Historico de citas (" + expediente.getHistoricoCitas().contarCitas() + "):");
        mostrarHistorico(expediente.getHistoricoCitas());

        System.out.println("Historico de medicamentos prescritos ("
                + expediente.getHistoricoMedicamentos().contarMedicamentos() + "):");
        mostrarHistorico(expediente.getHistoricoMedicamentos());
    }

    /**
     * Le da una vuelta completa a una lista interna (Lista Simple Circular)
     * e imprime cada registro con su fecha.
     *
     * @param historico histórico de citas o de medicamentos
     */
    private void mostrarHistorico(ListaCircular historico) {
        if (historico.getPrimero() == null) {
            System.out.println("   Sin registros.");
            return;
        }
        NodoSimple aux = historico.getPrimero();
        while (aux != historico.getUltimo()) {      // Del primero al penúltimo.
            imprimirRegistro(aux);
            aux = aux.getSiguiente();
        }
        imprimirRegistro(aux);                      // El último.
    }

    private void imprimirRegistro(NodoSimple nodo) {
        System.out.println("   " + consola.formatearFecha(nodo.getDato().getFecha())
                + " - " + nodo.getDato().getDetalle());
    }
}
