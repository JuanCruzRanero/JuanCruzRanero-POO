package ar.edu.unlu.ejercicio12;

public class Cuenta {
    protected double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }
}
