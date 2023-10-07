package ar.edu.unlu.ejercicio9;

import java.util.ArrayList;
import java.util.List;

public class Implementacion{
    public static void main(String[] argumentos) {

        FiguraDosDimensiones circulo = new Circulo(4.0);
        FiguraDosDimensiones rectangulo = new Rectangulo(5.0, 6.0);
        FiguraDosDimensiones cuadrado = new Cuadrado(3.0);
        FiguraDosDimensiones triangulo = new Triangulo(5.0, 4.0);

        FiguraTresDimensiones esfera = new Esfera(5.0);
        FiguraTresDimensiones paralelepipedo = new Paralelepipedo(5.0, 6.0, 7.0);
        FiguraTresDimensiones cubo = new Cubo(4.0);
        FiguraTresDimensiones tetraedro = new Tetraedro(5.0);

        System.out.println("FIGURAS DE DOS DIMENSIONES - ÁREAS:\n");
        System.out.printf("Círculo: %s\n", circulo.getArea());
        System.out.printf("Rectángulo: %s\n", rectangulo.getArea());
        System.out.printf("Cuadrado: %s\n", cuadrado.getArea());
        System.out.printf("Triángulo: %s\n", triangulo.getArea());
        System.out.println();

        System.out.println("FIGURAS DE TRES DIMENSIONES - VOLUMEN:\n");

        System.out.printf("Esfera: %s\n", esfera.getVolumen());
        System.out.printf("Paralelepípedo: %s\n", paralelepipedo.getVolumen());
        System.out.printf("Cubo: %s\n", cubo.getVolumen());
        System.out.printf("Tetraedro: %s\n", tetraedro.getVolumen());

        List<FiguraTresDimensiones> formasGeometricas = new ArrayList<>();

        formasGeometricas.add(esfera);
        formasGeometricas.add(paralelepipedo);
        formasGeometricas.add(cubo);
        formasGeometricas.add(tetraedro);

        System.out.println("\nFIGURAS DE TRES DIMENSIONES - ÁREAS: \n");
        for (FiguraTresDimensiones forma : formasGeometricas) {
            System.out.println(forma.getClass().getSimpleName() + ": " + forma.getArea());
        }
    }
}
