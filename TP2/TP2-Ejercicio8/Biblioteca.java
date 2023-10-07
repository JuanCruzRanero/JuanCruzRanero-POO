package ar.edu.unlu.ejercicio8;

import java.util.ArrayList;
import java.util.List;
public class Biblioteca{

    private List<Libro> libros;
    private List<Revista> revistas;
    private List<Diario> diarios;
    private List<Tesis> tesis;
    public Biblioteca(){
        this.libros = new ArrayList<>();
        this.revistas = new ArrayList<>();
        this.diarios = new ArrayList<>();
        this.tesis = new ArrayList<>();
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public void agregarRevista(Revista revista){
        revistas.add(revista);
    }

    public void agregarDiario(Diario diario){
        diarios.add(diario);
    }

    public void agregarTesis(Tesis tesis){
        this.tesis.add(tesis);
    }


    public void prestarLibro(Libro libro, int cantidad){
        for (Libro libroTemporal : libros){
            if (libroTemporal.equals(libro)){
                libroTemporal.prestar(cantidad);
                return;
            }
        }
        System.out.println("Libro no disponible!");
    }

    public void prestarTesis(Tesis tesis) {
        System.out.println("Préstamo de Tesis realizado:");
        System.out.println(tesis);
    }

    public void prestarRevista(Revista revista, int cantidad) {
        for (Revista revistaTemporal : revistas){
            if (revistaTemporal.equals(revista)){
                revistaTemporal.prestar(cantidad);
                return;
            }
        }
        System.out.println("Revista no disponible!");
    }

    public void prestarDiario(Diario diario) {
        System.out.println("Préstamo de Diario realizado:");
        System.out.println(diario);
    }


}
