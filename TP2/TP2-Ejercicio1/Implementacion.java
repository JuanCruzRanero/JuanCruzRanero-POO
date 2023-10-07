package ar.edu.unlu.ejercicio1.socios;

public class Implementacion {
    public static void main(String[] argumentos){

        SuscripcionBasica basica = new SuscripcionBasica("Básica", 900);
        SuscripcionIntermedia intermedia = new SuscripcionIntermedia("Intermedia", 1200);
        SuscripcionDestacada destacada = new SuscripcionDestacada("Destacada", 1800);

        Socio socio1 = new Socio("Martín", "12.345.678", "Justo Daract 1234", "mail1@gmail.com", "Básica");
        Socio socio2 = new Socio("Pablo", "87.654.321", "Beltrán 5678", "mail2@gmail.com", "Intermedio");
        Socio socio3 = new Socio("Ricardo", "9.121.800", "Aristóbulo del Valle 910", "mail3l@gmail.com", "Destacada");
        Socio socio4 = new Socio("Maximiliano", "44.234.432", "Bouchard 874", "mail4l@gmail.com", "Básica");

        Club club = new Club();

        club.agregarSocio(socio1);
        club.agregarSocio(socio2);
        club.agregarSocio(socio3);
        club.agregarSocio(socio4);

        System.out.println();
        club.listaNuevosSocios();
        club.listaActividadesPorSuscripcion();
        club.listaSociosPorSuscripcion("Básica");
    }
}
