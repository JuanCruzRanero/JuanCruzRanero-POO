package ar.edu.unlu.ejercicio4.billetera;

public class Cliente{
    private String nombre;
    private CuentaNormal cuentaNormal;
    private CuentaCredito cuentaCredito;

    public Cliente(String nombre, double saldoInicial, double limiteGiroNormal, double limiteGastoCredito) {
        this.nombre = nombre;
        this.cuentaNormal = new CuentaNormal(saldoInicial, limiteGiroNormal);
        this.cuentaCredito = new CuentaCredito(limiteGastoCredito);
    }

    public void realizarCompraCredito(double monto){
        double montoDisponibleCredito = cuentaCredito.getLimiteGasto() - cuentaCredito.getDeudaAcumulada();

        if (monto <= montoDisponibleCredito){
            cuentaCredito.realizarCompra(monto);
        }
        else{
            System.out.printf("El gasto de $%s excede el límite de gasto disponible en la cuenta de crédito.", monto);
        }
    }

    public void realizarPagoCredito(double monto) {
        cuentaCredito.realizarPago(monto);
    }

    public void realizarInversion(double monto, int dias) {
        cuentaNormal.realizarInversion(monto, dias);
    }

    public double getSaldo() {
        return cuentaNormal.getSaldo();
    }

    public double getLimiteGiroNormal() {
        return cuentaNormal.getLimiteGiroEnDescubierto();
    }

    public double getMontoDisponibleCredito() {
        return cuentaCredito.getLimiteGasto() - cuentaCredito.getDeudaAcumulada();

    }

    public double getSaldoDeudorCredito() {
        return cuentaCredito.getDeudaAcumulada();
    }

    public double getMontoInvertido() {
        return cuentaNormal.getMontoInvertido();
    }

    public double getInteresInversion() {
        return cuentaNormal.calcularInteresInversion();
    }
}

