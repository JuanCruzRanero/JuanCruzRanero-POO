package ar.edu.unlu.ejercicio11;

class CamionDeCarga extends Vehiculo {
    public CamionDeCarga(String patente, int diasAlquiler) {
        super(patente, diasAlquiler);
    }

    @Override
    public double calcularCostoAlquiler() {
        if (diasDeAlquiler > 30){
            return 75000 * diasDeAlquiler;
        }
        else{
            return 100000 * diasDeAlquiler;
        }
    }
}
