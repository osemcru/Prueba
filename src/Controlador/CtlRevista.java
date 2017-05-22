/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Revista;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julian
 */
public class CtlRevista {

    public ArrayList<Revista> listaRevistas;

    public CtlRevista() {
        listaRevistas = new ArrayList<>();
        cargarArchivoRv();

    }

    public boolean registrarRevista(Revista revista) {
        try {
            listaRevistas.add(revista);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DefaultTableModel listarRv() {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISSN", "Titulo", "Asignatura", "Año", "No°Copias", "Volumen"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < listaRevistas.size(); i++) {
            modelo.addRow(new Object[]{
                listaRevistas.get(i).getIsbnoIssn(),
                listaRevistas.get(i).getTitulo(),
                listaRevistas.get(i).getAsignatura(),
                listaRevistas.get(i).getAño(),
                listaRevistas.get(i).getNumCopias(),
                listaRevistas.get(i).getVolumen()
            });
        }
        return modelo;
    }

    public DefaultTableModel buscarListarRv(ArrayList<Revista> revista) {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISSN", "Titulo", "Asignatura", "Año", "No°Copias", "Volumen"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < revista.size(); i++) {
            //if(listaRevistas.get(i).getTitulo().equals(titulo)){
            modelo.addRow(new Object[]{
                revista.get(i).getIsbnoIssn(),
                revista.get(i).getTitulo(),
                revista.get(i).getAsignatura(),
                revista.get(i).getAño(),
                revista.get(i).getNumCopias(),
                revista.get(i).getVolumen()
            });
            //}
        }
        return modelo;
    }

    public Revista buscarRevista(int issn) {
        for (int i = 0; i < listaRevistas.size(); i++) {
            if (listaRevistas.get(i).getIsbnoIssn() == (issn)) {
                return listaRevistas.get(i);
            }
        }
        return null;
    }

    public DefaultTableModel listarConsulta(String titulo, int isbnIssn, String asignatura, int año, int copias) {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISSN", "Titulo", "Asignatura", "Año", "No°Copias", "Volumen"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        int intIndex;
        for (int i = 0; i < listaRevistas.size(); i++) {
            intIndex = listaRevistas.get(i).getTitulo().indexOf(titulo);
            if ((listaRevistas.get(i).getTitulo().equals(("?i")+titulo) || intIndex >= 0) || titulo.equals("")) {

                if (listaRevistas.get(i).getIsbnoIssn() == isbnIssn || isbnIssn == 0) {
                    intIndex = listaRevistas.get(i).getAsignatura().indexOf(asignatura);
                    if ((listaRevistas.get(i).getAsignatura().equalsIgnoreCase(asignatura) || intIndex >= 0) || asignatura.equals("")) {

                        if (listaRevistas.get(i).getAño() == año || año == 0) {

                            if (listaRevistas.get(i).getNumCopias() == copias || copias == 0) {

                                modelo.addRow(new Object[]{
                                    listaRevistas.get(i).getIsbnoIssn(),
                                    listaRevistas.get(i).getTitulo(),
                                    listaRevistas.get(i).getAsignatura(),
                                    listaRevistas.get(i).getAño(),
                                    listaRevistas.get(i).getNumCopias(),
                                    listaRevistas.get(i).getVolumen()
                                });

                            }
                        }
                    }
                }
            }
        }
        return modelo;
    }

    public boolean eliminarRevista(int issn) {

        for (int i = 0; i < listaRevistas.size(); i++) {

            if (listaRevistas.get(i).getIsbnoIssn() == (issn)) {
                listaRevistas.remove(i);
                return true;
            }

        }

        return false;
    }

    public boolean editarRevista(int issn, String titulo, String editorial, int año, String asignatura, int numCopias, String volumen, int numero) {
        try {
            for (int i = 0; i < listaRevistas.size(); i++) {
                if (listaRevistas.get(i).getIsbnoIssn() == (issn)) {
                    listaRevistas.get(i).setTitulo(titulo);
                    listaRevistas.get(i).setEditorial(editorial);
                    listaRevistas.get(i).setAño(año);
                    listaRevistas.get(i).setAsignatura(asignatura);
                    listaRevistas.get(i).setNumCopias(numCopias);
                    listaRevistas.get(i).setVolumen(volumen);
                    listaRevistas.get(i).setNumero(numero);
                    break;

                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String guardarArchivoRv() {
        FileOutputStream archivoRv;

        try {
            archivoRv = new FileOutputStream("ListaRevistas.txt");
        } catch (Exception e) {
            return "Error al crear el archivo";
        }

        ObjectOutputStream escrituraRv;

        try {
            escrituraRv = new ObjectOutputStream(archivoRv);
        } catch (Exception i) {
            return "Error con el archivo";
        }

        try {
            escrituraRv.writeObject(listaRevistas);
            return "Se ha guardado correctamente";
        } catch (Exception o) {
            return "Error al almacenar el archivo";
        }
    }

    public String cargarArchivoRv() {
        FileInputStream archivoRv;

        try {
            archivoRv = new FileInputStream("ListaRevistas.txt");
        } catch (Exception e) {
            return "Error cargando el archivo";
        }

        ObjectInputStream lecturaRv;

        try {
            lecturaRv = new ObjectInputStream(archivoRv);
        } catch (Exception e) {
            return "Error con el archivo";
        }

        try {
            listaRevistas = (ArrayList<Revista>) lecturaRv.readObject();
        } catch (Exception e) {
            return "Error cargando la informacion";
        }

        return "Archivo cargado correctamente";
    }

    public Revista buscarRevistaSeleccionada(int pos) {
        return listaRevistas.get(pos);
    }

    public boolean verificarRevista(int issn) {

        for (int i = 0; i < listaRevistas.size(); i++) {
            if (issn == (listaRevistas.get(i).getIsbnoIssn())) {
                return false;
            }
        }
        return true;
    }

}
