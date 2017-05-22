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
public class Pila {

    private Nodo tope;

    private int tamanio;

    public void Pila() {
        tope = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Nodo getTope() {
        return tope;
    }

    public Nodo eliminar() {
        return tope = null;
    }

    public Nodo apilar(Object valor) {

        Nodo nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {
            tope = nuevo;
        } else {
            nuevo.setSiguiente(tope);
            tope = nuevo;
        }
        tamanio++;
        return tope;
    }

    public Nodo desapilar() {

        if (esVacia()) {
            return null;
        } else {
            Nodo aux = tope;
            aux = aux.getSiguiente();
            tope.setSiguiente(null);
            tope = aux;

            tamanio--;
        }
        return tope;
    }
    
    public boolean buscar(Object valor){
        
        if(esVacia()){
            return false;
        }else{
            Nodo aux = tope;
            
            while(aux!=null){
                
                if(aux.getValor()==valor){
                    return true;
                }
            }
        }
        return false;
    }
}
