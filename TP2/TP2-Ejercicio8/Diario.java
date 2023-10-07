package ar.edu.unlu.ejercicio8;

public class Diario{
    private String nombre;
    private String editor;
    private String telefonoProveedor;
    private String fechaPublicacion;
    public Diario(String nombre, String editor, String telefonoProveedor, String fechaPublicacion) {
        this.nombre = nombre;
        this.editor = editor;
        this.telefonoProveedor = telefonoProveedor;
        this.fechaPublicacion = fechaPublicacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }
    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    @Override
    public String toString() {
        return "Diario{" +
                "NOMBRE= '" + nombre + '\'' +
                ", AUTOR= '" + editor + '\'' +
                ", TELEFONO= '" + telefonoProveedor + '\'' +
                ", FECHA= '" + fechaPublicacion + '\'' +
                '}'+"\n";
    }
}
