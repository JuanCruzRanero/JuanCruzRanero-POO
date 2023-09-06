package ar.edu.unlu.ejercicio5.listaDeTareas;
import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private int prioridad;
    private boolean completa;
    private final LocalDate fechaLimite;

    public Tarea(String descripcion, int prioridad, LocalDate fechaLimite){
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.completa = false;
    }

    public void modificarDescripcion(String nuevaDescripcion){
        this.descripcion = nuevaDescripcion;
    }

    public void cambiarPrioridad(int nuevaPrioridad){
        this.prioridad = nuevaPrioridad;
    }

    public int tareaPrioridad(){
        return prioridad;
    }

    public void marcarComoCompleta(){
        this.completa = true;
    }

    public boolean estaVencida(){
        return !completa && LocalDate.now().isAfter(fechaLimite);
    }

    public boolean estaCompleta(){
        return completa;
    }

    public String mostrarTarea(){
        if (estaCompleta()){
            return "(Vencida) " + descripcion;
        }
        else{
            return descripcion;
        }
    }
}
