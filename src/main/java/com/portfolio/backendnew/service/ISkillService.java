/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Skill;
import java.util.List;
public interface ISkillService {
    public Skill crear(Skill skill);
    public List<Skill> verTodos();
    public String eliminar(String skill);
    public Skill buscar(String skill);
    public Skill reemplazar(String anterior,Skill nueva);
    public String restaurar();
}
