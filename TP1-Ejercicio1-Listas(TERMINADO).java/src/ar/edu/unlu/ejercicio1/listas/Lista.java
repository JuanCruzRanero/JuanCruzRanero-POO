
package ar.edu.unlu.ejercicio1.listas;

public class Lista{

    private Nodo inicio = null;    // Referencia al nodo inicial de la lista

    public void crearLista(){
        inicio = null;
    }

    public boolean listaVacia(){
        return (inicio==null);
    }

    public int listaLongitud(){
        int contador = 0;
        Nodo nodoTemporal = inicio;

        while (nodoTemporal != null){
            contador++;
            nodoTemporal = nodoTemporal.getSiguiente();
        }

        return contador;
    }

    public void agregarElemento(Object dato){
        Nodo nuevoNodo = new Nodo(dato);

        if (inicio == null){
            inicio = nuevoNodo;
        }
        else{
            Nodo nodoTemporal = inicio;

            while(nodoTemporal.getSiguiente() != null){
                nodoTemporal = nodoTemporal.getSiguiente();
            }

            nodoTemporal.setSiguiente(nuevoNodo);
        }
    }

    public void eliminarElemento(int posicion){

        if (listaVacia()){     //Controlo que la lista no esté vacía
            return;
        }

        if (posicion>=1 && posicion <= listaLongitud()){   // Controlo que sea una posición válida

            if (posicion == 1){
                inicio = inicio.getSiguiente();
            }
            else {
                Nodo nodoActual = inicio;

                for (int i = 0; i < posicion - 2; i++){
                    nodoActual = nodoActual.getSiguiente();
                }

                Nodo nodoTemporal = nodoActual.getSiguiente();
                nodoActual.setSiguiente(nodoTemporal.getSiguiente());
            }
        }
    }

    public Object recuperarElemento(int posicion){
        Nodo nodoTemporal = inicio;

        for (int i = 0; i < posicion-1; i++){
            nodoTemporal = nodoTemporal.getSiguiente();
        }

        return nodoTemporal.getDato();
    }

    public void insertarElemento(Object dato, int posicion){

        Nodo nuevoNodo = new Nodo(dato);

        if (posicion==1){
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
        else{
           Nodo nodoTemporal = inicio;

           for (int i=0; i < posicion-2; i++){
               nodoTemporal = nodoTemporal.getSiguiente();
           }

           nuevoNodo.setSiguiente(nodoTemporal.getSiguiente());
           nodoTemporal.setSiguiente(nuevoNodo);
        }
    }

    public void mostrarLista(){                     // Funcion agregada para mostrar la lista y facilitar el chequeo de las funciones anteriores
        Nodo nodoMuestraLista = inicio;
        int posiciones = 0;

        System.out.println("CONTENIDO DE LA LISTA:");

        while (nodoMuestraLista != null){
            posiciones++;
            System.out.printf("Dato %d: %s\n", posiciones, nodoMuestraLista.getDato());
            nodoMuestraLista = nodoMuestraLista.getSiguiente();
        }

        System.out.println("\n");
    }

}
