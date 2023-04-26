/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Educacion;
import com.portfolio.backendnew.service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class EducacionController {
     @Autowired
    EducacionService educacions;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Educacion crear(@RequestBody Educacion educacion) {
        return educacions.crear(educacion);
    }

    @GetMapping("/traer")
    public List<Educacion> verTodos() {
        return educacions.verTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long id) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(educacions.eliminar(id), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Educacion editar(@PathVariable long id, @RequestBody Educacion educacion) {
        return educacions.editar(id, educacion);
    }

    @GetMapping("/traer/{id}")
    public Educacion buscar(@PathVariable long id) {
        return educacions.buscar(id);
    }
 
    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los contactos actuales
        //crear objetos por defecto
        //guardar todos los nuevos contactos
         HashMap<String,Boolean> estadoContactoRestaurado= new HashMap<>();
        estadoContactoRestaurado.put(educacions.restaurar(), true);
        return ResponseEntity.ok(estadoContactoRestaurado);
    }
}

