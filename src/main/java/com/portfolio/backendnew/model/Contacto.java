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
public class Contacto {
     @Id
    private String redsocial;
    private String logourl;
    private String url;
    private String texto;
    
    public Contacto(){
        
    }
    
    public Contacto(String redsocial,String logourl, String url, String texto){
        this.redsocial=redsocial;
        this.logourl=logourl;
        this.url=url;
        this.texto=texto;
    }
}
