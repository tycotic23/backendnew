/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Proyecto;
import java.util.List;
public interface IProyectoService {
    public Proyecto crear(Proyecto proyecto);
    public List<Proyecto> verTodos();
    public String eliminar(long id);
    public Proyecto buscar(long id);
    public Proyecto editar(long id,Proyecto proyecto);
    public String restaurar();
}
