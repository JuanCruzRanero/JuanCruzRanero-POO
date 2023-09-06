package ar.edu.unlu.ejercicio7.ecuacion;
import java.util.Objects;
import java.util.Scanner;

public class ImplementacionEcucacion {

    public static void main(String[] args){

        String opcion_y;
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Valor de b: ");
        double b = sc.nextDouble();

        System.out.print("Valor de c: ");
        double c = sc.nextDouble();

        Ecuacion ecuacion = new Ecuacion(a, b, c);


        double discriminante = ecuacion.discriminante();

        if (discriminante < 0){
            System.out.println("La ecuación no tiene raíces reales.");
        }
        else if (discriminante == 0){
            double raizUnica = ecuacion.primeraRaiz();
            System.out.printf("La ecuación tiene sólo una raíz, y es: %f", raizUnica);
        }
        else{
            double raiz1 = ecuacion.primeraRaiz();
            double raiz2 = ecuacion.segundaRaiz();
            System.out.println("Raíz 1: " + raiz1);
            System.out.println("Raíz 2: " + raiz2);
        }

        sc.nextLine();
        System.out.print("Quiere calcular el valor de 'y'? (S/N): ");
        opcion_y = sc.nextLine();
        System.out.println("\n");

        if (Objects.equals(opcion_y, "S") || Objects.equals(opcion_y, "s")){
            System.out.print("Ingrese el valor de x para calcular y: ");
            double x = sc.nextDouble();
            double y = ecuacion.calcularY(x);
            System.out.printf("El valor de y para x= %f es: %f", x, y);
        }
        else if (Objects.equals(opcion_y, "N") || Objects.equals(opcion_y, "n")){
            System.out.println("Como gustes...");
        }
        else{
            System.out.println("Esa opción no existe... Intentelo de nuevo.");
        }

        sc.close();
    }
}
