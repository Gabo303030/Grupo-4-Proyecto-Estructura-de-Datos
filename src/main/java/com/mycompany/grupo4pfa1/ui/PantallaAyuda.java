package com.mycompany.grupo4pfa1.ui;

/**
 * Pantalla de la opción Ayuda: versión de la herramienta y personas que
 * desarrollaron la solución.
 *
 * @author Mathias Solan
 */
public class PantallaAyuda {

    /** N se incrementa con cada avance interno del desarrollo. */
    public static final String VERSION = "Avance 2 V 2.0.1";

    /**
     * Muestra la versión y los integrantes que serán evaluados.
     */
    public void mostrarAyuda() {
        System.out.println("\n===== AYUDA =====");
        System.out.println("Version de la herramienta: " + VERSION);
        System.out.println("Desarrollado por: Grupo 4");
        System.out.println(" - Jonathan Umaña Rivera");
        System.out.println(" - Daniela Villegas");
        System.out.println(" - Mathias Solan");
        System.out.println(" - Gabriel Alvarez");
    }
}
