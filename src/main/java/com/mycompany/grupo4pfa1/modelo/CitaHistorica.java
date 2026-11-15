package com.mycompany.grupo4pfa1.modelo;

import java.util.Date;

/**
 * Cita realizada a un paciente. Se guarda en el Histórico de Citas del expediente.
 *
 * @author Gabriel Alvarez
 */
public class CitaHistorica extends RegistroHistorico {
    private String nombreDoctor;
    private String diagnostico;

    public CitaHistorica() {
    }

    public CitaHistorica(Date fecha, String nombreDoctor, String diagnostico) {
        super(fecha);
        this.nombreDoctor = nombreDoctor;
        this.diagnostico = diagnostico;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String getDetalle() {
        return "Doctor (a): " + nombreDoctor + " - Diagnostico: " + diagnostico;
    }
}
