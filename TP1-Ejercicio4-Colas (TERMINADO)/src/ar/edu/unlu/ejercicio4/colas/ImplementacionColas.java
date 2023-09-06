package ar.edu.unlu.ejercicio4.colas;

public class ImplementacionColas {
    public static void main(String[] argumentos) {
        Cola cola = new Cola();

        if (cola.colaVacia()) {
            System.out.println("\nLa cola está vacía!\n");
        }

        System.out.println("Cargando cola...\n");

        cola.encolarElemento(9);
        cola.encolarElemento(10);
        cola.encolarElemento(11);
        cola.encolarElemento(12);
        cola.encolarElemento(13);

        if (!cola.colaVacia()) {
            System.out.println("La cola ya no está vacía!\n");
        }

        System.out.println("Muestro la cola:\n");
        cola.mostrarCola();
        System.out.println("Muestro de nuevo para chequear que no se pierde con el método:\n");
        cola.mostrarCola();

        System.out.printf("Frente de la cola: %s\n", cola.recuperarFrente());
        System.out.printf("Final de la cola: %s\n", cola.recuperarFinal());

        cola.desencolarElemento();
        System.out.println("\nCola con el primer elemento desencolado (Primera Entrada Primera Salida):\n");
        cola.mostrarCola();
    }
}
