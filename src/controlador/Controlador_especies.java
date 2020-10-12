
package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;
import modelo.Especies;

/**
 * Clase Controlador_especies que me permite realizar el crud a la clase
 * Especies
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_especies {

    static List<Especies> lista_esp = cargarArbol();
/**
 * Método que me permite guardar los datos de las especies en un archivo
 * @param nombreEsp
 * @param nombreCientific
 * @param descripcion 
 */
    public static void guardarArbol(String nombreEsp, String nombreCientific, String descripcion) {
        List<Especies> lista = null;
        try {
            lista = cargarArbol();
            Especies esp = new Especies(nombreEsp, nombreCientific, descripcion);

            lista.add(esp);
            lista_esp = lista;
            try (FileOutputStream fileOut = new FileOutputStream("data.txt"); //creo el archivo llamado data.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized data is saved in data.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }
/**
 * Método que me permite cargar los datos de un archivo
 * @return lista de especies
 */
    public static List<Especies> cargarArbol() {
        List<Especies> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("data.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Especies>) in.readObject();
            }
        } catch (FileNotFoundException i) {
            System.out.println(i);
        } catch (ClassNotFoundException c) {
            System.out.println("Arbol class not found");
            System.out.println(c);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return lista_es;
    }
/**
 * Método que me permite editar una especie
 * @param nombreEsp
 * @param nombreCientific
 * @param descripcio 
 */
    public static void editar(String nombreEsp, String nombreCientific, String descripcio) {
        List<Especies> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_esp.remove(lista_esp.indexOf(es));
            for (Especies lista_esp1 : lista) {
                if (lista_esp1.getNombreEsp().equalsIgnoreCase(nombreEsp)) {
                    lista.get(ind).setNombreEsp(nombreEsp);
                    lista.get(ind).setNombreCientific(nombreCientific);
                    lista.get(ind).setDescripcion(descripcio);
                    break;
                }

                ind++;
            }
            lista_esp = lista;
            try (FileOutputStream fileOut = new FileOutputStream("data.txt"); //creo el archivo llamado data.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized data is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        
    }
  
/**
 * Método que me permite eliminar una especie
 * @param nombreEsp
 * @return lista de especies
 */
    public static List<Especies> eliminar(String nombreEsp) {
        List<Especies> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_esp.remove(lista_esp.indexOf(es));
            for (Especies lista_esp1 : lista) {
                if (lista_esp1.getNombreEsp().equalsIgnoreCase(nombreEsp)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_esp = lista;
            try (FileOutputStream fileOut = new FileOutputStream("data.txt"); //creo el archivo llamado data.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized data is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar ascendentemente las especies
 * @return lista de especies
 */
    public static List<Especies> ordenarAsc() {
        List<Especies> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            Collections.sort(lista_aux);
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordenar descendentemente las especies
 * @return lista de especies
 */
    public static List<Especies> ordenarDes() {
        List<Especies> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            Collections.reverse(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite recuperar una especie por nombre en espanol
 * @param nombre
 * @return lista de especies
 */
    public static List<Especies> recuperarPorId(String nombre) {
        List<Especies> lista_aux = null;
        try {

            List<Especies> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Especies lista1 : lista) {

                if (lista1.getNombreEsp().equals(nombre)) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }

  
}
