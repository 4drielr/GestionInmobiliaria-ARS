/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;
import gestioninmobiliaria_ars.Catalogo.*;
import gestioninmobiliaria_ars.Exceptions.InvalidValueException;
import gestioninmobiliaria_ars.Vivienda.*;
import java.util.*;
/**
 *
 * @author 4drie
 */
public class Menu {
    /**
     * Pide por terminal los valores para crear un objeto piso y lo añade al catalogo.
     * @param sc
     * @param catalogo 
     */
    private static void menuOptionOne(Scanner sc, Catalogo catalogo) {
        System.out.println("Introduce la superficie.");
        double superficie=Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el precio.");
        double precio=Double.parseDouble(sc.nextLine());
        System.out.println("Elige el tipo de operacion:\n"
                + "1. VENTA.\n"
                + "2. ALQUILER.\n"
                + "3. ALQUILER CON OPCIÓN A VENTA.");
        int op=Integer.parseInt(sc.nextLine());
        Operacion operacion = null;
        switch(op){
            case 1:
                operacion=Operacion.VENTA;
                break;
            case 2:
                operacion=Operacion.ALQUILER;
                break;
            case 3:
                operacion=Operacion.ALQUILER_OPCION_VENTA;
                break;
            default:
                System.out.println("Elige una opcíon válida.");
                break;
        }
        System.out.println("Introduce la direccion.");
        String direccion = sc.nextLine();

        System.out.println("Introduce la planta.");
        int planta = Integer.parseInt(sc.nextLine());
        
        char puerta = 0;
        do {
        System.out.println("Introduce la puerta.");
        String n=sc.nextLine();
        if(n.length() != 1 || !Character.isLetter(n.charAt(0))){
            System.out.println("Introduce una sola letra.");
            continue;
        }
        puerta=n.charAt(0);
} while (Character.isLetter(puerta));
        Piso piso = new PisoImpl(superficie, precio, operacion, direccion, planta, puerta);
        catalogo.addPisoCatalogo(piso);
        if(catalogo.getPisos().contains(piso)){
            System.out.println("La operación fue realizada con éxito.");
        }
        else{
            System.out.println("La operación no pudo realizarse.");
        }
        System.out.println(catalogo.getPisos());
    }
    /**
     * Elimina un piso del catalogo pidiendo los valores necesarios
     * @param sc
     * @param catalogo
     * @throws InvalidValueException 
     */
    private static void menuOptionTwo(Scanner sc, Catalogo catalogo) throws InvalidValueException{
        System.out.println("Introduce la planta.");
        int planta = Integer.parseInt(sc.nextLine());
        char puerta = 0;
        do {
        System.out.println("Introduce la puerta.");
        String n=sc.nextLine();
        if(n.length() != 1 || !Character.isLetter(n.charAt(0))){
            System.out.println("Introduce una sola letra.");
            continue;
        }
        puerta=n.charAt(0);
} while (Character.isLetter(puerta));
        System.out.println("Introduce la direccion.");
        String direccion = sc.nextLine();
        
        Piso piso = new PisoImpl(0, 0, null, direccion, planta, puerta);
        
        catalogo.removePisoCatalogo(piso);
        
        if(!catalogo.getPisos().contains(piso)){
            System.out.println("El piso ha sido eliminado correctamente.");
        }
        else{
            System.out.println("El piso no ha podido ser eliminado.");
    }
    }
    
    /**
     * Muestra la dirección del piso más barato por superficie
     * @param catalogo 
     */
    private static void menuOptionThree(Catalogo catalogo){
        System.out.println(catalogo.getDireccionPisoMenorPrecioSuperficie());
    }
    
    /**
     * Se rebajan los precios de los pisos que estén por encima de una superficie pedida
     * @param sc
     * @param catalogo 
     */
    private static void menuOptionFour(Scanner sc, Catalogo catalogo){
        System.out.println("Introduce la superficie.");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el porcentaje de rebaja(%).");
        int porcentaje = Integer.parseInt(sc.nextLine());
        
        catalogo.rebajarPrecioSuperficieMayor(superficie, porcentaje);
        System.out.println("Los pisos con superficie " + superficie + " se han rebajado correctamente.");
        System.out.println(catalogo.getPisos());
    }
    
    /**
     * Filtra el catalogo por precio y superficie
     * @param sc
     * @param catalogo 
     */
    private static void menuOptionFive(Scanner sc, Catalogo catalogo){
        System.out.println("Introduzca el precio.");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca la superficie.");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println(catalogo.getPisosPrecioSuperficie(precio, superficie));
    }
    
    /**
     * Imprime el catalogo
     * @param catalogo 
     */
    private static void menuOptionSix(Catalogo catalogo){
        System.out.println(catalogo.getPisos());
    }
    
    /**
     * Realiza un metodo dependiendo del numero introducido
     * @param sc
     * @param catalogo
     * @throws InvalidValueException 
     */
    public static void menu(Scanner sc, Catalogo catalogo) throws InvalidValueException {
        int option;
        do {
            System.out.println("Pulse un número del 1 al 6 para realizar algunas de las siguientes opciones.\n"
                    + "1: Añadir nuevo piso\n"
                    + "2: Eliminar un piso\n"
                    + "3. Mostrar piso con el menor precio por superficie\n"
                    + "4. Rebajar pisos.\n"
                    + "5. Filtrar por precio y por superficie.\n"
                    + "6: Visualizar Catálogo. \n"
                    + "7: Salir del menú");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    menuOptionOne(sc, catalogo);
                    break;
                case 2:
                    menuOptionTwo(sc, catalogo);
                    break;
                case 3:
                    menuOptionThree(catalogo);
                    break;
                case 4:
                    menuOptionFour(sc, catalogo);
                    ;
                    break;
                case 5:
                    menuOptionFive(sc, catalogo);
                    ;
                    break;
                case 6:
                    menuOptionSix(catalogo);
                    ;
                    break;
                case 7:
                    System.out.println("Cerrando menú...");
                    break;
                default:
                    System.out.println("Opción no disponible.");
                    break;
            }
        } while (option != 7);
    }
}
