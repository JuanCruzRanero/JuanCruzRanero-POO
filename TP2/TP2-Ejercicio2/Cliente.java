package ar.edu.unlu.ejercicio2.turismo;

public class Cliente {

    private String nombre;
    private String dni;
    private String email;

    public Cliente (String nombre, String dni, String email){
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }
}
