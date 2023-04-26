/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Idioma;
import java.util.List;
public interface IIdiomaService {
    public Idioma crear(Idioma idioma);
    public List<Idioma> verTodos();
    public String eliminar(String idioma);
    public Idioma buscar(String idioma);
    public Idioma reemplazar(String anterior,Idioma nuevo);
    public String restaurar();
}
