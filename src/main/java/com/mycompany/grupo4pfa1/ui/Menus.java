package com.mycompany.grupo4pfa1.ui;

import com.mycompany.grupo4pfa1.servicio.GestionAbandono;
import com.mycompany.grupo4pfa1.servicio.GestorAtencion;
import com.mycompany.grupo4pfa1.servicio.GestorCitas;

/**
 * Menú principal y submenú de llegada de pacientes. Cada opción se delega
 * a la pantalla que le corresponde.
 *
 * @author Daniela Villegas
 */
public class Menus {

    private Consola consola = new Consola();

    private GestorAtencion gestor = new GestorAtencion();
    private GestionAbandono gestionAbandono = new GestionAbandono(gestor);
    private GestorCitas gestorCitas = new GestorCitas();

    private PantallaFichas pantallaFichas = new PantallaFichas(consola, gestor);
    private PantallaAtencion pantallaAtencion = new PantallaAtencion(consola, gestor, gestorCitas);
    private PantallaAbandono pantallaAbandono = new PantallaAbandono(consola, gestionAbandono);
    private PantallaConsultas pantallaConsultas = new PantallaConsultas(consola, gestor, gestionAbandono);
    private PantallaBitacora pantallaBitacora = new PantallaBitacora(consola, gestorCitas);
    private PantallaExpedientes pantallaExpedientes = new PantallaExpedientes(consola, gestorCitas);
    private PantallaAyuda pantallaAyuda = new PantallaAyuda();

    /**
     * Da la bienvenida y muestra el menú principal hasta que el usuario elija Salir.
     */
    public void menuPrincipal() {
        System.out.println("Bienvenido (a) al sistema de atencion de pacientes del hospital \"Su Salud\"");

        String opcion = "";
        while (!opcion.equals("5")) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestionar Llegada de Pacientes");
            System.out.println("2. Consulta de Bitacora de Citas del dia");
            System.out.println("3. Consulta de Expediente unico de Pacientes");
            System.out.println("4. Ayuda");
            System.out.println("5. Salir");
            opcion = consola.leerTexto("Seleccione una opcion: ");

            if (opcion.equals("1")) {
                menuGestionLlegada();
            } else if (opcion.equals("2")) {
                pantallaBitacora.mostrarBitacora();
            } else if (opcion.equals("3")) {
                pantallaExpedientes.consultarExpedientes();
            } else if (opcion.equals("4")) {
                pantallaAyuda.mostrarAyuda();
            } else if (opcion.equals("5")) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opcion invalida.");
            }
        }
    }

    /**
     * Submenú Gestionar Llegada de Pacientes. La opción Regresar vuelve al menú principal.
     */
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
            opcion = consola.leerTexto("Seleccione una opcion: ");

            if (opcion.equals("1")) {
                pantallaFichas.seleccionarFicha();
            } else if (opcion.equals("2")) {
                pantallaAtencion.atenderPaciente();
            } else if (opcion.equals("3")) {
                pantallaAbandono.abandonarCola();
            } else if (opcion.equals("4")) {
                pantallaConsultas.mostrarFichasPendientes();
            } else if (opcion.equals("5")) {
                pantallaConsultas.mostrarQuejasRecibidas();
            } else if (opcion.equals("6")) {
                System.out.println("Regresando al menu principal...");
            } else {
                System.out.println("Opcion invalida.");
            }
        }
    }
}
