package ar.edu.unlu.ProyectoPoker.Modelo;

import java.util.ArrayList;
import java.util.Scanner;
public class Juego {
    private Mesa mesa;
    private int turnoActual;

    public Juego(){
        this.turnoActual = 0;
        this.mesa = new Mesa();
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % mesa.getJugadores().length;
    }

    public Jugador obtenerJugadorActual() {
        return mesa.getJugadores()[turnoActual];
    }

    public Jugador[] agregarJugadores(int cantidadJugadores){
        mesa.setJugadores(new Jugador[cantidadJugadores]);
        return mesa.getJugadores();
    }

    public Integer[] crearVectorApuestas(int cantidadJugadores){
        mesa.setApuestas(new Integer[cantidadJugadores]);
        for (int i=0; i<mesa.getApuestas().length; i++){
            mesa.getApuestas()[i]=0;
        }
        return mesa.getApuestas();
    }

    public boolean[] crearVectorJugadoresEnJuego(int cantidadJugadores){
        mesa.setJugadoresEnJuego(new boolean[cantidadJugadores]);
        for (int i=0; i<mesa.getApuestas().length; i++){
            mesa.getJugadoresEnJuego()[i] = true;
        }
        return mesa.getJugadoresEnJuego();
    }

    public void cargarJugadores(String nombre, int posicion){
        mesa.getJugadores()[posicion] = new Jugador(nombre);
    }

    public void resetearManos(){
        for (int i=0; i< mesa.getJugadores().length; i++) {
            for (int j = 0; j < 5; j++) {
                mesa.getJugadores()[i].dejarCarta(1);
            }
            mesa.getApuestas()[i] = 0;
            mesa.getJugadores()[i].setJugando(true);
            mesa.getJugadores()[i].setHayQueIgualar(false);
            mesa.getJugadoresEnJuego()[i] = mesa.getJugadores()[i].getJugando();
        }
    }

    public void resetearMazo(){
        Mazo mazo = new Mazo();
        mazo.mezclarMazo();
    }

    public boolean todosApostaronIgualYNadieAbandono(){
        int coincidencias = 0;
        int apuestaAux = mesa.getApuestas()[0];
        int coincidenciasBoolean = 0;
        for (int i=0; i< mesa.getJugadores().length; i++){

            if (mesa.getJugadoresEnJuego()[i]){
                coincidenciasBoolean++;
            }
            if (mesa.getApuestas()[i]==apuestaAux){
                coincidencias++;
            }
        }
        return coincidencias == coincidenciasBoolean;
    }

    public void resetearEstadoJugadores(){
        for (int i=0; i< mesa.getJugadores().length; i++) {
            mesa.getJugadores()[i].setJugando(true);
            mesa.getJugadores()[i].setHayQueIgualar(false);
        }
    }

    public void repartir(){
        mesa.getMazo().crearMazo();
        mesa.getMazo().mezclarMazo();
        for (int i = 0; i < mesa.getJugadores().length; i++) {
            mesa.getJugadores()[i].pedirMano(mesa.getMazo());
            mesa.getJugadores()[i].ordenarManoJugador();
            System.out.printf("\nMANO DEL JUGADOR '%s'\n", mesa.getJugadores()[i].getNombre());
            mesa.getJugadores()[i].mostrarManoJugador();
            System.out.println();
            CombinacionJugador combinacionJugador = CombinacionJugador.evaluarMano(mesa.getJugadores()[i].getMano());
            mesa.getJugadores()[i].setCombinacion(combinacionJugador);
            System.out.printf("\nJuego del jugador '%s': %s\n\n", mesa.getJugadores()[i].getNombre(), mesa.getJugadores()[i].getCombinacion().getNombreCombinacion());
        }
    }

