package ar.edu.unlu.ejercicio3.academiaDeDanzas;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDisciplinaConMayorIngresos {
    public static String calcularDisciplinaConMayorIngresos(List<Diagramacion> diagramaciones) {
        List<DisciplinaIngresos> ingresosPorDisciplina = new ArrayList<>();

        for (Diagramacion diagramacion : diagramaciones){

            String disciplina = diagramacion.getDisciplina();
            double importe = diagramacion.getProfesor().getSalarioPorClase() * diagramacion.getAlumnosInscriptos().size();
            boolean encontrada = false;

            for (DisciplinaIngresos disciplinaIngresos : ingresosPorDisciplina){
                if (disciplinaIngresos.disciplina.equals(disciplina)){
                    disciplinaIngresos.ingresos += importe;
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                ingresosPorDisciplina.add(new DisciplinaIngresos(disciplina, importe));
            }
        }

        String disciplinaConMayorIngresos = null;
        double mayorIngreso = 0.0;

        for (DisciplinaIngresos disciplinaIngresos : ingresosPorDisciplina) {
            if (disciplinaIngresos.ingresos > mayorIngreso) {
                mayorIngreso = disciplinaIngresos.ingresos;
                disciplinaConMayorIngresos = disciplinaIngresos.disciplina;
            }
        }

        return disciplinaConMayorIngresos;
    }

    private static class DisciplinaIngresos {
        String disciplina;
        double ingresos;

        DisciplinaIngresos(String disciplina, double ingresos) {
            this.disciplina = disciplina;
            this.ingresos = ingresos;
        }
    }
}
