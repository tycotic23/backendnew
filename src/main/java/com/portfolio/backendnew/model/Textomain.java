/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Textomain {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String texto;
    private String fotourl;
    private String ubicacion;
    
    public Textomain(String nombre, String texto, String fotourl, String ubicacion){
        this.nombre=nombre;
        this.texto=texto;
        this.fotourl=fotourl;
        this.ubicacion=ubicacion;
    }
    
    public Textomain(){
    
    }
}

