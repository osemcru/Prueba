/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Cristian Cruz
 */
public class Administrador extends Usuario {

    private double salario;
    private Date fechaIngreso;

    public Administrador(double salario, Date fechaIngreso, String nombreCompleto, String direccion, String correo, int codigo, int cedula) {
        super(nombreCompleto, direccion, correo, codigo, cedula);
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public Administrador() {

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
