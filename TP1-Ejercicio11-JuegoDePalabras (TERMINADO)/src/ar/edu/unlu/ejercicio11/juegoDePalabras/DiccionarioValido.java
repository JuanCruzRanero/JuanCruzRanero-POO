package ar.edu.unlu.ejercicio11.juegoDePalabras;
import java.util.ArrayList;
public class DiccionarioValido {
    private static String[] listaPalabras = {"koala", "esquizoide", "exonerado", "yirar", "walkman", "querer", "hola", "cantata"};

    public static boolean palabraValida(String palabraEvaluar){
        for (int i = 0; i < listaPalabras.length; i++){
            String palabraTemp = listaPalabras[i];
            if (palabraTemp.equals(palabraEvaluar)){
                return true;
            }
        }
        return false;
    }
}
