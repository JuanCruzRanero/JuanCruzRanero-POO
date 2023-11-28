package ar.edu.unlu.ProyectoPoker.Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinacionJugador {
    private String combinacion;
    private int valorDelJuego;
    private List<Carta> cartasDeLaCombinacion;

    public CombinacionJugador(String combinacion, int valorDelJuego, List<Carta> cartasDeLaCombinacion){
        this.combinacion = combinacion;
        this.valorDelJuego = valorDelJuego;
        this.cartasDeLaCombinacion = cartasDeLaCombinacion;
    }

    public static CombinacionJugador evaluarMano(Mano mano){
        if (EscaleraReal(mano)){
            return new CombinacionJugador("Escalera Real", 10, mano.getMano());     // En los juegos Escalera Real, Escalera Color, Color, Escalera, basta con obtener la mano del jugador,
        }                                                                                                  // pues son juegos compuestos por las 5 cartas de la misma.
        else if (EscaleraColor(mano)){
            return new CombinacionJugador("Escalera Color", 9, mano.getMano());
        }
        else if (Poker(mano)){
            return new CombinacionJugador("Poker", 8, getCartasPoker(mano));
        }
        else if (Full(mano)){
            return new CombinacionJugador("Full", 7, getCartasFull(mano));
        }
        else if (Color(mano)){
            return new CombinacionJugador("Color", 6, mano.getMano());
        }
        else if (Escalera(mano)){
            return new CombinacionJugador("Escalera", 5, mano.getMano());
        }
        else if (Pierna(mano)){
            return new CombinacionJugador("Pierna", 4, getCartasPierna(mano));
        }
        else if (DoblePar(mano)){
            return new CombinacionJugador("Doble Par", 3, getCartasDoblePar(mano));
        }
        else if (Par(mano)){
            return new CombinacionJugador("Par", 2, getCartasPar(mano));
        }
        else{
            return new CombinacionJugador("Carta Alta", 1, mano.getMano());    // Es carta alta si no existe ninguno de los demas juegos, por ende no hace falta el metodo que lo compruebe.
        }                                                                                             // Aquí también sólo obtenemos la mano, pues basta con ver el valor de la última carta de la misma.
    }

    public static boolean Par(Mano mano){
        for (int i=0; i <= (mano.getMano().size() - 2); i++){
            if (mano.getMano().get(i).getValor().equals(mano.getMano().get(i+1).getValor())){
                return true;
            }
        }
        return false;
    }

    private static boolean DoblePar(Mano mano) {
        int pares = 0;
        for (int i = 0; i <= (mano.getMano().size() - 2); i++) {
            if (mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor())) {
                pares++;
                i++;
            }
        }
        return pares == 2;
    }

    private static boolean Pierna(Mano mano){
        for (int i = 0; i <= (mano.getMano().size() - 3); i++){
            if ( (mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor()) ) && ( mano.getMano().get(i + 1).getValor().equals(mano.getMano().get(i + 2).getValor()) )){
                return true;
            }
        }
        return false;
    }


    private static boolean Escalera(Mano mano) {
        for (int i = 0; i < (mano.getMano().size() - 1); i++){
            String cartaActual = mano.getMano().get(i).getValor();
            String cartaSiguiente = mano.getMano().get(i+1).getValor();
            int indiceActual = Arrays.asList(Carta.getCARTAS()).indexOf(cartaActual);
            int indiceSiguiente = Arrays.asList(Carta.getCARTAS()).indexOf(cartaSiguiente);
            if ((indiceSiguiente - indiceActual) != 1){
                return false;
            }
        }
        return true;
    }

    private static boolean Color(Mano mano){
        int contadorCorazones = 0;
        int contadorDiamantes = 0;
        int contadorPicas = 0;
        int contadorTreboles = 0;

        for (Carta carta : mano.getMano()){
            String palo = carta.getPalo();
            switch (palo){
                case "Corazones":
                    contadorCorazones++;
                    break;
                case "Diamantes":
                    contadorDiamantes++;
                    break;
                case "Picas":
                    contadorPicas++;
                    break;
                case "Treboles":
                    contadorTreboles++;
                    break;
            }
        }
        return contadorCorazones == 5 || contadorDiamantes == 5 || contadorPicas == 5 || contadorTreboles == 5; //Acordarse que acá puede ir >=
    }

    private static boolean Poker(Mano mano) {
        for (int i = 0; i <= (mano.getMano().size() - 4); i++){
            if (  (mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor()))   &&   (mano.getMano().get(i + 1).getValor().equals(mano.getMano().get(i + 2).getValor()))   &&   (mano.getMano().get(i + 2).getValor().equals(mano.getMano().get(i + 3).getValor() ))) {
                return true;
            }
        }
        return false;
    }

    private static boolean EscaleraColor(Mano mano) {
        return Escalera(mano) && Color(mano);
    }

    private static boolean Full(Mano mano) {
        return Pierna(mano) && DoblePar(mano);
    }

    private static boolean EscaleraReal(Mano mano) {
        return Escalera(mano) && mano.getMano().get(mano.getMano().size() - 1).getValor().equals("A");      //Si el jugador tiene escalera, y la última carta de esa escalera es un AS, entonces tiene escalera real.
    }

    private static List<Carta> getCartasPar(Mano mano) {
        for (int i = 0; i <= (mano.getMano().size() - 2); i++) {
            if (mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor())) {
                return List.of(mano.getMano().get(i), mano.getMano().get(i + 1));
            }
        }
        return new ArrayList<>();
    }

    private static List<Carta> getCartasDoblePar(Mano mano) {
        List<Carta> cartasDelDoblePar = new ArrayList<>();
        int pares = 0;

        for (int i = 0; i <= (mano.getMano().size() - 2); i++){
            if (mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor())){
                cartasDelDoblePar.add(mano.getMano().get(i));
                cartasDelDoblePar.add(mano.getMano().get(i + 1));
                pares++;
                i++;
            }
        }
        if (pares == 2){
            return cartasDelDoblePar;
        }
        else{
            return new ArrayList<>();
        }
    }

    private static List<Carta> getCartasPierna(Mano mano) {
        for (int i = 0; i <= (mano.getMano().size() - 3); i++) {
            if ((mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor())) && (mano.getMano().get(i + 1).getValor().equals(mano.getMano().get(i + 2).getValor()))) {
                return List.of(mano.getMano().get(i), mano.getMano().get(i + 1), mano.getMano().get(i + 2));
            }
        }
        return new ArrayList<>();
    }

    private static List<Carta> getCartasPoker(Mano mano){
        for (int i = 0; i <= (mano.getMano().size() - 4); i++) {
            if ((mano.getMano().get(i).getValor().equals(mano.getMano().get(i + 1).getValor())) && (mano.getMano().get(i + 1).getValor().equals(mano.getMano().get(i + 2).getValor())) && (mano.getMano().get(i + 2).getValor().equals(mano.getMano().get(i + 3).getValor()))) {
                return List.of(mano.getMano().get(i), mano.getMano().get(i + 1), mano.getMano().get(i + 2), mano.getMano().get(i + 3));
            }
        }
        return new ArrayList<>();
    }

    private static List<Carta> getCartasFull(Mano mano){
        List<Carta> cartasDelFull = new ArrayList<>();
        List<Carta> cartasDeLaPierna = getCartasPierna(mano);
        List<Carta> cartasDelDoblePar = getCartasDoblePar(mano);

        if (!cartasDeLaPierna.isEmpty() && !cartasDelDoblePar.isEmpty()){
            cartasDelFull.addAll(cartasDeLaPierna);
            cartasDelFull.addAll(cartasDelDoblePar);
        }
        if (cartasDelFull.size() == 5 ){
            return cartasDelFull;
        }
        else{
            return new ArrayList<>();
        }
    }

    // GETTERS Y SETTERS
    public String getNombreCombinacion() {
        return combinacion;
    }
    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }
    public int getValorDelJuego() {
        return valorDelJuego;
    }
    public void setValorDelJuego(int valorDelJuego) {
        this.valorDelJuego = valorDelJuego;
    }
    public List<Carta> getCartasDeLaCombinacion() {
        return cartasDeLaCombinacion;
    }
    public void setCartasDeLaCombinacion(List<Carta> cartasDeLaCombinacion) {
        this.cartasDeLaCombinacion = cartasDeLaCombinacion;
    }
}
