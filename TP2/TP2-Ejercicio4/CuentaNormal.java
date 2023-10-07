package ar.edu.unlu.ejercicio4.billetera;

public class CuentaNormal{
    private double saldo;
    private double limiteGiroEnDescubierto;
    private Inversion inversion;

    public CuentaNormal(double saldo, double limiteGiroEnDescubierto) {
        this.saldo = saldo;
        this.limiteGiroEnDescubierto = limiteGiroEnDescubierto;
        this.inversion = null;
    }

    public void realizarInversion(double monto, int dias) {
        if (inversion == null){
            inversion = new Inversion(monto, dias);
        }
        else{
            System.out.println("Usted ya cuenta con una inversión activa.");
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public double getLimiteGiroEnDescubierto(){
        return limiteGiroEnDescubierto;
    }

    public double getMontoDisponible(){
        double montoDisponible = saldo + limiteGiroEnDescubierto;
        if (inversion != null){
            montoDisponible += inversion.calcularInteres();
        }
        return montoDisponible;
    }

    public double getMontoInvertido() {
        if (inversion != null){
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
