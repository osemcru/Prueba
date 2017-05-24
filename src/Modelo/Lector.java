/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Cristian Cruz
 */
public class Lector extends Usuario{
    
    private Prestamo[] prestamos = new Prestamo[3];

    public Lector(String codigo, String cedula, String nombreCompleto, String direccion, String correo) {
        super(codigo, cedula, nombreCompleto, direccion, correo);
    }

    
    public Prestamo getPrestamos(int i) {
        return prestamos[i];
    }

    public void setPrestamos(Prestamo[] prestamos, int i) {
        this.prestamos[i] = prestamos[i];
    }
     
}
