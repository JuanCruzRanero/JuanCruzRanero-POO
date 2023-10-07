package ar.edu.unlu.ejercicio12;

public class CajaAhorro extends Cuenta {
    private double tasaInteres;

    public CajaAhorro(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public void realizarDeposito(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
        else{
            System.out.println("No podés depositar un monto negativo!");
        }
    }
}
