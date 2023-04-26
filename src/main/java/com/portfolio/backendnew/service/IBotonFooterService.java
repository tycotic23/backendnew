/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Botonfooter;
import java.util.List;
public interface IBotonFooterService {
     public Botonfooter crear(Botonfooter botonFooter);
        public List<Botonfooter> verTodos();
    public String eliminar(long id);
    public Botonfooter buscar(long id);
    public Botonfooter editar(long id,Botonfooter botonFooter);
    public String restaurar();
}
