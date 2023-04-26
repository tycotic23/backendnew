/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Textomain;
import java.util.List;
public interface ITextoMainService {
    public Textomain crear(Textomain textoMain);
    public List<Textomain> verTodos();
    public String eliminar(long id);
    public Textomain buscar(long id);
    public Textomain editar(long id,Textomain textoMain);
    public String restaurar();
}
