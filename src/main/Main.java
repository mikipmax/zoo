
package main;

import vista.Login;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase Main la que se encarga de ejecutar nuestro programa
 *
 * @author Diego
 * @version 1.0
 */
public class Main {

     public static void main(String[] args) throws UnsupportedLookAndFeelException, ParseException{
/**
 * Con esta línea hago uso de la librería Synthetica para darle un aspecto visual al framey sus componentes 
 */
         UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        
         /**
          * Invoco al login
          */
         Login vista = new Login();
         vista.setVisible(true);
         vista.setLocationRelativeTo(null);
         
    }
}
