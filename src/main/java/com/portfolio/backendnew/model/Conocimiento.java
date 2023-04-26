/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Conocimiento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String logourl;
    @ManyToOne
    private Categoria categoria;
    
    public String getCategoriaCategoria(){
        return categoria.getCategoria();
    }
    
      public long getCategoriaId(){
        return categoria.getId();
    }
    
    public int getOrdenCategoria(){
        return categoria.getOrden();
    }
    

    
    public Conocimiento(){
        
    }
    
    public Conocimiento(String nombre, String logourl, Categoria categoria){
        this.nombre=nombre;
        this.logourl=logourl; 
        this.categoria=categoria;
    }
}
