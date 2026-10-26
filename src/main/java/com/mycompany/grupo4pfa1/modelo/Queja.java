package com.mycompany.grupo4pfa1.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Registro de un abandono. */
public class Queja {
    private final String numeroFicha;
    private final String cedula;
    private final String nombre;
    private final String motivo;
    private final Date fechaHoraAbandono;

    public Queja(Paciente paciente, String motivo) {
        this.numeroFicha = paciente.getNumeroFicha();
        this.cedula = paciente.getCedula();
        this.nombre = paciente.getNombre();
        this.motivo = motivo;
        this.fechaHoraAbandono = new Date();
    }

    public String getNumeroFicha() { return numeroFicha; }
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getMotivo() { return motivo; }
    public Date getFechaHoraAbandono() { return new Date(fechaHoraAbandono.getTime()); }

    @Override
    public String toString() {
        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fechaHoraAbandono);
        return "Ficha #" + numeroFicha + " con cédula " + cedula
                + " abandona la cola sin ser atendido(a) a la fecha y hora "
                + fecha + " por el siguiente motivo: " + motivo;
    }
}
