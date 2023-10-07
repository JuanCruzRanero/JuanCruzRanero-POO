package ar.edu.unlu.ejercicio7.estacionDeServicioExtendido;

import java.util.ArrayList;
import java.util.List;

public class Playero {
    private String nombre;
    private String dni;
    private String telefono;
    private List<Venta> ventas;
    private List<Cliente> topClientesMesAnterior;
    private boolean enTop10VentasMesAnterior;

    public Playero(String nombre, String dni, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.ventas = new ArrayList<>();
        this.topClientesMesAnterior = new ArrayList<>();
        this.enTop10VentasMesAnterior = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void registrarVenta(Venta venta){
        ventas.add(venta);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public double getTotalDeVentas(){
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.getLitrosVendidos();
        }
        return total;
    }

    public void setTopClientesMesAnterior(List<Cliente> topClientesMesAnterior) {
        this.topClientesMesAnterior = topClientesMesAnterior;
    }

    public void setEnTop10VentasMesAnterior(boolean enTop10VentasMesAnterior) {
        this.enTop10VentasMesAnterior = enTop10VentasMesAnterior;
    }

    public boolean estaEnTop10VentasMesAnterior() {
        return enTop10VentasMesAnterior;
    }

    public List<Cliente> getTopClientesMesAnterior() {
        return topClientesMesAnterior;
    }
}
