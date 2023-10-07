package ar.edu.unlu.ejercicio2.turismo;

public class Compra {

    private Cliente comprador;
    private PaqueteTurismo paquete;
    private double valor;

    public Compra(Cliente comprador, PaqueteTurismo paquete){
        this.comprador = comprador;
        this.paquete = paquete;
        this.valor = paquete.getValorDelPaquete();
    }

    public PaqueteTurismo getPaquete() {
        return paquete;
    }
}
