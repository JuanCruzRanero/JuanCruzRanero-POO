package ar.edu.unlu.ejercicio11;

public class Presupuesto {
    private Vehiculo vehiculo;
    private int diasAlquiler;

    public Presupuesto(Vehiculo vehiculo, int diasAlquiler) {
        this.vehiculo = vehiculo;
        this.diasAlquiler = diasAlquiler;
    }

    public double calcularMonto() {
        return vehiculo.calcularCostoAlquiler();
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }
}
