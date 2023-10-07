package ar.edu.unlu.ejercicio1.socios;

import java.util.ArrayList;
import java.util.List;

public class Suscripcion {

    private String tipoSuscripcion;
    private double cuota;
    private List<Actividad> actividadesTipoSuscripcion;

    public Suscripcion(String tipoSuscripcion, double cuota){
        this.tipoSuscripcion = tipoSuscripcion;
        this.cuota = cuota;
        this.actividadesTipoSuscripcion = new ArrayList<>();
    }

    public String getTipoSuscripcion(){
        return tipoSuscripcion;
    }

    public double getCuota(){
        return cuota;
    }

    public List<Actividad> getActividadesTipoSuscripcion() {
        return actividadesTipoSuscripcion;
    }

    public void setActividadesTipoSuscripcion(Actividad actividad) {
        actividadesTipoSuscripcion.add(actividad);
    }
}
