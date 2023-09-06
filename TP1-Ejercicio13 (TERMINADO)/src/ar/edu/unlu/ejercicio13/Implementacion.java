package ar.edu.unlu.ejercicio13;

import java.time.LocalDate;
import java.util.List;

public class Implementacion {

    public static void main(String[] argumentos) {

        LocalDate anteAyer = LocalDate.now().minusDays(2);
        LocalDate ayer = LocalDate.now().minusDays(1);
        LocalDate hoy = LocalDate.now();
        LocalDate maniana = LocalDate.now().plusDays(1);
        LocalDate pasadoManiana = LocalDate.now().plusDays(2);

        ListaDeTarea listaTareas = new ListaDeTarea();

        Colaborador colaborador = new Colaborador("Marcos");
        Colaborador colaborador2 = new Colaborador("Patricia");

        Tarea tarea1 = new Tarea("Pasear al perro", 4, maniana);
        Tarea tarea2 = new Tarea("Consultar repuesto del auto", 2, hoy);
        Tarea tarea3 = new Tarea("Ir al cine a ver la nueva película de Marvel", 1, ayer);
        Tarea tarea4 = new Tarea("Ir a ver al Pato Fontanet", 5, pasadoManiana);
        Tarea tarea5 = new Tarea("Llennar las botellas de agua", 7, anteAyer);
        Tarea tarea6 = new Tarea("Pasear al perro", 3, hoy);


        listaTareas.agregarTarea(tarea1);
        listaTareas.agregarTarea(tarea2);
        listaTareas.agregarTarea(tarea3);
        listaTareas.agregarTarea(tarea4);
        listaTareas.agregarTarea(tarea5);
        listaTareas.agregarTarea(tarea6);

        LocalDate fechaDeCompletado = LocalDate.now().minusDays(6);
        LocalDate fechaDeCompletado2 = LocalDate.now().minusDays(3);

        listaTareas.marcarTareaComoCompletada(tarea1, colaborador, fechaDeCompletado);
        listaTareas.marcarTareaComoCompletada(tarea2, colaborador2, fechaDeCompletado2);

        List<Tarea> tareasMarcos = listaTareas.getTareasColaborador(colaborador);
        List<Tarea> tareasPatricia = listaTareas.getTareasColaborador(colaborador2);


        System.out.println("Tareas completadas por Marcos:");
        for (Tarea tarea : tareasMarcos) {
            System.out.printf("Tarea: '%s' completada el %s\n\n", tarea.getDescripcion(), tarea.getFechaDeCompletado());
        }

        System.out.println("Tareas completadas por Patricia:");
        for (Tarea tarea : tareasPatricia) {
            System.out.printf("Tarea: '%s' completada el %s\n\n", tarea.getDescripcion(), tarea.getFechaDeCompletado());
        }

    }
}
