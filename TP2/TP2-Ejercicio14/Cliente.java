package ar.edu.unlu.ejercicio14.SunBeachDos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<PaqueteTurismo> compras = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void comprarPaquete(PaqueteTurismo paquete) {
        compras.add(paquete);
    }

    public List<PaqueteTurismo> getCompras() {
        return compras;
    }

    public String getNombre() {
        return nombre;
    }
}