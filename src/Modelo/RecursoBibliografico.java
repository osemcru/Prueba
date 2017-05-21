/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class RecursoBibliografico implements Serializable{
    
    protected String titulo;
    
    protected String editorial;
    
    // para el libro Año edicion
    // para la revista año
    protected int año;
    
    
    // para el libro sera ISBN
    // para revista sera numero
    
    protected String asignatura;
    
    protected int numCopias ,isbnoIssn;

    public RecursoBibliografico(String titulo, String editorial, int año, String asignatura, int numCopias, int isbnoIssn) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.año = año;
        this.asignatura = asignatura;
        this.numCopias = numCopias;
        this.isbnoIssn = isbnoIssn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public int getIsbnoIssn() {
        return isbnoIssn;
    }

    public void setIsbnoIssn(int isbnoIssn) {
        this.isbnoIssn = isbnoIssn;
    }


    
    
    
}
