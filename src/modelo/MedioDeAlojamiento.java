package modelo;

public class MedioDeAlojamiento {

    //Declaración
    private int valorBaseNoche;
    private int cantidadNoches;
    private String tipoTemporada;
    private DatosCliente datosCliente;

    //Constructores
    public MedioDeAlojamiento(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datosCliente) {
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
        this.datosCliente = datosCliente;
    }
    public MedioDeAlojamiento() {
    }

    //Getters y Setters
    public int getValorBaseNoche() {
        return valorBaseNoche;
    }
    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }
    public int getCantidadNoches() {
        return cantidadNoches;
    }
    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }
    public String getTipoTemporada() {
        return tipoTemporada;
    }
    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }
    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    //Metodo subtotal
    public int subtotal() {
        cantidadNoches = 3;
        valorBaseNoche = 10000;
        int subtotal = cantidadNoches * valorBaseNoche;
        return subtotal;
    }
}
