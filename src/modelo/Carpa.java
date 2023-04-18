package modelo;

public class Carpa extends MedioDeAlojamiento {

    //Declaración
    private int cantidadPersonas;

    //Constructores
    public Carpa(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datosCliente, int cantidadPersonas) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datosCliente);
        this.cantidadPersonas = cantidadPersonas;
    }
    public Carpa() {
    }

    //Getters y Setters
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
