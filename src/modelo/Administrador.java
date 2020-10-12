package modelo;

import java.io.Serializable;
import vista.Adm_vista;

/**
 * Clase Admnistrador que se encarga de gestionar los usuarios del sistema zoo (Crud)
 * @author Diego
 * @version 1.0
 */
public class Administrador implements Serializable, Comparable<Administrador> {
/**
 * Atributos de la clase Administrador
 */
    private String user;
    private String pass;
/**
 * Constructor de la clase Administrador
 * @param user
 * @param pass 
 */
    public Administrador(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
/**
 * Método getter del usuario
 * @return ususario
 */
    public String getUser() {
        return user;
    }
/**
 * Método setter del usuario
 * @param user 
 */
    public void setUser(String user) {
        this.user = user;
    }
/**
 * Método getter de la clave
 * @return clave 
 */
    public String getPass() {
        return pass;
    }
/**
 * Método setter de la clave
 * @param pass 
 */
    public void setPass(String pass) {
        this.pass = pass;
    }
/**
 * Sobreescritura del método compareTo
 * @param o objeto de tipo Administrador
 * @return un valor de tipo entero para posteriormetne poder ordenar por usuario o por clave 
 */
    @Override
    public int compareTo(Administrador o) {
        if (Adm_vista.bandera_adm_orden == 1) {
            return this.pass.compareToIgnoreCase(o.getPass());
        } else {
            return this.user.compareToIgnoreCase(o.getUser());
        }
    }
}
