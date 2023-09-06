package ar.edu.unlu.ejercicio4.colas;

public class Cola {
    private Nodo frenteCola = null;
    private Nodo finalCola = null;

    public void crearCola() {
        frenteCola = null;
        finalCola = null;
    }

    public boolean colaVacia() {
        return (frenteCola == null);
    }

    public void encolarElemento(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (colaVacia()) {
            frenteCola = nuevoNodo;
            finalCola = nuevoNodo;
        }
        else{
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
    }

    public Object desencolarElemento() {

        if (colaVacia()) {
            return null;
        }

        Nodo nodoActual = frenteCola;
        Object dato = frenteCola.getDato();
        frenteCola = nodoActual.getSiguiente();

        return dato;
    }

    public void mostrarCola(){

        if (colaVacia()){
            System.out.println("La cola está vacía, no hay nada que mostrar.");
            return;
        }

        Cola colaAuxiliar = new Cola();
        Object datos = desencolarElemento();
        System.out.println("Contenido de la cola:\n");
        int posiciones=0;

        while (datos != null){
            posiciones++;
            System.out.printf("Elemento %d: %s\n", posiciones, datos);
            colaAuxiliar.encolarElemento(datos);
            datos = desencolarElemento();
        }

        System.out.println("\n");

        while (!colaAuxiliar.colaVacia()){
            encolarElemento(colaAuxiliar.desencolarElemento());
        }
    }

    public Object recuperarFrente(){
        if (colaVacia()){
            return null;
        }
        return frenteCola.getDato();
    }

    public Object recuperarFinal(){
        if (colaVacia()){
            return null;
        }
        return finalCola.getDato();
    }

}
