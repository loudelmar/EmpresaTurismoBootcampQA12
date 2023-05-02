package modelo;

public class Hotel extends Hospederia {

    //Constructores
    public Hotel(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, String tipoMedioDeAlojamiento, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, tipoMedioDeAlojamiento, capacidad, esFumador, conDesayuno);
    }

    public Hotel() {
        super();
    }

    //Método abstract incrementaValorBase
    @Override
    public int incrementaValorBase() {
        int incrementaValorBase = 0;
        return incrementaValorBase;
    }

}
