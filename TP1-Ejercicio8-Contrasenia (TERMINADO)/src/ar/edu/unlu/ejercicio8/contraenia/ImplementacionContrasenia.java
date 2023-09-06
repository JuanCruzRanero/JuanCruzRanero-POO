package ar.edu.unlu.ejercicio8.contraenia;

public class ImplementacionContrasenia {

    public static void main(String[] args) {

        Contrasenia generador = new Contrasenia();
        generador.PreguntarLongitud();
        System.out.printf("Su nueva contraseña es: %s y su nivel de seguridad es: %s.\n", generador.getContrasenia(), generador.getCondicion());
        System.out.printf("Longitud de la nueva contraseña: %d caracteres.", generador.getLongitud());
    }
}
