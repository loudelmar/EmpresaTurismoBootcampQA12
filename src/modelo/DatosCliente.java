package modelo;

public class DatosCliente {

    //Declaración
    private String nombre;
    private String rut;

    //Constructores
    public DatosCliente() {
    }
    public DatosCliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRut() { return rut; }
    public void setRut(String rut) {
        this.rut = rut;
    }
}
