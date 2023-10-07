package ar.edu.unlu.ejercicio5;

public class CuentaCredito {
    private double limiteGasto;
    private double tasaRecargo;
    private double deudaAcumulada;

    public CuentaCredito(double limiteGasto) {
        this.limiteGasto = limiteGasto;
        this.tasaRecargo = 0.05;
        this.deudaAcumulada = 0;
    }

    public void realizarCompra(double monto) {
        if (monto <= getLimiteGasto()) {
            deudaAcumulada += monto;
        } else {
            System.out.println("La compra excede el límite de gasto.");
        }
    }

    public void realizarPago(double monto) {
        if (monto >= 0){
            deudaAcumulada -= monto;
        }
        else{
            System.out.println("No puede pagar un monto negativo!");
        }
    }

    public double getLimiteGasto() {
        return limiteGasto - deudaAcumulada;
    }

    public double getDeudaAcumulada() {
        return deudaAcumulada;
    }
}
