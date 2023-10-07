package ar.edu.unlu.ejercicio14.SunBeachDos;

import java.util.List;

public class Implementacion {
    public static void main(String[] args) {

        SunBeach agencia = new SunBeach();

        Transporte proveedorTransporte = new Transporte("Combi", 100.0, 10.0);
        Hospedaje proveedorHospedaje = new Hospedaje("Hoteles 'Lo de Norma'", 200.0, 30);
        GuiaTuristico proveedorGuia = new GuiaTuristico("Guía Carlos", 50.0, 300);

        agencia.agregarProveedor(proveedorTransporte);
        agencia.agregarProveedor(proveedorHospedaje);
        agencia.agregarProveedor(proveedorGuia);

        Destino destino1 = new Destino("Santa Teresita");
        Destino destino2 = new Destino("Boulogne");

        PaqueteTurismo paquete1 = new PaqueteTurismo(destino1);
        PaqueteTurismo paquete2 = new PaqueteTurismo(destino2);
        PaqueteTurismo paquete3 = new PaqueteTurismo(destino2);

        paquete1.agregarProveedor(proveedorTransporte);
        paquete1.agregarProveedor(proveedorHospedaje);
        paquete1.agregarProveedor(proveedorGuia);

        paquete2.agregarProveedor(proveedorTransporte);
        paquete2.agregarProveedor(proveedorGuia);

        paquete3.agregarProveedor(proveedorTransporte);
        paquete3.agregarProveedor(proveedorHospedaje);
        paquete3.agregarProveedor(proveedorGuia);

        agencia.agregarPaquete(paquete1);
        agencia.agregarPaquete(paquete2);
        agencia.agregarPaquete(paquete3);

        Cliente cliente1 = new Cliente("Jesús");
        Cliente cliente2 = new Cliente("María");
        Cliente cliente3 = new Cliente("Carlos");

        agencia.registrarVenta(cliente1, paquete1);
        agencia.registrarVenta(cliente2, paquete2);
        agencia.registrarVenta(cliente3, paquete3);

        System.out.println();
        agencia.generarInformeVentasPorDestino();

        Destino destinoFavorito = agencia.calcularDestinoFavorito();
        if (destinoFavorito != null){
            System.out.println("El destino favorito de los clientes es: " + destinoFavorito.getNombre());
        }
        else{
            System.out.println("No se ha determinado un destino favorito aún.");
        }

        List<String> informeVentas = agencia.getInformeVentas();
        System.out.println("\nInforme de ventas:");
        for (String venta : informeVentas) {
            System.out.println(venta);
        }
    }
}