package com.mycompany.grupo4pfa1.modelo;

import java.util.Date;

/**
 * Clase padre de los registros que se guardan en las listas internas del
 * expediente (citas y medicamentos). Los dos tienen una fecha en formato
 * timestamp, por eso comparten el mismo nodo de la Lista Circular.
 *
 * @author Gabriel Alvarez
 */
public abstract class RegistroHistorico {
    private Date fecha;

    public RegistroHistorico() {
    }

    public RegistroHistorico(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Fecha como número (milisegundos), para ordenar el histórico del
     * registro más antiguo al más reciente.
     *
     * @return la fecha del registro en milisegundos
     */
    public long getMarcaTiempo() {
        return fecha.getTime();
    }

    /**
     * Texto con el detalle del registro, sin la fecha.
     *
     * @return detalle a mostrar en la consulta del expediente
     */
    public abstract String getDetalle();
}
