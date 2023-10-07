package ar.edu.unlu.ejercicio5;

public class Inversion {
    private double montoInvertido;
    private int diasRestantes;
    private boolean cancelada;

    public Inversion(double montoInvertido, int diasRestantes) {
        this.montoInvertido = montoInvertido;
        this.diasRestantes = diasRestantes;
        this.cancelada = false;
    }

    public double calcularInteres(){

        if (!cancelada){
            if (diasRestantes > 0){
                if (diasRestantes >= 30){
                    return montoInvertido * 0.05;
                }
                else{
                    return montoInvertido * 0.4;
                }
            }
        }
        return 0;
    }

    public boolean estaCancelada() {
        return cancelada;
    }

    public void cancelarInversion() {
        cancelada = true;
    }

    public double getMontoInvertido() {
        return montoInvertido;
    }
}
