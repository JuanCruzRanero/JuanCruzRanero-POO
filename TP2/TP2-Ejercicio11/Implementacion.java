package ar.edu.unlu.ejercicio11;

public class Implementacion {
    public static void main(String[] arguemntos){

        SistemaAgencia administrador = new SistemaAgencia();

        Vehiculo auto1 = new AutoPasajero("AAA-111", 9, 4);
        Vehiculo auto2 = new AutoVip("BBB-222", 3);
        Vehiculo combi = new Combi("CCC-333", 12);
        Vehiculo camionetaFlete = new CamionetaFlete("DDD-444", 1, 1000);
        Vehiculo camionCarga = new CamionDeCarga("CCC-555", 18 );

        administrador.registrarVehiculo(auto1);
        administrador.registrarVehiculo(auto2);
        administrador.registrarVehiculo(combi);
        administrador.registrarVehiculo(camionetaFlete);
        administrador.registrarVehiculo(camionCarga);

        Cliente cliente1 = new Cliente("Patricio Fontanet");
        Cliente cliente2 = new Cliente("Eli Suárez");
        Cliente cliente3 = new Cliente("Charly García");
        Cliente cliente4 = new Cliente("Indio Solari");
        Cliente cliente5 = new Cliente("Pedro Aznar");

        administrador.registrarCliente(cliente1);
        administrador.registrarCliente(cliente2);
        administrador.registrarCliente(cliente3);
        administrador.registrarCliente(cliente4);
        administrador.registrarCliente(cliente5);

        Presupuesto presupuesto1 = administrador.generarPresupuesto(auto1, 9);
        Presupuesto presupuesto2 = administrador.generarPresupuesto(combi, 12);
        Presupuesto presupuesto3 = administrador.generarPresupuesto(camionCarga, 18);
        Presupuesto presupuesto4 = administrador.generarPresupuesto(auto2, 3);
        Presupuesto presupuesto5 = administrador.generarPresupuesto(camionetaFlete, 1);

        administrador.registrarAlquiler(cliente1, presupuesto1);
        administrador.registrarAlquiler(cliente2, presupuesto2);
        administrador.registrarAlquiler(cliente3, presupuesto3);
        administrador.registrarAlquiler(cliente4, presupuesto4);
        administrador.registrarAlquiler(cliente5, presupuesto5);

        System.out.println();
        System.out.printf("El cliente %s alquiló 'Auto de Pasajero' por %s días.\n", cliente1.getNombre(), presupuesto1.getDiasAlquiler());
        System.out.printf("El monto total de alquileres para el cliente %s es: $%s\n", cliente1.getNombre(), administrador.obtenerMontoTotalAlquileresCliente(cliente1));
        System.out.println();
        System.out.printf("El cliente %s alquiló 'Combi' por %s días.\n", cliente2.getNombre(), presupuesto2.getDiasAlquiler());
        System.out.printf("El monto total de alquileres para el cliente %s es: $%s\n", cliente2.getNombre(), administrador.obtenerMontoTotalAlquileresCliente(cliente2));
        System.out.println();
        System.out.printf("El cliente %s alquiló 'Camión de Carga' por %s días.\n", cliente3.getNombre(), presupuesto3.getDiasAlquiler());
        System.out.printf("El monto total de alquileres para el cliente %s es: $%s\n", cliente3.getNombre(), administrador.obtenerMontoTotalAlquileresCliente(cliente3));
        System.out.println();
        System.out.printf("El cliente %s alquiló 'Auto VIP' por %s días.\n", cliente4.getNombre(), presupuesto4.getDiasAlquiler());
        System.out.printf("El monto total de alquileres para el cliente %s es: $%s\n", cliente4.getNombre(), administrador.obtenerMontoTotalAlquileresCliente(cliente4));
        System.out.println();
        System.out.printf("El cliente %s alquiló 'Flete' por %s días.\n", cliente5.getNombre(), presupuesto5.getDiasAlquiler());
        System.out.printf("El monto total de alquileres para el cliente %s es: $%s\n", cliente5.getNombre(), administrador.obtenerMontoTotalAlquileresCliente(cliente5));
        System.out.println();
        System.out.printf("El monto total de alquileres en el sistema es de: $%s\n", administrador.obtenerMontoTotalAlquileresSistema());
    }
}
