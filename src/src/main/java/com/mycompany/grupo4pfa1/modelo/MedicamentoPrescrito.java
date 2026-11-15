package com.mycompany.grupo4pfa1.modelo;

import java.util.Date;

/**
 * Medicamento prescrito a un paciente. Se guarda en el Histórico de
 * Medicamentos Prescritos del expediente.
 *
 * @author Gabriel Alvarez
 */
public class MedicamentoPrescrito extends RegistroHistorico {
    private String medicamento;

    public MedicamentoPrescrito() {
    }

    public MedicamentoPrescrito(Date fecha, String medicamento) {
        super(fecha);
        this.medicamento = medicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String getDetalle() {
        return "Medicamento: " + medicamento;
    }
}
