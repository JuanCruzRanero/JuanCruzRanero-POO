package ar.edu.unlu.ejercicio1.listas;

public class Nodo {
    private Object dato;   // Dato del nodo
    private Nodo siguiente = null; // Enlace al siguiente Nodo de la lista

    public Nodo(Object dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
