package ar.edu.unlu.ejercicio10;

import java.util.Date;
public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String apellido, String telefono, String cuit, Date fechaNacimiento, double salarioMensual) {
        super(nombre, apellido, telefono, cuit, fechaNacimiento);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public String getNombreYApellido() {
        return this.nombre + " " + this.apellido;
    }

    @Override
    public double calcularSueldo(){
        double sueldo = salarioMensual;
        if (esMesDeCumpleanos()){
            sueldo += 1000;
        }
        return sueldo;
    }
}