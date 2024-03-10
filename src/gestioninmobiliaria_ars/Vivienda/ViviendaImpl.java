/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioninmobiliaria_ars.Vivienda;

import gestioninmobiliaria_ars.Exceptions.InvalidValueException;
import java.util.Objects;

/**
 *
 * @author DAW TARDE
 */

/*El tipo principal que maneja la inmobiliaria será el tipo Vivienda que dispone de los siguientes atributos: 

Superficie (real)
Precio (real)
Operación (enumerado con los valores: alquiler, venta y alquiler con opción a venta. 
Dirección (cadena).*/
public class ViviendaImpl implements Vivienda, Comparable<Vivienda> {

    protected double superficie;
    protected double precio;
    protected Operacion operacion;
    protected String direccion;
    private final static double DESCUENTO = 0.10;
    private final static double COMISION_ALQUILER = 0.08;
    private final static double COMISION_VENTA = 0.14;
    private final static double COMISION_COMPRA = 0.11;

    //Crear la clase y la interfaz con sus métodos observables y modificables
    /**
     * Obtiene la superficie actual de la vivienda
     *
     * @return superficie actual de la vivienda
     */
    @Override
    public double getSuperficie() {
        return this.superficie;
    }

    /**
     * Obtiene el precio actual de la vivienda
     *
     * @return precio actual de la vivienda
     */
    @Override
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Obtiene el tipo de operacion de la vivienda
     *
     * @return tipo de operacion de la vivienda
     */
    @Override
    public Operacion getOperacion() {
        return this.operacion;
    }

    /**
     * Obtiene la dirección actual de la vivienda
     *
     * @return direccion actual de la vivienda
     */
    @Override
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Modifica la superficie actual de la vivienda
     *
     * @param superf
     */
    @Override
    public void setSuperficie(double superf) {
        this.superficie = superf;
    }

    /**
     * Modifica la superficie actual de la vivienda
     *
     * @param price
     */
    @Override
    public void setPrecio(double price) {
        try{
            checkPrecio(price);
            this.precio = price;
        } catch (InvalidValueException e){
            System.out.println(e);
        }
    }

    /**
     * Modifica el tipo de operacion de la vivienda
     *
     * @param operation
     */
    @Override
    public void setOperacion(Operacion operation) {
        this.operacion = operation;
    }

    /**
     * Modifica la direccion actual de la vivienda
     *
     * @param direction
     */
    @Override
    public void setDireccion(String direction) {
        this.direccion = direction;
    }

    //Crear tres constructores:
    //Uno que reciba los valores de todos los atributos por parámetro.
    public ViviendaImpl(double sup, double pre, Operacion op, String dir) {
        try{
            checkPrecio(pre);
            this.precio = pre;
        } catch (InvalidValueException e){
            System.out.println(e);
        }
        this.superficie = sup;
        this.operacion = op;
        this.direccion = dir;
    }

    //Uno que reciba únicamente la dirección y el resto los inicialice al valor establecido por defecto:
    public ViviendaImpl(String di) {
        this.superficie = 90.0;
        this.precio = 150000;
        this.operacion = Operacion.VENTA;
        this.direccion = di;
    }

    //Uno que no reciba ningún valor por parámetro e inicialice al valor nulo todos los atributos. El valor por defecto de operación es venta.
    public ViviendaImpl() {
        this.superficie = 0;
        this.precio = 0;
        this.operacion = Operacion.VENTA;
        this.direccion = "";
    }

    //Crear un método que rebaje el precio de la vivienda a un 10%. El valor de rebaja debe ser creado en una constante.
    /**
     * Obtiene la dirección actual de la vivienda
     *
     * @return precio vivienda con 10% de rebaja
     */
    @Override
    public double precioDescuento() {
        return this.precio - this.precio * DESCUENTO;
    }

    /*Crear el método toString que muestre la información de la Vivienda en el siguiente formato:
         Dirección: Calle Andujar nº 24, Sevilla - precio=150.000 - superficie=80m2 - operación=ALQUILER*/
    @Override
    public String toString() {
        return "Dirección: " + this.direccion + " - precio=" + this.precio + " - superficie=" + this.superficie + "m2 - operación=" + this.operacion;
    }

    //Cree un método que dada una operación, alquiler, venta o alquiler con opción a compra, devuelva si la vivienda es de esa operación.
    /**
     * Obtiene si la operación es la misma que la introducida como parametro
     *
     * @param operation
     * @return Operacion es igual al parametro
     */
    @Override
    public boolean esOperacion(Operacion operation) {
        return this.operacion.equals(operation);
    }

