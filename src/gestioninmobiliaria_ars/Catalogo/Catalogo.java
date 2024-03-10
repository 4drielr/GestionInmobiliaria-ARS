/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioninmobiliaria_ars.Catalogo;

import gestioninmobiliaria_ars.Exceptions.InvalidValueException;
import gestioninmobiliaria_ars.Vivienda.Piso;
import java.util.*;

/**
 *
 * @author 4drie
 */
public interface Catalogo{
    public List<Piso> getPisos();
    public void setPisos(List<Piso> pisos);
    public int contarPisosPorOperacion(String tipoOperacion) throws InvalidValueException;
    public void addPisoCatalogo(Piso nuevoPiso);
    public void removePisoCatalogo(Piso piso) throws InvalidValueException;
    public double getPreciosPlanta(int planta);
    public String getDireccionPisoMenorPrecioSuperficie();
    public Catalogo getPisosPrecioSuperficie(double precio, double superficie);
    public void ordenarXSuperficie();
    public boolean isPisoPrecioMenor(double precio);
    public boolean isPisosDebajoPlanta(int planta);
    public void rebajarPrecioSuperficieMayor(double superficie, int porcentaje);
}
