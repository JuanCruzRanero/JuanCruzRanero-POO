package ar.edu.unlu.ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Implementacion{

    public static void main(String[] args){

        LocalDate anteAyer = LocalDate.now().minusDays(2);
        LocalDate ayer = LocalDate.now().minusDays(1);
        LocalDate hoy = LocalDate.now();
        LocalDate maniana = LocalDate.now().plusDays(1);
        LocalDate pasadoManiana = LocalDate.now().plusDays(2);


        List<Tarea> listaTareas = new ArrayList<>();

        Tarea tarea1 = new Tarea("Pasear al perro", 4, maniana);
        Tarea tarea2 = new Tarea("Consultar repuesto del auto", 2, hoy);
        Tarea tarea3 = new Tarea("Ir al cine a ver la nueva película de Marvel", 1, ayer);
        Tarea tarea4 = new Tarea("Ir a ver al Pato Fontanet", 5, pasadoManiana);
        Tarea tarea5 = new Tarea("Llennar las botellas de agua", 7, anteAyer);
        Tarea tarea6 = new Tarea("Pasear al perro", 3, hoy);


        listaTareas.add(tarea1);
        listaTareas.add(tarea2);
        listaTareas.add(tarea3);
        listaTareas.add(tarea4);
        listaTareas.add(tarea5);
        listaTareas.add(tarea6);

        tarea3.marcarComoCompleta();
        tarea4.marcarComoCompleta();

        LocalDate fechaRecordatorio = LocalDate.now().plusDays(7);
        LocalDate fechaRecordatorio2 = LocalDate.now().plusDays(2);
        LocalDate fechaRecordatorio3 = LocalDate.now().plusDays(1);

        tarea1.setFechaRecordatorio(fechaRecordatorio);
        tarea2.setFechaRecordatorio(fechaRecordatorio2);
        tarea3.setFechaRecordatorio(fechaRecordatorio3);

        System.out.print("\n");


        System.out.println("TAREAS ORDENADAS POR PRIORIDAD: ");

        for(int i = 0; i < listaTareas.size() - 1; i++){

            for(int j = i + 1; j < listaTareas.size(); j++){

                Tarea tareaI = listaTareas.get(i);
                Tarea tareaJ = listaTareas.get(j);

                if (tareaI.getPrioridad() > tareaJ.getPrioridad()) {
                    listaTareas.set(i, tareaJ);
                    listaTareas.set(j, tareaI);
                }
            }
        }

        for(int i = 0; i < listaTareas.size(); i++){

            Tarea tarea = listaTareas.get(i);

            int estaVencida = 0;

            if (tarea.estaVencida()){
                estaVencida=2;
            }
            else{
                estaVencida=1;
            }

            switch(estaVencida){
                case 1:
                    System.out.printf("Tarea de prioridad %d: %s\n",tarea.getPrioridad(), tarea.mostrarTarea());

                    if (!tarea.estaCompleta()){            //Si la tarea está completa, nos damos cuenta por el (Vencida); y obvio no hace falta mostrar que ya está vencida.
                        System.out.printf("¿La tarea está vencida? %b\n", tarea.estaVencida());
                        System.out.printf("¿La tarea está completa? %b\n", tarea.estaCompleta());
                    }
                    System.out.println("\n");

                    break;

                case 2:
                    break;
            }
        }

        System.out.println("TAREAS ORDENADAS POR FECHA DE VENCIMIENTO: ");

        for(int i = 0; i < listaTareas.size() - 1; i++){

            for (int j = i + 1; j < listaTareas.size(); j++){

                Tarea tareaI = listaTareas.get(i);
                Tarea tareaJ = listaTareas.get(j);

                if (tareaI.getFechaLimite().isAfter(tareaJ.getFechaLimite())){
                    listaTareas.set(i, tareaJ);
                    listaTareas.set(j, tareaI);
                }
            }
        }

        for(int i = 0; i < listaTareas.size(); i++){

            Tarea tarea = listaTareas.get(i);

            int estaVencida;

            if (tarea.estaVencida()){
                estaVencida=2;
            }
            else{
                estaVencida=1;
            }

            switch(estaVencida){
                case 1:
                    System.out.printf("Tarea de prioridad %d: %s\n",tarea.getPrioridad(), tarea.mostrarTarea());

                    if (!tarea.estaCompleta()){            //Si la tarea está completa, nos damos cuenta por el (Vencida); y obvio no hace falta mostrar que ya está vencida.
                        System.out.printf("¿La tarea está vencida? %b\n", tarea.estaVencida());
                        System.out.printf("¿La tarea está completa? %b\n", tarea.estaCompleta());
                    }
                    System.out.println("\n");

                    break;

                case 2:
                    break;
            }
        }

        String descripcionBuscada = "Pasear al perro";

        System.out.printf("\nBuscando tarea por título: %s\n", descripcionBuscada);

        for (Tarea tarea : listaTareas){

            int encuentro;

            if (tarea.getDescripcion().equals(descripcionBuscada)){
                encuentro=1;
            }
            else{
                encuentro=2;
            }

            switch (encuentro){     // Hacemos un switch para que devuelva todas las ocurrencias de esa descripción en particular
                case 1:
                    System.out.printf("Encontrada: Prioridad %d: %s\n", tarea.getPrioridad(), tarea.mostrarTarea());
                    break;
                case 2:
                    break;
            }
        }
    }
}
