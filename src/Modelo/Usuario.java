/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Cristian Cruz
 */
public class Usuario implements Serializable{
    
    protected String nombreCompleto,direccion,correo;
    protected int codigo,cedula;

    public Usuario(String nombreCompleto, String direccion, String correo, int codigo, int cedula) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.correo = correo;
        this.codigo = codigo;
        this.cedula = cedula;
    }

    public Usuario() {
        
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
