package ar.edu.unlu.ejercicio3.pilas;

public class ImplementacionPilas {

    public static void main(String[] argumentos){

        Pila pila = new Pila();

        if(pila.pilaVacia()){
            System.out.println("La pila está vacía.\n");
        }

        System.out.println("Cargando pila...\n");

        pila.apilarElemento(9);
        pila.apilarElemento(10);
        pila.apilarElemento(11);
        pila.apilarElemento(12);
        pila.apilarElemento(13);

        if (!pila.pilaVacia()){
            System.out.println("La pila ya no está vacía.\n");
        }

        pila.mostrarPila();

        System.out.printf("tope actual de la pila: %s\n\n", pila.devolverTope());

        System.out.println("Muestro la pila una vez:\n");
        pila.mostrarPila();

        System.out.println("Muestro la pila de nuevo para demostrar que no se perdió la misma:\n");
        pila.mostrarPila();

        pila.desapilarElemento();
        System.out.println("Pila con el elemento desapilado: ");
        pila.mostrarPila();
    }
}
