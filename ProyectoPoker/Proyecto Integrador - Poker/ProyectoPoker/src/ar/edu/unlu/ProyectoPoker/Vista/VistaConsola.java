package ar.edu.unlu.ProyectoPoker.Vista;
import ar.edu.unlu.ProyectoPoker.Modelo.Jugador;
import ar.edu.unlu.ProyectoPoker.Modelo.Mazo;
import ar.edu.unlu.ProyectoPoker.Observer.Observador;

import java.util.Scanner;

public class VistaConsola implements Observador {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void actualizarMazo(Mazo mazo){
        System.out.println("\n¡Cantidad de cartas del mazo actualizada con éxito!");
        mazo.cartasDisponibles();
    }

    public int cantidadJugadoresArrays() {
        System.out.println();
        System.out.println(" -------------------------------------------------------- ");
        System.out.println("|---------------¡BIENVENIDO AL PÓKER!--------------------|");
        System.out.println(" -------------------------------------------------------- \n");
        System.out.println(" -------------------------------------------------------");
        System.out.println("|Ingrese la cantidad de jugadores (mínimo 2, máximo 5): |");
        System.out.println(" ------------------------------------------------------- ");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine();
        if (cantidadJugadores < 2 || cantidadJugadores > 5) {
            do {
                System.out.println("Cantidad de jugadores errónea.");
                System.out.println("Por favor, ingrese nuevamente la cantidad de jugadores (mínimo 2, máximo 5): ");
                cantidadJugadores = scanner.nextInt();
                scanner.nextLine();
            } while (cantidadJugadores < 2 || cantidadJugadores > 5);
        }
        return cantidadJugadores;
    }

