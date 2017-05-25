/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bibliotecario;
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
public class CtlBibliotecario {

    private ArrayList<Bibliotecario> listaBibliotecarios;
    private ArbolBinario bibliotecarios;

    public CtlBibliotecario() {
        listaBibliotecarios = new ArrayList<>();
        bibliotecarios = new ArbolBinario();
        cargarArchivoB();
    }

    /**
     * Registra un usuario de tipo bibliotecario
     *
     * @param bibliotecario, es el usuario a resgitrar
     */
    public void registrarBibliotecario(Bibliotecario bibliotecario) {
        listaBibliotecarios.add(bibliotecario);
        bibliotecarios.agregar(bibliotecario.getCedula());
    }

    /**
     * devuelve el default table model para la tabla de bibliotecarios
     *
     * @return el defaultablemodel para llenar la tabla de bibliotecarios en la
     * vista
     */
    public DefaultTableModel listarB() {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"Codigo", "Cédula", "Nombre", "Dirección", "Correo", "Jornada"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < listaBibliotecarios.size(); i++) {
            modelo.addRow(new Object[]{
                listaBibliotecarios.get(i).getCodigo(),
                listaBibliotecarios.get(i).getCedula(),
                listaBibliotecarios.get(i).getNombreCompleto(),
                listaBibliotecarios.get(i).getDireccion(),
                listaBibliotecarios.get(i).getCorreo(),
                listaBibliotecarios.get(i).getTurnoAtencion()});
        }
        return modelo;
    }

    /**
     * Busca un bibliotecario
     *
     * @param cedula, es la cedula del usuario a buscar
     * @return el bibliotecario si esta o null si no
     */
    public Bibliotecario buscarBibliotecario(int cedula) {

        int cedulaArbol = bibliotecarios.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaBibliotecarios.size(); i++) {
                if (listaBibliotecarios.get(i).getCedula() == cedulaArbol) {
                    return listaBibliotecarios.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Elimina un usuario de la lista de bibliotecarios
     *
     * @param cedula, es la cedula del usuario a eliminar
     * @return true si lo elimina o false si no
     */
    public boolean eliminarBibliotecario(int cedula) {

        for (int i = 0; i < listaBibliotecarios.size(); i++) {

            if (listaBibliotecarios.get(i).getCedula() == (cedula)) {

                listaBibliotecarios.remove(i);
                bibliotecarios.borrar(cedula);
                return true;
            }

        }

        return false;
    }

    /**
     * Edita un bibliotecario de la lista de bibliotecarios
     *
     * @param codigo
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param turnoAtencion
     */
    public void editarBibliotecario(int codigo, int cedula, String nombre, String direccion, String correo, String turnoAtencion) {
        for (int i = 0; i < listaBibliotecarios.size(); i++) {
            if (listaBibliotecarios.get(i).getCedula() == (cedula)) {
                listaBibliotecarios.get(i).setNombreCompleto(nombre);
                listaBibliotecarios.get(i).setCodigo(codigo);
                listaBibliotecarios.get(i).setCorreo(correo);
                listaBibliotecarios.get(i).setDireccion(direccion);
                listaBibliotecarios.get(i).setTurnoAtencion(turnoAtencion);
                break;
            }
        }
    }

    /**
     * guarda un archivo de texto con la lista de los bibliotecarios
     */
    public void guardarArchivoB() {
        try {
            FileOutputStream archivoBib = new FileOutputStream("ListaBibliotecarios.txt");
            ObjectOutputStream escrituraBib = new ObjectOutputStream(archivoBib);
            escrituraBib.writeObject(listaBibliotecarios);
        } catch (Exception o) {
            o.printStackTrace();
        }
    }

    /**
     * carga el archivo de texto con los bibliotecarios
     */
    public void cargarArchivoB() {
        try {
            FileInputStream archivoBib = new FileInputStream("ListaBibliotecarios.txt");
            ObjectInputStream lecturaBib = new ObjectInputStream(archivoBib);
            listaBibliotecarios = (ArrayList<Bibliotecario>) lecturaBib.readObject();

            if (bibliotecarios.getRaiz() == null) {
                for (int i = 0; i < listaBibliotecarios.size(); i++) {
                    bibliotecarios.agregar(listaBibliotecarios.get(i).getCedula());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * busca el bibliotecario seleccionado de la tabla
     *
     * @param pos, es la posición del bibliotecario a buscar en la lista
     * @return el bibliotecario en la posicion de la lista
     */
    public Bibliotecario buscarBibliotecarioSeleccionado(int pos) {
        return listaBibliotecarios.get(pos);
    }

    /**
     * comprueba si existe un bibliotecario con esa cuenta
     *
     * @param cedula, es la cedula del usuario
     * @param codigo, es el codigo del usuario
     * @return true si esta o false si no
     */
    public boolean comprobarCuentaB(int cedula, int codigo) {

        int cedulaArbol = bibliotecarios.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaBibliotecarios.size(); i++) {
                if (cedulaArbol == (listaBibliotecarios.get(i).getCedula()) && codigo == (listaBibliotecarios.get(i).getCodigo())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * verifica si existe un usuario bibliotecario con tal cedula y codigo
     *
     * @param codigo, es el codigo del usuario a buscar
     * @param cedula, es la cedula del usuario a buscar
     * @return false si hay un usuario con ese codigo o cedula, true si no
     */
    public boolean verificarBibliotecario(int codigo, int cedula) {

        int cedulaArbol = bibliotecarios.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaBibliotecarios.size(); i++) {
                if (codigo == (listaBibliotecarios.get(i).getCodigo()) || cedulaArbol == (listaBibliotecarios.get(i).getCedula())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void guardarDatosBiblio(int cedula) {
        Properties propiedades = new Properties();
        OutputStream salida = null;

        String guardar = cedula + "";

        try {
            salida = new FileOutputStream("sesion.properties");

            // asignamos los valores a las propiedades
            propiedades.setProperty("cedulaBiblio", guardar);

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

    public Bibliotecario cargarDatosBiblio() {
        Properties propiedades = new Properties();
        InputStream entrada = null;

        String cargar = null;

        try {

            entrada = new FileInputStream("sesion.properties");

            // cargamos el archivo de propiedades
            propiedades.load(entrada);

            // obtenemos las propiedades y las imprimimos
            cargar = propiedades.getProperty("cedulaBiblio");

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

        for (int i = 0; i < listaBibliotecarios.size(); i++) {
            if (cedula == (listaBibliotecarios.get(i).getCedula())) {
                return listaBibliotecarios.get(i);
            }
        }
        return null;
    }
}
