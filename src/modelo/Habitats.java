package modelo;

import java.io.Serializable;
import vista.Habitats_vista;

/***********************************************************************
 * Module:  Habitats.java
 * Author:  Diego
 * Purpose: Defines the Class Habitats
 ***********************************************************************/


/**
 * Clase Habitats 
 * @author Diego
 * @version 1.0
 */
public class Habitats implements Serializable, Comparable<Habitats>{
/**
 * Atributos de la clase
 */
   private String nombreHab;
   private String clima;
   private String tipoVeg;
   private String[] continente;
/**
 * Constructor de la clase
 * @param nombreHab
 * @param clima
 * @param tipoVeg
 * @param continente 
 */
    public Habitats(String nombreHab, String clima, String tipoVeg, String[] continente) {
        this.nombreHab = nombreHab;
        this.clima = clima;
        this.tipoVeg = tipoVeg;
        this.continente = continente;
    }
   
/**
 * Mëtodo getter del nombre del hábitat
 * @return nombre del hábitat
 */
   public String getNombreHab() {
      return nombreHab;
   }
   

/**
 * Método setter del nombre del Hábitat
 * @param newNombreHab 
 */
   public void setNombreHab(String newNombreHab) {
      nombreHab = newNombreHab;
   }
   
/**
 * Método getter del clima
 * @return clima
 */
   public String getClima() {
      return clima;
   }
   /**
    * Método setter del clima
    * @param newClima 
    */
   public void setClima(String newClima) {
      clima = newClima;
   }
   /**
    * Método getter del tipo de vegetación
    * @return tipo de vegetación
    */
   public String getTipoVeg() {
      return tipoVeg;
   }
   /**
    * Método setter del tipo de vegetación
    * @param newTipoVeg 
    */
   public void setTipoVeg(String newTipoVeg) {
      tipoVeg = newTipoVeg;
   }
   /**
    * Mëtodo getter de el o los continentes
    * @return continente(s)
    */
   public String [] getContinente() {
      return continente;
   }
   /**
    * Mëtodo setter del continente
    * @param newContinente 
    */
   public void setContinente(String[] newContinente) {
      continente = newContinente;
   }
/**
 * Sobreescritura del método compareTo 
 * @param o
 * @return un valor entero que posteriormente permitira ordenar por clima o por nombre del hábitat
 */
    @Override
    public int compareTo(Habitats o) {
         if (Habitats_vista.bandera_hab_orden == 1) {
            return this.clima.compareToIgnoreCase(o.getClima());
        } else {
              return this.nombreHab.compareToIgnoreCase(o.getNombreHab());
        }
    }

}