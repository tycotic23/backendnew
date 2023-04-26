/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Idioma;
import com.portfolio.backendnew.repository.IdiomaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService implements IIdiomaService{
    @Autowired
    IdiomaRepository Idiomas;

    @Override
    public Idioma crear(Idioma idioma) {
        return Idiomas.save(idioma); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Idioma> verTodos() {
        return Idiomas.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(String idioma) {
        Idiomas.deleteById(idioma); 
        return "Borrado";
    }

    @Override
    public Idioma buscar(String idioma) {
        return Idiomas.findById(idioma).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Idioma reemplazar(String anterior, Idioma nuevo) {
        eliminar(anterior);
        return Idiomas.save(nuevo);
    }

    @Override
    public String restaurar() {
        Idiomas.deleteAll();
        List<Idioma> original=new ArrayList<>();
        original.add(new Idioma("Español",100));
        original.add(new Idioma("Inglés",50));
        original.add(new Idioma("Alemán",10));
        Idiomas.saveAll(original);
        return "Restaurado con éxito";
    }
}
