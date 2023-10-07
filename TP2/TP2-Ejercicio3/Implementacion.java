package ar.edu.unlu.ejercicio3.academiaDeDanzas;

import java.util.ArrayList;
import java.util.List;


public class Implementacion{
    public static void main(String[] args){

        Academia academia = new Academia("La Acadé");

        Profesor profesor1 = new Profesor("Patricio Fontanet");
        Profesor profesor2 = new Profesor("Ariel Ortega");

        Diagramacion diagramacion1 = new Diagramacion("Miércoles", "09:00 - 12:00", "Inicial", "Cachengue", profesor1);
        Diagramacion diagramacion2 = new Diagramacion("Viernes", "16:00 - 21:00", "Avanzado", "Tango", profesor2);

        Alumno alumno1 = new Alumno("Kodigo", "kodimatarata@gmail.com", "0912-2018");
        Alumno alumno2 = new Alumno("PapoMC", "labestiadelhardcore@gmail.com", "2222-2222");
        Alumno alumno3 = new Alumno("Dtoke", "chekechechekecheka@gmail.com", "3333-3333");

        academia.agregarDiagramacion(diagramacion1);
        academia.agregarDiagramacion(diagramacion2);

        diagramacion1.inscribirAlumno(alumno1);
        diagramacion1.inscribirAlumno(alumno2);
        diagramacion2.inscribirAlumno(alumno3);

        List<Profesor> profesores = new ArrayList<>();
        profesores.add(profesor1);
        profesores.add(profesor2);

        System.out.println();
        System.out.printf("Academia '%s'\n\n", academia.getNombre());

        System.out.printf("Diagramaciones de '%s'\n\n", academia.getNombre());

        for (Diagramacion diagramacion : academia.getDiagramaciones()){
            System.out.printf("Dia: %s - Horario: %s - Profesor: %s\n", diagramacion.getDia(), diagramacion.getHorario(), diagramacion.getProfesor().getNombre());

            System.out.println("\nAlumnos inscriptos:\n");
            for (Alumno alumno : diagramacion.getAlumnosInscriptos()){
                System.out.printf("Alumno: %s - Credencial: %s\n", alumno.getNombre(), alumno.getCredencial());
            }
            System.out.println();
        }

        System.out.println();
        alumno1.marcarAsistencia();
        alumno2.marcarAsistencia();
        alumno2.marcarAsistencia();
        alumno1.marcarAsistencia();
        System.out.println();
        alumno1.imprimirAsistencias();
        alumno2.imprimirAsistencias();
        alumno3.imprimirAsistencias();

        CalculadoraImporte.calcularImportePorProfesor(profesores, academia.getDiagramaciones());
        System.out.println();

        String disciplinaMayorIngresos = CalculadoraDisciplinaConMayorIngresos.calcularDisciplinaConMayorIngresos(academia.getDiagramaciones());
        System.out.printf("La disciplina con mayor magnitud de ingresos es: %s\n", disciplinaMayorIngresos);
    }
}
