package modelo;

public class Cabagna extends Hospederia{
    //Declaración
    private boolean chimenea;

    //Constructores
    public Cabagna(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, String tipoMedioDeAlojamiento, int capacidad, boolean esFumador, boolean conDesayuno, boolean chimenea) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, tipoMedioDeAlojamiento, capacidad, esFumador, conDesayuno);
        this.chimenea = chimenea;
    }

    //Getters y Setters
    public boolean isChimenea() {
        return chimenea;
    }
    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    //Métodos sobrecargados incrementaValorBase y valorACancelar
    @Override
    public int incrementaValorBase(){
        int incrementaValorBase = 0;
        if (this.getCapacidad()>5){
            incrementaValorBase = this.getValorBaseNoche() * 18/100;
        }
        return incrementaValorBase;
    }

    @Override
    public int valorACancelar() {
        int valorACancelar = this.subtotal() - this.bonoDescuento() + this.adicional();
        return valorACancelar;
    }
}
