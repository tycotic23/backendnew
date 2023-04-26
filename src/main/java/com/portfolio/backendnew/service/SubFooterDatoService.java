/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Subfooterdato;
import com.portfolio.backendnew.repository.SubFooterDatoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubFooterDatoService implements ISubFooterDatoService{
    @Autowired
    SubFooterDatoRepository SubFooterDatos;

    @Override
    public Subfooterdato crear(Subfooterdato subFooterDato) {
        return SubFooterDatos.save(subFooterDato); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Subfooterdato> verTodos() {
        return SubFooterDatos.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        SubFooterDatos.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Subfooterdato buscar(long id) {
        return SubFooterDatos.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subfooterdato editar(long id, Subfooterdato subFooterDato) {
        subFooterDato.setId(id);
        return SubFooterDatos.save(subFooterDato);
    }
    
    @Override
    public String restaurar() {
        SubFooterDatos.deleteAll();
        List<Subfooterdato> original=new ArrayList<>();
        original.add(new Subfooterdato("../assets/contactos-orejas-28.png", "mailto:magui.maggie@gmail.com", "magui.maggie@gmail.com"));
        original.add(new Subfooterdato("../assets/contactos-orejas-27.png", "https://wa.me/5493417197518", "+54 9 341 719-7518"));
        SubFooterDatos.saveAll(original);
        return "Restaurado con éxito";
    }
}
