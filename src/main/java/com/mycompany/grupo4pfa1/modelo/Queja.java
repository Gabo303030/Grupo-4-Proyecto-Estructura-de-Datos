package com.mycompany.grupo4pfa1.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Registro de un paciente que abandonó la cola sin ser atendido.
 * Es la información que se guarda en el nodo de la Pila de Quejas.
 *
 * @author Gabriel Alvarez
 */
public class Queja {
    private String numeroFicha;
    private String cedula;
    private String nombre;
    private String motivo;
    private Date fechaHoraAbandono;

    public Queja() {
    }

    /**
     * Crea la queja con los datos del paciente. La fecha y hora del abandono
     * la calcula el sistema.
     *
     * @param paciente paciente que abandona la cola
     * @param motivo motivo de salida
     */
    public Queja(Paciente paciente, String motivo) {
        this.numeroFicha = paciente.getNumeroFicha();
        this.cedula = paciente.getCedula();
        this.nombre = paciente.getNombre();
        this.motivo = motivo;
        this.fechaHoraAbandono = new Date();
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public Date getFechaHoraAbandono() {
        return fechaHoraAbandono;
    }

    @Override
    public String toString() {
        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fechaHoraAbandono);
        return "Ficha # " + numeroFicha + " con cedula " + cedula
                + " abandona la cola sin ser atendido (a) a la fecha y hora "
                + fecha + " por el siguiente motivo " + motivo;
    }
}
