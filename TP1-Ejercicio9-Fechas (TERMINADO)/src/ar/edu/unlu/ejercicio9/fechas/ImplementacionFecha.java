package ar.edu.unlu.ejercicio9.fechas;

import java.time.LocalDate;
import java.util.Scanner;

public class ImplementacionFecha {

    public static void main(String[] argumentos){

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué formato desea? (1/2):");
        System.out.println("1. dd-MM-yyyy");
        System.out.println("2. MM-dd-yyyy");

        int formato = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Primera fecha: ");
        String fechaStr1 = scanner.nextLine();
        System.out.println();

        System.out.println("Segunda fecha: ");
        String fechaStr2 = scanner.nextLine();
        System.out.println();

        System.out.println("Tercera fecha: ");
        String fechaStr3 = scanner.nextLine();
        System.out.println();

        LocalDate fecha1 = Fecha.pasarFecha(fechaStr1, formato);
        LocalDate fecha2 = Fecha.pasarFecha(fechaStr2, formato);
        LocalDate fecha3 = Fecha.pasarFecha(fechaStr3, formato);

        System.out.printf("¿La primera fecha (%s) está entre la segunda (%s) y la tercera (%s)? %b\n", fechaStr1, fechaStr2, fechaStr3, Fecha.entreFechas(fecha1, fecha2, fecha3));
        System.out.printf("¿La segunda fecha (%s) está entre la primera (%s) y la tercera (%s)? %b\n", fechaStr2, fechaStr1, fechaStr3, Fecha.entreFechas(fecha2, fecha1, fecha3));
        System.out.printf("¿La tercera fecha (%s) está entre la primera (%s) y la segunda (%s)? %b\n", fechaStr3, fechaStr1, fechaStr2, Fecha.entreFechas(fecha3, fecha1, fecha2));

        System.out.println();

        if (Fecha.esMayor(fecha1, fecha2)){
            System.out.printf("La primera fecha (%s) es mayor que la segunda (%s)\n", fechaStr1, fechaStr2);
        }
        else if (Fecha.esMenor(fecha1, fecha2)){
            System.out.printf("La primera fecha (%s) es menor que la segunda (%s)\n", fechaStr1, fechaStr2);
        }
        else{
            System.out.printf("La primera y la segunda fecha son iguales, ambas son el día %s\n", fechaStr1);
        }

        System.out.println();

        if (Fecha.esMayor(fecha2, fecha3)){
            System.out.printf("La segunda fecha (%s) es mayor que la tercera (%s)\n", fechaStr2, fechaStr3);
        }
        else if (Fecha.esMenor(fecha2, fecha3)){
            System.out.printf("La segunda fecha (%s) es menor que la tercera (%s)\n", fechaStr2, fechaStr3);
        }
        else{
            System.out.printf("La segunda fecha y la tercera son iguales, ambas son el día %s\n", fechaStr2);
        }

        System.out.println();

        if (Fecha.esMayor(fecha3, fecha1)){
            System.out.printf("La tercera fecha (%s) es mayor que la primera (%s)\n", fechaStr3, fechaStr1);
        }
        else if (Fecha.esMenor(fecha3, fecha1)) {
            System.out.printf("La tercera fecha (%s) es menor que la primera (%s)\n", fechaStr3, fechaStr1);
        }
        else {
            System.out.printf("La tercera fecha y la primera son iguales, ambas son el día %s\n", fechaStr3);
        }
    }
}
