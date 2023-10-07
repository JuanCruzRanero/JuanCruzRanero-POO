package ar.edu.unlu.ejercicio1.socios;

public class SuscripcionIntermedia extends Suscripcion{
    public SuscripcionIntermedia(String tipoSuscripcion, double cuota){
        super("Intermedia", 1200);
        setActividadesTipoSuscripcion(new Actividad("Natación"));
        setActividadesTipoSuscripcion(new Actividad("Fútbol"));
    }
}
