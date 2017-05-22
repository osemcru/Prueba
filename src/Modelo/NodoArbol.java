/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Krull
 */
public class NodoArbol {
    
    private Usuario valor;
    private NodoArbol izq, der;

    public void NodoArbol() {
        this.valor = null;
        this.izq = null;
        this.der = null;
    }

    public Usuario getValor() {
        return valor;
    }

    public void setValor(Usuario valor) {
        this.valor = valor;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }
    
}
