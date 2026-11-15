# Grupo 4 - Proyecto Final Estructuras de Datos (SC-304)

MVP del hospital **"Su Salud"** en Java (Apache NetBeans, proyecto Maven). Versión actual: **Avance 2 V 2.0.1**.

## Integrantes

| Parte | Integrante | Responsabilidad |
|---|---|---|
| Persona 1 | Daniela Villegas | Menús, Seleccionar Ficha, Expediente Único (Lista Doble Circular) y su consulta |
| Persona 2 | Jonathan Umaña Rivera | Colas, Atender Paciente (regla P, P, R) y flujo de la cita del doctor |
| Persona 3 | Gabriel Alvarez | Abandonar Cola, Pila de Quejas e históricos del expediente (Listas Simples Circulares) |
| Persona 4 | Mathias Solan | Fichas pendientes, Quejas recibidas, Bitácora de Citas (Lista Simple), Ayuda y documentación |

## Funcionalidades

**Avance 1 - Gestionar Llegada de Pacientes**

1. Seleccionar Ficha (R1, R2... / P1, P2..., secuencia separada por tipo).
2. Atender Paciente (cada 2 preferenciales se atiende 1 regular).
3. Abandonar Cola de Pacientes (la queja se guarda en la Pila de Quejas).
4. Mostrar Fichas Pendientes (regulares en verde `[R]`, preferenciales en naranja `[P]`).
5. Mostrar Quejas recibidas.

**Avance 2 - Expediente y Bitácora**

- Atender Paciente continúa con la cita: expediente (nuevo o existente), datos de la cita y medicamentos.
- Consulta de Bitácora de Citas del día (verde / amarillo / rojo según el tiempo de espera).
- Consulta de Expediente Único de Pacientes (navegación Siguiente / Anterior).

## Estructuras de datos: clases del profesor y herencia

Las estructuras son las **clases vistas en clase**. Solo se les ajustó el tipo de dato del Nodo (y el campo por el que se ordena). Todo método adicional está en una **clase hija**.

| Uso en el proyecto | Clase del profesor (padre) | Nodo | Clase hija del grupo | Métodos del profesor que reutiliza |
|---|---|---|---|---|
| Cola de regulares y cola de preferenciales | `ColaDinamica` | `colas.Nodo` (Paciente) | `ColaPacientes` | `encolar`, `desencolar`, `estaVacia`, `getFrente` |
| Pila de Quejas | `PilaDinamica` | `pilas.Nodo` (Queja) | `PilaQuejas` | `apilar`, `retornaCima`, `esVacia` |
| Bitácora de Citas del día | `ListaSimple` | `listas.Nodo` (CitaBitacora) | `BitacoraCitas` | `insertarOrdenado` (cédula de menor a mayor) |
| Expediente Único de Pacientes | `ListaDobleCircular` | `NodoDoble` (Expediente) | `ExpedienteUnico` | `insertarOrdenado` (cédula de menor a mayor) |
| Histórico de Citas (lista interna) | `ListaCircular` | `NodoSimple` (RegistroHistorico) | `HistoricoCitas` | `insertarOrdenado` (por fecha) |
| Histórico de Medicamentos (lista interna) | `ListaCircular` | `NodoSimple` (RegistroHistorico) | `HistoricoMedicamentos` | `insertarOrdenado` (por fecha) |

No se usan arreglos ni estructuras de las librerías de Java (`ArrayList`, `LinkedList`, etc.).

## Paquetes

```
com.mycompany.grupo4pfa1
├── GRUPO4PFA1.java          Clase principal (main)
├── estructuras
│   ├── colas                Nodo, ColaDinamica, ColaPacientes
│   ├── pilas                Nodo, PilaDinamica, PilaQuejas
│   └── listas               Nodo, ListaSimple, BitacoraCitas,
│                            NodoSimple, ListaCircular, HistoricoCitas, HistoricoMedicamentos,
│                            NodoDoble, ListaDobleCircular, ExpedienteUnico
├── modelo                   Paciente, Queja, CitaBitacora, Expediente,
│                            RegistroHistorico, CitaHistorica, MedicamentoPrescrito
├── servicio                 GestorAtencion, GestionAbandono, GestorCitas
└── ui                       Consola, Menus y una Pantalla por opción
```

## Cómo ejecutarlo

1. Abrir la carpeta del proyecto en Apache NetBeans (File > Open Project).
2. Clic derecho sobre el proyecto > **Clean and Build**.
3. **Run** (F6). El programa se usa desde la ventana Output.

## Documentación

- [Product Backlog](docs/ProductBacklog.md)
- [Diagrama de clases](docs/DiagramaClases.md)
- Javadoc: `docs/javadoc/index.html` (se regenera en NetBeans con clic derecho sobre el proyecto > Generate Javadoc).
