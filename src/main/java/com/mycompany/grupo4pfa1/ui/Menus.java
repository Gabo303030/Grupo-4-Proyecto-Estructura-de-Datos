package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.modelo.Paciente;
import com.mycompany.grupo4pfa1.servicio.GestorAtencion;
import com.mycompany.grupo4pfa1.servicio.GestionAbandono;
import com.mycompany.grupo4pfa1.modelo.Queja;
import com.mycompany.grupo4pfa1.estructuras.Nodo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Menús de consola del sistema de atención de pacientes.
 *
 * @author daniv
 */
public class Menus {

    private Scanner entrada = new Scanner(System.in);

    private GestorAtencion gestor = new GestorAtencion();
    private GestionAbandono gestionAbandono = new GestionAbandono(gestor);

    private int contadorRegular = 0;
    private int contadorPreferencial = 0;

    public void menuPrincipal() {
        System.out.println("Bienvenido al sistema de atencion de pacientes del Hospital");

        String opcion = "";
        while (!opcion.equals("3")) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestion de llegada de Pacientes");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextLine();

            boolean valida = false;
            if (opcion.equals("1")) {
                valida = true;
                menuGestionLlegada();
            }
            if (opcion.equals("2")) {
                valida = true;
                ayuda();
            }
            if (opcion.equals("3")) {
                valida = true;
                System.out.println("Saliendo del sistema...");
            }
            if (!valida) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    public void menuGestionLlegada() {
        String opcion = "";
        while (!opcion.equals("6")) {
            System.out.println("\n===== GESTIONAR LLEGADA DE PACIENTES =====");
            System.out.println("1. Seleccionar Ficha");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Abandonar Cola de Pacientes");
            System.out.println("4. Mostrar Fichas Pendientes");
            System.out.println("5. Mostrar Quejas recibidas");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextLine();

            boolean valida = false;
            if (opcion.equals("1")) {
                valida = true;
                seleccionarFicha();
            }
            if (opcion.equals("2")) {
                valida = true;
                System.out.println(gestor.atenderPacienteMensaje());
            }
            if (opcion.equals("3")) {
                valida = true;
                abandonarCola();
            }
            if (opcion.equals("4")) {
                valida = true;
                mostrarFichasPendientes();
            }
            if (opcion.equals("5")) {
                valida = true;
                mostrarQuejasRecibidas();
            }
            if (opcion.equals("6")) {
                valida = true;
                System.out.println("Regresando al menu principal...");
            }
            if (!valida) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    public void seleccionarFicha() {
        try {
            System.out.println("Tipo de paciente: 1. Paciente Regular  2. Paciente Preferencial");
            System.out.print("Seleccione el tipo: ");
            String tipo = entrada.nextLine();

            if (!tipo.equals("1") && !tipo.equals("2")) {
                throw new Exception("Tipo de paciente invalido!");
            }

            System.out.print("Cedula: ");
            String cedula = entrada.nextLine();
            if (cedula.isEmpty()) {
                throw new Exception("Debe digitar la cedula!");
            }

            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();
            if (nombre.isEmpty()) {
                throw new Exception("Debe digitar el nombre!");
            }

            Paciente paciente = new Paciente();
            paciente.setCedula(cedula);
            paciente.setNombre(nombre);
            paciente.setFechaHoraLlegada(new Date());

            if (tipo.equals("1")) {
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

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ayuda() {
        System.out.println("\n===== AYUDA =====");
        System.out.println("Version de la herramienta: Avance 1 V 1.0.1");
        System.out.println("Desarrollado por: Grupo 4");
        System.out.println("Integrantes: completar con los nombres del grupo antes de entregar.");
    }
   
    /** Muestra las fichas pendientes sin desencolar pacientes. */
    public void mostrarFichasPendientes() {
        System.out.println("\n===== FICHAS PENDIENTES =====");
        if (gestor.getColaRegular().estaVacia() && gestor.getColaPreferencial().estaVacia()) {
            System.out.println("No hay fichas pendientes.");
            return;
        }
        System.out.println("[REGULAR]");
        mostrarCola(gestor.getColaRegular().getFrente());
        System.out.println("[PREFERENCIAL]");
        mostrarCola(gestor.getColaPreferencial().getFrente());
    }

    private void mostrarCola(Nodo<Paciente> actual) {
        if (actual == null) System.out.println("Sin pacientes pendientes.");
        while (actual != null) {
            Paciente paciente = actual.getDato();
            System.out.println("Ficha #" + paciente.getNumeroFicha() + " - Cedula: "
                    + paciente.getCedula() + " - Nombre: " + paciente.getNombre());
            actual = actual.getSiguiente();
        }
    }

    /** Recorre la pila sin desapilar las quejas. */
    public void mostrarQuejasRecibidas() {
        System.out.println("\n===== QUEJAS RECIBIDAS =====");
        Nodo<Queja> actual = gestionAbandono.getPilaQuejas().getCima();
        if (actual == null) {
            System.out.println("No hay quejas recibidas.");
            return;
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (actual != null) {
            Queja queja = actual.getDato();
            System.out.println("Ficha #" + queja.getNumeroFicha() + " con cedula "
                    + queja.getCedula() + " abandona la cola sin ser atendido(a) a la fecha y hora "
                    + formato.format(queja.getFechaHoraAbandono()) + " por el siguiente motivo: "
                    + queja.getMotivo());
            actual = actual.getSiguiente();
        }
    }

    /** Registra el abandono y su motivo en la pila de quejas. */
    public void abandonarCola() {
        System.out.print("Numero de ficha que abandona: ");
        String ficha = entrada.nextLine().trim();
        if (ficha.isEmpty()) {
            System.out.println("Debe indicar el numero de ficha.");
            return;
        }
        System.out.print("Motivo de salida: ");
        String motivo = entrada.nextLine().trim();
        if (motivo.isEmpty()) {
            System.out.println("Debe indicar el motivo de salida.");
            return;
        }
        Queja queja = gestionAbandono.abandonar(ficha, motivo);
        if (queja == null) {
            System.out.println("No se encontro una ficha pendiente con ese numero.");
        } else {
            System.out.println("Ficha #" + queja.getNumeroFicha() + " con cedula "
                    + queja.getCedula() + " abandona la cola sin ser atendido(a).");
        }
    }
}
