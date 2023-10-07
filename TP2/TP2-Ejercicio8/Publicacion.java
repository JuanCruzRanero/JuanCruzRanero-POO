package ar.edu.unlu.ejercicio8;

public class Publicacion{
    protected String nombre;
    protected String editor;
    protected String telefonoProveedor;
    protected CantidadEjemplar cantidadEjemplares;

    public Publicacion(String nombre, String editor, String telefonoProveedor, CantidadEjemplar cantidadEjemplares){
        this.nombre = nombre;
        this.editor = editor;
        this.telefonoProveedor = telefonoProveedor;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public CantidadEjemplar getCantidadEjemplares(){
        return cantidadEjemplares;
    }

    @Override
    public String toString(){
        return "Publicacion{" +
                "NOMBRE= '" + nombre + '\'' +
                ", AUTOR= '" + editor + '\'' +
                ", TELEFONO= '" + telefonoProveedor + '\'' +
                ", CANTIDAD EJEMPLARES= " + cantidadEjemplares.getCantidadDeEjemplares() +
                '}'+"\n";
    }
}
