/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Educacion;
import com.portfolio.backendnew.repository.EducacionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    EducacionRepository Educacions;

    @Override
    public Educacion crear(Educacion Educacion) {
        return Educacions.save(Educacion); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Educacion> verTodos() {
        return Educacions.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        Educacions.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Educacion buscar(long id) {
        return Educacions.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Educacion editar(long id, Educacion educacion) {
        educacion.setId(id);
        return Educacions.save(educacion);
    }
    
    @Override
    public String restaurar() {
        Educacions.deleteAll();
        List<Educacion> original=new ArrayList<>();
        original.add(new Educacion("../assets/logo artes visuales.png","2017", "Actualidad", "Escuela provincial de artes visuales.", "Tecnicatura en diseño gráfico y comunicación visual"));
        original.add(new Educacion("../assets/logo-fceia.png", "2020", "2019", "Facultad de Ciencias Exactas de la Universidad Nacional de Rosario.", "Licenciatura en ciencias de la computación. Incompleto."));
        original.add(new Educacion("../assets/logoutnwhite.png", "2015", "2016", "Universidad Tecnológica Nacional.", "Ingeniería en sistemas. Incompleto."));
        original.add(new Educacion("../assets/ic-logo-02.png", "2010", "2014", "Colegio Sagrado Corazón.", "Orientación producción de bienes y servicios. 2do mejor promedio."));
        Educacions.saveAll(original);
        return "Restaurado con éxito";
    }
}