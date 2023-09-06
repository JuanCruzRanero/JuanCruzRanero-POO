package ar.edu.unlu.ejercicio2.listasDoblementeEnlazadas;

public class ImplementacionListasDoblementeEnlazadas {
    public static void main(String[] argumentos){

        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        if (lista.listaVacia()){
            System.out.println("\nLa lista está vacía\n");
        }

        System.out.println("Cargando lista...\n");
        System.out.println("Lista cargada con éxito!\n");

        lista.agregarElemento(9);
        lista.agregarElemento(10);
        lista.agregarElemento(11);
        lista.agregarElemento(12);
        lista.agregarElemento(13);

        lista.mostrarLista();

        lista.insertarElemento(912, 3);
        System.out.println("Lista post-inserción en la tercera posición: \n");
        lista.mostrarLista();

        lista.eliminarElemento( 3);
        System.out.println("Lista post-eliminación de la tercera posición: \n");
        lista.mostrarLista();

        System.out.printf("La lista tiene %d elementos.\n",lista.listaLongitud());

        System.out.printf("\nEl elemento de la posicion 3 es %s\n", lista.recuperarElemento(3));
    }
}
