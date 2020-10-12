/**
 * Paquete que guarda todos los contradores de las respectivas clases
 */
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
import modelo.Administrador;

/**
 * Clase Controlador_Adm que me permite realizar el crud a la clase
 * Administrador
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_Adm {

    static List<Administrador> lista_Adm = cargarArbol();

    /**
     * Método que me permite guardar los datos de la clase Administrador en un
     * archivo
     *
     * @param usuario
     * @param clave
     */
    public static void guardarArbol(String usuario, String clave) {
        List<Administrador> lista = null;
        try {
            lista = cargarArbol();
            Administrador admin = new Administrador(usuario, clave);

            lista.add(admin);
            lista_Adm = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataAdm.txt"); //creo el archivo llamado dataAdm.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataAdm is saved in dataAdm.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    /**
     * Método que me permite cargar los datos del administraodr en un archivo
     *
     * @return una lista de Administradores
     */
    public static List<Administrador> cargarArbol() {
        List<Administrador> lista_es = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataAdm.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_es = (List<Administrador>) in.readObject();
                int bandera_root = 0;
                for (Administrador lista_e : lista_es) {
                    if (lista_e.getUser().equalsIgnoreCase("admin")) {
                        bandera_root = 1;
                    }

                }

                if (bandera_root == 0 || lista_es.isEmpty()) {
                    lista_es.add(new Administrador("admin", "admin"));
                }
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
     * Método que me permitei editar un administrador y guardar ese cambio en el
     * archivo
     *
     * @param user
     * @param clave
     */
    public static void editar(String user, String clave) {
        List<Administrador> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;

            for (Administrador lista_esp1 : lista) {
                if (lista_esp1.getUser().equalsIgnoreCase(user)) {
                    lista.get(ind).setPass(clave);

                    break;
                }

                ind++;
            }
            lista_Adm = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataAdm.txt"); //creo el archivo llamado dataAdm.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataAdm is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }

    }
/**
 * Mëtodo que me permite eliminar un administrador de la lista
 * @param user
 * @return una lista de administradores
 */
    public static List<Administrador> eliminar(String user) {
        List<Administrador> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
            // lista_esp.remove(lista_esp.indexOf(es));
            for (Administrador lista_esp1 : lista) {
                if (lista_esp1.getUser().equalsIgnoreCase(user)) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_Adm = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataAdm.txt"); //creo el archivo llamado dataAdm.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataAdm is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar de manera ascendente la lista de administradores
 * @return una lista de administradores
 */
    public static List<Administrador> ordenarAsc() {
        List<Administrador> lista_aux = null;
        try {

            lista_aux = cargarArbol();

            Collections.sort(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordenar de manera descenente la lista de administradores
 * @return lista de administradores 
 */
    public static List<Administrador> ordenarDes() {
        List<Administrador> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            Collections.reverse(lista_aux);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permiti recuperar un administrador de la lista, por usuario
 * @param user
 * @return una lista de administradores
 */
    public static List<Administrador> recuperarPorId(String user) {
        List<Administrador> lista_aux = null;
        try {

            List<Administrador> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Administrador lista1 : lista) {

                if (lista1.getUser().equals(user)) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }

}
