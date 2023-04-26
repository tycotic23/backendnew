/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Explaboral;
import java.util.List;
public interface IExpLaboralService {
    public Explaboral crear(Explaboral expLaboral);
    public List<Explaboral> verTodos();
    public String eliminar(long id);
    public Explaboral buscar(long id);
    public Explaboral editar(long id,Explaboral expLaboral);
    public String restaurar();
}
