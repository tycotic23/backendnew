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
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String pictureurl;
    private String titulo;
    private String descripcion;
    private boolean botonver;
    private String botonurl;
    
    public Proyecto(String pictureurl, String titulo, String descripcion, boolean botonver, String botonurl){
        this.pictureurl=pictureurl;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.botonver=botonver;
        this.botonurl=botonurl;
    }
    
    public Proyecto(){
        
    }
}
