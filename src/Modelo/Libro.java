/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Asus
 */
public class Libro extends RecursoBibliografico{
    
    private String autor,edicion;
    
    private int numeroPaginas, numeroDiasPrestado;

    public Libro(String autor, String edicion, int numeroPaginas, int numeroDiasPrestado, String titulo, String editorial, int año, String asignatura, int numCopias, int isbnoIssn) {
        super(titulo, editorial, año, asignatura, numCopias, isbnoIssn);
        this.autor = autor;
        this.edicion = edicion;
        this.numeroPaginas = numeroPaginas;
        this.numeroDiasPrestado = numeroDiasPrestado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroDiasPrestado() {
        return numeroDiasPrestado;
    }

    public void setNumeroDiasPrestado(int numeroDiasPrestado) {
        this.numeroDiasPrestado = numeroDiasPrestado;
    }


    
  
}
