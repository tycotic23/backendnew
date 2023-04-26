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
public class Educacion {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String logourl;
    private String fechaini;
    private String fechafin;
    private String institucion;
    private String titulo;
    
    public Educacion(){
        
    }
    
    public Educacion(String logourl,String fechaini, String fechafin, String institucion, String titulo){
        this.logourl=logourl;
        this.fechaini=fechaini;
        this.fechafin=fechafin;
        this.institucion=institucion;
        this.titulo=titulo;
    }
}
