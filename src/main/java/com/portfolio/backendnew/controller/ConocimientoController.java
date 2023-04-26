/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Categoria;
import com.portfolio.backendnew.model.Conocimiento;
import com.portfolio.backendnew.service.ConocimientoService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conocimientos")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class ConocimientoController {
    @Autowired
    ConocimientoService conocimientos;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Conocimiento crear(@RequestBody Conocimiento conocimiento) {
        return conocimientos.crear(conocimiento);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crearcategoria")
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return conocimientos.crearCategoria(categoria);
    }

    @GetMapping("/traer")
    public List<Conocimiento> verTodos() {
        return conocimientos.verTodos();
    }
    
    @GetMapping("/traercategorias")
    public List<Categoria> verCategorias() {
        return conocimientos.verCategorias();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long id) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(conocimientos.eliminar(id), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminarcategoria/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminarCategoria(@PathVariable long id) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(conocimientos.eliminarCategoria(id), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Conocimiento editar(@PathVariable long id, @RequestBody Conocimiento conocimiento) {
        return conocimientos.editar(id, conocimiento);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editarcategoria/{id}")
    public Categoria editarCategoria(@PathVariable long id, @RequestBody Categoria categoria) {
        return conocimientos.editarCategoria(id, categoria);
    }

    @GetMapping("/traer/{id}")
    public Conocimiento buscar(@PathVariable long id) {
        return conocimientos.buscar(id);
    }
    
     @GetMapping("/traercategoria/{id}")
    public Categoria buscarCategoria(@PathVariable long id) {
        return conocimientos.buscarCategoria(id);
    }
    
    @GetMapping("/traercategoriabynombre/{nombre}")
    public Categoria buscarCategoriabyNombre(@PathVariable String nombre) {
        return conocimientos.buscarCategoriabyNombre(nombre);
    }
    
    @GetMapping("/traerconocimientosbycategoria/{id}")
    public List<Conocimiento> conocimientosByCategoria(@PathVariable long id) {
        return conocimientos.ConocimientosbyCategoria(id);
    }

    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los conocimientos actuales
        //crear objetos por defecto
        //guardar todos los nuevos conocimientos
         HashMap<String,Boolean> estadoConocimientoEliminado= new HashMap<>();
        estadoConocimientoEliminado.put(conocimientos.restaurar(), true);
        return ResponseEntity.ok(estadoConocimientoEliminado);
    }
}
