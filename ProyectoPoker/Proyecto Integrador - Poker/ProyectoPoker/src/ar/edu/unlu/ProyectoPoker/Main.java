package ar.edu.unlu.ProyectoPoker;

import ar.edu.unlu.ProyectoPoker.Controlador.Controlador;
import ar.edu.unlu.ProyectoPoker.Modelo.Juego;
import ar.edu.unlu.ProyectoPoker.Vista.VistaConsola;

public class Main {
    public static void main(String[] argumentos){
        Juego juego = new Juego();
        VistaConsola vista = new VistaConsola();
        Controlador controlador = new Controlador(juego, vista);
        controlador.jugar();
    }
}
