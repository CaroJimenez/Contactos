package mx.edu.utez.contactos4b.listas;

import mx.edu.utez.contactos4b.model.BeanContacto;

public class Nodo {
 private BeanContacto valor;
  private Nodo siguiente;
    public void Nodo(){
        this.valor = null;
        this.siguiente = null;
    }
    public BeanContacto getValor() {
        return valor;
    }
    public void setValor(BeanContacto valor) {
        this.valor = valor;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
