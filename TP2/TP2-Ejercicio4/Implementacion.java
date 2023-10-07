package ar.edu.unlu.ejercicio4.billetera;

public class Implementacion {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Patricio Fontanet", 2000.0, 900.0, 1000.0);

        cliente.realizarInversion(500.0, 30);
        cliente.realizarCompraCredito(300000.0);
        cliente.realizarCompraCredito(400.0);
        cliente.realizarPagoCredito(60.0);

        System.out.printf("Saldo: %s", cliente.getSaldo());
        System.out.printf("Límite de Giro en Descubierto: %s", cliente.getLimiteGiroNormal());
        System.out.printf("Monto disponible para compras a crédito: %s", cliente.getMontoDisponibleCredito());
        System.out.printf("Saldo deudor en crédito: %s", cliente.getSaldoDeudorCredito());
        System.out.printf("Monto invertido: %s", cliente.getMontoInvertido());
        System.out.printf("Interés en la inversión: %s", cliente.getInteresInversion());
    }
}
