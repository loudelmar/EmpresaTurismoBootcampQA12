package modelo;

public class DatosCliente {

    //Declaración
    private String nombre;
    private int rut;

    //Constructores
    public DatosCliente() {
    }
    public DatosCliente(String nombre, int rut) {
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
    public int getRut() { return rut; }
    public void setRut(int rut) {
        this.rut = rut;
    }
}
