package ar.edu.unlu.ejercicio8;

public class Libro extends Publicacion{
    private String isbn;

    public Libro(String nombre, String editor, String telefonoProveedor, CantidadEjemplar cantidadEjemplares, String isbn){
        super(nombre, editor, telefonoProveedor, cantidadEjemplares);
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + isbn + '\'' +
                "} " + super.toString();
    }

    public void prestar(int cantidad){
        if (getCantidadEjemplares().getCantidadDeEjemplares() >= cantidad){
            getCantidadEjemplares().setCantidadDeEjemplares(getCantidadEjemplares().getCantidadDeEjemplares() - cantidad);
            System.out.println("Préstamo de Libro realizado:");
            System.out.println(this);
        }
        else{
            System.out.println("La cantidad de ejemplares solicitada excede a la existente!");
        }
    }
}
