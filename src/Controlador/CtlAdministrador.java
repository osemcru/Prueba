/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julian
 */
public class CtlAdministrador {

    private ArrayList<Administrador> listaAdministradores;
    private ArbolBinario administradores;

    public CtlAdministrador() {
        listaAdministradores = new ArrayList<>();
        administradores = new ArbolBinario();
        cargarArchivoA();
    }

    /**
     * Registra un usuario de tipo administrador
     *
     * @param administrador, es el usuario a resgitrar
     */
    public void registrarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
        administradores.agregar(administrador.getCedula());
    }

    /**
     * devuelve el default table model para la tabla de administradores
     *
     * @return el defaultablemodel para llenar la tabla de administradores en la
     * vista
     */
    public DefaultTableModel listarA() {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"Codigo", "Cédula", "Nombre", "Dirección", "Correo", "Salario", "Fecha Ingreso"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < listaAdministradores.size(); i++) {
            modelo.addRow(new Object[]{
                listaAdministradores.get(i).getCodigo(),
                listaAdministradores.get(i).getCedula(),
                listaAdministradores.get(i).getNombreCompleto(),
                listaAdministradores.get(i).getDireccion(),
                listaAdministradores.get(i).getCorreo(),
                listaAdministradores.get(i).getSalario(),
                listaAdministradores.get(i).getFechaIngreso()});
        }
        return modelo;
    }

    /**
     * Busca un administrador
     *
     * @param cedula, es la cedula del usuario a buscar
     * @return el administrador si esta o null si no
     */
    public Administrador buscarAdministrador(int cedula) {

        int cedulaArbol = administradores.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaAdministradores.size(); i++) {
                if (listaAdministradores.get(i).getCedula() == cedulaArbol) {
                    return listaAdministradores.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Elimina un usuario de la lista de administradores
     *
     * @param cedula, es la cedula del usuario a eliminar
     * @return true si lo elimina o false si no
     */
    public boolean eliminarAdministrador(int cedula) {

        for (int i = 0; i < listaAdministradores.size(); i++) {

            if (listaAdministradores.get(i).getCedula() == (cedula)) {

                listaAdministradores.remove(i);
                administradores.borrar(cedula);
                return true;
            }

        }

        return false;
    }

    /**
     * Edita un usuario de tipo administrador con sus respectivos atributos
     *
     * @param codigo
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param salario
     * @param fechaIngreso
     */
    public void editarAdministrador(int codigo, int cedula, String nombre, String direccion, String correo, double salario, Date fechaIngreso) {
        for (int i = 0; i < listaAdministradores.size(); i++) {
            if (listaAdministradores.get(i).getCedula() == (cedula)) {
                listaAdministradores.get(i).setNombreCompleto(nombre);
                listaAdministradores.get(i).setCodigo(codigo);
                listaAdministradores.get(i).setCorreo(correo);
                listaAdministradores.get(i).setDireccion(direccion);
                listaAdministradores.get(i).setSalario(salario);
                listaAdministradores.get(i).setFechaIngreso(fechaIngreso);
                break;

            }
        }
    }

    /**
     * guarda un archivo de texto con la lista de los administradores
     */
    public void guardarArchivoA() {
        try {
            FileOutputStream archivoAdm = new FileOutputStream("ListaAdministradores.txt");
            ObjectOutputStream escrituraAdm = new ObjectOutputStream(archivoAdm);
            escrituraAdm.writeObject(listaAdministradores);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * carga el archivo de texto con los administradores
     */
    public void cargarArchivoA() {
        try {
            FileInputStream archivoAdm = new FileInputStream("ListaAdministradores.txt");
            ObjectInputStream lecturaAdm = new ObjectInputStream(archivoAdm);
            listaAdministradores = (ArrayList<Administrador>) lecturaAdm.readObject();

            if (administradores.getRaiz() == null) {
                for (int i = 0; i < listaAdministradores.size(); i++) {
                    administradores.agregar(listaAdministradores.get(i).getCedula());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * busca el administrador seleccionado de la tabla
     *
     * @param pos, es la posición del administrador a buscar en la lista
     * @return el administrador en la posicion de la lista
     */
    public Administrador buscarAdministradorSeleccionado(int pos) {
        return listaAdministradores.get(pos);
    }

    /**
     * comprueba si existe un administrador con esa cuenta
     *
     * @param cedula, es la cedula del usuario
     * @param codigo, es el codigo del usuario
     * @return true si esta o false si no
     */
    public boolean comprobarCuentaA(int cedula, int codigo) {

        int cedulaArbol = administradores.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaAdministradores.size(); i++) {
                if (cedulaArbol == (listaAdministradores.get(i).getCedula()) && codigo == (listaAdministradores.get(i).getCodigo())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * verifica si existe un usuario administrador con tal cedula y codigo
     *
     * @param codigo, es el codigo del usuario a buscar
     * @param cedula, es la cedula del usuario a buscar
     * @return false si hay un usuario con ese codigo o cedula, true si no
     */
    public boolean verificarAdministrador(int codigo, int cedula) {

        int cedulaArbol = administradores.buscar(cedula);

        if (cedulaArbol > 0) {
            for (int i = 0; i < listaAdministradores.size(); i++) {
                if (codigo == (listaAdministradores.get(i).getCodigo()) || cedulaArbol == (listaAdministradores.get(i).getCedula())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void guardarDatosAdmin(int cedula) {
        Properties propiedades = new Properties();
        OutputStream salida = null;
        String guardar = cedula + "";

        try {
            salida = new FileOutputStream("sesion.properties");

            // asignamos los valores a las propiedades
            propiedades.setProperty("cedulaAdmin", guardar);

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

    public Administrador cargarDatosAdmin() {
        Properties propiedades = new Properties();
        InputStream entrada = null;

        String cargar = null;

        try {

            entrada = new FileInputStream("sesion.properties");

            // cargamos el archivo de propiedades
            propiedades.load(entrada);

            // obtenemos las propiedades y las imprimimos
            cargar = propiedades.getProperty("cedulaAdmin");

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

        for (int i = 0; i < listaAdministradores.size(); i++) {
            if (cedula == (listaAdministradores.get(i).getCedula())) {
                return listaAdministradores.get(i);
            }
        }
        return null;
    }
}
