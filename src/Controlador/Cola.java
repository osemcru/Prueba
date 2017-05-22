/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nodo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cola {

    private Nodo cabeza;
    private Nodo cola;

    int tamanio;

    public void Cola() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Nodo peek() {
        return cabeza;
    }

    public Nodo eliminar() {
        tamanio = 0;
        return cabeza = null;
    }

    public Nodo add(Object valor) {

        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);

        if (esVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        tamanio++;
        return cabeza;
    }

    public Nodo poll() {

        if (esVacia()) {
            System.out.println("No hay ningun valor encolado");
        } else {
            Nodo aux = cabeza;
            aux = aux.getSiguiente();
            cabeza.setSiguiente(null);
            cabeza = aux;

            tamanio--;
        }
        return cabeza;
    }
}
