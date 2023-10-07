package ar.edu.unlu.ejercicio13.sistemaDeVuelos;

public class Pasajero extends Persona{
    private String numeroDePasajero;
    private Ticket ticket;

    public Pasajero(String nombre, String numeroTelefono, String direccion, String numeroDePasajero) {
        super(nombre, numeroTelefono, direccion);
        this.numeroDePasajero = numeroDePasajero;
    }

    public String getNumeroDePasajero(){
        return numeroDePasajero;
    }

}
