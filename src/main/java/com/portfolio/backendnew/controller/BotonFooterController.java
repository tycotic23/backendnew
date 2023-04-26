/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Botonfooter;
import com.portfolio.backendnew.service.BotonFooterService;
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
@RequestMapping("/botonesfooter")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class BotonFooterController {
    @Autowired
    BotonFooterService botonFooters;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Botonfooter crear(@RequestBody Botonfooter botonFooter) {
        return botonFooters.crear(botonFooter);
    }

    @GetMapping("/traer")
    public List<Botonfooter> verTodos() {
        return botonFooters.verTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long id) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(botonFooters.eliminar(id), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Botonfooter editar(@PathVariable long id, @RequestBody Botonfooter botonFooter) {
        return botonFooters.editar(id, botonFooter);
    }

    @GetMapping("/traer/{id}")
    public Botonfooter buscar(@PathVariable long id) {
        return botonFooters.buscar(id);
    }

    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los botonFooters actuales
        //crear objetos por defecto
        //guardar todos los nuevos botonFooters
        HashMap<String,Boolean> estadobotonFooterEliminado= new HashMap<>();
        estadobotonFooterEliminado.put(botonFooters.restaurar(), true);
        return ResponseEntity.ok(estadobotonFooterEliminado);
    }
}
