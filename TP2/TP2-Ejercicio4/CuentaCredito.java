package ar.edu.unlu.ejercicio4.billetera;

public class CuentaCredito {
    private double limiteGasto;
    private double tasaRecargo;
    private double deudaAcumulada;

    public CuentaCredito(double limiteGasto){
        this.limiteGasto = limiteGasto;
        this.tasaRecargo = 0.05;
        this.deudaAcumulada = 0;
    }

    public void realizarCompra(double monto){
        if (monto <= getLimiteGasto()){
            deudaAcumulada += monto;
        }
        else{
            System.out.println("Error. La compra excede el límite de gasto posible.");
        }
    }

    public void realizarPago(double monto){
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

    public double getTasaRecargo() {
        return tasaRecargo;
    }

    public double getDeudaAcumulada() {
        return deudaAcumulada;
    }
}
