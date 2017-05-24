/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.NodoArbol;

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
    
    public void setRaiz(NodoArbol r) {
        this.raiz = r;
    }

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean agregar(int valor) {
        NodoArbol nuevo = new NodoArbol();
        nuevo.setValor(valor);
        insertar(nuevo, raiz);
        return true;
    }

    public void insertar(NodoArbol nuevo, NodoArbol pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getValor() <= pivote.getValor()) {
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

    public int buscar(int valor) {
        return (buscar(this.raiz, valor));
    }

    private int buscar(NodoArbol r, int x) {
        if (r == null) {
            return 0;
        }
        int compara = ((Comparable) r.getValor()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return r.getValor();
        }
    }
    
    private NodoArbol buscarMin(NodoArbol r) {
        for (; r.getIzq() != null; r = r.getIzq());
        return (r);
    }
    
    public void borrar(int valor) {
        if (this.buscar(valor)!=0) {
            return;
        }

        NodoArbol z = borrar(this.raiz, valor);
        this.setRaiz(z);
    }

    private NodoArbol borrar(NodoArbol r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getValor()).compareTo(x);
        if (compara > 0) {
            r.setIzq(borrar(r.getIzq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            if (r.getIzq() != null && r.getDer() != null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                NodoArbol cambiar = buscarMin(r.getDer());
                int aux = cambiar.getValor();
                cambiar.setValor(r.getValor());
                r.setValor(aux);
                r.setDer(borrar(r.getDer(), x));
            } else {
                r = (r.getIzq() != null) ? r.getIzq() : r.getDer();
            }
        }
        return r;
    }
}
