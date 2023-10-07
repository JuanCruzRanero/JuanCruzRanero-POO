package ar.edu.unlu.ejercicio3.academiaDeDanzas;

import java.util.List;

public class CalculadoraImporte {
    public static void calcularImportePorProfesor(List<Profesor> profesores, List<Diagramacion> diagramaciones){

        System.out.println("\nIMPORTE A PAGAR A LOS PROFESORES:\n");

        for (Profesor profesor : profesores) {
            int totalAsistencias = 0;

            for (Diagramacion diagramacion : diagramaciones) {
                if (diagramacion.getProfesor().equals(profesor)){
                    List<Alumno> alumnosInscritos = diagramacion.getAlumnosInscriptos();

                    for (Alumno alumno : alumnosInscritos){
                        if (alumno.getAsistencia() > 0){
                            totalAsistencias++;
                        }
                    }
                }
            }

            double importe = totalAsistencias * profesor.getSalarioPorClase();

            System.out.printf("Profesor: %s\n", profesor.getNombre());
            System.out.printf("Asistencias totales: %s\n", totalAsistencias);
            System.out.printf("Importe a pagar: $%s\n", importe);
            System.out.println();
        }
    }
}
