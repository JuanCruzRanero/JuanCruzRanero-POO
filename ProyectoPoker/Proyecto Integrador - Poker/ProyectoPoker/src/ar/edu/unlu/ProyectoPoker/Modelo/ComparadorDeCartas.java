package ar.edu.unlu.ProyectoPoker.Modelo;

import java.util.Arrays;
import java.util.Comparator;
public class ComparadorDeCartas implements Comparator<Carta> {
    @Override
    public int compare(Carta carta1, Carta carta2){
        String[] cartas = Carta.getCARTAS();
        return Arrays.asList(cartas).indexOf(carta1.getValor()) - Arrays.asList(cartas).indexOf(carta2.getValor());
    }
}





