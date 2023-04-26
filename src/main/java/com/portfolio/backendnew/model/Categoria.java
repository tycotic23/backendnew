/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String categoria;
    private int orden;
    
    
   @OneToMany(mappedBy = "categoria",orphanRemoval=false)
    @JsonIgnore
    private List<Conocimiento> conocimientos;
    
    public Categoria(){
        
    }
    
    public Categoria(String categoria,int orden){
        this.categoria=categoria;
        this.orden=orden;
    }
}
