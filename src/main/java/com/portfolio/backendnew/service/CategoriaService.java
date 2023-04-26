/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Categoria;
import com.portfolio.backendnew.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService implements ICategoriaService {
     @Autowired
     CategoriaRepository Categorias;

    @Override
    public Categoria crear(Categoria Categoria) {
        return Categorias.save(Categoria); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categoria> verTodos() {
        return Categorias.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        Categorias.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Categoria buscar(long id) {
        return Categorias.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public long crearId(){
        Categoria ult= Categorias.findFirstByOrderByIdDesc();
        if (ult==null) return 1;
        return ult.getId()+1;
    }
    
    public Categoria buscarPorNombre(String nombre){
        return Categorias.findByCategoria(nombre);
    }

    @Override
    public Categoria editar(long id, Categoria categoria) {
        categoria.setId(id);
        return Categorias.save(categoria);
    }

    @Override
    public String restaurar() {
        Categorias.deleteAll();
        return "Restaurado con éxito";
    }

    @Override
    public List<Categoria> sortByOrden() {
        return Categorias.findAllByOrderByOrdenAsc();
    }

 
}
