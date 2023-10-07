package ar.edu.unlu.ejercicio9;

public class Cuadrado extends FiguraDosDimensiones {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }
}
