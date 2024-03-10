/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioninmobiliaria_ars.Vivienda;

/**
 *
 * @author DAW TARDE
 */
public interface Vivienda {
    public double getSuperficie();
    public double getPrecio();
    public Operacion getOperacion();
    public String getDireccion();
    public void setSuperficie(double superf);
    public void setPrecio(double price);
    public void setOperacion(Operacion operation);
    public void setDireccion(String direction);
    public double precioDescuento();
    public boolean esOperacion(Operacion operation);
    public double esPorGestion();
    public double getPrecioM2();
    public String getMayorPrecioM2(Vivienda vivienda);
    public String esTamanhoVivienda();
    public String getLocalidad();
    public void modificarSuperficie(double[]superficies);
}
