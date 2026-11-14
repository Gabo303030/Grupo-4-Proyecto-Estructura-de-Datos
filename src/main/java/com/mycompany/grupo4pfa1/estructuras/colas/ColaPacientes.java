package com.mycompany.grupo4pfa1.estructuras.colas;

import com.mycompany.grupo4pfa1.modelo.Paciente;

/**
 * Cola de pacientes del hospital "Su Salud".
 * Hereda de la ColaDinamica vista en clase y le agrega los métodos que
 * ocupa el proyecto, reutilizando encolar y desencolar del profesor.
 *
 * @author Jonathan Umaña Rivera
 */
public class ColaPacientes extends ColaDinamica {

    public ColaPacientes() {
        super();
    }

    /**
     * Saca al paciente del frente reutilizando desencolar.
     *
     * @return el paciente que sigue, o null si la cola está vacía
     */
    public Paciente atenderSiguiente(){
        try{
            return this.desencolar();
        }
        catch (Exception e){    // La cola está vacía.
            return null;
        }
    }

    /**
     * Cuenta los pacientes pendientes recorriendo la cola sin alterarla.
     *
     * @return cantidad de pacientes en la cola
     */
    public int contarPacientes(){
        int cuenta = 0;
        Nodo temp = this.getFrente();
        while (temp != null){
            cuenta = cuenta + 1;
            temp = temp.getSiguiente();
        }
        return cuenta;
    }

    /**
     * Busca un paciente por número de ficha sin alterar la cola.
     *
     * @param numeroFicha ficha a buscar, por ejemplo R1 o P2
     * @return el paciente encontrado, o null si la ficha no está en la cola
     */
    public Paciente buscarPorFicha(String numeroFicha){
        Nodo temp = this.getFrente();
        while (temp != null){
            if (temp.getDato().getNumeroFicha().equalsIgnoreCase(numeroFicha)){
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    /**
     * Elimina de la cola al paciente con la ficha indicada (abandono).
     * Le da una vuelta completa a la cola: cada paciente se desencola y se
     * vuelve a encolar, excepto el que se retira. Así los demás quedan en el
     * mismo orden (Primero en llegar, primero en salir).
     *
     * @param numeroFicha ficha del paciente que abandona
     * @return el paciente eliminado, o null si la ficha no está en la cola
     */
    public Paciente eliminarPorFicha(String numeroFicha){
        Paciente encontrado = this.buscarPorFicha(numeroFicha);
        if (encontrado == null){
            return null;
        }
        int cantidad = this.contarPacientes();
        for (int i = 0; i < cantidad; i++){
            Paciente actual = this.atenderSiguiente();   // Reutiliza desencolar.
            if (actual != encontrado){
                this.encolar(actual);                    // Reutiliza encolar.
            }
        }
        return encontrado;
    }

}
