/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Prestamo{
    
    private RecursoBibliografico recurso;
    
    private int tiempoPrestamo;
    
    private Date fechaSolicitud;
       
    private boolean aprobado;
   
    private Lector lector;

    public Prestamo(RecursoBibliografico recurso, int tiempoPrestamo, Date fechaSolicitud, boolean aprobado, Lector lector) {
        this.recurso = recurso;
        this.tiempoPrestamo = tiempoPrestamo;
        this.fechaSolicitud = fechaSolicitud;
        this.aprobado = aprobado;
        this.lector = lector;
    }

    public RecursoBibliografico getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoBibliografico recurso) {
        this.recurso = recurso;
    }

    public int getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    public void setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }
    
}
