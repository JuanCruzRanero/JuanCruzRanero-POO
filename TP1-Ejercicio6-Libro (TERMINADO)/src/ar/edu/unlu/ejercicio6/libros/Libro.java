package ar.edu.unlu.ejercicio6.libros;

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private int ejemplaresDisponibles;
    private int ejemplaresPrestados;

    public Libro(String titulo, String autor, int paginas, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void prestarLibro() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
            ejemplaresPrestados++;
        }
    }

    public void devolverLibro() {
        if (ejemplaresPrestados > 0) {
            ejemplaresDisponibles++;
            ejemplaresPrestados--;
        }
    }

    public String toString() {
        return "El libro " + titulo + " creado por el autor " + autor +
                " tiene " + paginas + " páginas, quedan " +
                ejemplaresDisponibles + " disponibles y se prestaron " +
                ejemplaresPrestados + ".";
    }
}