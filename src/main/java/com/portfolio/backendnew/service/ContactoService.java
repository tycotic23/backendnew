/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Contacto;
import com.portfolio.backendnew.repository.ContactoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContactoService{
    @Autowired
    ContactoRepository Contactos;

    @Override
    public Contacto crear(Contacto contacto) {
        return Contactos.save(contacto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contacto> verTodos() {
        return Contactos.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(String redSocial) {
        Contactos.deleteById(redSocial); 
        return "Borrado";
    }

    @Override
    public Contacto buscar(String redSocial) {
        return Contactos.findById(redSocial).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contacto editar(String redSocial, Contacto contacto) {
        Contactos.deleteById(redSocial);
        return Contactos.save(contacto);
    }
    
    @Override
    public String restaurar() {
        Contactos.deleteAll();
        List<Contacto> original=new ArrayList<>();
        original.add(new Contacto("Linkedin", "../assets/contactos-pag-iconos-07.png", "https://www.linkedin.com/in/tom%C3%A1s-stevan-balanda-wagner-0b313125a/", "Tomas Stevan Balanda Wagner"));
        original.add(new Contacto("E-mail", "../assets/contactos-pag-iconos-05.png", "mailto:magui.maggie@gmail.com", "magui.maggie@gmail.com"));
        original.add(new Contacto("Behance", "../assets/contactos-pag-iconos-06.png", "https://www.behance.net/tomasstevan", "Tomas Stevan Balanda Wagner"));
        original.add(new Contacto("Teléfono", "../assets/contactos-pag-iconos-04.png", "https://wa.me/5493417197518", "+54 9 341 719-7518"));
        original.add(new Contacto("Itch.io", "../assets/contactos-pag-iconos-08.png", "https://tycotic.itch.io/", "tycotic"));
        original.add(new Contacto("Github", "../assets/contactos-pag-iconos-09.png", "https://github.com/tycotic23", "tycotic23"));
        Contactos.saveAll(original);
        return "Restaurado con éxito";
    }
}
