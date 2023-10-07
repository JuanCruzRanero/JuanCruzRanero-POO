package ar.edu.unlu.ejercicio11;

public class CamionetaFlete extends Vehiculo {
    private int pesoAutorizadoTotal;

    public CamionetaFlete(String patente, int diasDeAlquiler, int pesoAutorizadoTotal){
        super(patente, diasDeAlquiler);
        this.pesoAutorizadoTotal = pesoAutorizadoTotal;
    }

    @Override
    public double calcularCostoAlquiler(){
        return super.calcularCostoAlquiler() + 600 * pesoAutorizadoTotal;
    }
}
