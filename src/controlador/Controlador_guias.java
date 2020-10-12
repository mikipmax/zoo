package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import modelo.Guias;
import vista.Guia_vista;

/**
 * Clase Controlador_guias que me permite realizar el crud a la clase
 * Guias
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_guias {

    static List<Guias> lista_guias = cargarArbol();

    /**
     * Método que me permite grabar los guias en un archivo
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIn
     */
    public static void guardarArbol(String nombre, String direccion, String telefono, Date fechaIn) {
        List<Guias> lista = null;
        try {
            lista = cargarArbol();
            Guias guias = new Guias(nombre, direccion, telefono, fechaIn);

            lista.add(guias);
            lista_guias = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataGuias.txt"); //creo el archivo llamado dataGuias.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataGuias is saved in dataGuias.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    /**
     * Método que me permite cargar los datos de los guias desde un archivo
     *
     * @return lista de guías
     */
    public static List<Guias> cargarArbol() {
        List<Guias> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataGuias.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Guias>) in.readObject();
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
     * Método que me permite editar un gúia
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechaIn
     */
    public static void editar(String nombre, String direccion, String telefono, Date fechaIn) {
        List<Guias> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_guias.remove(lista_guias.indexOf(es));
            for (Guias lista_esp1 : lista) {
                if (lista_esp1.getNombre().equalsIgnoreCase(nombre)) {
                    lista.get(ind).setNombre(nombre);
                    lista.get(ind).setDireccion(direccion);
                    lista.get(ind).setTelf(telefono);
                    lista.get(ind).setFechaIn(fechaIn);
                    break;
                }

                ind++;
            }
            lista_guias = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataGuias.txt"); //creo el archivo llamado dataGuias.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataGuias is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }

    }

    /**
     * Método que me permite eliminar un guía
     *
     * @param nombre
     * @return lista de guías
     */
    public static List<Guias> eliminar(String nombre) {
        List<Guias> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;

            for (Guias lista_esp1 : lista) {
                if (lista_esp1.getNombre().equalsIgnoreCase(nombre)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_guias = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataGuias.txt"); //creo el archivo llamado dataGuias.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataGuias is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar ascendentemente lso guías
 * @return lista de guías
 */
    public static List<Guias> ordenarAsc() {
        List<Guias> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            if (Guia_vista.bandera_guia_orden == 1) {
                Collections.sort(lista_aux, new Comparator<Guias>() {

                    @Override
                    public int compare(Guias o1, Guias o2) {
                        return o1.getDireccion().compareToIgnoreCase(o2.getDireccion());

                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Guias>() {

                    @Override
                    public int compare(Guias o1, Guias o2) {
                        return o1.getNombre().compareToIgnoreCase(o2.getNombre());

                    }
                });
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordnear descendentemente los guías
 * @return lista de guías
 */
    public static List<Guias> ordenarDes() {
        List<Guias> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            if (Guia_vista.bandera_guia_orden == 1) {
                Collections.sort(lista_aux, new Comparator<Guias>() {

                    @Override
                    public int compare(Guias o1, Guias o2) {

                        return o2.getDireccion().compareToIgnoreCase(o1.getDireccion());
                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Guias>() {

                    @Override
                    public int compare(Guias o1, Guias o2) {
                        return o2.getNombre().compareToIgnoreCase(o1.getNombre());

                    }
                });
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite recuperar un guía por su nombre
 * @param nombre
 * @return lista de guías
 */
    public static List<Guias> recuperarPorId(String nombre) {
        List<Guias> lista_aux = null;
        try {

            List<Guias> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Guias lista1 : lista) {

                if (lista1.getNombre().equals(nombre)) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }

}
