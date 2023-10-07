package ar.edu.unlu.ejercicio8;

public class SocioBiblioteca{
    private String nombre;
    private String numeroSocio;

    public SocioBiblioteca(String nombre, String numeroSocio){
        this.nombre = nombre;
        this.numeroSocio = numeroSocio;
    }

    @Override
    public String toString(){
        return "SocioBiblioteca{" +
                "nombre='" + nombre + '\'' +
                ", numeroSocio='" + numeroSocio + '\'' +
                '}';
    }
}
