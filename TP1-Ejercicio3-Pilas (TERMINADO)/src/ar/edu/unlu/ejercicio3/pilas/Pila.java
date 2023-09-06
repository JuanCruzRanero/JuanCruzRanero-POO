package ar.edu.unlu.ejercicio3.pilas;


public class Pila {

    private Nodo tope = null;

    public void crearPila(){
        tope=null;
    }

    public boolean pilaVacia(){
        return (tope==null);
    }

    public void apilarElemento(Object dato){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public Object desapilarElemento(){

        if (pilaVacia()){
            return null;
        }
        Nodo nodoTopeActual = tope;
        tope = nodoTopeActual.getSiguiente();
        return nodoTopeActual.getDato();
    }

    public Object devolverTope(){

        if (pilaVacia()){
            System.out.println("La pila está vacía, no hay nada que mostrar.");
            return null;
        }
        return (tope.getDato());
    }

    public void mostrarPila(){

        if (pilaVacia()){
            System.out.println("La pila está vacía, no hay nada que mostrar.");
            return;
        }

        Pila pilaAuxiliar = new Pila();
        Object datos = desapilarElemento();
        System.out.println("Contenido de la pila:\n");
        int posiciones=0;

        while (datos!=null){
            posiciones++;
            System.out.printf("Elemento %d: %s\n", posiciones, datos);
            pilaAuxiliar.apilarElemento(datos);
            datos = desapilarElemento();
        }

        System.out.println("\n");

        while (!pilaAuxiliar.pilaVacia()){
            apilarElemento(pilaAuxiliar.desapilarElemento());
        }
    }

}
