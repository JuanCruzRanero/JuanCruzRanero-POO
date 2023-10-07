package ar.edu.unlu.ejercicio13.sistemaDeVuelos;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private int numeroDeVuelo;
    private String fecha;
    private String origen;
    private String destino;
    private List<Persona> miembrosVuelo;

    public Vuelo(int numeroDeVuelo, String fecha, String origen, String destino){
        this.numeroDeVuelo = numeroDeVuelo;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.miembrosVuelo = new ArrayList<>();
    }

    public void agregarPersona(Persona persona){
        miembrosVuelo.add(persona);
    }

    public List<Persona> getMiembrosVuelo(){
        return miembrosVuelo;
    }
}