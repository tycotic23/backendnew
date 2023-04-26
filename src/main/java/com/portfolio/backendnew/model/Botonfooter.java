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
public class Botonfooter {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String logo;
    private String url;
    
    public Botonfooter(){
        
    }
    
    public Botonfooter(String logo, String url){
        this.logo=logo;
        this.url=url;
    }
}

