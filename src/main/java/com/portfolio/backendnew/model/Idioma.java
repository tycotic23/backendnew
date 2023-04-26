/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Idioma {
     private int nivel;
    @Id
    private String idioma;
    
    public Idioma(){
        
    }
    
    public Idioma(String idioma, int nivel){
        this.idioma=idioma;
        this.nivel=nivel;
    }
}
