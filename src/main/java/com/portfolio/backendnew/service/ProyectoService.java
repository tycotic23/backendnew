/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Proyecto;
import com.portfolio.backendnew.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    ProyectoRepository Proyectos;

    @Override
    public Proyecto crear(Proyecto proyecto) {
        return Proyectos.save(proyecto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proyecto> verTodos() {
        return Proyectos.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        Proyectos.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Proyecto buscar(long id) {
        return Proyectos.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proyecto editar(long id, Proyecto proyecto) {
        proyecto.setId(id);
        return Proyectos.save(proyecto);
    }
    
    @Override
    public String restaurar() {
        Proyectos.deleteAll();
        List<Proyecto> original=new ArrayList<>();
        original.add(new Proyecto("../assets/captura-proyecto-1.png", "Proyecto 1: Mi Portfolio Web", "Proyecto presentado como trabajo final para curso de programación full Stack en el marco del programa \"Argentina Programa\" de la Nación. \nEste proyecto tiene como consigna ser un portfolio web con la posibilidad de iniciar sesión y modificar elementos dentro del mismo a través de una interfaz simple. Permite modificar, crear y eliminar experiencias laborales, estudios y proyectos. \n No admite eliminar ciertos elementos que ya van a existir por defecto (este proyecto, algunas experiencias laborales y educativas. \n Sí permite agregar y luego eliminar o modificar esos nuevos elementos", false, ""));
        Proyectos.saveAll(original);
        return "Restaurado con éxito";
    }
}