    /*6 Crear un método que devuelva la cantidad que se lleva la inmobiliaria por la gestión. 
        En el caso de las viviendas en alquiler se lleva un 8% del precio, en el caso de las viviendas en venta se lleva un 14% y en el alquiler con opción a compra un 11%*/
    /**
     * Obtiene cuán es la comisión por el tipo de operación
     *
     * @return precio multiplicado por la comisión correspondiente
     */
    @Override
    public double esPorGestion() {
        double price = this.getPrecio();
        switch (this.operacion) {
            case ALQUILER:
                price = this.precio * COMISION_ALQUILER;
                break;
            case VENTA:
                price = this.precio * COMISION_VENTA;
                break;
            case ALQUILER_OPCION_VENTA:
                price = this.precio * COMISION_COMPRA;
        }
        return price;
    }

    /*7 Crear un método que dado otra Vivienda y sí únicamente la operación en ambas en la misma, 
    es decir, ambas están en Venta o en alquiler nos devuelva la dirección de la vivienda con mayor precio por metro cuadrado. En el caso de que las viviendas  
    no tengan la misma operación  devuelva “Las viviendas no tienen la misma dirección”. 
    Para ello, necesitará crear un método que calcule el precio por metro cuadrado.*/
    /**
     * Obtiene el precio por metro cuadrado de la vivienda
     *
     * @return precio entre superficie
     */
    @Override
    public double getPrecioM2() {
        return this.precio / this.superficie;
    }

    /**
     * Devuelve la vivienda con mayor precio por metro cuadrado entre 2
     *
     * @param vivienda
     * @return direccion de vivienda con mayor precio por metro cuadrado
     */
    @Override
    public String getMayorPrecioM2(Vivienda vivienda) {
        String direccion = "";
        if (this.operacion.equals(vivienda.getOperacion())) {
            if (this.getPrecioM2() > vivienda.getPrecioM2()) {
                direccion = this.getDireccion();
            } else if (this.getPrecioM2() == vivienda.getPrecioM2()) {
                direccion = "Tienen el mismo precio";
            } else {
                direccion = vivienda.getDireccion();
            }
        } else {
            direccion = "Las viviendas no tienen la misma dirección";
        }
        return direccion;
    }

    /*8 Cree un método que devuelva un String que diga si la vivienda es pequeña, mediana o grande. (0.6P)
Superficie
Cadena
<70
Vivienda pequeña
70 -  95
Vivienda mediana
>95
Vivienda grande
     */
    /**
     * Obtiene el tamaño de la vivienda
     *
     * @return tamaño de vivienda
     */
    @Override
    public String esTamanhoVivienda() {
        String message = "";
        if (this.superficie < 70) {
            message = "Vivienda pequeña";
        } else if (this.superficie >= 70 && this.superficie <= 95) {
            message = "Vivienda mediana";
        } else {
            message = "Vivienda grande";
        }
        return message;
    }

    /*9 Cree un método que devuelva la localidad en la que se encuentra la vivienda. El formato de la dirección siempre se escribirá así: (1P)

Calle Andujar nº 24, Sevilla
Avenida Andalucía nº107 - 3ºA, Lebrija
Plaza de los rios nº 86 - puerta A - 1º D, Matalascañas*/
    /**
     *
     * Obtiene la localidad de la direccion
     *
     * @return localidad
     */
    @Override
    public String getLocalidad() {
        String[] localidad = this.direccion.split(", ");
        String local = localidad[1];
        return local;
    }

    /**
     * Modifica la superficie con la suma de todos los valores de un array
     *
     * @param superficies
     */
    //10 Cree un método que dado un array con las superficies de cada una de las estancias de la vivienda te calcule la superficie total y modifique la superficie.
    @Override
    public void modificarSuperficie(double[] superficies) {
        double sum = 0;
        for (double element : superficies) {
            sum += element;
        }
        this.setSuperficie(sum);
    }

    //3 Implemente en Vivienda el método equals y el compareTo. Dos viviendas son iguales si tienen la misma dirección.Se ordenan por dirección. 
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Vivienda) {
            Vivienda v = (Vivienda) o;
            r = this.getDireccion().equals(v.getDireccion());
        }
        return r;
    }
    
    
    public int compareTo(Vivienda o1) {
        return this.getDireccion().compareTo(o1.getDireccion());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.direccion);
        return hash;
    }
    
    /**
     * Comprueba si el precio de la vivienda es menor a 0 (negativo)
     *
     * @param precio
     * @throws gestioninmobiliaria_ars.Exceptions.InvalidValueException
     */
    /*Una vivienda no puede tener un precio negativo. Cree una excepción verificada que muestre un mensaje por pantalla que indique que el precio no puede ser negativo. 
Lance la excepción en el constructor con un método estático. */
    public static void checkPrecio(double precio) throws InvalidValueException{
        if(precio<0){
            throw new InvalidValueException("El precio de la vivienda no puede ser negativo.");
        }
    }

}
