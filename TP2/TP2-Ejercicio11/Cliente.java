package ar.edu.unlu.ejercicio11;

public class Cliente {
    private String nombre;
    private double montoTotalAlquileres;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.montoTotalAlquileres = 0;
    }

    public void agregarMontoAlquiler(double monto) {
        this.montoTotalAlquileres += monto;
    }

    public double getMontoTotalAlquileres() {
        return montoTotalAlquileres;
    }

    public String getNombre() {
        return nombre;
    }
}