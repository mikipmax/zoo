package modelo;

/**
 * *********************************************************************
 * Module: Empleado.java Author: Diego Purpose: Defines the Class Empleado
 * *********************************************************************
 */
import java.io.Serializable;
import java.util.*;

/**
 * Clase Empleado (SuperClase)
 *
 * @author Diego
 * @version 1.0
 */
public class Empleado implements Serializable {
/**
 * Atributos de la clase 
 */
    private String nombre;
    private String direccion;
    private String telf;
    private Date fechaIn;
/**
 * Constructor de la clase
 * @param nombre
 * @param direccion
 * @param telf
 * @param fechaIn 
 */
    public Empleado(String nombre, String direccion, String telf, Date fechaIn) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telf = telf;
        this.fechaIn = fechaIn;
    }
/**
 * Método getter del nombre
 * @return nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Método setter del nombre
 * @param newNombre 
 */
    public void setNombre(String newNombre) {
        nombre = newNombre;
    }
/**
 * Método getter de la dirección
 * @return dirección
 */
    public String getDireccion() {
        return direccion;
    }
/**
 * Método setter de la dirección
 * @param newDireccion 
 */
    public void setDireccion(String newDireccion) {
        direccion = newDireccion;
    }
/**
 * Método getter del teléfono
 * @return  telefóno
 */
    public String getTelf() {
        return telf;
    }
/**
 * Método setter del teléfono
 * @param newTelf 
 */
    public void setTelf(String newTelf) {
        telf = newTelf;
    }
/**
 * Mëtodo getter de la fecha de ingreso
 * @return fecha de ingreso
 */
    public Date getFechaIn() {
        return fechaIn;
    }
/**
 * Mëtodo setter de la fecha 
 * @param fechaIn 
 */
    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

}
