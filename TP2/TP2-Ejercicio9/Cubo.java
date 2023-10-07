package ar.edu.unlu.ejercicio9;

public class Cubo extends FiguraTresDimensiones {
    private double arista;

    public Cubo(double arista) {
        this.arista = arista;
    }

    @Override
    public double getArea() {
        return 6 * arista * arista;
    }

    @Override
    public double getVolumen() {
        return Math.pow(arista, 3);
    }
}