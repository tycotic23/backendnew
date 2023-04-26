/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Subfooterdato;
import java.util.List;
public interface ISubFooterDatoService {
    public Subfooterdato crear(Subfooterdato subFooterDato);
    public List<Subfooterdato> verTodos();
    public String eliminar(long id);
    public Subfooterdato buscar(long id);
    public Subfooterdato editar(long id,Subfooterdato subFooterDato);
    public String restaurar();
}