package ar.edu.unlu.ejercicio1.socios;

public class Socio {
    private String nombre;
    private String dni;
    private String direccion;
    private String email;
    private String tipoDeSuscripcion;

    public Socio(String nombre, String dni, String direccion, String email, String tipoDeSuscripcion){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.email = email;
        this.tipoDeSuscripcion = tipoDeSuscripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }
}
