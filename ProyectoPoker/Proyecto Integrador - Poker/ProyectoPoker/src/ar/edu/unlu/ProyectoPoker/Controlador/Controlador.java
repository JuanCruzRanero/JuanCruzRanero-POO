package ar.edu.unlu.ProyectoPoker.Controlador;
import ar.edu.unlu.ProyectoPoker.Modelo.CombinacionJugador;
import ar.edu.unlu.ProyectoPoker.Modelo.Juego;
import ar.edu.unlu.ProyectoPoker.Modelo.Jugador;
import ar.edu.unlu.ProyectoPoker.Vista.VistaConsola;

public class Controlador {
    Juego juego;
    VistaConsola vista;

    public Controlador(Juego juego, VistaConsola vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void jugar() {
        int cantidadJugadores = vista.cantidadJugadoresArrays();
        juego.agregarJugadores(cantidadJugadores);
        for (int i = 0; i < cantidadJugadores; i++) {
            juego.cargarJugadores(vista.solicitarNombreJugador(), i);
        }
        juego.crearVectorApuestas(cantidadJugadores);
        juego.crearVectorJugadoresEnJuego(cantidadJugadores);

        Jugador jugadorActual;
        int ronda = 1;
        while (juego.sigueJuego()) {
            vista.mostrarCartelRonda(ronda);

            if (ronda > 1) {
                juego.resetearManos();
                juego.resetearEstadoJugadores();
                juego.resetearMazo();
            }
            juego.repartir();

            int contador = 0;
            while (contador < juego.getMesa().getJugadores().length) {
                jugadorActual = juego.obtenerJugadorActual();
                String decision = vista.pedirDescartes(jugadorActual.getNombre());

                if (decision.equalsIgnoreCase("s")) {
                    int cantidadDescarte = vista.cantidadDescartes();
                    for (int i = 0; i < cantidadDescarte; i++) {
                        int posicionDescarte = vista.posicionDescarte();
                        juego.obtenerJugadorActual().dejarCarta(posicionDescarte);
                        System.out.println();
                        juego.obtenerJugadorActual().mostrarManoJugador();
                        System.out.println();
                    }
                    jugadorActual.pedirCartas(juego.getMesa().getMazo(), cantidadDescarte);
                    juego.getMesa().getMazo().agregarObservador(vista);
                    jugadorActual.getMano().ordenarMano();
                    jugadorActual.getMano().mostrarMano();
                    CombinacionJugador combinacionJugador = CombinacionJugador.evaluarMano(jugadorActual.getMano());
                    jugadorActual.setCombinacion(combinacionJugador);
                    vista.mostrarJuegoJugador(jugadorActual.getNombre(), jugadorActual.getCombinacion().getNombreCombinacion());
                }
                juego.siguienteTurno();
                contador++;
            }

            while (juego.sigueMano()) {
                jugadorActual = juego.obtenerJugadorActual();
                if (jugadorActual.getJugando() && jugadorActual.getFichas() > 0) {
                    vista.quienVa(jugadorActual.getNombre(), jugadorActual.getFichas());
                    if (jugadorActual.getHayQueIgualar()) {
                        String decision = vista.decisionApostarAbandonarHayQueIgualar(juego.getMesa().getApuestaActual());
                        if (decision.equalsIgnoreCase("apostar")){
                            int apuesta = vista.pedirApuestaHayQueIgualar(jugadorActual.getFichas(), juego.getMesa().getApuestaActual());
                            juego.getMesa().setApuestaActual(apuesta);                                      // Seteo las características como la apuesta actual (la que va a haber que igualar) y el pozo.
                            juego.getMesa().setPozo(juego.getMesa().getPozo() + apuesta);                   // Luego cargo las apuestas en un vector para chequear que todos apostaron lo mismo.
                            juego.getMesa().cargarApuestas(juego.getTurnoActual(), apuesta);
                            jugadorActual.apostar(apuesta);
                            jugadorActual.setHayQueIgualar(false);
                            juego.siguienteTurno();
                            jugadorActual = juego.obtenerJugadorActual();
                            jugadorActual.setHayQueIgualar(true);

                            if (juego.todosApostaronIgualYNadieAbandono()) {
                                juego.determinarGanador();
                                juego.getMesa().setPozo(0);
                                for (int i = 0; i < juego.getMesa().getJugadores().length; i++) {
                                    juego.getMesa().getJugadores()[i].setJugando(false);

                                    if (juego.getMesa().getJugadores()[i].getFichas() == 0){   //ELIMINA AL JUGADOR QUE TENGA 0 FICHAS
                                        juego.eliminarJugador(juego.getMesa().getJugadores()[i]);
                                    }
                                }
                            }
                        } else {
                            juego.cargarEstado(juego.getTurnoActual(), false);
                            jugadorActual.setJugando(false);
                            jugadorActual.abandonar();
                            juego.siguienteTurno();
                            jugadorActual = juego.obtenerJugadorActual();
                            jugadorActual.setHayQueIgualar(true);
                        }
                    }

                    else {
                        if (vista.decisionApostarAbandonar().equalsIgnoreCase("apostar")) {
                            int cantidad = vista.pedirApuesta(jugadorActual.getFichas(), juego.getMesa().getApuestaActual());
                            juego.getMesa().setApuestaActual(cantidad);
                            juego.getMesa().setPozo(juego.getMesa().getPozo() + cantidad);
                            juego.getMesa().cargarApuestas(juego.getTurnoActual(), cantidad);
                            jugadorActual.apostar(cantidad);
                            jugadorActual.setHayQueIgualar(false);
                            juego.siguienteTurno();
                            jugadorActual = juego.obtenerJugadorActual();
                            jugadorActual.setHayQueIgualar(true);

                            if (juego.todosApostaronIgualYNadieAbandono()) {
                                juego.determinarGanador();
                                juego.getMesa().setPozo(0);
                                for (int i = 0; i < juego.getMesa().getJugadores().length; i++) {
                                    juego.getMesa().getJugadores()[i].setJugando(false);

                                    if (juego.getMesa().getJugadores()[i].getFichas() == 0) {   //ELIMINA AL JUGADOR QUE TENGA 0 FICHAS
                                        juego.eliminarJugador(juego.getMesa().getJugadores()[i]);
                                    }
                                }
                            }
                        }
                        else {
                            juego.cargarEstado(juego.getTurnoActual(), false);
                            jugadorActual.abandonar();
                            juego.siguienteTurno();
                        }
                    }
                }

                if (!juego.sigueMano() && !juego.todosApostaronIgualYNadieAbandono()) {
                    if (!jugadorActual.getJugando()) {
                        juego.siguienteTurno();
                    }
                    jugadorActual = juego.obtenerJugadorActual();

                    vista.mostrarGanadorRondaAbandono(jugadorActual, ronda, juego.getMesa().getPozo());
                    juego.getMesa().setPozo(0);
                    ronda++;
                }
                else if (!juego.sigueMano()) {
                    ronda++;
                    juego.getMesa().setApuestaActual(0);
                    juego.getMesa().setPozo(0);
                    juego.resetearMazo();
                }
            }

            vista.separador();
        }
        vista.mostrarGanadorJuego(juego.getMesa().getJugadores());
    }

}
