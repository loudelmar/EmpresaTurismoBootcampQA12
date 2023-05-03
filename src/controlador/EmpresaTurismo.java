package controlador;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.Hotel;
import modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<MedioDeAlojamiento> empresaTurismo;

    public EmpresaTurismo(ArrayList empresaTurismo) {
        this.empresaTurismo = empresaTurismo;
    }

    public ArrayList getEmpresaTurismo() {
        return empresaTurismo;
    }

    public void setEmpresaTurismo(ArrayList empresaTurismo) {
        this.empresaTurismo = empresaTurismo;
    }


    //Opción 1: Ingresar Medio de Alojamiento.
    public void ingresarCarpa(Carpa carpa){
        if (buscarCliente(carpa.getDatosCliente().getRut())==-1){
            empresaTurismo.add(carpa);
        }
    }
    public void ingresarHotel (Hotel hotel) {
        if (buscarCliente(hotel.getDatosCliente().getRut()) == -1) {
            empresaTurismo.add(hotel);
        }
    }
    public void ingresarCabagna (Cabagna cabagna){
        if (buscarCliente(cabagna.getDatosCliente().getRut())==-1){
            empresaTurismo.add(cabagna);
        }

    }

    //Opción 2:Mostrar Medios de Alojamiento.
    public String mediosDeAlojamiento(){
        String mensaje = "";
        MedioDeAlojamiento medioDeAlojamiento = null;
        int contador = 0;

        for(int i=0; i<empresaTurismo.size(); i++){
            if(empresaTurismo.get(i) instanceof MedioDeAlojamiento){
                medioDeAlojamiento = empresaTurismo.get(i);

                mensaje = mensaje + "El valor base noche es: $" + medioDeAlojamiento.getValorBaseNoche() +
                        ", la cantidad de noches son: " + medioDeAlojamiento.getCantidadNoches() + ", el tipo de temporada es: " +
                        medioDeAlojamiento.getTipoTemporada() + ". Los datos del cliente son el nombre: " +
                        medioDeAlojamiento.getDatosCliente().getNombre() + " y su rut: " + medioDeAlojamiento.getDatosCliente().getRut() +
                        "\n";

                contador++;
            }
        }
        if (contador==0){
            mensaje = "No hay calzados de mujer!";
        }
        return mensaje;
    }

    //Opción 3: Mostrar datos de un Cliente X.
    public String datosCliente(String rut){
        String mensaje = "";
        Cabagna cabagna = null;
        Hotel hotel = null;
        Carpa carpa = null;
        for(int i=0; i<empresaTurismo.size(); i++){
            if (empresaTurismo.get(i).getDatosCliente().getRut().compareToIgnoreCase(rut)==0){
                if (empresaTurismo.get(i) instanceof Cabagna){
                    cabagna = (Cabagna) empresaTurismo.get(i);
                    mensaje = "El cliente se llama: " + cabagna.getDatosCliente().getNombre() +
                            " y está alojado en: " + cabagna.getTipoMedioDeAlojamiento() +
                            " durante " + cabagna.getCantidadNoches() + " días, en temporada " +
                            cabagna.getTipoTemporada() + ". El valor base es $" + cabagna.getValorBaseNoche() +
                            ". Se alojan " + cabagna.getCapacidad() + " personas. ¿Es fumador? " + cabagna.isEsFumador() +
                            ". ¿Es con chimenea? " + cabagna.isChimenea() + ".";
                } else if (empresaTurismo.get(i) instanceof Hotel){
                    hotel = (Hotel) empresaTurismo.get(i);
                    mensaje = "El cliente se llama: " + hotel.getDatosCliente().getNombre() +
                            " y está alojado en: " + hotel.getTipoMedioDeAlojamiento() +
                            " durante " + hotel.getCantidadNoches() + " días, en temporada " +
                            hotel.getTipoTemporada() + ". El valor base es $" + hotel.getValorBaseNoche() +
                            ". Se alojan " + hotel.getCapacidad() + " personas. ¿Es fumador? " + hotel.isEsFumador() +
                            ". ¿Es con desayuno? " + hotel.isConDesayuno() + ".";
                } else if (empresaTurismo.get(i) instanceof Carpa){
                    carpa = (Carpa) empresaTurismo.get(i);
                    mensaje = "El cliente se llama: " + carpa.getDatosCliente().getNombre() +
                            " y está alojado en: " + carpa.getTipoMedioDeAlojamiento() +
                            " durante " + carpa.getCantidadNoches() + " días, en temporada " +
                            carpa.getTipoTemporada() + ". El valor base es $" + carpa.getValorBaseNoche() +
                            ". Se alojan " + carpa.getCantidadPersonas() + " personas.";
                }
            }
        }
        return mensaje;
    }

    //Opción 4: Total Adicional.
    public int totalAdicional(){
        int totalAdicional = 0;
        for (int i=0; i<empresaTurismo.size(); i++){
                totalAdicional = totalAdicional + empresaTurismo.get(i).adicional();
        }
        return totalAdicional;
    }

    //Opción 5: Total Bono Descuento.
    public int totalBonoDescuento(){
        int totalBonoDescuento = 0;
        for (int i=0; i<empresaTurismo.size(); i++){
            totalBonoDescuento = totalBonoDescuento + (empresaTurismo.get(i).bonoDescuento());
        }
        return totalBonoDescuento;
    }

    //Opción 6: Cantidad medios de alojamiento X.
    public String cantidadMediosDeAlojamiento(){
        String mensaje = "";
        for (int i=0; i<empresaTurismo.size(); i++){
            if (i > 0) {
                mensaje = "El total de los medios de alojamiento es: " + empresaTurismo.size();
                break;
            }
        }
        return mensaje;
    }

    //Opción 7: Valor a cancelar por un cliente X.
    public String valorACancelar (String rut){
        int valorACancelar = 0;
        for (int i=0; i<empresaTurismo.size(); i++){
            if (empresaTurismo.get(i).getDatosCliente().getRut().compareToIgnoreCase(rut) == 0){
                return "El valor a cancelar de " + empresaTurismo.get(i).getDatosCliente().getNombre() +
                        " es de $" + empresaTurismo.get(i).valorACancelar();
            }
        } return "El cliente con ese rut no existe. Escriba otro rut...";
    }

    //Opción 8: Aplicar incremento del valor base.
    public String incrementoValorBase(String rut){
        Cabagna cabagna = null;
        for (int i = 0; i < empresaTurismo.size(); i++) {
            if (empresaTurismo.get(i).getDatosCliente().getRut().compareToIgnoreCase(rut) == 0) {
                if (empresaTurismo.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresaTurismo.get(i);
                    return "El incremento al valor base es de: $" + cabagna.incrementaValorBase();
                }
            }
        }
        return "No hay un incremento al valor base.";

    }

    public int buscarCliente(String rutCliente){
        for (int i=0; i < empresaTurismo.size(); i++){
            if (empresaTurismo.get(i).getDatosCliente().getRut().compareToIgnoreCase(rutCliente)==0){
                return i;
            }
        }
        return -1;
    }
}
