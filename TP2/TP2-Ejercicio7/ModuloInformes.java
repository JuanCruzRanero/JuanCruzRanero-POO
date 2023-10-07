package ar.edu.unlu.ejercicio7.estacionDeServicioExtendido;

import java.util.ArrayList;
import java.util.List;

public class ModuloInformes {

    private List<Playero> playeros;
    private List<Combustible> tiposCombustible;

    public ModuloInformes() {
        this.playeros = new ArrayList<>();
        this.tiposCombustible = new ArrayList<>();
    }

    public void agregarCombustible(Combustible combustible) {
        tiposCombustible.add(combustible);
    }

    public void contratarPlayero(Playero playero) {
        playeros.add(playero);
    }

    public double getTotalVentas(){
        double recaudacionTotal = 0;
        for (Playero playero : playeros) {
            for (Venta venta : playero.getVentas()) {
                recaudacionTotal += venta.getTotalVenta();
            }
        }
        return recaudacionTotal;
    }

    public void ventasPorCombustible(){

        for (Combustible combustible : tiposCombustible){

            int cantidadVentas = 0;
            double recaudacionCombustible = 0;

            for (Playero playero : playeros){

                for (Venta venta : playero.getVentas()){
                    if (venta.getTipoCombustible().equals(combustible.getNombreCombustible())){
                        cantidadVentas++;
                        recaudacionCombustible += venta.getTotalVenta();
                    }
                }
            }

            if (cantidadVentas != 0){
                System.out.printf("Tipo de combustible: '%s'  -  Porcentaje: %f por ciento.\n", combustible.getNombreCombustible(), (recaudacionCombustible / getTotalVentas()) * 100);
            }
        }
    }

    public void generarInformeSurtidoresPorMonto(){

        List<String> codigosSurtidores = new ArrayList<>();
        List<Double> totalesPorSurtidor = new ArrayList<>();

        for (Playero playero : playeros){
            for (Venta venta : playero.getVentas()){

                String codigoDeSurtidor = venta.getSurtidorUsado().getCodigoDeSurtidor();
                double montoVenta = venta.getTotalVenta();
                int indice = codigosSurtidores.indexOf(codigoDeSurtidor);

                if (indice == -1){
                    codigosSurtidores.add(codigoDeSurtidor);
                    totalesPorSurtidor.add(montoVenta);
                }
                else{
                    double totalExistente = totalesPorSurtidor.get(indice);
                    totalesPorSurtidor.set(indice, totalExistente + montoVenta);
                }
            }
        }

        while (!codigosSurtidores.isEmpty()){

            int maxIndex = 0;

            for (int i=1; i < codigosSurtidores.size(); i++){
                if (totalesPorSurtidor.get(i) > totalesPorSurtidor.get(maxIndex)){
                    maxIndex = i;
                }
            }

            String codigoSurtidor = codigosSurtidores.get(maxIndex);
            double totalVenta = totalesPorSurtidor.get(maxIndex);
            System.out.printf("El surtidor número %s recaudó un total de $%f\n", codigoSurtidor, totalVenta);

            codigosSurtidores.remove(maxIndex);
            totalesPorSurtidor.remove(maxIndex);
        }
    }

    public void generarInformeSurtidoresPorLitros(){

        List<String> codigosSurtidores = new ArrayList<>();
        List<Double> litrosExpendidosPorSurtidor = new ArrayList<>();

        for (Playero playero : playeros){
            for (Venta venta : playero.getVentas()){

                String codigoSurtidor = venta.getSurtidorUsado().getCodigoDeSurtidor();
                double litrosVendidos = venta.getLitrosVendidos();
                int indice = codigosSurtidores.indexOf(codigoSurtidor);

                if (indice == -1){
                    codigosSurtidores.add(codigoSurtidor);
                    litrosExpendidosPorSurtidor.add(litrosVendidos);
                }
                else{
                    double litrosExistente = litrosExpendidosPorSurtidor.get(indice);
                    litrosExpendidosPorSurtidor.set(indice, litrosExistente + litrosVendidos);
                }
            }
        }

        while (!codigosSurtidores.isEmpty()){
            int indiceMax = 0;

            for (int i = 1; i < codigosSurtidores.size(); i++){
                if (litrosExpendidosPorSurtidor.get(i) > litrosExpendidosPorSurtidor.get(indiceMax)){
                    indiceMax = i;
                }
            }

            String codigoSurtidor = codigosSurtidores.get(indiceMax);
            double litrosExpendidos = litrosExpendidosPorSurtidor.get(indiceMax);
            System.out.printf("El surtidor número %s tuvo %f litros expendidos.\n", codigoSurtidor, litrosExpendidos);

            codigosSurtidores.remove(indiceMax);
            litrosExpendidosPorSurtidor.remove(indiceMax);
        }
    }

    public void generarInformePlayerosPorVentas(){

        List<String> nombresPlayeros = new ArrayList<>();
        List<Double> montosVentasPorPlayero = new ArrayList<>();

        for (Playero playero : playeros){
            String nombrePlayero = playero.getNombre();
            double totalVentas = playero.getTotalDeVentas();
            nombresPlayeros.add(nombrePlayero);
            montosVentasPorPlayero.add(totalVentas);
        }

        while (!nombresPlayeros.isEmpty()){
            int indiceMax = 0;

            for (int i = 1; i < nombresPlayeros.size(); i++){
                if (montosVentasPorPlayero.get(i) > montosVentasPorPlayero.get(indiceMax)){
                    indiceMax = i;
                }
            }

            String nombrePlayero = nombresPlayeros.get(indiceMax);
            double montoVentas = montosVentasPorPlayero.get(indiceMax);
            System.out.printf("El Playero/a '%s' vendió la cantidad de %f litros.\n",nombrePlayero ,montoVentas);

            nombresPlayeros.remove(indiceMax);
            montosVentasPorPlayero.remove(indiceMax);
        }
    }

