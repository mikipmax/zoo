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
import modelo.Habitats;

/**
 * Clase Controlador_habitats que me permite realizar el crud a la clase
 * Habitats
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_habitats {

    static List<Habitats> lista_hab = cargarArbol();
/**
 * Método que me permite grabar los datos de los hábitats en un archivo
 * @param nombreHab
 * @param clima
 * @param tipoVegetacion
 * @param continente 
 */
    public static void guardarArbol(String nombreHab, String clima, String tipoVegetacion, String[] continente) {
        List<Habitats> lista = null;
        try {
            lista = cargarArbol();
            Habitats hab = new Habitats(nombreHab, clima, tipoVegetacion, continente);

            lista.add(hab);
            lista_hab = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataHab.txt"); //creo el archivo llamado dataHab.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataHab is saved in dataHab.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }
/**
 * Método que me permite cargar los datos de los hábitats desde un archivo
 * @return lista de hábitats
 */
    public static List<Habitats> cargarArbol() {
        List<Habitats> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataHab.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Habitats>) in.readObject();
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
 * Método que me permite editar un hábitat
 * @param nombreHab
 * @param clima
 * @param tipoVegetacion
 * @param continente 
 */
    public static void editar(String nombreHab, String clima, String tipoVegetacion, String[] continente) {
        List<Habitats> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
          
            for (Habitats lista_esp1 : lista) {
                if (lista_esp1.getNombreHab().equalsIgnoreCase(nombreHab)) {
                    lista.get(ind).setNombreHab(nombreHab);
                    lista.get(ind).setClima(clima);
                    lista.get(ind).setTipoVeg(tipoVegetacion);
                    lista.get(ind).setContinente(continente);
                    break;
                }

                ind++;
            }
            lista_hab = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataHab.txt"); //creo el archivo llamado dataHab.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataHab is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }

    }
/**
 * Método que me permite eliminar un hábitat 
 * @param nombreHab
 * @return lista de hábitats
 */
    public static List<Habitats> eliminar(String nombreHab) {
        List<Habitats> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_hab.remove(lista_hab.indexOf(es));
            for (Habitats lista_esp1 : lista) {
                if (lista_esp1.getNombreHab().equalsIgnoreCase(nombreHab)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_hab = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataHab.txt"); //creo el archivo llamado dataHab.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataHab is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar ascendentemente los hábitats
 * @return lista de hábitats
 */
    public static List<Habitats> ordenarAsc() {
        List<Habitats> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            Collections.sort(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordenar descendentemente los hábitats
 * @return lista de hábitats
 */
    public static List<Habitats> ordenarDes() {
        List<Habitats> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            Collections.reverse(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite recuperar un hábitat por su nombre
 * @param nombre
 * @return lista de hábitats
 */
    public static List<Habitats> recuperarPorId(String nombre) {
        List<Habitats> lista_aux = null;
        try {

            List<Habitats> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Habitats lista1 : lista) {

                if (lista1.getNombreHab().equals(nombre)) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
}
