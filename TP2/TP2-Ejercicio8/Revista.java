package ar.edu.unlu.ejercicio8;

public class Revista extends Publicacion{
    private String issn;

    public Revista(String nombre, String editor, String telefonoProveedor, CantidadEjemplar cantidadEjemplares, String issn){
        super(nombre, editor, telefonoProveedor, cantidadEjemplares);
        this.issn = issn;
    }


    @Override
    public String toString(){
        return "Revista{" +
                "ISSN='" + issn + '\'' +
                "} " + super.toString();
    }

    public void prestar(int cantidad){
        if (getCantidadEjemplares().getCantidadDeEjemplares() >= cantidad){
            getCantidadEjemplares().setCantidadDeEjemplares(getCantidadEjemplares().getCantidadDeEjemplares() - cantidad);
            System.out.println("Préstamo de Revista realizado:");
            System.out.println(this);
        }
        else{
            System.out.println("La cantidad de ejemplares solicitada excede a la existente!");
        }
    }
}
