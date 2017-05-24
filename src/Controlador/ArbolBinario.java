/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.NodoArbol;
import Modelo.Usuario;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ArbolBinario {

    private NodoArbol raiz;
    int cant;
    int altura;

    public NodoArbol getRaiz() {
        return this.raiz;
    }

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean agregar(Usuario valor) {
        NodoArbol nuevo = new NodoArbol();
        nuevo.setValor(valor);
        insertar(nuevo, raiz);
        return true;
    }

    public void insertar(NodoArbol nuevo, NodoArbol pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getValor().getCedula() <= pivote.getValor().getCedula()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }
    }

    public Usuario buscar(Usuario valor) {
        return (buscar(this.raiz, valor));
    }

    private Usuario buscar(NodoArbol r, Usuario x) {
        if (r == null) {
            return null;
        }
        int compara = ((Comparable) r.getValor()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return (Usuario) r.getValor();
        }
    }
}
