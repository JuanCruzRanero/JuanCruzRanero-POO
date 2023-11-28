package ar.edu.unlu.ProyectoPoker.Modelo;

import ar.edu.unlu.ProyectoPoker.Observer.Observable;
import ar.edu.unlu.ProyectoPoker.Observer.Observador;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo implements Observable {
    private ArrayList<Carta> mazo;
    private ArrayList<Observador> observadores;

    public Mazo(){
        this.mazo = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void agregarCarta(Carta carta){
        mazo.add(carta);
    }

    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizarMazo(this);
        }
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public Carta agarrarCarta(){
        Carta cartaAux = new Carta("", "");
        cartaAux = mazo.remove(0);
        notificar();
        return cartaAux;

    }
    public void crearMazo(){

        String[] palos = Carta.getPALOS();
        String[] cartasPorPalos = Carta.getCARTAS();

        for (int i=0; i<palos.length; i++){
            for (int j=0; j<cartasPorPalos.length; j++){
                agregarCarta(new Carta(cartasPorPalos[j], palos[i]));
            }
        }
    }

    public void mezclarMazo(){
        Collections.shuffle(mazo);
        notificar();
    }

    public void cartasDisponibles(){
        int cantidad=0;
        for (Carta carta : mazo){
            cantidad++;
        }
        System.out.println(cantidad);
    }

    //Getters y Setters
    public ArrayList<Carta> getMazo() {
        return mazo;
    }
}
