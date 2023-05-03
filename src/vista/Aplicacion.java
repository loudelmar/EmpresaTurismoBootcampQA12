package vista;

import controlador.EmpresaTurismo;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        EmpresaTurismo empresaTurismo = new EmpresaTurismo(new ArrayList<>());
        String rut;

        int opcion;
        do {
            opcion  = menu();
            switch (opcion) {
                case 1 -> {
                    //Rut del cliente
                    rut = ingresarRutCliente();
                    if (empresaTurismo.buscarCliente(rut) == -1) {
                        //Nombre del cliente
                        System.out.println("¿Cual es el nombre del cliente?");
                        String nombre = Leer.dato();

                        //Valor base noche
                        System.out.println("¿Cuál es el Valor base de la noche en $?");
                        int valorBaseNoche = Leer.datoInt();

                        //Cantidad de noches
                        System.out.println("¿Cuántas noches reservará el cliente?");
                        int cantidadNoches = Leer.datoInt();

                        //Tipo de temporada
                        String tipoTemporada;
                        do {
                            System.out.println("¿En qué temporada se alojará? (Baja, Media, Alta)");
                            tipoTemporada = Leer.dato();
                        } while (tipoTemporada.compareToIgnoreCase("Baja") != 0 &&
                                tipoTemporada.compareToIgnoreCase("Media") != 0 &&
                                tipoTemporada.compareToIgnoreCase("Alta") != 0);

                        //Tipo de alojamiento
                        String tipoAlojamiento;
                        do {
                            System.out.println("¿En qué se alojará? (Carpa, Cabaña, Hotel)");
                            tipoAlojamiento = Leer.dato();
                        } while (tipoAlojamiento.compareToIgnoreCase("Carpa") != 0 &&
                                tipoAlojamiento.compareToIgnoreCase("Cabaña") != 0 &&
                                tipoAlojamiento.compareToIgnoreCase("Hotel") != 0);

                        //Carpa
                        if (tipoAlojamiento.equalsIgnoreCase("Carpa")) {
                            String tipoMedioAlojamiento = "Carpa";
                            //Cantidad de personas - CARPA
                            System.out.println("¿Cuántas personas se alojarán?");
                            int cantidadPersonas = Leer.datoInt();
                            empresaTurismo.ingresarCarpa(new Carpa(new DatosCliente(nombre, rut), valorBaseNoche, cantidadNoches,
                                    tipoTemporada, tipoMedioAlojamiento, cantidadPersonas));
                            System.out.println("¡La reserva de la carpa está guardada!");
                        } else {
                            //Capacidad - CABAGNA | HOTEL
                            System.out.println("¿Cuál es la capacidad de la cabaña?");
                            int capacidad = Leer.datoInt();

                            //¿Es fumador? - CABAGNA | HOTEL
                            int fumador;
                            boolean esFumador = false;
                            do {
                                System.out.println("¿El cliente es fumador? En caso positivo escriba 1, y en caso negativo escriba 2");
                                fumador = Leer.datoInt();
                                switch (fumador) {
                                    case 1 -> esFumador = true;
                                    case 2 -> esFumador = false;
                                }
                            } while (fumador < 0 || fumador > 2);

                            //¿Con desayuno? CABAGNA | HOTEL
                            int desayuno;
                            boolean conDesayuno = false;
                            do {
                                System.out.println("¿El cliente quiere desayuno? En caso positivo escriba 1, y en caso negativo escriba 2");
                                desayuno = Leer.datoInt();
                                switch (desayuno) {
                                    case 1 -> conDesayuno = true;
                                    case 2 -> conDesayuno = false;
                                }
                            } while (desayuno < 0 || desayuno > 2);

                            //Hotel
                            if (tipoAlojamiento.equalsIgnoreCase("Hotel")) {
                                String tipoMedioAlojamiento = "Hotel";
                                empresaTurismo.ingresarHotel(new Hotel(new DatosCliente(nombre, rut), valorBaseNoche, cantidadNoches,
                                        tipoTemporada, tipoMedioAlojamiento, capacidad, esFumador, conDesayuno));
                                System.out.println("¡La reserva del hotel está guardada!");
                            } else {
                                String tipoMedioAlojamiento = "Cabaña";
                                //¿Con chimenea?
                                int chimenea;
                                boolean conChimenea = false;
                                do {
                                    System.out.println("¿El cliente quiere una cabaña con chimenea? En caso positivo escriba 1, y en caso negativo escriba 2");
                                    chimenea = Leer.datoInt();
                                    switch (chimenea) {
                                        case 1 -> conChimenea = true;
                                        case 2 -> conChimenea = false;
                                    }
                                } while (chimenea < 0 || chimenea > 2);

                                //Cabaña
                                empresaTurismo.ingresarCabagna(new Cabagna(new DatosCliente(nombre, rut), valorBaseNoche,
                                        cantidadNoches, tipoTemporada, tipoMedioAlojamiento, capacidad, esFumador, conDesayuno,
                                        conChimenea));
                                System.out.println("¡La reserva de la cabaña está guardada!");
                            }
                        }
                    } else {
                        System.out.println("El cliente con el rut " + rut + " ya existe! Ingresa un cliente con otro rut :)");
                    }
                }
                case 2 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        System.out.println(empresaTurismo.mediosDeAlojamiento());
                    }
                }
                case 3 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        rut = ingresarRutCliente();
                        System.out.println(empresaTurismo.datosCliente(rut));
                    }
                }
                case 4 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento para calcular total adicional :(");
                    } else {
                        System.out.println("Los medios de alojamiento tienen un total adicional de $" + empresaTurismo.totalAdicional());
                    }
                }
                case 5 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento para calcular bonos descuento :(");
                    } else {
                        System.out.println("El total de los bonos de descuento son $" + empresaTurismo.totalBonoDescuento());
                    }
                }
                case 6 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        System.out.println(empresaTurismo.cantidadMediosDeAlojamiento());
                    }
                }
                case 7 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        rut = ingresarRutCliente();
                        System.out.println(empresaTurismo.valorACancelar(rut));
                    }
                }
                case 8 -> {
                    if (empresaTurismo.getEmpresaTurismo().size() == 0) {
                        System.out.println("No hay medios de alojamiento :(");
                    } else {
                        rut = ingresarRutCliente();
                        System.out.println(empresaTurismo.incrementoValorBase(rut));
                    }
                }
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
