package ar.edu.unlu.ejercicio8;

public class Prestamo{
    private Publicacion publicacion;
    private SocioBiblioteca socio;

    public Prestamo(Publicacion publicacion, SocioBiblioteca socio){
        this.publicacion = publicacion;
        this.socio = socio;
    }


    @Override
    public String toString(){
        return "Prestamo{" +
                "publicacion=" + publicacion +
                ", socio=" + socio +
                '}';
    }
}
