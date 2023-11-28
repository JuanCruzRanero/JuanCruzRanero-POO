package ar.edu.unlu.ProyectoPoker.Modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private boolean jugando;
    private int fichas;
    private int apuestaActual;
    private Mano mano;
    private boolean hayQueIgualar;
    private CombinacionJugador combinacionJugador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.jugando = true;
        this.fichas = 2000;
        this.apuestaActual = 0;
        this.mano = new Mano();
        this.hayQueIgualar = false;
        this.combinacionJugador = new CombinacionJugador("",0, new ArrayList<>());
    }

    public void pedirMano(Mazo mazo){
        mano.crearMano(mazo);
    }

    public void ordenarManoJugador(){
        mano.ordenarMano();
    }

    public void pedirCartas(Mazo mazo, int cantidad){

        for (int i=0; i<cantidad; i++){
            Carta carta = mazo.agarrarCarta();
            mano.agregarCarta(carta);
        }

        System.out.printf("Han sido entregadas %d cartas.\n", cantidad);
    }

    public void mostrarManoJugador(){
        mano.mostrarMano();
    }

    public void dejarCarta(int posicion){

        if (mano.getMano().isEmpty()){
            System.out.println("La mano ya no tiene cartas!");
        }
        else{
            mano.getMano().remove(posicion-1);
        }
    }

    public void apostar(int cantidad){

        fichas -= cantidad;
        System.out.printf("El jugador '%s' realizó una apuesta de %d\n", nombre, cantidad);

    }

    public void abandonar(){
        jugando = false;
    }

    public int sumaJuego(){
        int suma=0;

        if (getCombinacion().getNombreCombinacion().equals("Carta Alta")) {
            return getCombinacion().getCartasDeLaCombinacion().get(4).getValorNumerico();
        }
        else{
            for (int i = 0; i < getCombinacion().getCartasDeLaCombinacion().size(); i++) {
                suma += getCombinacion().getCartasDeLaCombinacion().get(i).getValorNumerico();
            }
            return suma;
        }
    }

    // GETTERS Y SETTERS
    public Mano getMano() {return mano;}
    public void setMano(Mano mano){
        this.mano = mano;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getFichas() {
        return fichas;
    }
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }
    public boolean getJugando(){
        return jugando;
    }
    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
    public boolean getHayQueIgualar() {
        return hayQueIgualar;
    }
    public void setHayQueIgualar(boolean hayQueIgualar) {
        this.hayQueIgualar = hayQueIgualar;
    }
    public CombinacionJugador getCombinacion() {
        return combinacionJugador;
    }
    public void setCombinacion(CombinacionJugador combinacion) {
        this.combinacionJugador = combinacion;
    }
    public int getApuestaActual() {return apuestaActual;}
    public void setApuestaActual(int apuestaActual) {this.apuestaActual = apuestaActual;}
}
