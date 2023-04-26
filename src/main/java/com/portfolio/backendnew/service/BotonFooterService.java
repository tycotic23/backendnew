/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Botonfooter;
import com.portfolio.backendnew.repository.BotonFooterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BotonFooterService implements IBotonFooterService {
     @Autowired
    BotonFooterRepository BotonFooters;

    @Override
    public Botonfooter crear(Botonfooter botonFooter) {
        return BotonFooters.save(botonFooter); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Botonfooter> verTodos() {
        return BotonFooters.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        BotonFooters.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Botonfooter buscar(long id) {
        return BotonFooters.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Botonfooter editar(long id, Botonfooter botonFooter) {
        botonFooter.setId(id);
        return BotonFooters.save(botonFooter);
    }

    @Override
    public String restaurar() {
        BotonFooters.deleteAll();
        List<Botonfooter> original=new ArrayList<>();
        original.add(new Botonfooter("../assets/githublogo-naranja.png", "https://github.com/tycotic23"));
        original.add(new Botonfooter("../assets/behance-logo.png","https://www.behance.net/tomasstevan"));
        original.add(new Botonfooter("../assets/itchio-logo.png", "https://tycotic.itch.io/"));
        
        BotonFooters.saveAll(original);
        return "Restaurado con éxito";
    }
}

