/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.repository;

import com.portfolio.backendnew.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    List<Categoria> findAllByOrderByOrdenAsc();
    Categoria findByCategoria(String categoria);
    Categoria findFirstByOrderByIdDesc();
}
