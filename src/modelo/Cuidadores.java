package modelo;

/**
 * *********************************************************************
 * Module: Cuidadores.java Author: Diego Purpose: Defines the Class
 * Cuidadores
 **********************************************************************
 */
import java.util.*;

/**
 * Clase Cuidadores (Hija de Empleados)
 * @author Diego
 * @version 1.0
 */
public class Cuidadores extends Empleado {
/**
 * Constructor de la clase cuyos parámetros son heredados de su clase padre Empleados
 * @param nombre
 * @param direccion
 * @param telf
 * @param fechaIn 
 */
    public Cuidadores(String nombre, String direccion, String telf, Date fechaIn) {
        super(nombre, direccion, telf, fechaIn);
    }

}
