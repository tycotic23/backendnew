/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backendnew.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backendnew.security.entity.Rol;
import com.portfolio.backendnew.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
