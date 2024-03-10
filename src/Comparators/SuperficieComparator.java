/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;

import gestioninmobiliaria_ars.Vivienda.*;
import java.util.Comparator;

/**
 *
 * @author 4drie
 */
public class SuperficieComparator implements Comparator<Piso> {
    public int compare(Piso piso1, Piso piso2) {
        return Double.compare(piso1.getSuperficie(), piso2.getSuperficie());
    }
}
