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
public class Revista extends RecursoBibliografico{
    
    
    // el numero y volumen deben ser iguales
    // para que sea la misma revista
    private String volumen;
    private int numero;

    public Revista(String volumen, int numero, String titulo, String editorial, int año, String asignatura, int numCopias, int isbnoIssn) {
        super(titulo, editorial, año, asignatura, numCopias, isbnoIssn);
        this.volumen = volumen;
        this.numero = numero;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    }

 
    
    
    
    
    
    

