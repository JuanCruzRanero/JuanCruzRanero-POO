package ar.edu.unlu.ejercicio14.SunBeachDos;

public class Hospedaje extends Proveedor {

    private int cantidadMinima;

    public Hospedaje(String nombre, double precioBase, int cantidadMinima) {
        super(nombre, precioBase, "Hospedaje");
        this.cantidadMinima = cantidadMinima;
    }

    public double calcularImporte(int numClientes) {
        if (numClientes > cantidadMinima) {
            return super.calcularImporte(numClientes) - (0.005 * super.calcularImporte(numClientes));
        } else {
            return super.calcularImporte(numClientes);
        }
    }
}