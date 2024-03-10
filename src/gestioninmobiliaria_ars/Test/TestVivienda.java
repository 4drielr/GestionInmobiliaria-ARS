/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestioninmobiliaria_ars.Test;

import gestioninmobiliaria_ars.Vivienda.Operacion;
import gestioninmobiliaria_ars.Vivienda.ViviendaImpl;
import gestioninmobiliaria_ars.Vivienda.Vivienda;
import java.util.*;
import Menu.*;


/**
 *
 * @author DAW TARDE
 */
public class TestVivienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*11.1Crear una vivienda llamada v1 con los siguientes valores: (0.1P)
Superficie: 80m2.
Precio: 850 euros.
Operación: Alquiler
Dirección: Calle Gongora nº 58  - 4ºB, Cordoba*/
        Vivienda v1 = new ViviendaImpl(80, 850, Operacion.ALQUILER, "Calle Gongora nº58 - 4ºB, Cordoba");
        
        //Cree una vivienda v2 con el constructor vacío.
        Vivienda v2 = new ViviendaImpl();
        
        /*Cree una nueva vivienda v3 con los siguientes datos: (0.1P)
Superficie: 90.0m2
Precio: 150.000
Operación: Venta*/
        Vivienda v3 = new ViviendaImpl("");
        
        //Recoja por terminal la superficie, el precio y la dirección. La operación será venta. Modifique  v2 a partir de los siguientes datos recogidos por terminal.
        Scanner s = new Scanner(System.in);
    System.out.println("Escribe la superficie");
    double superficie = s.nextDouble();
        System.out.println("Escribe el precio");
        int precio = s.nextInt();
        s.nextLine();
        System.out.println("Escribe la dirección");
        String direccion = s.nextLine();
        
        v2.setSuperficie(superficie);
        v2.setPrecio(precio);
        v2.setDireccion(direccion);
        v2.setOperacion(Operacion.VENTA);
        
        //11.5 Modifique la dirección v3 con: Plaza de las flores nº 24, Úbeda
        v3.setDireccion("Plaza de las flores nº 24, Úbeda");
        
        //11.6 Se ha realizado una rebaja de un 10% de v1. Muestra por pantalla el precio actual.
        System.out.println("v1 con un descuento del 10% es: " + v1.precioDescuento());
        
        //11.7 Muestre por pantalla la comisión que se lleva la inmobiliaria por v2
        System.out.println("La comisión que se lleva la inmobiliaria por v2 es: " + v2.esPorGestion());
        
        //11.8 Calcule y muestre por pantalla el precio por metro cuadrado de v2
        System.out.println("El precio por m2 de v2 es: " + v2.getPrecioM2());
        
        //11.9 Muestre la localidad de v1 por pantalla.
        System.out.println("La localidad de v1 es: " + v1.getLocalidad());
        
        //11.10 Muestre por pantalla la dirección de la vivienda con mayor precio por metro cuadrado. Compare solo v2 y v3. Use el método del ejercicio 7
        System.out.println("La dirección de la vivienda con mayor precio por M2 entre v2 y v3 es: " + v2.getMayorPrecioM2(v3));
        
        //11.11 Repita el apartado anterior con v1 y v3.
        System.out.println("La dirección de la vivienda con mayor precio por M2 entre v1 y v3 es: " + v1.getMayorPrecioM2(v3));
        
        //11.12 Muestra por pantalla el tipo de vivienda que es v3: ¿pequeña, mediana o grande?
        System.out.println("De que tamaño es v3? " + v2.esTamanhoVivienda());
        
        //11.13 Muestra por pantalla la dirección de la vivienda con mayor precio por metro cuadrado.
        System.out.println("Precios por m2 de v1, v2 y v3: " + v1.getPrecioM2() + " | " + v2.getPrecioM2() + " | " + v3.getPrecioM2());
    }
}
