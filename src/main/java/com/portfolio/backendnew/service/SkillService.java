/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Skill;
import com.portfolio.backendnew.repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired
    SkillRepository skills;

    @Override
    public Skill crear(Skill skill) {
        return skills.save(skill); 
    }

    @Override
    public List<Skill> verTodos() {
        return skills.findAll();
    }

    @Override
    public String eliminar(String skill) {
        skills.deleteById(skill); 
        return "Borrado";
    }

    @Override
    public Skill buscar(String skill) {
        return skills.findById(skill).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Skill reemplazar(String anterior, Skill nueva) {
        eliminar(anterior);
        return crear(nueva);
    }

    @Override
    public String restaurar() {
        skills.deleteAll();
        List<Skill> original=new ArrayList<>();
        original.add(new Skill("Proactividad"));
        original.add(new Skill("Trabajo en equipo"));
        original.add(new Skill("Responsabilidad"));
        original.add(new Skill("Gestión del tiempo"));
        original.add(new Skill("Comunicación"));
        skills.saveAll(original);
        return "Restaurado con éxito";
    }
}
