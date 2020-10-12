package modelo;

/**
 * *********************************************************************
 * Module: Guias.java Author: Diego Purpose: Defines the Class Guias
 * *********************************************************************
 */

import java.util.*;

/**
 * Clase Guias (Hija de Empleados)
 * @author Diego
 * @version 1.0
 */
public class Guias extends Empleado  {
/**
 * Constructor de la clase Guias que hereda los atributos de la clase Empleados
 * @param nombre
 * @param direccion
 * @param telf
 * @param fechaIn 
 */
    public Guias(String nombre, String direccion, String telf, Date fechaIn) {
        super(nombre, direccion, telf, fechaIn);

    }

}
