package ar.edu.unlu.ejercicio9.fechas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private static DateTimeFormatter formatoUno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter formatoDos = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public static LocalDate pasarFecha(String fechaStr, int formato) {
        DateTimeFormatter formatter = formato == 1 ? formatoUno : formatoDos;
        return LocalDate.parse(fechaStr, formatter);
    }

    public static boolean entreFechas(LocalDate fecha, LocalDate fechaInicio, LocalDate fechaFin) {
        return fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin);
    }

    public static boolean esMayor(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isAfter(fecha2);
    }

    public static boolean esMenor(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isBefore(fecha2);
    }
}