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
public class Bibliotecario extends Usuario{
    
    private String turnoAtencion;

    public Bibliotecario(String turnoAtencion, String codigo, String cedula, String nombreCompleto, String direccion, String correo) {
        super(codigo, cedula, nombreCompleto, direccion, correo);
        this.turnoAtencion = turnoAtencion;
    }

   

    public Bibliotecario(){
        
    }

    public String getTurnoAtencion() {
        return turnoAtencion;
    }

    public void setTurnoAtencion(String turnoAtencion) {
        this.turnoAtencion = turnoAtencion;
    }
    
    
}
