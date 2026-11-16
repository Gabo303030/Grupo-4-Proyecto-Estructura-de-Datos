package com.mycompany.grupo4pfa1.modelo;

import com.mycompany.grupo4pfa1.estructuras.listas.HistoricoCitas;
import com.mycompany.grupo4pfa1.estructuras.listas.HistoricoMedicamentos;

/**
 * Expediente de un paciente. Es la información que se guarda en el nodo del
 * Expediente Único de Pacientes (Lista Doble Circular) y lleva por dentro
 * sus dos listas internas (Listas Simples Circulares).
 *
 * @author Daniela Villegas
 */
public class Expediente {
    private String cedula;
    private String nombre;
    private int edad;
    private String genero;
    private HistoricoCitas historicoCitas;                  // Lista interna 1.
    private HistoricoMedicamentos historicoMedicamentos;    // Lista interna 2.

    public Expediente() {
        this.historicoCitas = new HistoricoCitas();
        this.historicoMedicamentos = new HistoricoMedicamentos();
    }

    public Expediente(String cedula, String nombre, int edad, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.historicoCitas = new HistoricoCitas();
        this.historicoMedicamentos = new HistoricoMedicamentos();
    }

    /**
     * Cédula como número, para ordenar los expedientes de menor a mayor.
     *
     * @return la cédula convertida a número
     */
    public long getCedulaNumerica() {
        return Paciente.cedulaANumero(cedula);
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public HistoricoCitas getHistoricoCitas() {
        return historicoCitas;
    }

    public HistoricoMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
