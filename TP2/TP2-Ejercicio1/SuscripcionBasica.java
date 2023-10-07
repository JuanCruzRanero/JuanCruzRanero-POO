package ar.edu.unlu.ejercicio1.socios;

public class SuscripcionBasica extends Suscripcion{
    public SuscripcionBasica(String tipoSuscripcion, double cuota){
        super("Básica", 900);
        setActividadesTipoSuscripcion(new Actividad("Natación"));
    }
}

