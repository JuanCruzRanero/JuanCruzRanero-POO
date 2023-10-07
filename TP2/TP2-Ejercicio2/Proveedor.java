package ar.edu.unlu.ejercicio2.turismo;

public class Proveedor {

    private String nombre;
    private String clasificacion;

    public Proveedor(String nombre, String clasificacion){
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

}
