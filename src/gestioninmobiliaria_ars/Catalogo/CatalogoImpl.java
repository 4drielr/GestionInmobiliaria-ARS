/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioninmobiliaria_ars.Catalogo;

import Comparators.SuperficieComparator;
import gestioninmobiliaria_ars.Exceptions.InvalidValueException;
import gestioninmobiliaria_ars.Vivienda.Operacion;
import gestioninmobiliaria_ars.Vivienda.Piso;
import gestioninmobiliaria_ars.Vivienda.PisoImpl;
import java.util.*;

/**
 *
 * @author DAW TARDE
 */
public class CatalogoImpl implements Catalogo {

    private List<Piso> pisos;

    public CatalogoImpl(List<Piso> piso) {
        this.pisos = piso;
    }

     public CatalogoImpl() {
        super();
         this.pisos = new ArrayList<>();
    }
    /**
     * Obtiene el array de objetos tipo Piso
     *
     * @return array de objetos tipo Piso
     */
    public List<Piso> getPisos() {
        return pisos;
    }

    /**
     * Modifica la lista con objetos de tipo piso
     *
     * @param pisos
     */
    @Override
    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }

    //7 Para el tipo Catálogo implemente un método para que: reciba una cadena de caracteres con “ALQUILER” o “VENTA” y devuelva el número de pisos de esa operación.
    /**
     * cuenta los pisos con operacion "alquiler" o "venta"
     *
     * @param tipoOperacion
     * @return contador de pisos
     * @throws InvalidValueException
     */
    public int contarPisosPorOperacion(String tipoOperacion) throws InvalidValueException {
        int contador = 0;
            Operacion operacion = Operacion.valueOf(tipoOperacion.toUpperCase());
            if(operacion!=Operacion.ALQUILER && operacion!=Operacion.VENTA){
                throw new InvalidValueException("La operación no puede ser distinto a alquiler o venta.");
            }

            for (Piso piso : this.pisos) {
                if (piso.getOperacion().equals(operacion)) {
                    contador++;
                }
            }
        return contador;
    }

    //8 Para el tipo Catálogo implemente un método que añada un nuevo piso al catálogo. Tenga en cuenta que no se pueden incluir dos pisos iguales en el catálogo.
    /**
     * Añade un nuevo piso al catalogo
     *
     * @param nuevoPiso
     */
    public void addPisoCatalogo(Piso nuevoPiso) {
        if (!pisos.contains(nuevoPiso)) {
            pisos.add(nuevoPiso);
        }
    }

    //9 Para el tipo Catálogo implemente un método que elimine un piso existente del catálogo. Si el piso no se encuentra en el catálogo entonces deberá lanzar una excepción indicando esto. 
    /**
     * Elimina un piso existente en el catalogo
     *
     * @param pisos
     * @throws InvalidValueException
     */
    public void removePisoCatalogo(Piso piso) throws InvalidValueException {
        if (pisos.contains(piso)) {
            pisos.remove(piso);
        } else {
            throw new InvalidValueException("El piso no se encuentra en la lista.");
        }
    }

    //10 Para el tipo Catálogo implemente un método para que: reciba una planta y devuelva la suma de precios de los pisos que están en esa planta.
    /**
     * Recibe la suma de los pisos en una planta
     *
     * @param planta
     * @return sum
     */
    public double getPreciosPlanta(int planta) {
        double sum = 0;
        for (Piso piso : pisos) {
            if(piso.getPlanta()==planta){
           sum += piso.getPrecio(); 
        }
            
        }
        return sum;
    }

    //11 Para el tipo Catálogo implemente un método para que: devuelva la dirección del piso con el menor precio por superficie (cociente de precio por superficie).
    /**
     * Devuelve la dirección del piso con menor precio por superficie
     *
     * @return direccion
     */
    public String getDireccionPisoMenorPrecioSuperficie() {
        double n = Double.MAX_VALUE;
        String direccion = "";
        for (Piso piso : pisos) {
            if (piso.getPrecioM2() < n) {
                n = piso.getPrecioM2();
                direccion = piso.getDireccion();
            }
        }
        return direccion;
    }

    //12 Para el tipo Catálogo implemente un método para que: dado un precio p y una superficie s devuelve un Catálogo con los pisos con superficie mayor que s y precio menor que p.
    /**
     * Devuelve un catalogo con los pisos con una superficie mayor y un precio menor a los introducidos
     *
     * @param precio
     * @param superficie
     * @return catalogo
     */
    public Catalogo getPisosPrecioSuperficie(double precio, double superficie){
        CatalogoImpl catalogo = new CatalogoImpl();
        for (Piso piso:pisos){
            if(piso.getSuperficie() > superficie && piso.getPrecio() < precio){
                catalogo.addPisoCatalogo(piso);
            }
        }
        return catalogo;
    }
    
    //13 Para el tipo Catálogo implemente un método para que: Ordena el Catálogo por superficie.
    /**
     * Ordena el catalogo por superficie
     *
     */
    public void ordenarXSuperficie(){
        Collections.sort(pisos, new SuperficieComparator());
    }
    
    //14 Para el tipo Catálogo implemente un método para que: Dado un precio p devuelva si existe un piso con precio menor que p.
    /**
     * Devuelve un piso con un precio menor al introducido
     *
     * @param precio
     * @return boolean
     */
    public boolean isPisoPrecioMenor(double precio){
        boolean b = false;
        for(Piso piso:pisos){
            if(piso.getPrecio()<precio){
                b=true;
                break;
            }
    }
        return b;
    }
    
    //15 Para el tipo Catálogo implemente un método para que: Dada una planta p devuelve si todos los pisos están por debajo de esa planta.
    /**
     * Devuelve si todos los pisos están por debajo de una planta introducida
     *
     * @param planta
     */
    public boolean isPisosDebajoPlanta(int planta){
        for (Piso piso:pisos){
            if(piso.getPlanta()>=planta){
                return false;
            }
        }
        return true;
    }
    
    //16 Para el tipo Catálogo implemente un método para que: Dado una superficie s y un porcentaje p rebaja el precio de los pisos con superficie mayor que s un porcentaje p.
    /**
     * Rebaja todos los pisos un porcentaje introducido que tengan una superficie mayor a la introducida
     *
     * @param superficie
     * @param porcentaje
     */
    public void rebajarPrecioSuperficieMayor(double superficie, int porcentaje){
        double p = porcentaje/100;
        for(Piso piso:pisos){
            if(piso.getSuperficie()>superficie){
                piso.setPrecio(piso.getPrecio()-(piso.getPrecio()*p));
            }
        }
    }
}
