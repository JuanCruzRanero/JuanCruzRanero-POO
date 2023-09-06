package ar.edu.unlu.ejercicio5.listaDeTareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionListaDeTarea {

    public static void main(String[] args){

        LocalDate maniana = LocalDate.now().plusDays(1);
        LocalDate ayer = LocalDate.now().minusDays(1);


        List<Tarea> listaTareas = new ArrayList<>();

        Tarea tarea1 = new Tarea("Ir al supermercado mañana", 1, maniana);
        Tarea tarea2 = new Tarea("Consultar repuesto del auto", 2, ayer);
        Tarea tarea3 = new Tarea("Ir al cine a ver la nueva película de Marvel", 3, ayer);

        tarea2.marcarComoCompleta();

        listaTareas.add(tarea1);
        listaTareas.add(tarea2);
        listaTareas.add(tarea3);

        System.out.print("\n");

        for (int i = 0; i < listaTareas.size(); i++) {
            Tarea tarea = listaTareas.get(i);
            System.out.println("Tarea " + tarea.tareaPrioridad() + ": " + tarea.mostrarTarea());

            if (!tarea.estaCompleta()) {            //Si la tarea está completa, nos damos cuenta por el (Vencida); y obvio no hace falta mostrar que ya está vencida.
                System.out.println("¿La tarea está vencida? " + tarea.estaVencida());
                System.out.println("¿La tarea está completa? " + tarea.estaCompleta());
            }
            System.out.println("\n");
        }
    }
}