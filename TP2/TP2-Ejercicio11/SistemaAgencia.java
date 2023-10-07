package ar.edu.unlu.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class SistemaAgencia {
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;

    public SistemaAgencia() {
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo){
        boolean patenteExistente = vehiculos.stream().anyMatch(v -> v.getPatente().equals(vehiculo.getPatente()));
        if (!patenteExistente){
            vehiculos.add(vehiculo);
        }
        else{
            System.out.println("Patente ya registrada para otro vehículo.");
        }
    }

    public Presupuesto generarPresupuesto(Vehiculo vehiculo, int diasAlquiler){
        return new Presupuesto(vehiculo, diasAlquiler);
    }

    public void registrarAlquiler(Cliente cliente, Presupuesto presupuesto){
        double montoAlquiler = presupuesto.calcularMonto();
        cliente.agregarMontoAlquiler(montoAlquiler);
    }

    public void registrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public double obtenerMontoTotalAlquileresCliente(Cliente cliente){
        return cliente.getMontoTotalAlquileres();
    }

    public double obtenerMontoTotalAlquileresSistema(){
        double montoTotal = 0;
        for (Cliente cliente : clientes){
            montoTotal += cliente.getMontoTotalAlquileres();
        }
        return montoTotal;
    }

}
