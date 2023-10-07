package ar.edu.unlu.ejercicio9;

public class Rectangulo extends FiguraDosDimensiones {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return base * altura;
    }
}
