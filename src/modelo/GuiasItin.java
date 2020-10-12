package modelo;

/***********************************************************************
 * Module:  GuiasItin.java
 * Author:  Diego
 * Purpose: Defines the Class GuiasItin
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * Clase GuiasItin
 * @author Diego
 * @version 1.0
 */
public class GuiasItin implements Serializable {
/**
 * Atributo de la clase GuiasItin
 */
   private Date horaItin;
/**
 * Constructor de la clase
 * @param horaItin 
 */
    public GuiasItin(Date horaItin) {
        this.horaItin = horaItin;
    }
   /**
    * Método getter de la hora de Itinerario
    * @return hora de itinerario
    */

   public Date getHoraItin() {
      return horaItin;
   }
   
/**
 * Método setter de la hora de Itinerario
 * @param newHoraItin 
 */
   public void setHoraItin(Date newHoraItin) {
      horaItin = newHoraItin;
   }

}