    public void generarTop10Clientes(){

        List<String> patentes = new ArrayList<>();
        List<Double> montosTotales = new ArrayList<>();

        for (Playero playero : playeros){

            for (Venta venta : playero.getVentas()){
                String patente = venta.getPatente();
                double monto = venta.getLitrosVendidos();
                int indice = patentes.indexOf(patente);

                if (indice == -1){
                    patentes.add(patente);
                    montosTotales.add(monto);
                }
                else{
                    montosTotales.set(indice, montosTotales.get(indice) + monto);
                }
            }
        }


        int contador = 0;
        while (contador < 10 && !patentes.isEmpty()){
            int indiceMax = 0;
            double montoMax = montosTotales.get(0);

            for (int i = 1; i < montosTotales.size(); i++){
                if (montosTotales.get(i) > montoMax){
                    indiceMax = i;
                    montoMax = montosTotales.get(i);
                }
            }

            System.out.printf("Cliente de patente '%s' - Total de litros: '%f'\n", patentes.get(indiceMax), montoMax);

            patentes.remove(indiceMax);
            montosTotales.remove(indiceMax);
            contador++;
        }
    }

    public void calcularTopClientesMesAnterior(){
        List<Cliente> topClientes = new ArrayList<>();
        List<Double> montosTotalesPorCliente = new ArrayList<>();

        for (Playero playero : playeros){

            for (Venta venta : playero.getVentas()){
                Cliente cliente = new Cliente(venta.getPatente(), "");
                double monto = venta.getLitrosVendidos();
                int indice = topClientes.indexOf(cliente);

                if (indice == -1){
                    topClientes.add(cliente);
                    montosTotalesPorCliente.add(monto);
                }
                else{
                    montosTotalesPorCliente.set(indice, montosTotalesPorCliente.get(indice) + monto);
                }
            }
        }


        List<Cliente> top10ClientesMesAnterior = new ArrayList<>();
        List<Double> montosTop10Clientes = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            if (topClientes.isEmpty()){
                break;
            }

            int indiceMax = 0;
            double montoMax = montosTotalesPorCliente.get(0);

            for (int j=1; j < montosTotalesPorCliente.size(); j++){
                if (montosTotalesPorCliente.get(j) > montoMax){
                    indiceMax = j;
                    montoMax = montosTotalesPorCliente.get(j);
                }
            }

            top10ClientesMesAnterior.add(topClientes.get(indiceMax));
            montosTop10Clientes.add(montoMax);

            topClientes.remove(indiceMax);
            montosTotalesPorCliente.remove(indiceMax);
        }

        for (Playero playero : playeros){
            playero.setTopClientesMesAnterior(top10ClientesMesAnterior);
        }
    }

    public void calcularTopVentasMesAnterior(){

        List<Playero> topEmpleados = new ArrayList<>();
        List<Double> montosTotalesPorEmpleado = new ArrayList<>();

        for (Playero playero : playeros) {
            double totalVentas = playero.getTotalDeVentas();
            int indice = topEmpleados.indexOf(playero);

            if (indice == -1){
                topEmpleados.add(playero);
                montosTotalesPorEmpleado.add(totalVentas);
            }
            else{
                montosTotalesPorEmpleado.set(indice, montosTotalesPorEmpleado.get(indice) + totalVentas);
            }
        }

        List<Playero> top10EmpleadosMesAnterior = new ArrayList<>();
        List<Double> montosTop10Empleados = new ArrayList<>();

        for (int i=0; i < 10; i++){

            if (topEmpleados.isEmpty()){
                break;
            }

            int indiceMax = 0;
            double montoMax = montosTotalesPorEmpleado.get(0);

            for (int j=1; j < montosTotalesPorEmpleado.size(); j++){

                if (montosTotalesPorEmpleado.get(j) > montoMax){
                    indiceMax = j;
                    montoMax = montosTotalesPorEmpleado.get(j);
                }
            }

            top10EmpleadosMesAnterior.add(topEmpleados.get(indiceMax));
            montosTop10Empleados.add(montoMax);

            topEmpleados.remove(indiceMax);
            montosTotalesPorEmpleado.remove(indiceMax);
        }

        for (Playero playero : playeros){
            playero.setEnTop10VentasMesAnterior(top10EmpleadosMesAnterior.contains(playero));
        }
    }

    public void aplicarDescuentos(){
        for (Playero playero : playeros){

            if (playero.estaEnTop10VentasMesAnterior()){
                List<Cliente> topClientes = playero.getTopClientesMesAnterior();

                for (Venta venta : playero.getVentas()){

                    if (topClientes.contains(venta.getPatente())){
                        double descuento = venta.getTotalVenta() * 0.05;
                        venta.setTotalVenta(venta.getTotalVenta() - descuento);
                    }
                }
            }
        }
    }

    public void permitirDescuentoEmpleado(Playero empleado, Cliente cliente) {
        empleado.setEnTop10VentasMesAnterior(true);
        List<Cliente> topClientes = empleado.getTopClientesMesAnterior();
        if (!topClientes.contains(cliente)) {
            topClientes.add(cliente);
        }
    }
}
