package ar.edu.unlu.ProyectoPoker.Modelo;
import java.util.ArrayList;

public class Mesa{
    private int pozo;
    private int apuestaActual;
    private Integer[] apuestas;
    private Jugador[] jugadores;
    private boolean[] jugadoresEnJuego;
    private ArrayList<Jugador> jugadoresEmpatados;
    private Mazo mazo;
    public Mesa(){
        this.pozo=0;
        this.jugadores = new Jugador[]{};
        this.apuestas = new Integer[]{};
        this.jugadoresEnJuego = new boolean[]{};
        this.jugadoresEmpatados = new ArrayList<>();
        this.mazo = new Mazo();
    }

    // GETTERS Y SETTERS
    public int getPozo() {
        return pozo;
    }
    public void setPozo(int pozo) {
        this.pozo = pozo;
    }
    public void setApuestaActual(int apuestaActual){
        this.apuestaActual = apuestaActual;
    }
    public int getApuestaActual() {
        return apuestaActual;
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }
    public Mazo getMazo() {
        return mazo;
    }
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    public Integer[] getApuestas() {
        return apuestas;
    }
    public void setApuestas(Integer[] apuestas) {
        this.apuestas = apuestas;
    }
    public boolean[] getJugadoresEnJuego() {
        return jugadoresEnJuego;
    }
    public void setJugadoresEnJuego(boolean[] jugadoresEnJuego) {
        this.jugadoresEnJuego = jugadoresEnJuego;
    }
    public ArrayList<Jugador> getJugadoresEmpatados() {
        return jugadoresEmpatados;
    }
    public void setJugadoresEmpatados(ArrayList<Jugador> jugadoresEmpatados) {this.jugadoresEmpatados = jugadoresEmpatados;}
    public void cargarApuestas(int posicion, int cantidad){
        apuestas[posicion] = cantidad;
    }

}
