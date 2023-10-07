package ar.edu.unlu.ejercicio7.estacionDeServicioExtendido;

public class Venta{
    private String patente;
    private String tipoCombustible;
    private double totalVenta;
    private int litrosVendidos;
    private Surtidor surtidorUsado;

    public Venta(Cliente cliente, Combustible tipoCombustible, int litros, Surtidor surtidorUsado){
        this.patente = cliente.getPatente();
        this.tipoCombustible = tipoCombustible.getNombreCombustible();
        this.totalVenta = litros * tipoCombustible.getValorCombustible();
        this.litrosVendidos = litros;
        this.surtidorUsado = surtidorUsado;
    }

    public String getPatente() {
        return patente;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public int getLitrosVendidos() {
        return litrosVendidos;
    }

    public Surtidor getSurtidorUsado() {
        return surtidorUsado;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

}