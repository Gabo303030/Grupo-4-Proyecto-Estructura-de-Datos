package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.estructuras.colas.ColaPacientes;
import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.modelo.Queja;
import com.mycompany.grupo4pfa1.servicio.GestionAbandono;
import com.mycompany.grupo4pfa1.servicio.GestorAtencion;

/**
 * Pantallas de consulta del Avance 1: Mostrar Fichas Pendientes (lista las
 * dos colas) y Mostrar Quejas recibidas (lista la pila).
 * Las estructuras solo se recorren, no se modifican.
 *
 * @author Mathias Solan
 */
public class PantallaConsultas {

    private Consola consola;
    private GestorAtencion gestor;
    private GestionAbandono gestionAbandono;

    public PantallaConsultas(Consola consola, GestorAtencion gestor, GestionAbandono gestionAbandono) {
        this.consola = consola;
        this.gestor = gestor;
        this.gestionAbandono = gestionAbandono;
    }

    /**
     * Lista las fichas pendientes: en verde las de Paciente Regular y en
     * naranja las de Paciente Preferencial.
     */
    public void mostrarFichasPendientes() {
        System.out.println("\n===== FICHAS PENDIENTES =====");
        if (!gestor.hayPacientes()) {
            System.out.println("No hay fichas pendientes.");
            return;
        }
        System.out.println(consola.pintar("[R] Pacientes Regulares (verde)", Consola.VERDE));
        mostrarCola(gestor.getColaRegular(), "[R]", Consola.VERDE);
        System.out.println(consola.pintar("[P] Pacientes Preferenciales (naranja)", Consola.NARANJA));
        mostrarCola(gestor.getColaPreferencial(), "[P]", Consola.NARANJA);
    }

    /**
     * Recorre una cola desde el frente sin desencolar a nadie.
     *
     * @param cola cola a listar
     * @param distintivo marca que se imprime al inicio de cada ficha
     * @param color color con el que se pinta cada ficha
     */
    private void mostrarCola(ColaPacientes cola, String distintivo, String color) {
        if (cola.estaVacia()) {
            System.out.println("   Sin pacientes pendientes.");
            return;
        }
        com.mycompany.grupo4pfa1.estructuras.colas.Nodo actual = cola.getFrente();
        while (actual != null) {
            Paciente paciente = actual.getDato();
            System.out.println(consola.pintar("   " + distintivo + " Ficha # " + paciente.getNumeroFicha()
                    + " - Cedula: " + paciente.getCedula()
                    + " - Nombre: " + paciente.getNombre()
                    + " - Llegada: " + consola.formatearFecha(paciente.getFechaHoraLlegada()), color));
            actual = actual.getSiguiente();
        }
    }

    /**
     * Lista la Pila de Quejas desde la cima (la queja más reciente primero)
     * sin desapilar.
     */
    public void mostrarQuejasRecibidas() {
        System.out.println("\n===== QUEJAS RECIBIDAS =====");
        if (gestionAbandono.getPilaQuejas().esVacia()) {
            System.out.println("No hay quejas recibidas.");
            return;
        }
        com.mycompany.grupo4pfa1.estructuras.pilas.Nodo actual = gestionAbandono.getPilaQuejas().retornaCima();
        while (actual != null) {
            Queja queja = actual.getDato();
            System.out.println("Ficha # " + queja.getNumeroFicha() + " con cedula " + queja.getCedula()
                    + " abandona la cola sin ser atendido (a) a la fecha y hora "
                    + consola.formatearFecha(queja.getFechaHoraAbandono())
                    + " por el siguiente motivo " + queja.getMotivo());
            actual = actual.getAbajo();
        }
    }
}
