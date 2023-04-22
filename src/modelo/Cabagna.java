package modelo;

public abstract class Cabagna extends Hospederia{
    //Declaración
    private boolean chimenea;

    //Constructores
    public Cabagna(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno, boolean chimenea) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidad, esFumador, conDesayuno);
        this.chimenea = chimenea;
    }

    //Getters y Setters
    public boolean isChimenea() {
        return chimenea;
    }
    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    //Método incrementaValorBase
    @Override
    public int incrementaValorBase(){
        int incrementaValorBase = 0;
        if (this.getCapacidad()>5){
            incrementaValorBase = this.getValorBaseNoche() + 18/100;
        }
        return incrementaValorBase;
    }
}
