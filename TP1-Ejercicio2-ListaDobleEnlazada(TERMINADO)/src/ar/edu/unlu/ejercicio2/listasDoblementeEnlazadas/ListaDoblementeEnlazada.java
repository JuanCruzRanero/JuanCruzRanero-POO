package ar.edu.unlu.ejercicio2.listasDoblementeEnlazadas;

public class ListaDoblementeEnlazada {
    private Nodo inicioLista = null;
    private Nodo finalLista = null;

    public void crearLista(){
        inicioLista = null;
        finalLista = null;
    }
    public boolean listaVacia(){
        return (inicioLista==null);
    }

    public int listaLongitud(){
        if (listaVacia()){
            return 0;
        }

        int contador=0;
        Nodo nodoTemporal = inicioLista;

        while (nodoTemporal != null){
            contador++;
            nodoTemporal = nodoTemporal.getSiguiente();
        }

        return contador;
    }

    public void agregarElemento(Object dato) {

        Nodo nuevoNodo = new Nodo(dato);

        if (listaVacia()) {
            inicioLista = nuevoNodo;
            finalLista = nuevoNodo;
        }
        else {
            finalLista.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(finalLista);
            finalLista = nuevoNodo;
        }
    }

    public void eliminarElemento(int posicion){
        if (listaVacia()){
            return;
        }

        if(posicion>=1 && posicion<=listaLongitud()){

            if (posicion==1){
                inicioLista = inicioLista.getSiguiente();
                if(inicioLista!=null){
                    inicioLista.setAnterior(null);
                }
            }
            else if (posicion==listaLongitud()) {
                finalLista = finalLista.getAnterior();
                if (finalLista != null){
                    finalLista.setSiguiente(null);
                }
            }

            else{
                Nodo nodoActual = inicioLista;

                for (int i=0; i < posicion-1; i++){
                    nodoActual = nodoActual.getSiguiente();
                }

                nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
            }
        }
    }

    void insertarElemento(Object dato, int posicion){
        Nodo nuevoNodo = new Nodo(dato);

        if (listaVacia()){
            inicioLista=nuevoNodo;
            finalLista=nuevoNodo;
        }
        else if (posicion==1){
            nuevoNodo.setSiguiente(inicioLista);
            inicioLista.setAnterior(nuevoNodo);
            inicioLista = nuevoNodo;


        }
        else if(posicion==listaLongitud()){
            finalLista.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(finalLista);
            finalLista = nuevoNodo;
        }
        else{
            Nodo nodoActual = inicioLista;

            for(int i=0; i<posicion-2; i++){
                nodoActual = nodoActual.getSiguiente();
            }

            nuevoNodo.setSiguiente(nodoActual.getSiguiente());
            nuevoNodo.setAnterior(nodoActual);
            nodoActual.getSiguiente().setAnterior(nuevoNodo);
            nodoActual.setSiguiente(nuevoNodo);
        }
    }

    public void mostrarLista(){                     // Funcion agregada para mostrar la lista y facilitar el chequeo de las funciones anteriores
        Nodo nodoMuestraLista = inicioLista;
        int posiciones = 0;

        System.out.println("CONTENIDO DE LA LISTA:");

        while (nodoMuestraLista != null){
            posiciones++;
            System.out.printf("Dato %d: %s\n", posiciones, nodoMuestraLista.getDato());
            nodoMuestraLista = nodoMuestraLista.getSiguiente();
        }

        System.out.println("\n");
    }

    public Object recuperarElemento(int posicion){
        Nodo nodoActual = inicioLista;

        for (int i=0; i<posicion-1; i++){
            nodoActual = nodoActual.getSiguiente();
        }

        return nodoActual.getDato();
    }
}
