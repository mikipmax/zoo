package modelo;

import java.io.Serializable;
import vista.Zonas_vista;

/**
 * *********************************************************************
 * Module: Zonas.java Author: Diego Purpose: Defines the Class Zonas
 * *********************************************************************
 */
/**
 * Clase Zonas
 *
 * @author Diego
 * @version 1.0
 */
public class Zonas implements Serializable, Comparable<Zonas> {
/**
 * Atributos de la clase
 */
    private String nombreZon;
    private String ext;
/**
 * Constructor de la clase
 * @param nombreZon
 * @param ext 
 */
    public Zonas(String nombreZon, String ext) {
        this.nombreZon = nombreZon;
        this.ext = ext;
    }
/**
 * Método getter del nombre de la zona
 * @return nombre de la zona
 */
    public String getNombreZon() {
        return nombreZon;
    }
/**
 * Mëtodo setter del nombre de la zona
 * @param newNombreZon 
 */
    public void setNombreZon(String newNombreZon) {
        nombreZon = newNombreZon;
    }
/**
 * Método getter de la extensión
 * @return extensión
 */
    public String getExt() {
        return ext;
    }
/**
 * Método setter de la extensión
 * @param newExt 
 */
    public void setExt(String newExt) {
        ext = newExt;
    }
/**
 * Sobreescritura del método compareTo
 * @param o
 * @return un número entero que posteriormente va a permitir ordenar por extensión o por nombre de la zona
 */
    @Override
    public int compareTo(Zonas o) {
        if (Zonas_vista.bandera_zonas_orden == 1) {
            return this.ext.compareToIgnoreCase(o.getExt());
        } else {
            return this.nombreZon.compareToIgnoreCase(o.getNombreZon());
        }
    }

}
