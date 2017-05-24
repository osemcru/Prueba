/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Lector;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julian
 */
public class CtlLector {

    private ArrayList<Lector> listaLectores;
    private int indice = 0;

    public CtlLector() {
        listaLectores = new ArrayList<>();
        cargarArchivoL();
    }

    /**
     * Registra un usuario de tipo lector
     *
     * @param lector, es el usuario a resgitrar
     */
    public void registrarLector(Lector lector) {
        listaLectores.add(lector);
    }

    /**
     * devuelve el default table model para la tabla de lectores
     *
     * @return el defaultablemodel para llenar la tabla de lectores en la vista
     */
    public DefaultTableModel listarL() {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"Codigo", "Cédula", "Nombre", "Dirección", "Correo"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < listaLectores.size(); i++) {
            modelo.addRow(new Object[]{
                listaLectores.get(i).getCodigo(),
                listaLectores.get(i).getCedula(),
                listaLectores.get(i).getNombreCompleto(),
                listaLectores.get(i).getDireccion(),
                listaLectores.get(i).getCorreo()});
        }
        return modelo;
    }

    /**
     * Busca un lector
     *
     * @param cedula, es la cedula del usuario a buscar
     * @return el lector si esta o null si no
     */
    public Lector buscarLector(int cedula) {
        for (int i = 0; i < listaLectores.size(); i++) {
            if (listaLectores.get(i).getCedula() == (cedula)) {
                return listaLectores.get(i);
            }
        }
        return null;
    }

    /**
     * Elimina un usuario de la lista de lectores
     *
     * @param cedula, es la cedula del usuario a eliminar
     * @return true si lo elimina o false si no
     */
    public boolean eliminarLector(int cedula) {

        for (int i = 0; i < listaLectores.size(); i++) {

            if (listaLectores.get(i).getCedula() == (cedula)) {

                listaLectores.remove(i);
                return true;
            }

        }

        return false;
    }

    /**
     * edita un lector de la lista de lectores
     *
     * @param codigo
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     */
    public void editarLector(int codigo, int cedula, String nombre, String direccion, String correo) {
        for (int i = 0; i < listaLectores.size(); i++) {
            if (listaLectores.get(i).getCedula() == (cedula)) {
                listaLectores.get(i).setNombreCompleto(nombre);
                listaLectores.get(i).setCodigo(codigo);
                listaLectores.get(i).setCorreo(correo);
                listaLectores.get(i).setDireccion(direccion);
                break;
            }
        }
    }

    /**
     * guarda un archivo de texto con la lista de los lectores
     */
    public void guardarArchivoL() {
        try {
            FileOutputStream archivoLec = new FileOutputStream("ListaLectores.txt");
            ObjectOutputStream escrituraLec = new ObjectOutputStream(archivoLec);
            escrituraLec.writeObject(listaLectores);
        } catch (Exception o) {
            o.printStackTrace();
        }
    }

    /**
     * carga el archivo de texto con los lectores
     */
    public void cargarArchivoL() {
        try {
            FileInputStream archivoLec = new FileInputStream("ListaLectores.txt");
            ObjectInputStream lecturaLec = new ObjectInputStream(archivoLec);
            listaLectores = (ArrayList<Lector>) lecturaLec.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * busca el lector seleccionado de la tabla
     *
     * @param pos, es la posición del lector a buscar en la lista
     * @return el lector en la posicion de la lista
     */
    public Lector buscarlectorSeleccionado(int pos) {
        indice = pos;
        return listaLectores.get(pos);
    }

    /**
     * comprueba si existe un lector con esa cuenta
     *
     * @param cedula, es la cedula del usuario
     * @param codigo, es el codigo del usuario
     * @return true si esta o false si no
     */
    public boolean comprobarCuentaL(int cedula, int codigo) {
        for (int i = 0; i < listaLectores.size(); i++) {
            if (cedula == (listaLectores.get(i).getCedula()) && codigo == (listaLectores.get(i).getCodigo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica si existe un usuario lector con tal cedula y codigo
     *
     * @param codigo, es el codigo del usuario a buscar
     * @param cedula, es la cedula del usuario a buscar
     * @return false si hay un usuario con ese codigo o cedula, true si no
     */
    public boolean verificarLector(int codigo, int cedula) {

        for (int i = 0; i < listaLectores.size(); i++) {
            if (codigo == (listaLectores.get(i).getCodigo()) || cedula == (listaLectores.get(i).getCedula())) {
                return false;
            }
        }
        return true;
    }

    public void guardarDatosLector(int cedula) {
        Properties propiedades = new Properties();
        OutputStream salida = null;

        String guardar = cedula + "";

        try {
            salida = new FileOutputStream("sesion.properties");

            // asignamos los valores a las propiedades
            propiedades.setProperty("cedulaLector", guardar);

            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public Lector cargarDatosLector() {
        Properties propiedades = new Properties();
        InputStream entrada = null;

        String cargar = null;

        try {

            entrada = new FileInputStream("sesion.properties");

            // cargamos el archivo de propiedades
            propiedades.load(entrada);

            // obtenemos las propiedades y las imprimimos
            cargar = propiedades.getProperty("cedulaLector");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int cedula = Integer.parseInt(cargar);

        for (int i = 0; i < listaLectores.size(); i++) {
            if (cedula == (listaLectores.get(i).getCedula())) {
                return listaLectores.get(i);
            }
        }
        return null;
    }
}
