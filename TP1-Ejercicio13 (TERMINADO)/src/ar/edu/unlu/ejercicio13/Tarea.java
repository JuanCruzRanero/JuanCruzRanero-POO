package ar.edu.unlu.ejercicio13;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private int prioridad;
    private boolean completa;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private LocalDate fechaDeCompletado;
    private Colaborador hechaPor;

    public Tarea(String descripcion, int prioridad, LocalDate fechaLimite){
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.completa = false;
        this.fechaRecordatorio = null;
        this.hechaPor = null;
        this.fechaDeCompletado = null;
    }

    public void setDescripcion(String nuevaDescripcion){
        this.descripcion = nuevaDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void cambiarPrioridad(int nuevaPrioridad){
        this.prioridad = nuevaPrioridad;
    }

    public int getPrioridad(){
        return prioridad;
    }

    public void marcarComoCompleta(Colaborador colaborador, LocalDate fecha){
        if (!estaCompleta()){
            completa = true;
            fechaDeCompletado = fecha;
            hechaPor = colaborador;
        }
    }

    public LocalDate getFechaDeCompletado(){
        return fechaDeCompletado;
    }

    public Colaborador getHechaPor(){
        return hechaPor;
    }

    public boolean estaVencida(){
        return !completa && LocalDate.now().isAfter(fechaLimite);
    }

    public boolean estaCompleta(){
        return completa;
    }

    public void setFechaRecordatorio(LocalDate fechaRecordatorio){
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public LocalDate getFechaRecordatorio(){
        return fechaRecordatorio;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite){
    }

    public String mostrarTarea(){
        if (estaCompleta()){
            return "(Completa) " + descripcion;
        }
        else if (estaVencida()){
            return "(Vencida) " + descripcion;
        }
        else {
            String queRetorna = "";
            LocalDate hoy = LocalDate.now();

            if (fechaRecordatorio != null && fechaRecordatorio.isAfter(hoy)){
                queRetorna = "(por vencer) ";
            }

            return queRetorna + descripcion;
        }
    }
}