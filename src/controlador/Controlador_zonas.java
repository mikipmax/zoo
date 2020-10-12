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
import modelo.Zonas;


/**
 * Clase Controlador_Adm que me permite realizar el crud a la clase
 * Administrador
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_zonas {
static List<Zonas> lista_zon = cargarArbol();
/**
 * Método que me permite grabar los datos de las zonas en un archivo
 * @param nombreZonas
 * @param ext 
 */
    public static void guardarArbol(String nombreZonas, String ext) {
        List<Zonas> lista = null;
        try {
            lista = cargarArbol();
            Zonas zonas = new Zonas(nombreZonas,ext);

            lista.add(zonas);
            lista_zon = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataZonas.txt"); //creo el archivo llamado data.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized data is saved in data.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }
/**
 * Método que me permite cargar los datos de las zonas desde un archivo
 * @return lista de zonas
 */
    public static List<Zonas> cargarArbol() {
        List<Zonas> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataZonas.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Zonas>) in.readObject();
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
 * Método que me permite editar una zona
 * @param nombreZonas
 * @param ext 
 */
    public static void editar(String nombreZonas, String ext) {
        List<Zonas> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_zon.remove(lista_zon.indexOf(es));
            for (Zonas lista_zon1 : lista) {
                if (lista_zon1.getNombreZon().equalsIgnoreCase(nombreZonas)) {
                    lista.get(ind).setNombreZon(nombreZonas);
                    lista.get(ind).setExt(ext);
              
                    break;
                }

                ind++;
            }
            lista_zon = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataZonas.txt"); //creo el archivo llamado data.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized data is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        
    }
  
/**
 * Método que me permitira eliminar una zona
 * @param nombreZonas
 * @return lista de zonas
 */
    public static List<Zonas> eliminar(String nombreZonas) {
        List<Zonas> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
 
            for (Zonas lista_zon1 : lista) {
                if (lista_zon1.getNombreZon().equalsIgnoreCase(nombreZonas)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_zon = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataZonas.txt"); //creo el archivo llamado data.txt
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
 * Método que me permite ordenar ascendentemente las zonas
 * @return lista de zonas
 */
    public static List<Zonas> ordenarAsc() {
        List<Zonas> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            Collections.sort(lista_aux);
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordenar descendentemente las zonas
 * @return lista de zonas
 */
    public static List<Zonas> ordenarDes() {
        List<Zonas> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            Collections.reverse(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite recuperar una zona por su nombre
 * @param nombre
 * @return 
 */
    public static List<Zonas> recuperarPorId(String nombre) {
        List<Zonas> lista_aux = null;
        try {

            List<Zonas> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Zonas lista1 : lista) {

                if (lista1.getNombreZon().equals(nombre)) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }

}
