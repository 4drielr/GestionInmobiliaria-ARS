/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioninmobiliaria_ars.Vivienda;

/**
 *
 * @author DAW TARDE
 */
public interface Piso extends Vivienda, Comparable<Vivienda> {

    int getPlanta();

    char getPuerta();
    
    public void setPlanta(int planta);
    
    public void setPuerta(char puerta);
    
}
