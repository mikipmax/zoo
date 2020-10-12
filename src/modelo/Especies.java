package modelo;

/**
 * *********************************************************************
 * Module: Especies.java Author: Diego Purpose: Defines the Class Especies
 * *********************************************************************
 */
//importo la interface serializable
import java.io.Serializable;
//importo la clse Especie_vista
import vista.Especie_vista;

/**
 * Clase Especies a la cual haremos crud
 * @author Diego
 * @version 1.0
 */
public class Especies implements Serializable, Comparable<Especies> {

    /**
     * Atributos que pertenecen a la clase Especie
     */
    private String nombreEsp;
    private String nombreCientific;
    private String descripcion;

    /**
     * Contructor de la clase Especie
     *
     * @param nombreEsp nombre de la especie en espanol
     * @param nombreCientific de la especie
     * @param descripcion de la especie
     */
    public Especies(String nombreEsp, String nombreCientific, String descripcion) {
        this.nombreEsp = nombreEsp;
        this.nombreCientific = nombreCientific;
        this.descripcion = descripcion;
    }

    /**
     * Método getter de la descripción
     *
     * @return descripción de la especie
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método setter del atributo descripción
     *
     * @param  newDescripcion de la especie
     */
    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

    /**
     * Método getter del nombre científico
     * @return nombre científico
     */
    public String getNombreCientific() {
        return nombreCientific;
    }

    /**
     * Método setter del nombre científico
     * @param newNombreCientific 
     */
    public void setNombreCientific(String newNombreCientific) {
        nombreCientific = newNombreCientific;
    }
/**
 * Método getter del nombre en espanol
 * @return nombre en espanol
 */
    public String getNombreEsp() {
        return nombreEsp;
    }
/**
 * Método setter del nombre en espanol
 * @param newNombreEsp 
 */
    public void setNombreEsp(String newNombreEsp) {
        nombreEsp = newNombreEsp;
    }

    /**
     * Sobreescritura de método compareTo, para poder ordenar tanto por nombre
     * de especie en español o por nombre de especie cientifico
     *
     * @param o que es un objeto de tipo Especie
     * @return un valor entero, para saber el orden de cada especie en un
     * arrayList
     */
    @Override
    public int compareTo(Especies o) {
        if (Especie_vista.bandera_especie_orden == 1) {
            return this.nombreCientific.compareToIgnoreCase(o.getNombreCientific());
        } else {
            return this.nombreEsp.compareToIgnoreCase(o.getNombreEsp());
        }

    }

}
