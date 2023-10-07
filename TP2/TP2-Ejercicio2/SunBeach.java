package ar.edu.unlu.ejercicio2.turismo;

import java.util.ArrayList;
import java.util.List;

public class SunBeach{

    private List<Proveedor> proveedores;
    private List<Compra> ventas;
    private List<PaqueteTurismo> paquetes;
    private List<Cliente> clientes;
    private List<Destino> destinos;

    public SunBeach() {
        this.proveedores = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.paquetes = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.destinos = new ArrayList<>();
    }

    public void agregarDestino(Destino destino){ destinos.add(destino);}

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPaquete(PaqueteTurismo paquete){
        paquetes.add(paquete);
    }

    public void contratarProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }

    public void registrarVenta(Compra venta){
        ventas.add(venta);
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Compra> getVentas() {
        return ventas;
    }

    public List<PaqueteTurismo> getPaquetes() {
        return paquetes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}
