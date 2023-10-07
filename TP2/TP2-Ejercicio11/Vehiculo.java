package ar.edu.unlu.ejercicio11;

public class Vehiculo {
    protected String patente;
    protected int diasDeAlquiler;

    public Vehiculo(String patente, int diasDeAlquiler) {
        this.patente = patente;
        this.diasDeAlquiler = diasDeAlquiler;
    }

    public double calcularCostoAlquiler() {
        return 3000 * diasDeAlquiler;
    }

    public String getPatente() {
        return patente;
    }
}
