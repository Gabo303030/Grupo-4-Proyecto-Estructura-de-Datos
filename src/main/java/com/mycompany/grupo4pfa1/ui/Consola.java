package com.mycompany.grupo4pfa1.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Utilidades de consola que comparten todas las pantallas: lectura de datos
 * validados con Scanner, colores y formato de fechas.
 *
 * @author Daniela Villegas
 */
public class Consola {

    // Códigos ANSI para pintar el texto en la ventana Output. Naranja y amarillo usan el
    // mismo código básico (nunca salen en la misma pantalla) y cada línea lleva además su distintivo.
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String NARANJA = "\u001B[33m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String ROJO = "\u001B[31m";

    private Scanner entrada = new Scanner(System.in);
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * Muestra un mensaje y lee una línea de texto.
     *
     * @param mensaje texto que se le muestra al usuario
     * @return lo digitado, sin espacios al inicio ni al final
     */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    /**
     * Lee un texto que no puede quedar vacío. Repite la pregunta hasta que
     * el usuario digite algo.
     *
     * @param mensaje texto que se le muestra al usuario
     * @return el texto digitado
     */
    public String leerObligatorio(String mensaje) {
        String texto = leerTexto(mensaje);
        while (texto.isEmpty()) {
            System.out.println("Este dato es obligatorio.");
            texto = leerTexto(mensaje);
        }
        return texto;
    }

    /**
     * Lee una cédula: solo dígitos (sin guiones ni espacios), máximo 15.
     *
     * @param mensaje texto que se le muestra al usuario
     * @return la cédula digitada
     */
    public String leerCedula(String mensaje) {
        String cedula = leerTexto(mensaje);
        while (!cedula.matches("[0-9]{1,15}")) {
            System.out.println("Cedula invalida. Digite solo numeros, sin guiones ni espacios.");
            cedula = leerTexto(mensaje);
        }
        return cedula;
    }

    /**
     * Lee un número entero dentro de un rango.
     *
     * @param mensaje texto que se le muestra al usuario
     * @param minimo valor mínimo permitido
     * @param maximo valor máximo permitido
     * @return el número digitado
     */
    public int leerEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            String texto = leerTexto(mensaje);
            try {
                int numero = Integer.parseInt(texto);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                // No era un número: se vuelve a preguntar.
            }
            System.out.println("Valor invalido. Digite un numero entre " + minimo + " y " + maximo + ".");
        }
    }

    /**
     * Pinta un texto con el color indicado.
     *
     * @param texto texto a pintar
     * @param color una de las constantes de color de esta clase
     * @return el texto con los códigos de color
     */
    public String pintar(String texto, String color) {
        return color + texto + RESET;
    }

    /**
     * Da formato dd/MM/yyyy HH:mm:ss a una fecha (timestamp).
     *
     * @param fecha fecha a mostrar
     * @return la fecha en texto
     */
    public String formatearFecha(Date fecha) {
        return formatoFecha.format(fecha);
    }
}
