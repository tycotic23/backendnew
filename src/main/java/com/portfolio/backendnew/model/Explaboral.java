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
public class Explaboral {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String logourl;
    private String puesto;
    private String referencias;
    private String empresa;
    private String descripcion;
    private String fechaini;
    private String fechafin;
    
    public Explaboral(String logourl,String puesto, String referencias, String empresa, String descripcion, String fechaini, String fechafin){
        this.logourl=logourl;
        this.puesto=puesto;
        this.referencias=referencias;
        this.empresa=empresa;
        this.fechaini=fechaini;
        this.fechafin=fechafin;
        this.descripcion=descripcion;
    }
    
    public Explaboral(){
        
    }
}

