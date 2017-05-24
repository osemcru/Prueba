/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Libro;
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
public class CtlLibro {

    public ArrayList<Libro> listaLibros;
    public ArrayList<Libro> consultaLibros;

    public CtlLibro() {
        listaLibros = new ArrayList<>();
        consultaLibros = new ArrayList<>();
        cargarArchivoLb();

    }

    public boolean registrarLibro(Libro libro) {
        try {
            listaLibros.add(libro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DefaultTableModel listarLb() {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISBN", "Titulo", "Asignatura", "Año", "No°Copias", "No°Paginas"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < listaLibros.size(); i++) {
            modelo.addRow(new Object[]{
                listaLibros.get(i).getIsbnoIssn(),
                listaLibros.get(i).getTitulo(),
                listaLibros.get(i).getAsignatura(),
                listaLibros.get(i).getAño(),
                listaLibros.get(i).getNumCopias(),
                listaLibros.get(i).getNumeroPaginas()
            });
        }
        return modelo;
    }

    public DefaultTableModel buscarListarLb(ArrayList<Libro> libro) {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISBN", "Titulo", "Asignatura", "Año", "No°Copias", "No°Paginas"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < libro.size(); i++) {
            //if (consultaListaLibros.get(i).getTitulo().equals(titulo)) {
            modelo.addRow(new Object[]{
                libro.get(i).getIsbnoIssn(),
                libro.get(i).getTitulo(),
                libro.get(i).getAsignatura(),
                libro.get(i).getAño(),
                libro.get(i).getNumCopias(),
                libro.get(i).getNumeroPaginas()
            });
            //}

        }
        return modelo;
    }

    public Libro buscarLibro(int isbn) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getIsbnoIssn() == (isbn)) {
                return listaLibros.get(i);
            }
        }
        return null;
    }

    public DefaultTableModel listarConsulta(String titulo, int isbnIssn, String asignatura, int año, int copias) {
        DefaultTableModel modelo;
        String nombreColumnas[] = {"ISBN", "Titulo", "Asignatura", "Año", "No°Copias", "No°Paginas"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        consultaLibros.clear();
        int intIndex;
        for (int i = 0; i < listaLibros.size(); i++) {
            intIndex = listaLibros.get(i).getTitulo().indexOf(titulo);
            if ((listaLibros.get(i).getTitulo().equalsIgnoreCase(titulo) || intIndex >= 0) || titulo.equals("")) {

                if (listaLibros.get(i).getIsbnoIssn() == isbnIssn || isbnIssn == 0) {
                    intIndex = listaLibros.get(i).getAsignatura().indexOf(asignatura);
                    if ((listaLibros.get(i).getAsignatura().equalsIgnoreCase(asignatura) || intIndex >= 0) || asignatura.equals("")) {

                        if (listaLibros.get(i).getAño() == año || año == 0) {

                            if (listaLibros.get(i).getNumCopias() == copias || copias == 0) {

                                modelo.addRow(new Object[]{
                                    listaLibros.get(i).getIsbnoIssn(),
                                    listaLibros.get(i).getTitulo(),
                                    listaLibros.get(i).getAsignatura(),
                                    listaLibros.get(i).getAño(),
                                    listaLibros.get(i).getNumCopias(),
                                    listaLibros.get(i).getNumeroPaginas()
                                });

                                consultaLibros.add(listaLibros.get(i));
                            }
                        }
                    }
                }
            }
        }

        return modelo;
    }

    public boolean eliminarLibro(int isbn) {

        for (int i = 0; i < listaLibros.size(); i++) {

            if (listaLibros.get(i).getIsbnoIssn() == (isbn)) {
                listaLibros.remove(i);
                return true;
            }

        }

        return false;
    }

    public boolean editarLibro(int isbn, String autores, String edicion, int numPaginas, int numDiasPrestado, String titulo, String editorial, int año, String asignatura, int numCopias) {
        try {
            for (int i = 0; i < listaLibros.size(); i++) {
                if (listaLibros.get(i).getIsbnoIssn() == (isbn)) {
                    listaLibros.get(i).setAutor(autores);
                    listaLibros.get(i).setEdicion(edicion);
                    listaLibros.get(i).setNumeroPaginas(numPaginas);
                    listaLibros.get(i).setNumeroDiasPrestado(numDiasPrestado);
                    listaLibros.get(i).setTitulo(titulo);
                    listaLibros.get(i).setEditorial(editorial);
                    listaLibros.get(i).setAño(año);
                    listaLibros.get(i).setAsignatura(asignatura);
                    listaLibros.get(i).setNumCopias(numCopias);
                    break;

                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void guardarArchivoLb() {

        try {
            FileOutputStream archivoLb = new FileOutputStream("ListaLibros.txt");
            ObjectOutputStream escrituraLb = new ObjectOutputStream(archivoLb);
            escrituraLb.writeObject(listaLibros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarArchivoLb() {
        
        try {
            FileInputStream archivoLb = new FileInputStream("ListaLibros.txt");
            ObjectInputStream lecturaLb = new ObjectInputStream(archivoLb);
            listaLibros = (ArrayList<Libro>) lecturaLb.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Libro buscarLibroSeleccionado(int pos) {
        return consultaLibros.get(pos);
    }

    public boolean verificarLibro(int isbn) {

        for (int i = 0; i < listaLibros.size(); i++) {
            if (isbn == (listaLibros.get(i).getIsbnoIssn())) {
                return false;
            }
        }
        return true;
    }

}
