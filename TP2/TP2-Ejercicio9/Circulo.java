package ar.edu.unlu.ejercicio9;

public class Circulo extends FiguraDosDimensiones {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }
}