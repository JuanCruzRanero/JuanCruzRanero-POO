package ar.edu.unlu.ejercicio8;

public class Tesis{
    private String nombre;
    private String autor;
    private int mesPublicacion;
    private int anioPublicacion;
    private String telefonoProveedor;

    public Tesis(String nombre, String autor, String telefonoProveedor, int mesPublicacion, int anioPublicacion){
        this.nombre = nombre;
        this.autor = autor;
        this.telefonoProveedor = telefonoProveedor;
        this.mesPublicacion = mesPublicacion;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString(){
        return "Tesis{" +
                "NOMBRE= '" + nombre + '\'' +
                ", AUTOR= '" + autor + '\'' +
                ", TELEFONO= '" + telefonoProveedor + '\'' +
                ", MES= " + mesPublicacion + '\'' +
                ", AÑO= " + anioPublicacion + '\'' +
                '}'+"\n";
    }
}
