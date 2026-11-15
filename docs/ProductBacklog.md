# Product Backlog - Grupo 4

Backlog único para todo el proyecto. Los códigos US-01 a US-13 son los mismos de los issues del repositorio.

| Código | Avance | Nombre | Descripción | Responsable (s) |
|---|---|---|---|---|
| US-01 | 1 | Mostrar bienvenida y menú principal | Al ingresar, el sistema recibe al usuario con un mensaje de bienvenida y muestra el menú principal: Gestionar Llegada de Pacientes, Ayuda, Salir. | Daniela Villegas |
| US-02 | 1 | Mostrar submenú de llegada de pacientes | Submenú con: Seleccionar Ficha, Atender Paciente, Abandonar Cola de Pacientes, Mostrar Fichas Pendientes, Mostrar Quejas recibidas, Regresar. | Daniela Villegas |
| US-03 | 1 | Registrar paciente regular y generar ficha | Asigna una ficha consecutiva R1, R2, R3..., la muestra con "Su número de ficha es la:" e inserta en la cola de regulares la ficha, cédula, nombre y fecha y hora de llegada. | Daniela Villegas |
| US-04 | 1 | Registrar paciente preferencial y generar ficha | Asigna una ficha consecutiva P1, P2, P3... (secuencia separada de las R) e inserta al paciente en la cola de preferenciales. | Daniela Villegas |
| US-05 | 1 | Atender al siguiente paciente | Saca de la cola al paciente que corresponde: cada 2 preferenciales se atiende 1 regular cuando hay pacientes mezclados, respetando Primero en Llegar Primero en Salir. Muestra "Ficha # ... con cédula ... pasar a consulta médica." | Jonathan Umaña Rivera |
| US-06 | 1 | Abandonar la cola de pacientes | El paciente indica su ficha y el motivo de salida. Se elimina de la cola sin alterar a los demás y se muestra "Ficha # ... con cédula ... abandona la cola sin ser atendido (a)." | Gabriel Alvarez |
| US-07 | 1 | Registrar abandonos en la pila de quejas | Cada abandono se inserta en la Pila de Quejas con ficha, cédula, motivo y fecha y hora del abandono. | Gabriel Alvarez |
| US-08 | 1 | Mostrar fichas pendientes | Lista las dos colas: en verde las fichas de Paciente Regular y en naranja las de Paciente Preferencial. | Mathias Solan |
| US-09 | 1 | Mostrar quejas recibidas | Lista la Pila de Quejas con el formato "Ficha # ... con cédula ... abandona la cola sin ser atendido (a) a la fecha y hora dd/MM/yyyy HH:mm:ss por el siguiente motivo ...". | Mathias Solan |
| US-10 | 1 | Mostrar ayuda del sistema | Muestra la versión de la herramienta y quiénes desarrollaron la solución. | Mathias Solan |
| US-11 | 1 | Regresar al menú principal | La opción Regresar de los submenús vuelve al menú anterior. | Daniela Villegas |
| US-12 | 1 | Salir del sistema | La opción Salir del menú principal concluye la ejecución del programa. | Daniela Villegas |
| US-13 | 1 | Implementar las colas de pacientes | Dos colas (regulares y preferenciales) con la clase ColaDinamica vista en clase y la clase hija ColaPacientes. | Jonathan Umaña Rivera |
| US-14 | 2 | Corregir el Avance 1 con las clases del profesor | Reemplazar las clases genéricas propias por ColaDinamica y PilaDinamica vistas en clase, ajustando el Nodo, y pasar los métodos adicionales a clases hijas (ColaPacientes, PilaQuejas). | Jonathan Umaña Rivera, Gabriel Alvarez |
| US-15 | 2 | Agregar opciones nuevas al menú principal | Agregar al menú principal: Consulta de Bitácora de Citas del día y Consulta de Expediente único de Pacientes. | Daniela Villegas |
| US-16 | 2 | Mostrar al doctor los datos del paciente | Al atender, mostrar los datos de la ficha. Si el paciente no tiene expediente: "Paciente ... asiste a consulta por primera vez." Si tiene: mostrar cédula, nombre, edad y género. | Jonathan Umaña Rivera |
| US-17 | 2 | Registrar la cita y distribuir los datos | El doctor ingresa los datos del expediente (primera vez), la cita actual y los medicamentos. Al concluir se crea o actualiza el expediente con sus listas internas, se alimenta la bitácora y se muestra "Paciente ..., su cita ha concluido." | Jonathan Umaña Rivera |
| US-18 | 2 | Implementar la Bitácora de Citas del día | Lista Simple (clase del profesor + clase hija BitacoraCitas) con ficha, cédula, nombre, fecha de llegada y fecha de atención, insertando por cédula de menor a mayor. | Mathias Solan |
| US-19 | 2 | Consultar la Bitácora de Citas del día | Lista las citas atendidas en la sesión: verde de 1 a 30 segundos de espera, amarillo más de 30 segundos y menos de 1 minuto, rojo más de 1 minuto. | Mathias Solan |
| US-20 | 2 | Implementar el Expediente Único de Pacientes | Lista Doble Circular (clase del profesor + clase hija ExpedienteUnico) con cédula, nombre, edad y género, insertando por cédula de menor a mayor. | Daniela Villegas |
| US-21 | 2 | Implementar los históricos del expediente | Listas Simples Circulares dentro de cada expediente: Histórico de Citas (fecha, doctor, diagnóstico) e Histórico de Medicamentos Prescritos (fecha, medicamento). | Gabriel Alvarez |
| US-22 | 2 | Consultar el Expediente Único de Pacientes | Ver los expedientes uno por uno (información del paciente, histórico de citas e histórico de medicamentos) navegando hacia adelante y hacia atrás. | Daniela Villegas |
| US-23 | 2 | Actualizar la Ayuda | Actualizar la versión de la herramienta y los integrantes que presentan el avance. | Mathias Solan |
| US-24 | 2 | Actualizar la documentación | Product Backlog, diagrama de clases del Avance 2 integrado al del Avance 1 y Javadoc generado. | Mathias Solan |
