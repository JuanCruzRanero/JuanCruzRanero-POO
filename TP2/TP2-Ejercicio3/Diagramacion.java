package ar.edu.unlu.ejercicio3.academiaDeDanzas;

import java.util.ArrayList;
import java.util.List;

public class Diagramacion {
    private String dia;
    private String horario;
    private String nivel;
    private String disciplina;
    private Profesor profesor;
    private List<Alumno> alumnosInscriptos = new ArrayList<>();

    public Diagramacion(String dia, String horario, String nivel, String disciplina, Profesor profesor) {
        this.dia = dia;
        this.horario = horario;
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.profesor = profesor;
    }

    public String getDia() {
        return dia;
    }

    public String getHorario() {
        return horario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public List<Alumno> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void inscribirAlumno(Alumno alumno) {
        alumnosInscriptos.add(alumno);
    }
}
