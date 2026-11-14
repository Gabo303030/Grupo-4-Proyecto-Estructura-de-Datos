package com.mycompany.grupo4pfa1.servicio;

import com.mycompany.grupo4pfa1.estructuras.listas.BitacoraCitas;
import com.mycompany.grupo4pfa1.estructuras.listas.ExpedienteUnico;
import com.mycompany.grupo4pfa1.modelo.CitaBitacora;
import com.mycompany.grupo4pfa1.modelo.CitaHistorica;
import com.mycompany.grupo4pfa1.modelo.Expediente;
import com.mycompany.grupo4pfa1.modelo.MedicamentoPrescrito;
import com.mycompany.grupo4pfa1.modelo.Paciente;
import java.util.Date;

/**
 * Distribuye los datos de cada cita en las estructuras del Avance 2:
 * el Expediente Único de Pacientes (con sus listas internas) y la
 * Bitácora de Citas del día.
 *
 * @author Jonathan Umaña Rivera
 */
public class GestorCitas {

    private ExpedienteUnico expedienteUnico;
    private BitacoraCitas bitacora;

    public GestorCitas() {
        expedienteUnico = new ExpedienteUnico();
        bitacora = new BitacoraCitas();
    }

    /**
     * Busca el expediente de un paciente.
     *
     * @param cedula cédula del paciente
     * @return el expediente, o null si asiste a consulta por primera vez
     */
    public Expediente buscarExpediente(String cedula) {
        return expedienteUnico.buscarPorCedula(cedula);
    }

    /**
     * Crea el expediente de un paciente que asiste por primera vez y lo
     * inserta en el Expediente Único ordenado por cédula.
     *
     * @param paciente paciente que está siendo atendido
     * @param edad edad indicada por el doctor
     * @param genero género indicado por el doctor
     * @return el expediente recién creado
     */
    public Expediente crearExpediente(Paciente paciente, int edad, String genero) {
        Expediente expediente = new Expediente(paciente.getCedula(), paciente.getNombre(), edad, genero);
        expedienteUnico.registrarExpediente(expediente);
        return expediente;
    }

    /**
     * Guarda la cita actual: la agrega al histórico de citas del expediente
     * y alimenta la bitácora de citas del día.
     *
     * @param paciente paciente atendido (datos de la ficha)
     * @param expediente expediente del paciente
     * @param fechaAtencion fecha y hora en que el doctor recibió al paciente
     * @param nombreDoctor doctor que lo atendió
     * @param diagnostico diagnóstico en texto abierto
     */
    public void registrarCita(Paciente paciente, Expediente expediente, Date fechaAtencion,
            String nombreDoctor, String diagnostico) {
        expediente.getHistoricoCitas().agregarCita(
                new CitaHistorica(fechaAtencion, nombreDoctor, diagnostico));
        bitacora.registrarCita(new CitaBitacora(paciente.getNumeroFicha(), paciente.getCedula(),
                paciente.getNombre(), paciente.getFechaHoraLlegada(), fechaAtencion));
    }

    /**
     * Agrega un medicamento al histórico de medicamentos del expediente.
     * La fecha de prescripción la calcula el sistema.
     *
     * @param expediente expediente del paciente
     * @param medicamento medicamento prescrito
     */
    public void registrarMedicamento(Expediente expediente, String medicamento) {
        expediente.getHistoricoMedicamentos().agregarMedicamento(
                new MedicamentoPrescrito(new Date(), medicamento));
    }

    public ExpedienteUnico getExpedienteUnico() {
        return expedienteUnico;
    }

    public BitacoraCitas getBitacora() {
        return bitacora;
    }
}
