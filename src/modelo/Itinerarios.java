package modelo;

import java.io.Serializable;

/**
 * *********************************************************************
 * Module: Itinerarios.java Author: Diego Purpose: Defines the Class Itinerarios
 * *********************************************************************
 */
/**
 * Clase Itinerarios
 *
 * @author Diego
 * @version 1.0
 */
public class Itinerarios implements Serializable {
/**
 * Atributos de la clase
 */
    private int codItiner;
    private int duracionRec;
    private int longItiner;
    private int numMaxVisit;
    private int numDistEsp;
/**
 * Constructor de la clase
 * @param codItiner
 * @param duracionRec
 * @param longItiner
 * @param numMaxVisit
 * @param numDistEsp 
 */
    public Itinerarios(int codItiner, int duracionRec, int longItiner, int numMaxVisit, int numDistEsp) {
        this.codItiner = codItiner;
        this.duracionRec = duracionRec;
        this.longItiner = longItiner;
        this.numMaxVisit = numMaxVisit;
        this.numDistEsp = numDistEsp;
    }
/**
 * Método getter del código de itinerario
 * @return código de itinerario
 */
    public int getCodItiner() {
        return codItiner;
    }
/**
 * Método setter del código de itinerario
 * @param newCodItiner 
 */
    public void setCodItiner(int newCodItiner) {
        codItiner = newCodItiner;
    }
/**
 * Método getter de la duración de recorrido
 * @return duración de recorrido
 */
    public int getDuracionRec() {
        return duracionRec;
    }
/**
 * Método setter de la duración de recorrido
 * @param newDuracionRec 
 */
    public void setDuracionRec(int newDuracionRec) {
        duracionRec = newDuracionRec;
    }
/**
 * Mëtodo getter de la longitud de itinerario
 * @return longitud de itinerario
 */
    public int getLongItiner() {
        return longItiner;
    }
/**
 * Método setter de la longitud de itinerario
 * @param newLongItiner 
 */
    public void setLongItiner(int newLongItiner) {
        longItiner = newLongItiner;
    }
/**
 * Método getter del número máximo de visitas
 * @return número máximo de visitas
 */
    public int getNumMaxVisit() {
        return numMaxVisit;
    }
/**
 * Método setter del número máximo de visitas
 * @param newNumMaxVisit 
 */
    public void setNumMaxVisit(int newNumMaxVisit) {
        numMaxVisit = newNumMaxVisit;
    }
/**
 * Método getter del núnero distinto de especies
 * @return número distinto de especies
 */
    public int getNumDistEsp() {
        return numDistEsp;
    }
/**
 * Método setter del núemro distinto de especies
 * @param newNumDistEsp 
 */
    public void setNumDistEsp(int newNumDistEsp) {
        numDistEsp = newNumDistEsp;
    }

}
