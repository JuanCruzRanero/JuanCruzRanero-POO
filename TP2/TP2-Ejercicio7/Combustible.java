package ar.edu.unlu.ejercicio7.estacionDeServicioExtendido;

public class Combustible{
    private String nombreCombustible;
    private double valorCombustible;

    public Combustible(String nombreCombustible){
        if (nombreCombustible.equals("Nafta")){
            this.nombreCombustible = nombreCombustible;
            this.valorCombustible = 1000;
        }
        else if (nombreCombustible.equals("Gasoil")){
            this.nombreCombustible = nombreCombustible;
            this.valorCombustible = 500;
        }
        else{
            this.nombreCombustible = nombreCombustible;
            this.valorCombustible = 750;
        }
    }

    public double getValorCombustible() {
        return valorCombustible;
    }

    public String getNombreCombustible() {
        return nombreCombustible;
    }
}