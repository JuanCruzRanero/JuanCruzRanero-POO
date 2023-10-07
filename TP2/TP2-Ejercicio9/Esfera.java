package ar.edu.unlu.ejercicio9;

public class Esfera extends FiguraTresDimensiones {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double getVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}

