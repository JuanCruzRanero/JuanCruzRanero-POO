package ar.edu.unlu.ejercicio10;

import java.util.Date;

public class Implementacion{
    public static void main(String[] argumentos){

        Empleado Asalariado = new EmpleadoAsalariado("Patricio", "Fontanet", "11-1111-2222", "20-11111111-1", new Date(), 5000);
        Empleado PorComision = new EmpleadoPorComision("Carlos", "Solari", "11-2222-2222", "20-22222222-2", new Date(), 60000, 2.5);
        Empleado PorComisionConSalarioBase = new EmpleadoPorComisionConSalarioBase("Carlos", "García", "11-3333-3333", "20-33333333-3", new Date(), 70000, 2.0, 2000);
        Empleado PorHora = new EmpleadoPorHora("Federico", "Moura", "11-4444-4444", "20-44444444-4", new Date(), 10, 45);
        Empleado Pasante = new EmpleadoPasante("Eli", "Suárez", "11-5555-5555", "20-55555555-5", new Date());

        System.out.println();
        System.out.printf("El empleado %s forma parte de la categoría 'Asalariado' y su sueldo es de $%s.\n", Asalariado.getNombreYApellido(), Asalariado.calcularSueldo());
        System.out.printf("El empleado %s forma parte de la categoría 'Por comisión' y su sueldo es de $%s.\n", PorComision.getNombreYApellido(), PorComision.calcularSueldo());
        System.out.printf("El empleado %s forma parte de la categoría 'Por comisión con salario base' y su sueldo es de $%s.\n", PorComisionConSalarioBase.getNombreYApellido(), PorComisionConSalarioBase.calcularSueldo());
        System.out.printf("El empleado %s forma parte de la categoría 'Por hora' y su sueldo es de $%s.\n", PorHora.getNombreYApellido(), PorHora.calcularSueldo());
        System.out.printf("El empleado %s forma parte de la categoría 'Pasante' y su sueldo es de $%s.\n", Pasante.getNombreYApellido(), Pasante.calcularSueldo());

    }
}
