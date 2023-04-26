/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Categoria;
import com.portfolio.backendnew.model.Conocimiento;
import java.util.List;
import java.util.Map;
public interface IConocimientoService {
     public Conocimiento crear(Conocimiento conocimiento);
    public List<Conocimiento> verTodos();
    public Map<Categoria,List<Conocimiento>> agruparPorCategoria();
    public String eliminar(long id);
    public Conocimiento buscar(long id);
    public Conocimiento editar(long id,Conocimiento conocimiento);
    public String restaurar();
}
