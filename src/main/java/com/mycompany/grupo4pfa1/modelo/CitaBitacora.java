package com.mycompany.grupo4pfa1.modelo;

import java.util.Date;

/**
 * Cita atendida en la sesión. Es la información que se guarda en el nodo
 * de la Bitácora de Citas del día (Lista Simple).
 *
 * @author Mathias Solan
 */
public class CitaBitacora {
    private String numeroFicha;
    private String cedula;
    private String nombre;
    private Date fechaLlegada;
    private Date fechaAtencion;

    public CitaBitacora() {
    }

    public CitaBitacora(String numeroFicha, String cedula, String nombre, Date fechaLlegada, Date fechaAtencion) {
        this.numeroFicha = numeroFicha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
    }

    /**
     * Cédula como número, para ordenar la bitácora de menor a mayor.
     *
     * @return la cédula convertida a número
     */
    public long getCedulaNumerica() {
        return Paciente.cedulaANumero(cedula);
    }

    /**
     * Tiempo que el paciente esperó en la cola: desde que tomó la ficha
     * hasta que el doctor lo recibió.
     *
     * @return segundos de espera
     */
    public long getSegundosEspera() {
        return (fechaAtencion.getTime() - fechaLlegada.getTime()) / 1000;
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

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
}
