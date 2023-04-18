package vista;

import modelo.DatosCliente;
import modelo.Hospederia;
import modelo.MedioDeAlojamiento;

public class Aplicacion {

    public static void main(String[] args) {

        Hospederia hospederia = new Hospederia(new DatosCliente("Lourdes", 40775265),12000, 2, "media", 3, true);


    }

}
