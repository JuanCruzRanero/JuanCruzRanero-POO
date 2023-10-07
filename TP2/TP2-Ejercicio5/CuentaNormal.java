package ar.edu.unlu.ejercicio5;

import java.time.LocalDate;

public class CuentaNormal {
    private double saldo;
    private double limiteGiroEnDescubierto;
    private LocalDate fechaInvesion;
    private Inversion inversion;

    public void preCancelarInversion() {
        if (inversion != null && inversion.getMontoInvertido() > 0) {
            inversion.cancelarInversion();
        }
    }

    public CuentaNormal(double saldo, double limiteGiroEnDescubierto) {
        this.saldo = saldo;
        this.limiteGiroEnDescubierto = limiteGiroEnDescubierto;
        this.inversion = null;
    }

    public void realizarInversion(double monto, int dias){
        if (inversion == null || inversion.getMontoInvertido() == 0) {
            fechaInvesion = LocalDate.now();
            inversion = new Inversion(monto, dias);
        }
        else{
            System.out.println("Ya cuentas con una inversión en curso.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteGiroEnDescubierto() {
        return limiteGiroEnDescubierto;
    }

    public double getMontoDisponible() {
        double montoDisponible = saldo + limiteGiroEnDescubierto;
        if (inversion != null){
            double interes = inversion.calcularInteres();
            montoDisponible += interes;

            if (interes > 0 && !inversion.estaCancelada()) {
                return montoDisponible;
            }
        }
        return montoDisponible;
    }

    public double getMontoInvertido() {
        if (inversion != null) {
            return inversion.getMontoInvertido();
        }
        return 0;
    }

    public double calcularInteresInversion() {
        if (inversion != null){
            return inversion.calcularInteres();
        }
        return 0;
    }
}
