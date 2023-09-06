package ar.edu.unlu.ejercicio8.contraenia;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Contrasenia {

    private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_";
    private int longitud;
    private String contrasenia;
    private String condicion;

    public Contrasenia(){
        this.longitud = 8;
        hacerContrasenia();
    }

    public void PreguntarLongitud(){
        String opcion;
        System.out.printf("La longitud de la contraseña actual es de %d caracteres.\n", this.longitud);
        System.out.print("¿Quiere cambiarla? (S/N): ");

        Scanner sc = new Scanner(System.in);
        opcion = sc.nextLine();

        if (Objects.equals(opcion, "S") || Objects.equals(opcion, "s")){
            System.out.println("Ingrese la nueva longitud de su contraseña (mayor a 8 caracteres por favor): ");
            this.longitud = sc.nextInt();
            sc.nextLine();
            hacerContrasenia();
        }
        else if (Objects.equals(opcion, "N") || Objects.equals(opcion, "n")){
            System.out.printf("La contraseña seguirá siendo de %d caracteres.", this.longitud);
        }
        else{
            System.out.println("Debe ingresar s o n...");
        }
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getLongitud() {
        return longitud;
    }

    public void cambiarLongitud(int nuevaLongitud) {
        this.longitud = nuevaLongitud;
        hacerContrasenia();
    }

    private void hacerContrasenia() {
        Random random = new Random();
        StringBuilder contraseniaGenerada = new StringBuilder();
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;


        while (true){
            contraseniaGenerada.setLength(0); // Reiniciar la contraseña

            for (int i = 0; i < longitud; i++){

                int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
                char caracter = CARACTERES_PERMITIDOS.charAt(indice);
                contraseniaGenerada.append(caracter);

                if (Character.isUpperCase(caracter)){
                    mayusculas++;
                }
                else if (Character.isLowerCase(caracter)){
                    minusculas++;
                }
                else if (Character.isDigit(caracter)){
                    numeros++;
                }
            }

            if (mayusculas > 2 && minusculas > 1 && numeros > 1){
                condicion = "Fuerte";
                break;
            }
            else{
                condicion = "Débil";
                mayusculas = 0;
                minusculas = 0;
                numeros = 0;
            }
        }
        contrasenia = contraseniaGenerada.toString();
    }
    public String getCondicion () {
        return condicion;
    }
}
