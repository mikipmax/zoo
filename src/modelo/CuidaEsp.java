package modelo;

/***********************************************************************
 * Module:  CuidaEsp.java
 * Author:  Diego
 * Purpose: Defines the Class CuidaEsp
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * Clase Cuidador-Especie
 * @author Diego
 * @version 1.0
 */
public class CuidaEsp implements Serializable {
   /**
    * Atributo fecha de asignación de la clase Cuidador-Especie
    */
   private Date fechaAsign;
/**
 * Constructor de la clase
 * @param fechaAsign 
 */
    public CuidaEsp(Date fechaAsign) {
        this.fechaAsign = fechaAsign;
    }
   
   /**
    * Método getter de la fecha de asignación
    * @return fecha de asignación 
    */
   public Date getFechaAsign() {
      return fechaAsign;
   }
   /**
    * Método setter de la fecha de asignación
    * @param newFechaAsign 
    */
   public void setFechaAsign(Date newFechaAsign) {
      fechaAsign = newFechaAsign;
   }

}