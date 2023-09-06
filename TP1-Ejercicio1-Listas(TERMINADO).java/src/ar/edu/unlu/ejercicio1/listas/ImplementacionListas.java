package ar.edu.unlu.ejercicio1.listas;

public class ImplementacionListas {

    public static void main(String[] argumentos){
        Lista nuevaLista = new Lista();

        if (nuevaLista.listaVacia()){
            System.out.println("La lista está vacía!\n");
        }

        System.out.println("Cargando lista...");

        nuevaLista.agregarElemento(9);
        nuevaLista.agregarElemento(10);
        nuevaLista.agregarElemento(11);
        nuevaLista.agregarElemento(12);
        nuevaLista.agregarElemento(13);

        if (!nuevaLista.listaVacia()){
            System.out.println("La lista NO está vacía.\n");
        }

        System.out.println("Lista antes de eliminar:\n");
        nuevaLista.mostrarLista();

        nuevaLista.eliminarElemento(3);
        System.out.println("Lista post-eliminacion de la 3ra posicion:\n");
        nuevaLista.mostrarLista();

        System.out.printf("La longitud de la lista es %d elementos\n", nuevaLista.listaLongitud());

        System.out.printf("Recupero el elemento 2: %s\n", nuevaLista.recuperarElemento(2));

        System.out.println("Inserto un elemento en la 2da posicion:\n");
        nuevaLista.insertarElemento(80,2);
        nuevaLista.mostrarLista();
    }

}