    public String solicitarNombreJugador() {
        System.out.println("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public void mostrarCartelRonda(int ronda){
        System.out.println();
        System.out.println("---------------------------");
        System.out.printf("|          RONDA %d          |\n", ronda);
        System.out.println("---------------------------");
    }

    public String pedirDescartes(String nombreJugador){
        System.out.printf("\nJugador %s, ¿desea descartar cartas? S/N: ", nombreJugador);
        String decision = scanner.nextLine().toLowerCase();

        if (!decision.equals("s") && !decision.equals("n")) {
            do {
                System.out.println();
                System.out.println("Por favor, ingrese una respuesta válida.");
                System.out.printf("Jugador %s, ¿desea descartar cartas? S/N: ", nombreJugador);
                decision = scanner.nextLine().toLowerCase();
            } while (!decision.equals("s") && !decision.equals("n"));
        }
        return decision;
    }

    public int cantidadDescartes(){
        System.out.println("Ingrese la cantidad de cartas que desea descartar: ");
        int cantidadCartasADejar = scanner.nextInt();
        scanner.nextLine();
        if (cantidadCartasADejar > 5 || cantidadCartasADejar < 1){
            do {
                System.out.println();
                System.out.println("No puede dejar menos de 1 carta o más de 5.");
                System.out.println("Ingrese la cantidad de cartas que desea descartar: ");
                cantidadCartasADejar = scanner.nextInt();
                scanner.nextLine();
            } while (cantidadCartasADejar > 5 || cantidadCartasADejar < 1);
        }
        return cantidadCartasADejar;
    }

    public int posicionDescarte(){
        System.out.println("Ingrese la posicion de la carta que desea dejar: ");
        int posicion = scanner.nextInt();
        scanner.nextLine();
        return posicion;
    }

    public void mostrarJuegoJugador(String nombre, String nombreCombinacion){
        System.out.printf("\n\nJuego del jugador '%s': %s\n", nombre, nombreCombinacion);
    }

    public void quienVa(String nombreJugador, int fichasJugador){
        System.out.printf("\n¡Jugador %s, es tu turno!\n", nombreJugador);
        System.out.println("Fichas disponibles: " + fichasJugador);
    }

    public String decisionApostarAbandonarHayQueIgualar(int apuestaActual){
        System.out.printf("\n¿Desea 'apostar' (%d) o 'abandonar'?: \n", apuestaActual);
        String accion = scanner.nextLine().toLowerCase();

        if (!accion.equals("apostar") && !accion.equals("abandonar")) {
            do {
                System.out.println("\nOpción incorrecta.");
                System.out.println("¿Qué acción desea realizar? apostar/abandonar: ");
                accion = scanner.nextLine().toLowerCase();
            } while (!accion.equals("apostar") && !accion.equals("abandonar"));
        }
        return accion;
    }

    public int pedirApuestaHayQueIgualar(int fichasJugador, int apuestaActual){
        System.out.printf("\nAPUESTA ACTUAL A IGUALAR = %d\n", apuestaActual);
        System.out.println("Ingrese el monto a apostar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (fichasJugador < apuestaActual){
            if (cantidad<=0 || cantidad < fichasJugador){
                do {
                    System.out.println("\nApuesta inválida.");
                    System.out.printf("Usted cuenta con menos fichas que la apuesta actual. Usted debe ir all-in (%d).\n", fichasJugador);
                    System.out.println("Por favor, ingrese nuevamente su apuesta: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();
                }while(cantidad<=0 || cantidad<fichasJugador);
            }
            return cantidad;
        }
        else {
            if (cantidad <= 0 || cantidad > fichasJugador || cantidad < apuestaActual) {
                do {
                    System.out.println("\nApuesta inválida.");
                    System.out.printf("La misma debe ser mayor que 0, como mínimo la apuesta actual (%d) y como máximo su saldo actual (%d)\n", apuestaActual, fichasJugador);
                    System.out.println("Por favor, ingrese nuevamente su apuesta: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();
                } while (cantidad <= 0 || cantidad > fichasJugador || cantidad < apuestaActual);
            }
            return cantidad;
        }
    }

    public String decisionApostarAbandonar(){
        System.out.println("¿Qué acción desea realizar? apostar/abandonar: ");
        String accion = scanner.nextLine().toLowerCase();

        if (!accion.equals("apostar") && !accion.equals("abandonar")) {
            do {
                System.out.println("\nOpción incorrecta.");
                System.out.println("¿Qué acción desea realizar? apostar/abandonar: ");
                accion = scanner.nextLine().toLowerCase();
            } while (!accion.equals("apostar") && !accion.equals("abandonar"));
        }
        return accion;
    }

    public int pedirApuesta(int fichasJugador, int apuestaActual){
        System.out.printf("Ingrese el monto de su apuesta (Saldo actual: %d): \n", fichasJugador);
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        if (cantidad <= 0 || cantidad > fichasJugador || cantidad < apuestaActual) {
            do {
                System.out.println("\nApuesta inválida.");
                System.out.printf("La misma debe ser mayor que 0, como mínimo la apuesta actual (%d) y como máximo su saldo actual (%d)\n", apuestaActual, fichasJugador);
                System.out.println("Por favor, ingrese nuevamente su apuesta: ");
                cantidad = scanner.nextInt();
                scanner.nextLine();
            } while (cantidad <= 0 || cantidad > fichasJugador || cantidad < apuestaActual);
        }
        return cantidad;
    }

    public void mostrarGanadorRondaAbandono(Jugador jugadorActual, int ronda, int pozo){
        System.out.printf("Ganador de la mano numero %d: %s. Se lleva las %d fichas del pozo.\n", ronda, jugadorActual.getNombre(), pozo);
        jugadorActual.setFichas(jugadorActual.getFichas() + pozo);
        System.out.printf("Nuevo pozo del jugador '%s': %d\n", jugadorActual.getNombre(), jugadorActual.getFichas());
    }

    public void separador(){
        for (int i=0; i<7; i++){
            System.out.println();
        }
    }

    public void mostrarGanadorJuego(Jugador[] jugadores){
        System.out.println();
        System.out.println("  ----------------------------------------------------------------------------------");
        System.out.printf(" | JUGADOR GANADOR DEL JUEGO: '%s'. Se llevó la victoria con un total de %d fichas.|\n", jugadores[0].getNombre(), jugadores[0].getFichas());
        System.out.println(" |                              ¡FELICITACIONES!                                    |");
        System.out.println("  ----------------------------------------------------------------------------------");
    }

}
