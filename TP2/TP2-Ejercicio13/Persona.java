package ar.edu.unlu.ejercicio13.sistemaDeVuelos;

public class Persona{
    private String nombre;
    private String numeroTelefono;
    private String direccion;

    public Persona(String nombre, String numeroTelefono, String direccion) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
}

