package ar.edu.unlu.ejercicio8;

public class Implementacion{
    public static void main(String[] argumentos){

        Biblioteca administrador = new Biblioteca();

        Revista revista = new Revista("Entre lujurias y represión: Serú Girán: la banda que lo cambió todo", "Mariano del Mozo", "11-9876-1234", new CantidadEjemplar(10), "1111-2222");
        Libro libro = new Libro("Recuerdos que mienten un poco", "Indio Solari", "11-0912-2018", new CantidadEjemplar(15), "123456789");
        Tesis tesis = new Tesis("El año de Artaud", "Sergio Pujol","11-0101-1010", 9, 2014);
        Diario diario = new Diario("Cemento, el semillero del rock (1985-2004)", "Nicolás Igarzábal", "11-3456-7890", "01-01-2001");


        administrador.agregarLibro(libro);
        administrador.agregarRevista(revista);
        administrador.agregarDiario(diario);
        administrador.agregarTesis(tesis);

        administrador.prestarLibro(libro, 5);
        administrador.prestarRevista(revista, 7);
        administrador.prestarDiario(diario);
        administrador.prestarTesis(tesis);
    }
}
