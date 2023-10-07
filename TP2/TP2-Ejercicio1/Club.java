package ar.edu.unlu.ejercicio1.socios;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Socio> socios;

    public Club(){
        this.socios = new ArrayList<>();
    }

    public void agregarSocio(Socio socio){
        socios.add(socio);
    }

    public void listaNuevosSocios(){
        System.out.println("Socios inscriptos en el mes:\n");
        int contador = 0;

        for (Socio socio : socios){
            contador++;
            System.out.printf("\n%d. Socio: %s\n", contador,socio.getNombre());
            System.out.printf("Direccion: %s\n", socio.getDireccion());
            System.out.printf("DNI: %s\n", socio.getDni());
            System.out.printf("E-mail: %s\n", socio.getEmail());
            System.out.printf("Tipo de suscripción: %s\n", socio.getTipoDeSuscripcion());
        }

        System.out.printf("\nNúmero de socios inscriptos en el mes: %d\n\n", contador);
    }

    public void listaActividadesPorSuscripcion(){

        SuscripcionBasica basica = new SuscripcionBasica("Básica", 900);
        SuscripcionIntermedia intermedia = new SuscripcionIntermedia("Intermedia", 1200);
        SuscripcionDestacada destacada = new SuscripcionDestacada("Destacada", 1800);

        int contador=0;

        System.out.println("\nLista de actividades permitidas para la Suscripción Básica:");

        for (Actividad actividad : basica.getActividadesTipoSuscripcion()){
            System.out.printf("%d. %s\n", ++contador, actividad.getNombreActividad());
        }


        System.out.println("\nLista de actividades permitidas para la Suscripción Intermedia:");

        contador=0;
        for (Actividad actividad : intermedia.getActividadesTipoSuscripcion()){
            System.out.printf("%d. %s\n", ++contador, actividad.getNombreActividad());
        }


        System.out.println("\nLista de actividades permitidas para la Suscripción Destacada:");

        contador=0;
        for (Actividad actividad : destacada.getActividadesTipoSuscripcion()){
            System.out.printf("%d. %s\n", ++contador, actividad.getNombreActividad());
        }

    }

    public void listaSociosPorSuscripcion(String tipoDeSuscripcion){

        int contador = 0;

        System.out.printf("\n\nLista de socios con Suscripción '%s': \n\n",tipoDeSuscripcion);

        for (Socio socio : socios){
            if (socio.getTipoDeSuscripcion().equals(tipoDeSuscripcion)){
                ++contador;
                System.out.printf("\n%d. Socio: %s\n", contador, socio.getNombre());
                System.out.printf("Direccion: %s\n", socio.getDireccion());
                System.out.printf("DNI: %s\n", socio.getDni());
                System.out.printf("E-mail: %s\n", socio.getEmail());
            }
        }
    }
}
