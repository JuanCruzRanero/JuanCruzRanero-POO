package ar.edu.unlu.ejercicio3.academiaDeDanzas;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private String nombre;
    private List<Diagramacion> diagramaciones = new ArrayList<>();

    public Academia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Diagramacion> getDiagramaciones() {
        return diagramaciones;
    }

    public void agregarDiagramacion(Diagramacion diagramacion) {
        diagramaciones.add(diagramacion);
    }

}
