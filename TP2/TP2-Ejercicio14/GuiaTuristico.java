package ar.edu.unlu.ejercicio14.SunBeachDos;

public class GuiaTuristico extends Proveedor {
    private int cantidadMaxima;

    public GuiaTuristico(String nombre, double precioBase, int cantidadMaxima) {
        super(nombre, precioBase, "Guía Turístico");
        this.cantidadMaxima = cantidadMaxima;
    }

    public double calcularImporte(int numClientes) {
        if (numClientes > 200) {
            return super.calcularImporte(numClientes) + 90.0;
        } else {
            return super.calcularImporte(numClientes);
        }
    }
}