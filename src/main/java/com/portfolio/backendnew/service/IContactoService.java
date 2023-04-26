/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Contacto;
import java.util.List;
public interface IContactoService {
    public Contacto crear(Contacto contacto);
    public List<Contacto> verTodos();
    public String eliminar(String redSocial);
    public Contacto buscar(String redSocial);
    public Contacto editar(String redsocial,Contacto contacto);
    public String restaurar();
}
