/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Educacion;
import java.util.List;
public interface IEducacionService {
    public Educacion crear(Educacion educacion);
    public List<Educacion> verTodos();
    public String eliminar(long id);
    public Educacion buscar(long id);
    public Educacion editar(long id,Educacion educacion);
    public String restaurar();
}