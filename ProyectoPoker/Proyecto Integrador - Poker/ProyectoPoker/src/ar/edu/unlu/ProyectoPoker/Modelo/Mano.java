package ar.edu.unlu.ProyectoPoker.Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Mano {
    private ArrayList<Carta> mano;
    public Mano(){
        this.mano = new ArrayList<>();
    }

    public void crearMano(Mazo mazo){
        for (int i=0; i<5; i++){
            Carta carta = mazo.agarrarCarta();
            if (carta != null){
                mano.add(carta);
            }
        }
    }

    public void ordenarMano(){
        Collections.sort(mano, new ComparadorDeCartas());
    }

    public void agregarCarta(Carta carta){
        if (mano.size()<5){
            mano.add(carta);
        }
        else{
            System.out.println("La mano llegó a su limite de cartas posibles");
        }
    }

    public void mostrarMano(){
        for (Carta carta : mano){
            System.out.println();
            System.out.printf("%s de %s", carta.getValor(), carta.getPalo());
        }
    }

    //Getters y Setters
    public ArrayList<Carta> getMano() {
        return mano;
    }
    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }
}
