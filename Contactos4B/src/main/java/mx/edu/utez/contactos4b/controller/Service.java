package mx.edu.utez.contactos4b.controller;

import mx.edu.utez.contactos4b.listas.ListaCircular;
import mx.edu.utez.contactos4b.model.BeanContacto;
import mx.edu.utez.contactos4b.model.DaoContacto;

import java.util.List;

public class Service {
    public List<BeanContacto> getContactos(){
        DaoContacto daoContacto = new DaoContacto();
        return daoContacto.getContactos();
    };
    public List<BeanContacto> search(String texto){
        DaoContacto daoContacto = new DaoContacto();
        return daoContacto.search(texto);
    };

}
