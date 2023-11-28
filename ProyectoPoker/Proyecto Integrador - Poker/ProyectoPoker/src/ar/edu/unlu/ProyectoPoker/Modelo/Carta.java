package ar.edu.unlu.ProyectoPoker.Modelo;
public class Carta{
    private String valor;
    private static final String[] PALOS = {"PICAS", "TREBOL", "DIAMANTES", "CORAZONES"};
    private static final String[] CARTAS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String palo;
    public Carta(String valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public int getValorNumerico() {
        switch (valor) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(valor);
        }
    }
    
    //Getters y Setters
    public String getValor() {
        return valor;
    }
    public String getPalo() {
        return palo;
    }
    public static String[] getPALOS() {
        return PALOS;
    }
    public static String[] getCARTAS() {
        return CARTAS;
    }
}
