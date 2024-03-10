/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioninmobiliaria_ars.Vivienda;

/**
 *
 * @author DAW TARDE
 */
/* Tipo Piso, hereda de Vivienda. Añade atributos: planta (entero) y puerta (carácter) ambos observables y no modificables. 
Dos pisos se ordenan de forma natural por dirección, planta y puerta en ese orden. */
public class PisoImpl extends ViviendaImpl implements Piso, Vivienda {

    private int planta;
    private char puerta;

    //6 Implemente para el tipo Piso un constructor que reciba un argumento para cada atributo.
    public PisoImpl(double superficie, double precio, Operacion operacion, String direccion, int planta, char puerta) {
        super(superficie, precio, operacion, direccion);
        this.planta = planta;
        this.puerta = puerta;
    }

    /**
     * Obtiene el numero de planta actual del piso
     *
     * @return numero de planta actual del piso
     */
    @Override
    public int getPlanta() {
        return planta;
    }

    /**
     * Obtiene el numero de puerta actual del piso
     *
     * @return numero de puerta actual del piso
     */
    @Override
    public char getPuerta() {
        return puerta;
    }

    /**
     * Modifica el numero de planta actual del piso
     *
     * @param planta
     */
    @Override
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    /**
     * Modifica el numero de puerta actual del piso
     *
     * @param puerta
     */
    @Override
    public void setPuerta(char puerta) {
        this.puerta = puerta;
    }

    //4 Repite la misma operación para el tipo Piso.  Dos pisos son iguales entre sí si tiene la misma dirección, misma planta y la misma puerta.
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Piso) {
            Piso p = (Piso) o;
            r = super.equals(p) && this.getPlanta() == p.getPlanta() && this.getPuerta() == this.getPuerta();
        }
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.planta;
        hash = 67 * hash + this.puerta;
        return hash;
    }

    
    public int compareTo(Piso o1, Piso o2){
        int n;
        n = o1.getDireccion().compareTo(o2.getDireccion());
        if(n==0){
            n = Integer.compare(o1.getPlanta(), o2.getPlanta());
        }
        if(n==0){
            n = Character.compare(o1.getPuerta(), o2.getPuerta());
        }
        return n;
    }
    }
