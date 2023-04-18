package modelo;

public class Hotel extends Hospederia {

    //Declaración
    private boolean conDesayuno;

    //Constructores
    public Hotel(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datosCliente, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datosCliente, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }
    public Hotel() {
    }

    //Getters y Setters
    public boolean isConDesayuno() {
        return conDesayuno;
    }
    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }
}
