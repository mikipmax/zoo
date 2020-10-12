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
import java.util.List;
import modelo.Itinerarios;
import vista.Itinerario_vista;

/**
 * Clase Controlador_Itinerarios que me permite realizar el crud a la clase
 * Itinerarios
 *
 * @author Diego
 * @version 1.0
 */
public class Controlador_itinerarios {

    static List<Itinerarios> lista_it = cargarArbol();
/**
 * Método que me permite grabar los datos de los itinerarios en un archivo
 * @param codItiner
 * @param duracionRec
 * @param longItiner
 * @param numMaxVisit
 * @param numDistEsp 
 */
    public static void guardarArbol(int codItiner, int duracionRec, int longItiner, int numMaxVisit, int numDistEsp) {
        List<Itinerarios> lista = null;
        try {
            lista = cargarArbol();
            Itinerarios itinerarios = new Itinerarios(codItiner, duracionRec, longItiner, numMaxVisit, numDistEsp);

            lista.add(itinerarios);
            lista_it = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataIt.txt"); //creo el archivo llamado dataIt.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataIt is saved in dataIt.txt");
        } catch (IOException i) {
            System.out.println(i);
        }
    }
/**
 * Método que me permite cargar los datos de los itinerarios desde un archivo
 * @return lista de itinerarios
 */
    public static List<Itinerarios> cargarArbol() {
        List<Itinerarios> lista_it = new ArrayList<>();
        try {
            try (FileInputStream fileIn = new FileInputStream("dataIt.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                lista_it = (List<Itinerarios>) in.readObject();
            }
        } catch (FileNotFoundException i) {
            System.out.println(i);
        } catch (ClassNotFoundException c) {
            System.out.println("Arbol class not found");
            System.out.println(c);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return lista_it;
    }
/**
 * Método que me permite editar un itinerario
 * @param codItiner
 * @param duracionRec
 * @param longItiner
 * @param numMaxVisit
 * @param numDistEsp 
 */
    public static void editar(int codItiner, int duracionRec, int longItiner, int numMaxVisit, int numDistEsp) {
        List<Itinerarios> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
          
            for (Itinerarios lista_esp1 : lista) {
                if (lista_esp1.getCodItiner() == codItiner) {
                    lista.get(ind).setCodItiner(codItiner);
                    lista.get(ind).setDuracionRec(duracionRec);
                    lista.get(ind).setLongItiner(longItiner);
                    lista.get(ind).setNumMaxVisit(numMaxVisit);
                    lista.get(ind).setNumDistEsp(numDistEsp);
                    break;
                }

                ind++;
            }
            lista_it = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataIt.txt"); //creo el archivo llamado dataIt.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataIt is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }

    }
/**
 * Método que me permite eilminar un itinerario
 * @param codItiner
 * @return lista de itinerarios
 */
    public static List<Itinerarios> eliminar(int codItiner) {
        List<Itinerarios> lista = null;
        try {
            lista = cargarArbol();
            int ind = 0;
   
            for (Itinerarios lista_esp1 : lista) {
                if (lista_esp1.getCodItiner() == codItiner) {
                    lista.remove(ind);
                    break;
                }

                ind++;
            }
            lista_it = lista;
            try (FileOutputStream fileOut = new FileOutputStream("dataIt.txt"); //creo el archivo llamado dataIt.txt
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(lista);
            }
            System.out.printf("Serialized dataIt is saved ");
        } catch (IOException i) {
            System.out.println(i);
        }
        return lista;
    }
/**
 * Método que me permite ordenar ascendentemente los itinerarios
 * @return lista de itinerarios
 */
    public static List<Itinerarios> ordenarAsc() {
        List<Itinerarios> lista_aux = null;
        try {

            lista_aux = cargarArbol();
            if (Itinerario_vista.bandera_itin_orden == 1) {
                Collections.sort(lista_aux, new Comparator<Itinerarios>() {

                    @Override
                    public int compare(Itinerarios o1, Itinerarios o2) {
                        return new Integer(o1.getDuracionRec()).compareTo(o2.getDuracionRec());

                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Itinerarios>() {

                    @Override
                    public int compare(Itinerarios o1, Itinerarios o2) {
                        return new Integer(o1.getCodItiner()).compareTo(o2.getCodItiner());

                    }
                });
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite ordenar ascendentemente los itinerarios
 * @return lista de itinerarios
 */
    public static List<Itinerarios> ordenarDes() {
        List<Itinerarios> lista_aux = null;
        try {

            lista_aux = ordenarAsc();

            if (Itinerario_vista.bandera_itin_orden == 1) {
                Collections.sort(lista_aux, new Comparator<Itinerarios>() {

                    @Override
                    public int compare(Itinerarios o1, Itinerarios o2) {
                        return new Integer(o2.getDuracionRec()).compareTo(o1.getDuracionRec());

                    }
                });
            } else {
                Collections.sort(lista_aux, new Comparator<Itinerarios>() {

                    @Override
                    public int compare(Itinerarios o1, Itinerarios o2) {
                        return new Integer(o2.getCodItiner()).compareTo(o1.getCodItiner());

                    }
                });
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
/**
 * Método que me permite recuperar un itinerario por su codigo de itinerario
 * @param codItin
 * @return 
 */
    public static List<Itinerarios> recuperarPorId(int codItin) {
        List<Itinerarios> lista_aux = null;
        try {

            List<Itinerarios> lista = cargarArbol();
            lista_aux = new ArrayList<>();

            for (Itinerarios lista1 : lista) {

                if (lista1.getCodItiner() == codItin) {
                    lista_aux.add(lista1);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista_aux;
    }
}
