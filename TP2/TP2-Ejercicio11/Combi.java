package ar.edu.unlu.ejercicio11;

public class Combi extends Vehiculo {
    public Combi(String patente, int diasDeAlquiler) {
        super(patente, diasDeAlquiler);
    }

    @Override
    public double calcularCostoAlquiler(){
        return super.calcularCostoAlquiler() + 1500 * diasDeAlquiler;
    }
}
