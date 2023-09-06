package ar.edu.unlu.ejercicio6.libros;

public class Implementacion {
    public static void main(String[] argumentos){

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Charly y La Máquina de Hacer Música", "Diego Madoery", 216, 3);
        biblioteca.agregarLibro(libro1);

        Libro libro2 = new Libro("BURRITO - Mi autobiografía", "Ariel Arnaldo Ortega", 912, 18);
        biblioteca.agregarLibro(libro2);

        libro1.prestarLibro();
        libro1.prestarLibro();

        libro2.prestarLibro();
        libro2.prestarLibro();
        libro2.prestarLibro();
        libro2.prestarLibro();
        libro2.prestarLibro();
        libro2.devolverLibro();

        System.out.print("\n");

        biblioteca.mostrarLibros();

        System.out.print("\n");


        System.out.printf("En total, se hicieron %d préstamos.", biblioteca.cantidadPrestamos());


        if(libro1.getPaginas() > libro2.getPaginas()){
            System.out.printf("\nEl libro '%s' es más extenso que el libro '%s', tiene %d páginas más.\n", libro1.getTitulo(), libro2.getTitulo(), (libro1.getPaginas() - libro2.getPaginas()));
        }
        else if (libro2.getPaginas() > libro1.getPaginas()) {
            System.out.printf("\nEl libro '%s' es más extenso que el libro '%s', tiene %d páginas más.\n", libro2.getTitulo(), libro1.getTitulo(), (libro2.getPaginas()-libro1.getPaginas()));
        }
        else {
            System.out.printf("\nLos libros son igual de largos, ambos tienen %d páginas.\n", libro1.getPaginas());
        }
    }
}