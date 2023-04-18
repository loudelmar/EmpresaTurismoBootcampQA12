package modelo;

public class Hospederia extends MedioDeAlojamiento{

    //Declaración
    private int capacidad;
    private boolean esFumador;

    //Constructores
    public Hospederia(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int capacidad, boolean esFumador) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datosCliente);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }
    public Hospederia() {
    }

    //Getters y Setters
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public boolean isEsFumador() {
        return esFumador;
    }
    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
}
