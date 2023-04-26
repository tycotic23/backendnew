/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Contacto;
import com.portfolio.backendnew.service.ContactoService;
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
@RequestMapping("/contactos")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class ContactoController {
    @Autowired
    ContactoService contactos;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Contacto crear(@RequestBody Contacto contacto) {
        return contactos.crear(contacto);
    }

    @GetMapping("/traer")
    public List<Contacto> verTodos() {
        return contactos.verTodos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable String nombre) {
        HashMap<String,Boolean> estadoEliminado= new HashMap<>();
        estadoEliminado.put(contactos.eliminar(nombre), true);
        return ResponseEntity.ok(estadoEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{nombre}")
    public Contacto editar(@PathVariable String nombre, @RequestBody Contacto contacto) {
        return contactos.editar(nombre, contacto);
    }

    @GetMapping("/traer/{nombre}")
    public Contacto buscar(@PathVariable String nombre) {
        return contactos.buscar(nombre);
    }

    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los contactos actuales
        //crear objetos por defecto
        //guardar todos los nuevos contactos
         HashMap<String,Boolean> estadoContactoRestaurado= new HashMap<>();
        estadoContactoRestaurado.put(contactos.restaurar(), true);
        return ResponseEntity.ok(estadoContactoRestaurado);
    }
}