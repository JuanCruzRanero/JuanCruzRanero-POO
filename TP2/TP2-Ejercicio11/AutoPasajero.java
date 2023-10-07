package ar.edu.unlu.ejercicio11;

public class AutoPasajero extends Vehiculo {
    private int asientos;

    public AutoPasajero(String patente, int diasDeAlquiler, int asientos) {
        super(patente, diasDeAlquiler);
        this.asientos = asientos;
    }

    @Override
    public double calcularCostoAlquiler() {
        return super.calcularCostoAlquiler() + (300 * asientos * diasDeAlquiler);
    }
}