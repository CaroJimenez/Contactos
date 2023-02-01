package mx.edu.utez.contactos4b.listas;

import mx.edu.utez.contactos4b.model.BeanContacto;

public class ListaCircular<B> {
    private Nodo inicio;
    private Nodo ultimo;
    private int tamanio;
    public void Lista(){
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }
    public boolean esVacia(){
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }
    public void agregarAlFinal(BeanContacto contacto){
        Nodo nuevo = new Nodo();
        nuevo.setValor(contacto);
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public void listar(){
        if (!esVacia()) {
            Nodo aux = inicio;
            int i = 0;
            System.out.print("-> ");
            do{
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");
                aux = aux.getSiguiente();
                i++;
            }while(aux != inicio);
        }
    }

}
