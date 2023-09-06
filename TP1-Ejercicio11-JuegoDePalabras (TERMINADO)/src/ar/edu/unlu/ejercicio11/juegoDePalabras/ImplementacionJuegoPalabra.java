package ar.edu.unlu.ejercicio11.juegoDePalabras;

public class ImplementacionJuegoPalabra {
    public static void main(String[] argumentos){

        Jugador jugador1 = new Jugador("Maxi", 3);
        Jugador jugador2 = new Jugador("Juan", 3);

        jugador1.intentoDelJugador("exonerado");
        jugador1.intentoDelJugador("JuanFer");
        jugador1.intentoDelJugador("hola");

        jugador2.intentoDelJugador("yirar");
        jugador2.intentoDelJugador("exonerado");
        jugador2.intentoDelJugador("pato");

        if (jugador1.puntajeDelJugador() > jugador2.puntajeDelJugador()){
            System.out.printf("El jugador %s es el ganador, el resultado fue %d-%d a su favor. ¡Felicitaciones!", jugador1.nombreJugador(), jugador1.puntajeDelJugador(), jugador2.puntajeDelJugador());
        }
        else if (jugador2.puntajeDelJugador() > jugador1.puntajeDelJugador()){
            System.out.printf("El jugador %s es el ganador, el resultado fue %d-%d a su favor. ¡Felicitaciones!", jugador2.nombreJugador(), jugador2.puntajeDelJugador(), jugador1.puntajeDelJugador());
        }
        else{
            System.out.printf("¡Que partida pareja! ¡Empataron! ¡Ambos obtuvieron %d puntos!", jugador1.puntajeDelJugador());
        }
    }
}
