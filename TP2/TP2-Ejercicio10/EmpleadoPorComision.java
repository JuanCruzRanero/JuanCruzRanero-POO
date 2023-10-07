package ar.edu.unlu.ejercicio10;

import java.util.Date;
public class EmpleadoPorComision extends Empleado{
    private double ventasBrutas;
    private double porcentajeComision;

    public EmpleadoPorComision(String nombre, String apellido, String telefono, String cuit, Date fechaNacimiento, double ventasBrutas, double porcentajeComision) {
        super(nombre, apellido, telefono, cuit, fechaNacimiento);
        this.ventasBrutas = ventasBrutas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public String getNombreYApellido(){
        return this.nombre + " " + this.apellido;
    }

    @Override
    public double calcularSueldo(){
        double sueldo = ventasBrutas * (porcentajeComision / 100);
        if (esMesDeCumpleanos()){
            sueldo += 2000;
        }
        return sueldo;
    }
}