package modelo;

public class Carpa extends MedioDeAlojamiento {

    //Declaración
    private int cantidadPersonas;

    //Constructores
    public Carpa(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, String tipoMedioDeAlojamiento, int cantidadPersonas) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, tipoMedioDeAlojamiento);
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

    //Métodos sobrecargados valorACancelar y adicional
    @Override
    public int valorACancelar() {
        int valorACancelar = this.subtotal() - this.bonoDescuento() + this.adicional();
        return valorACancelar;
    }

    @Override
    public int adicional() {
        int adicional = 0;
        return adicional;
    }
}
