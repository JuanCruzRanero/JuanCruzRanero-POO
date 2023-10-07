package ar.edu.unlu.ejercicio11;

public class AutoVip extends Vehiculo {
    public AutoVip(String patente, int diasDeAlquiler) {
        super(patente, diasDeAlquiler);
    }

    @Override
    public double calcularCostoAlquiler() {
        return super.calcularCostoAlquiler() + 500 * diasDeAlquiler;
    }
}
