package ar.edu.unlu.ejercicio13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaDeTarea {

    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void marcarTareaComoCompletada(Tarea tarea, Colaborador colaborador, LocalDate fecha) {
        if (tareas.contains(tarea)) {
            tarea.marcarComoCompleta(colaborador, fecha);
        }
    }

    public List<Tarea> getTareasColaborador(Colaborador colaborador) {
        List<Tarea> tareasCompletadas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.estaCompleta() && tarea.getHechaPor() == colaborador) {
                tareasCompletadas.add(tarea);
            }
        }
        return tareasCompletadas;
    }

}
