package modelo;

public abstract class MedioDeAlojamiento {

    //Declaración
    private int valorBaseNoche;
    private int cantidadNoches;
    private String tipoTemporada;
    private String tipoMedioDeAlojamiento;
    private DatosCliente datosCliente;

    //Constructores
    public MedioDeAlojamiento(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, String tipoMedioDeAlojamiento) {
        this.datosCliente = datosCliente;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
        this.tipoMedioDeAlojamiento = tipoMedioDeAlojamiento;
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
    public String getTipoMedioDeAlojamiento() { return tipoMedioDeAlojamiento;}
    public void setTipoMedioDeAlojamiento(String tipoMedioDeAlojamiento) { this.tipoMedioDeAlojamiento = tipoMedioDeAlojamiento;}
    public String getTipoTemporada() { return tipoTemporada; }
    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }
    public DatosCliente getDatosCliente() {
        return datosCliente;
    }
    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    //Método subtotal:
    public int subtotal() {
        int subtotal = this.cantidadNoches * this.valorBaseNoche;
        return subtotal;
    }

    //Método bonoDescuento
    public int bonoDescuento(){
        int bonoDescuento = 0;
        if (this.tipoTemporada.equalsIgnoreCase("baja")){
            //subtotal - 25%
            bonoDescuento = Math.round(this.subtotal()*25/100);
        } else if (this.tipoTemporada.equalsIgnoreCase("media")){
            //subtotal - 12,5%
            bonoDescuento = (int) Math.round(this.subtotal()*12.5/100);

        }
        return bonoDescuento;
    }

    //Métodos abstractos valorACancelar y adicional
    public abstract int valorACancelar();
    public abstract int adicional ();
}
