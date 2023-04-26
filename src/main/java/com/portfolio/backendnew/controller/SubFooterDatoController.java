/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Subfooterdato;
import com.portfolio.backendnew.service.SubFooterDatoService;
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
@RequestMapping("/subfooterdatos")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class SubFooterDatoController {
    @Autowired
    SubFooterDatoService subFooterDatos;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Subfooterdato crear(@RequestBody Subfooterdato subFooterDato) {
        return subFooterDatos.crear(subFooterDato);
    }

    @GetMapping("/traer")
    public List<Subfooterdato> verTodos() {
        return subFooterDatos.verTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable long id) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(subFooterDatos.eliminar(id), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Subfooterdato editar(@PathVariable long id, @RequestBody Subfooterdato subFooterDato) {
        return subFooterDatos.editar(id, subFooterDato);
    }

    @GetMapping("/traer/{id}")
    public Subfooterdato buscar(@PathVariable long id) {
        return subFooterDatos.buscar(id);
    }
    
    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los contactos actuales
        //crear objetos por defecto
        //guardar todos los nuevos contactos
         HashMap<String,Boolean> estadoContactoRestaurado= new HashMap<>();
        estadoContactoRestaurado.put(subFooterDatos.restaurar(), true);
        return ResponseEntity.ok(estadoContactoRestaurado);
    }
}
