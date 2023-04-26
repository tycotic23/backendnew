/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.controller;

import com.portfolio.backendnew.model.Idioma;
import com.portfolio.backendnew.service.IdiomaService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/idiomas")
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class IdiomaController {
    @Autowired
    IdiomaService idiomas;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Idioma> crear(@RequestBody Idioma idioma) {
        if("".equals(idioma.getIdioma())) return new ResponseEntity<>(idioma,HttpStatus.LENGTH_REQUIRED);
        if(idioma.getNivel()<1 || idioma.getNivel()>100) return new ResponseEntity<>(idioma,HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(idiomas.crear(idioma),HttpStatus.OK);
    }

    @GetMapping("/traer")
    public List<Idioma> verTodos() {
        return idiomas.verTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{idioma}")
    public ResponseEntity<HashMap<String,Boolean>> eliminar(@PathVariable String idioma) {
        HashMap<String,Boolean> estadoIdiomaEliminado= new HashMap<>();
        estadoIdiomaEliminado.put(idiomas.eliminar(idioma), true);
        return ResponseEntity.ok(estadoIdiomaEliminado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{anterior}")
    public Idioma editar(@PathVariable String anterior, @RequestBody Idioma nuevo) {
        return idiomas.reemplazar(anterior, nuevo);
    }

    @GetMapping("/traer/{idioma}")
    public Idioma buscar(@PathVariable String idioma) {
        return idiomas.buscar(idioma);
    }
    
    @GetMapping("/restore")
    public ResponseEntity<HashMap<String,Boolean>> restaurar(){
        //borrar los idiomas actuales
        //crear objetos por defecto
        //guardar todos los nuevos idiomas
        HashMap<String,Boolean> estadoIdiomaEliminado= new HashMap<>();
        estadoIdiomaEliminado.put(idiomas.restaurar(), true);
        return ResponseEntity.ok(estadoIdiomaEliminado);
    }
}
