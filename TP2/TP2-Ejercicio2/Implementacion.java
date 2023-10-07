package ar.edu.unlu.ejercicio2.turismo;

public class Implementacion {

    public static void main(String[] argumentos) {

        SunBeach administrador = new SunBeach();

        // Creo lo necesario para poder hacer un ejemplo de implementación
        Destino destino1 = new Destino("Las Toninas");
        Destino destino2 = new Destino("Pamplona");
        Destino destino3 = new Destino("New York");

        administrador.agregarDestino(destino1);
        administrador.agregarDestino(destino2);
        administrador.agregarDestino(destino3);

        Hospedaje hospedaje1 = new Hospedaje("Lo de Norma");
        Hospedaje hospedaje2 = new Hospedaje("Cabaña 'El Tito'");
        Hospedaje hospedaje3 = new Hospedaje("Hotel Savoy");

        MedioTransporte transporte1 = new MedioTransporte("Combi");
        MedioTransporte transporte2 = new MedioTransporte("Avión");
        MedioTransporte transporte3 = new MedioTransporte("Barco");

        Excursion excursion1 = new Excursion("Visita a la piedra movediza");
        Excursion excursion2 = new Excursion("Snowboarding");
        Excursion excursion3 = new Excursion("Caminata");

        PaqueteTurismo paquete1 = new PaqueteTurismo("Paquete Basico", "Opción económica.", 912, destino1, transporte1, hospedaje1);
        paquete1.agregarExcursion(excursion1);

        PaqueteTurismo paquete2 = new PaqueteTurismo("Paquete Normal", "Opción media.", 1800, destino2, transporte2, hospedaje2);
        paquete2.agregarExcursion(excursion1);
        paquete2.agregarExcursion(excursion2);

        PaqueteTurismo paquete3 = new PaqueteTurismo("Paquete Premium", "Lo bueno sale caro.", 3100, destino3, transporte3, hospedaje3);
        paquete2.agregarExcursion(excursion1);
        paquete2.agregarExcursion(excursion2);
        paquete2.agregarExcursion(excursion3);

        administrador.agregarPaquete(paquete1);
        administrador.agregarPaquete(paquete2);
        administrador.agregarPaquete(paquete3);

        Cliente cliente1 = new Cliente("Martin González", "11.111.111", "mail1@gmail.com");
        Cliente cliente2 = new Cliente("Julieta Kudelka", "22.222.222", "mail2@gmail.com");
        Cliente cliente3 = new Cliente("Salomón Rondón", "33.333.333", "mail3@gmail.com");

        administrador.registrarCliente(cliente1);
        administrador.registrarCliente(cliente2);
        administrador.registrarCliente(cliente3);

        Proveedor proveedor1 = new Proveedor("Aerolíneas Argentinas", "Aéreo");
        Proveedor proveedor2 = new Proveedor("Rutatlántica", "Terrestre");
        Proveedor proveedor3 = new Proveedor("Barcos 'Esequiel'", "Marítimo");

        administrador.contratarProveedor(proveedor1);
        administrador.contratarProveedor(proveedor2);
        administrador.contratarProveedor(proveedor3);

        Compra compra1 = new Compra(cliente1, paquete1);
        Compra compra2 = new Compra(cliente2, paquete1);
        Compra compra3 = new Compra(cliente3, paquete2);

        administrador.registrarVenta(compra1);
        administrador.registrarVenta(compra2);
        administrador.registrarVenta(compra3);

        //INFORMES REQUERIDOS

        System.out.println("\nLISTADO DE PROVEEDORES: \n");
        for (Proveedor proveedor : administrador.getProveedores()){
            System.out.printf("Proveedor: %s  -  Clasificación: %s\n\n", proveedor.getNombre(), proveedor.getClasificacion());
        }

        System.out.println("\nPAQUETES DISPONIBLES: \n");
        int contador=0;
        for (PaqueteTurismo paquete : administrador.getPaquetes()){
            contador++;
            System.out.printf("%d. '%s'  Precio: %f\n\n", contador, paquete.getNombre(), paquete.getValorDelPaquete());
        }

        System.out.println("\nLISTADO DE CLIENTES: \n");
        for (Cliente cliente : administrador.getClientes()){
            System.out.printf("- Nombre: %s,   DNI: %s,  email: %s\n\n", cliente.getNombre(), cliente.getDni(), cliente.getEmail());
        }

        System.out.println("\nVENTAS ORGANIZADAS POR DESTINO: \n");
        for (Destino destino : administrador.getDestinos()){
            int contadorVentas = 0;

            for (Compra venta : administrador.getVentas()){
                if (venta.getPaquete().getDestino().equals(destino)){
                    contadorVentas++;
                }
            }

            System.out.printf("%s: %d.\n", destino.getDestino(), contadorVentas);
        }

        Destino destinoFavorito= new Destino("");
        int maxVentas = 0;
        for (Destino destino : administrador.getDestinos()){
            int contadorVentas = 0;

            for (Compra venta : administrador.getVentas()){
                if (venta.getPaquete().getDestino().equals(destino)){
                    contadorVentas++;
                }
            }
            if (contadorVentas > maxVentas){
                maxVentas = contadorVentas;
                destinoFavorito = destino;
            }
        }

        System.out.printf("\nEl destino favorito de los clientes es %s\n", destinoFavorito.getDestino());
    }
}

