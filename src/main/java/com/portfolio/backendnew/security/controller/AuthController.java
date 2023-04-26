/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.security.controller;

import com.portfolio.backendnew.dto.Mensaje;
import com.portfolio.backendnew.security.dto.JwtDto;
import com.portfolio.backendnew.security.dto.LoginUsuario;
import com.portfolio.backendnew.security.jwt.JwtProvider;
import com.portfolio.backendnew.security.service.RolService;
import com.portfolio.backendnew.security.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") //debe coincidir con la establecida en mainSecurity
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="https://tomasstevanargprog.web.app/")
public class AuthController {
     @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"),HttpStatus.BAD_REQUEST);
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        JwtDto jwtDto=new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
