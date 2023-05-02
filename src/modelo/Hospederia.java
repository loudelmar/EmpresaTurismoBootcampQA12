package modelo;

public abstract class Hospederia extends MedioDeAlojamiento{

    //Declaración
    private int capacidad;
    private boolean esFumador;
    private boolean conDesayuno;

    //Constructores
    public Hospederia(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoMedioDeAlojamiento, String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoMedioDeAlojamiento, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
        this.conDesayuno = conDesayuno;
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
    public boolean isConDesayuno() {
        return conDesayuno;
    }
    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    //Métodos sobrecargados valorACancelar y adicional
    @Override
    public int valorACancelar() {
        int valorACancelar = this.subtotal() - this.bonoDescuento() + this.adicional();
        return valorACancelar;
    }

    @Override
    public int adicional(){
        int adicional = 0;
        if (this.esFumador || this.conDesayuno){
            //+30%
            adicional = subtotal()*30/100;
        }
        return adicional;
    }

    //Método abstracto incrementaValorBase
    public abstract int incrementaValorBase();
}
