package com.mycompany.grupo4pfa1.modelo;

import java.util.Date;

/**
 * Datos de un paciente que llega a solicitar ficha.
 *
 * @author daniv
 */
public class Paciente {

    public static final String REGULAR = "Regular";
    public static final String PREFERENCIAL = "Preferencial";

    private String numeroFicha;
    private String cedula;
    private String nombre;
    private Date fechaHoraLlegada;
    private String tipoPaciente;

    public Paciente() {
    }

    public Paciente(String numeroFicha, String cedula, String nombre, Date fechaHoraLlegada, String tipoPaciente) {
        this.numeroFicha = numeroFicha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.tipoPaciente = tipoPaciente;
    }

    public boolean isPreferencial() {
        return PREFERENCIAL.equals(tipoPaciente);
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

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
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

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }
}
