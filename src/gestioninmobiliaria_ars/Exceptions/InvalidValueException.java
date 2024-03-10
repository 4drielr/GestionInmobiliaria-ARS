/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioninmobiliaria_ars.Exceptions;

/**
 *
 * @author DAW TARDE
 */

/*Una vivienda no puede tener un precio negativo. Cree una excepción verificada que muestre un mensaje por pantalla que indique que el precio no puede ser negativo. 
Lance la excepción en el constructor. En el test deberá manejar la excepción.*/

public class InvalidValueException extends Exception {
    public InvalidValueException(String message){
        super(message);
    }
}
