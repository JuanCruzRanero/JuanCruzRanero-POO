package ar.edu.unlu.ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Implementacion{

    public static void main(String[] args){

        LocalDate maniana = LocalDate.now().plusDays(1);
        LocalDate hoy = LocalDate.now();


        List<Tarea> listaTareas = new ArrayList<>();

        Tarea tarea1 = new Tarea("Pasear al perro", 4, maniana);
        Tarea tarea2 = new Tarea("Consultar repuesto del auto", 2, hoy);
        Tarea tarea3 = new Tarea("Ir al cine a ver la nueva película de Marvel", 1, hoy);

        tarea3.marcarComoCompleta();

        LocalDate fechaRecordatorio = LocalDate.now().plusDays(7);
        LocalDate fechaRecordatorio2 = LocalDate.now().plusDays(2);
        LocalDate fechaRecordatorio3 = LocalDate.now().plusDays(1);

        tarea1.setFechaRecordatorio(fechaRecordatorio);
        tarea2.setFechaRecordatorio(fechaRecordatorio2);
        tarea3.setFechaRecordatorio(fechaRecordatorio3);


        listaTareas.add(tarea1);
        listaTareas.add(tarea2);
        listaTareas.add(tarea3);

        System.out.print("\n");


        for (int i = 0; i < listaTareas.size() - 1; i++){

            for (int j = i + 1; j < listaTareas.size(); j++){

                Tarea tareaI = listaTareas.get(i);
                Tarea tareaJ = listaTareas.get(j);

                if (tareaI.getFechaRecordatorio().isAfter(tareaJ.getFechaRecordatorio())){
                    listaTareas.set(i, tareaJ);
                    listaTareas.set(j, tareaI);
                }
            }
        }

        for (int i = 0; i < listaTareas.size(); i++){

            Tarea tarea = listaTareas.get(i);
            System.out.printf("Tarea de prioridad %d: %s\n",tarea.getPrioridad(), tarea.mostrarTarea());

            if (!tarea.estaCompleta()){            //Si la tarea está completa, nos damos cuenta por el (Vencida); y obvio no hace falta mostrar que ya está vencida.
                System.out.printf("¿La tarea está vencida? %b\n", tarea.estaVencida());
                System.out.printf("¿La tarea está completa? %b\n", tarea.estaCompleta());
            }
            System.out.println("\n");
        }
    }
}
