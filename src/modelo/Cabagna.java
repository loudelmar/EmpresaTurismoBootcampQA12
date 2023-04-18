package modelo;

public class Cabagna extends Hospederia{
    //Declaración
    private boolean chimenea;

    //Constructores
    public Cabagna(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datosCliente, int capacidad, boolean esFumador, boolean chimenea) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datosCliente, capacidad, esFumador);
        this.chimenea = chimenea;
    }
    public Cabagna() {
    }

    //Getters y Setters
    public boolean isChimenea() {
        return chimenea;
    }
    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }
}
