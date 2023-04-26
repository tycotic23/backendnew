/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Categoria;
import com.portfolio.backendnew.model.Conocimiento;
import com.portfolio.backendnew.repository.ConocimientoRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConocimientoService implements IConocimientoService{
      @Autowired
    ConocimientoRepository Conocimientos;
      
      @Autowired
      CategoriaService categorias;

    @Override
    public Conocimiento crear(Conocimiento conocimiento) {
        Categoria categoria;
        //importante: la categoria debe crearse antes, si no existe dara error
        categoria = categorias.buscar(conocimiento.getCategoriaId());
        if (categoria==null) {
            //antes de crear una ver que no exista con el mismo nombre
            categoria = categorias.buscarPorNombre(conocimiento.getCategoriaCategoria());
            if (categoria==null){
                //crear categoria
                Categoria nueva= conocimiento.getCategoria();
                nueva.setId(categorias.crearId());
                nueva=categorias.crear(nueva);
                conocimiento.setCategoria(nueva);
            }
            else{
                //categoria.setId(116);
                conocimiento.setCategoria(categoria);
            }
        }
        return Conocimientos.save(conocimiento); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Conocimiento> verTodos() {
        return Conocimientos.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Categoria> verCategorias(){
        return categorias.sortByOrden();
    }
    
    public Categoria crearCategoria(Categoria categoria){
        return categorias.crear(categoria);
    }
    
    public String eliminarCategoria(long id){
        //antes de eliminar, hay que quitar todos los conocimientos que tengan esa categoria
        List<Conocimiento> conocimientosBorrar = Conocimientos.findByCategoria_id(id);
        for (Conocimiento con:conocimientosBorrar){
            eliminar(con.getId());
        }
        //eliminar categoria
        return categorias.eliminar(id);
    }
    
    public List<Conocimiento> ConocimientosbyCategoria(long id){
        //return categorias.getConocimientos(id).get(0);
        return Conocimientos.findByCategoria_id(id);
    }
    
    

    
    public Categoria editarCategoria(long id, Categoria categoria) {
        return categorias.editar(id, categoria);
    }

    @Override
    public String eliminar(long id) {
        Conocimientos.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Conocimiento buscar(long id) {
        return Conocimientos.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Categoria buscarCategoria(long id) {
        return categorias.buscar(id);
    }
    
    public Categoria buscarCategoriabyNombre(String nombre) {
        return categorias.buscarPorNombre(nombre);
    }

    @Override
    public Conocimiento editar(long id, Conocimiento conocimiento) {
        conocimiento.setId(id);
        return Conocimientos.save(conocimiento);
    }

    @Override
    public Map<Categoria,List<Conocimiento>> agruparPorCategoria() {
        Map<Categoria,List<Conocimiento>> conocimientosAgrupados=new HashMap<>();
        return conocimientosAgrupados;
    }
    
    
    @Override
    public String restaurar() {
        Conocimientos.deleteAll();
        categorias.restaurar();
        List<Conocimiento> original=new ArrayList<>();
        //importante: primero restaurar Categoria
        Categoria lenguajes=new Categoria("Lenguajes",0);
        Categoria front=new Categoria("Front End",1);
        Categoria frameworks=new Categoria("Frameworks",2);
        Categoria diseño=new Categoria("Diseño",3);
        original.add(new Conocimiento("C/C++", "assets/lenguajes-01.png", lenguajes));
        original.add(new Conocimiento("Java", "assets/lenguajes-02.png", lenguajes));
        original.add(new Conocimiento("SQL", "assets/lenguajes-06.png", lenguajes));
        original.add(new Conocimiento("Javascript", "assets/lenguajes-05.png", lenguajes));
        original.add(new Conocimiento("HTML", "assets/lenguajes-04.png", front));
        original.add(new Conocimiento("Javascript", "assets/lenguajes-05.png", front));
        original.add(new Conocimiento("CSS", "assets/lenguajes-07.png", front));
        original.add(new Conocimiento("Spring Boot", "assets/lenguajes-03.png", frameworks));
        original.add(new Conocimiento("Angular", "assets/lenguajes-08.png",frameworks));
        original.add(new Conocimiento("Photoshop", "assets/lenguajes-09.png", diseño));
        original.add(new Conocimiento("Illustrator", "assets/lenguajes-10.png", diseño));
        original.add(new Conocimiento("Blender", "assets/lenguajes-11.png", diseño));
        original.add(new Conocimiento("After Effects", "assets/lenguajes-12.png", diseño));
        for (Conocimiento conocimiento:original){
            crear(conocimiento);
        }
        return "Restaurado con éxito";
    }

}
