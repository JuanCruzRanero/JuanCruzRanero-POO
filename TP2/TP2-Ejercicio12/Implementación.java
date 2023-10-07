package ar.edu.unlu.ejercicio12;

public class Implementación{
    public static void main(String[] argumentos) {

        Cliente cliente = new Cliente("Patricio Rogelio Santos Fontanet", 100000.0, 90.0, 1000.0);

        System.out.println();
        System.out.printf("Cuenta de %s \n", cliente.getNombreCliente());
        System.out.printf("Saldo inicial: %s\n", cliente.getSaldo());
        System.out.printf("Límite de giro en descubierto: %s\n", cliente.getLimiteGiroNormal());
        System.out.printf("Límite de gasto en crédito: %s\n", cliente.getMontoDisponibleCredito());
        System.out.println();

        // Realizar una inversión
        double montoInversion = 500.0;
        int diasInversion = 30;
        cliente.realizarInversion(montoInversion, diasInversion);

        System.out.printf("Inversión realizada con éxito! Monto invertido: %s - Plazo: %s días.\n", montoInversion, diasInversion);
        System.out.printf("Monto invertido: %s\n", cliente.getMontoInvertido());
        System.out.printf("Interés en la inversión: %s\n", cliente.getInteresInversion());
        System.out.println();


        double compra1 = 600.0;
        double compra2 = 300.0;
        cliente.realizarCompraCredito(compra1);
        cliente.realizarCompraCredito(compra2);

        System.out.println("Compras a crédito realizadas:\n");
        System.out.printf("Compra 1: %s\n", compra1);
        System.out.printf("Compra 2: %s\n", compra2);
        System.out.printf("Saldo disponible para compras a crédito: %s\n", cliente.getMontoDisponibleCredito());
        System.out.printf("Saldo deudor en crédito: %s\n", cliente.getSaldoDeudorCredito());
        System.out.println();

        double pagoCredito = 600.0;

        cliente.realizarPagoCredito(pagoCredito);
        System.out.printf("Se efectuó un pago a la deuda de crédito de %s\n", pagoCredito);
        System.out.printf("Saldo deudor en crédito post-pago: %s\n", cliente.getSaldoDeudorCredito());
        System.out.println();

        cliente.cancelarInversion();
        System.out.println("Inversión cancelada con éxito.");
        System.out.printf("Monto invertido post-cancelación: %s\n", cliente.getMontoInvertido());
        System.out.println();

        double compra3 = 600.0;
        cliente.realizarCompraCredito(compra3);
        System.out.printf("Compra a crédito realizada! La inversión fue precancelada automáticamente. Monto de la compra: %s\n", compra3);
        System.out.printf("Monto invertido post-precancelación automática: %s\n", cliente.getMontoInvertido());
        System.out.printf("Monto disponible post-precancelación automática: %s\n", cliente.getMontoDisponible());


        CajaAhorro cajaAhorro = new CajaAhorro(2000.0, 0.02);

        System.out.println();
        System.out.printf("Caja de Ahorro - Saldo inicial: $%s\n", cajaAhorro.getSaldo());

        double depositoCajaAhorro = 1000.0;
        cajaAhorro.realizarDeposito(depositoCajaAhorro);

        System.out.printf("Se efectuó un depósito de $%s en la caja de ahorro.\n", depositoCajaAhorro);
        System.out.printf("El saldo post-depósito es: %s", cajaAhorro.getSaldo());
    }
}
