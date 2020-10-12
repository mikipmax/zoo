
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
import modelo.Cuidadores;
import vista.Cuidador_vista;

/**
 * Clase Controlador_cuidadores que me permite realizar el crud a la clase
 * Cuidadores
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_cuidadores {
    static List<Cuidadores> lista_cuidadores = cargarArbol();
/**
 * Método que me permite guardar los datos de los cuidadores en una archivo
 * @param nombre
 * @param direccion
 * @param telefono
 * @param fechaIn 
 */
    public static void guardarArbol(String nombre, String direccion, String telefono, Date fechaIn) {
        List<Cuidadores> lista = null;
        try {
            lista = cargarArbol();
            Cuidadores guias = new Cuidadores(nombre, direccion, telefono, fechaIn);

            lista.add(guias);
            lista_cuidadores = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataCuidadores.txt"); //creo el archivo llamado dataCuidadores.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataCuidadores is saved in dataCuidadores.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }
/**
 * Método que me permite cargar los datos de un archivo
 * @return lista de cuidadores
 */
    public static List<Cuidadores> cargarArbol() {
        List<Cuidadores> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataCuidadores.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Cuidadores>) in.readObject();
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
 * Método que me permite editar un cuidador 
 * @param nombre
 * @param direccion
 * @param telefono
 * @param fechaIn 
 */
    public static void editar(String nombre, String direccion, String telefono, Date fechaIn) {
        List<Cuidadores> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_cuidadores.remove(lista_cuidadores.indexOf(es));
            for (Cuidadores lista_esp1 : lista) {
                if (lista_esp1.getNombre().equalsIgnoreCase(nombre)) {
                    lista.get(ind).setNombre(nombre);
                    lista.get(ind).setDireccion(direccion);
                    lista.get(ind).setTelf(telefono);
                    lista.get(ind).setFechaIn(fechaIn);
                    break;
                }

                ind++;
            }
            lista_cuidadores = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataCuidadores.txt"); //creo el archivo llamado dataCuidadores.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataCuidadores is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }

    }
/**
 * Método que me permite eliminar un cuidador
 * @param nombre
 * @return lista de cuidadores
 */
    public static List<Cuidadores> eliminar(String nombre) {
        List<Cuidadores> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_cuidadores.remove(lista_cuidadores.indexOf(es));
            for (Cuidadores lista_esp1 : lista) {
                if (lista_esp1.getNombre().equalsIgnoreCase(nombre)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_cuidadores = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataCuidadores.txt"); //creo el archivo llamado dataCuidadores.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataCuidadores is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar de manera ascendnete los cuidadores
 * @return lista de cuidadores
 */
    public static List<Cuidadores> ordenarAsc() {
        List<Cuidadores> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            if (Cuidador_vista.bandera_cuidador_orden== 1) {
                Collections.sort(lista_aux, new Comparator<Cuidadores>() {

                    @Override
                    public int compare(Cuidadores o1, Cuidadores o2) {
                        return o1.getDireccion().compareToIgnoreCase(o2.getDireccion());

                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Cuidadores>() {

                    @Override
                    public int compare(Cuidadores o1, Cuidadores o2) {
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
 * Método que me permite ordenar descendentemente los cuidadores
 * @return lista de cuidadores
 */
    public static List<Cuidadores> ordenarDes() {
        List<Cuidadores> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            if (Cuidador_vista.bandera_cuidador_orden == 1) {
                Collections.sort(lista_aux, new Comparator<Cuidadores>() {

                    @Override
                    public int compare(Cuidadores o1, Cuidadores o2) {

                        return o2.getDireccion().compareToIgnoreCase(o1.getDireccion());
                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Cuidadores>() {

                    @Override
                    public int compare(Cuidadores o1, Cuidadores o2) {
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
 * Método que me permite recuperar un cuidador, mediante su nombre
 * @param nombre
 * @return lista de cuidadores
 */
    public static List<Cuidadores> recuperarPorId(String nombre) {
        List<Cuidadores> lista_aux = null;
        try {

            List<Cuidadores> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Cuidadores lista1 : lista) {

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
