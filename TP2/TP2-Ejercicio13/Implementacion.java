package ar.edu.unlu.ejercicio13.sistemaDeVuelos;

public class Implementacion{
    public static void main(String[] argumentos){

        Pasajero pasajero = new Pasajero("Marcos", "11-1234-5678", "Libertador 178", "123");
        Tripulante tripulante = new Tripulante("Darío", "11-9876-5432", "Bouchard 321", "Piloto");

        Vuelo vuelo = new Vuelo(31, "09-12-2018", "Buenos Aires", "Madrid");
        vuelo.agregarPersona(pasajero);
        vuelo.agregarPersona(tripulante);

        System.out.println("Personas en el vuelo:\n");

        for (Persona persona : vuelo.getMiembrosVuelo()){

            System.out.printf("Nombre: %s\n", persona.getNombre());

            if (persona instanceof Pasajero){
                System.out.printf("Número de Pasajero: %s\n", ((Pasajero) persona).getNumeroDePasajero());
                System.out.println();
            }
            else if (persona instanceof Tripulante){
                System.out.printf("Cargo: %s\n", ((Tripulante) persona).getCargo());
            }
        }
    }
}

