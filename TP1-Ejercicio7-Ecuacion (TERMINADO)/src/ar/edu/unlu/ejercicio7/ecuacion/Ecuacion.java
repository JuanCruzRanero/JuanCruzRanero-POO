package ar.edu.unlu.ejercicio7.ecuacion;

public class Ecuacion {

    private final double a;
    private final double b;
    private final double c;

    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminante() {
        return (b * b) - (4 * a * c);
    }

    public double primeraRaiz() {
        if (discriminante() < 0) {
            return Double.NaN;

        } else {
            return (-b + Math.sqrt(discriminante())) / (2 * a);
        }
    }

    public double segundaRaiz() {
        if (discriminante() < 0) {
            return Double.NaN;

        } else {
            return (-b - Math.sqrt(discriminante())) / (2 * a);
        }
    }

    public double calcularY(double x) {
        return a * x * x + b * x + c;
    }
}
