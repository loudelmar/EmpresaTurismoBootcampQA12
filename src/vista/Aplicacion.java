package vista;

import controlador.EmpresaTurismo;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        EmpresaTurismo empresaTurismo = new EmpresaTurismo(new ArrayList<>());

        Carpa carpa = new Carpa(new DatosCliente("Lou","40775265"),10000,3,"baja","carpa",3);
        Hotel hotel = new Hotel(new DatosCliente("Lourdes","3333333"),11000, 5, "media", "hotel", 6, true, true);
        Cabagna cabagna = new Cabagna(new DatosCliente("Lourdes del Mar", "12345678"),15000, 2, "baja", "cabaña", 3, false, true,false);

        empresaTurismo.ingresarCarpa(carpa);
        empresaTurismo.ingresarHotel(hotel);
        empresaTurismo.ingresarCabagna(cabagna);

        int opcion;
        do {
            opcion  = menu();
            switch (opcion) {
                case 1:
                    System.out.println("Ingreso Medio de Alojamiento");
                    break;
                case 2:
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        System.out.println(empresaTurismo.mediosDeAlojamiento());
                    }
                    break;
                case 3:
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        String rut;
                        rut = ingresarRutCliente();
                        System.out.println(empresaTurismo.datosCliente(rut));
                    }
                    break;
                case 4:
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento para calcular total adicional :(");
                    } else {
                        System.out.println("Los medios de alojamiento tienen un total adicional de $" + empresaTurismo.totalAdicional());
                    }
                    break;
                case 5:
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento para calcular bonos descuento :(");
                    } else {
                        System.out.println("El total de los bonos de descuento son $" + empresaTurismo.totalBonoDescuento());
                    }
                    break;
                case 6:
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        System.out.println(empresaTurismo.cantidadMediosDeAlojamiento());
                    }
                    break;
                case 7:
                    System.out.println("Valor a Cancelar de Cliente");
                    break;
                case 8:
                    System.out.println("Aplicar Incremento de Valor Base");
                    break;
            }
        }while (opcion !=9 );
    }

    public static int menu(){
        System.out.println("************Empresa de Turismo v1.0************");
        System.out.println("1.\tIngresar Medio de Alojamiento");
        System.out.println("2.\tMostrar medios de alojamiento");
        System.out.println("3.\tDatos de un cliente X");
        System.out.println("4.\tTotal adicional");
        System.out.println("5.\tTotal bono descuento");
        System.out.println("6.\tCantidad medios de alojamiento X");
        System.out.println("7.\tValor a cancelar por un cliente X");
        System.out.println("8.\tAplicar incremento del valor base");
        System.out.println("9.\tSalir");
        System.out.println("Ingrese una opción para continuar...");

        return Leer.datoInt();
    }

    public static String ingresarRutCliente(){
        System.out.println("Ingrese el rut del cliente (Por ej. 40775265): ");
        return Leer.dato();
    }

}