    public void determinarGanador(){
        Jugador ganador = new Jugador("");
        int contadorCartaAltaTodos = 0;
        mesa.setJugadoresEmpatados(new ArrayList<>());

        for (int j = 0; j < mesa.getJugadores().length; j++){
            if (mesa.getJugadores()[j].getCombinacion().getNombreCombinacion().equals("Carta Alta")){
                contadorCartaAltaTodos++;
            }
        }

        if (contadorCartaAltaTodos != mesa.getJugadores().length){        // Esto para que si, por ejemplo, tengo un jugador con un par de 2 (suma 4) y uno con A (valor 14), que no gane el segundo.
            int sumaMayor = 0;
            int valorJuegoMayor = 0;

            for (int j = 0; j < mesa.getJugadores().length; j++) {
                if (mesa.getJugadores()[j].sumaJuego() > sumaMayor && !mesa.getJugadores()[j].getCombinacion().getNombreCombinacion().equals("Carta Alta") && (mesa.getJugadores()[j].getCombinacion().getValorDelJuego()) > valorJuegoMayor){
                    ganador = mesa.getJugadores()[j];
                    sumaMayor = ganador.sumaJuego();
                    valorJuegoMayor = ganador.getCombinacion().getValorDelJuego();
                }
            }

            for (int i=0; i<mesa.getJugadores().length; i++){
                if (!mesa.getJugadores()[i].getCombinacion().getNombreCombinacion().equals("Carta Alta") && mesa.getJugadores()[i].sumaJuego() == sumaMayor){
                    mesa.getJugadoresEmpatados().add(mesa.getJugadores()[i]);
                }
            }

            if (mesa.getJugadoresEmpatados().size() >= 2){
                int posicion=0;
                System.out.println("Los ganadores de esta ronda son: ");
                for (Jugador jugador : mesa.getJugadoresEmpatados()){
                    posicion++;
                    jugador.setFichas(jugador.getFichas() + (mesa.getPozo() / mesa.getJugadoresEmpatados().size()));
                    System.out.printf("Ganador %d: '%s'. Se lleva %d fichas del pozo. Nuevo pozo del jugador '%s': %d\n", posicion, jugador.getNombre(), mesa.getPozo() / mesa.getJugadoresEmpatados().size(), jugador.getNombre(), jugador.getFichas());
                }
            }
            else{
                System.out.printf("\nJUGADOR GANADOR: %s\n", ganador.getNombre());
                ganador.setFichas(ganador.getFichas() + mesa.getPozo());
                System.out.printf("Se lleva las %d fichas del pozo. Nuevo pozo del jugador %s: %d\n", mesa.getPozo(), ganador.getNombre(), ganador.getFichas());
            }
        }

        else{
            int sumaMayor = 0;
            for (int j = 0; j < mesa.getJugadores().length; j++) {
                if (mesa.getJugadores()[j].sumaJuego() > sumaMayor) {
                    ganador = mesa.getJugadores()[j];
                    sumaMayor = ganador.sumaJuego();
                }
            }

            if (mesa.getJugadoresEmpatados().size() >= 2){
                int posicion=0;
                System.out.println("Los ganadores de esta ronda son: ");
                for (Jugador jugador : mesa.getJugadoresEmpatados()){
                    posicion++;
                    jugador.setFichas(jugador.getFichas() + (mesa.getPozo() / mesa.getJugadoresEmpatados().size()));
                    System.out.printf("Ganador %d: '%s'. Se lleva %d fichas del pozo. Nuevo pozo del jugador '%s': %d\n", posicion, jugador.getNombre(), mesa.getPozo() / mesa.getJugadoresEmpatados().size(), jugador.getNombre(), jugador.getFichas());
                }
            }
            else{
                System.out.printf("\nJUGADOR GANADOR: %s\n", ganador.getNombre());
                ganador.setFichas(ganador.getFichas() + mesa.getPozo());
                System.out.printf("Se lleva las %d fichas del pozo. Nuevo pozo del jugador %s: %d\n", mesa.getPozo(), ganador.getNombre(), ganador.getFichas());
            }
        }
    }

    public boolean sigueMano(){
        int contadorJugadoresEnMano = 0;
        for (int i=0; i<mesa.getJugadores().length; i++) {
            if (mesa.getJugadores()[i].getJugando()){
                contadorJugadoresEnMano++;
            }
        }
        if (contadorJugadoresEnMano>=2){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean sigueJuego(){

        int contadorJugadoresEnJuego=0;

        for (int i = 0; i<mesa.getJugadores().length; i++){
            if (mesa.getJugadores()[i].getFichas()>0){
                contadorJugadoresEnJuego++;
            }
            else{
                eliminarJugador(mesa.getJugadores()[i]);
            }
        }
        if (contadorJugadoresEnJuego>=2){
            return true;
        }
        else{
            return false;
        }
    }

    public void eliminarJugador(Jugador jugadorAEliminar){
        int posicionAEliminar = -1;
        for (int i = 0; i < mesa.getJugadores().length; i++) {
            if (mesa.getJugadores()[i].equals(jugadorAEliminar)) {
                posicionAEliminar = i;
                break;
            }
        }
        if (posicionAEliminar != -1) {
            Jugador[] nuevoVectorJugadores = new Jugador[mesa.getJugadores().length - 1];
            int indiceAux = 0;
            for (int i = 0; i < mesa.getJugadores().length; i++) {
                if (i != posicionAEliminar) {
                    nuevoVectorJugadores[indiceAux++] = mesa.getJugadores()[i];
                }
            }
            mesa.setJugadores(nuevoVectorJugadores);
        }
    }

    public void cargarEstado(int posicion, boolean condicion){
        mesa.getJugadoresEnJuego()[posicion] = condicion;
    }

    //Getters y Setters
    public Mesa getMesa() {
        return mesa;
    }
    public int getTurnoActual() {
        return turnoActual;
    }
}
