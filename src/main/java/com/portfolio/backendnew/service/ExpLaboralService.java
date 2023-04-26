/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backendnew.service;

import com.portfolio.backendnew.model.Explaboral;
import com.portfolio.backendnew.repository.ExpLaboralRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpLaboralService implements IExpLaboralService{
    @Autowired
    ExpLaboralRepository ExpLaborals;

    @Override
    public Explaboral crear(Explaboral expLaboral) {
        return ExpLaborals.save(expLaboral); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Explaboral> verTodos() {
        return ExpLaborals.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String eliminar(long id) {
        ExpLaborals.deleteById(id); 
        return "Borrado";
    }

    @Override
    public Explaboral buscar(long id) {
        return ExpLaborals.findById(id).orElse(null); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Explaboral editar(long id, Explaboral expLaboral) {
        expLaboral.setId(id);
        return ExpLaborals.save(expLaboral);
    }
    
    @Override
    public String restaurar() {
        ExpLaborals.deleteAll();
        List<Explaboral> original=new ArrayList<>();
        original.add(new Explaboral("../assets/logo-SD.png", "Asistente de producción", "", "Sonidos Distantes Producciones", "Gestión administrativa para productora musical dedicada a eventos empresariales y particulares.", "Noviembre 2022", "Actualmente"));
        original.add(new Explaboral("../assets/logo-soluciones-practicas.png", "Diseñador Gráfico", "", "Soluciones Prácticas - Estudio de Diseño", "Diseñador gráfico freelance.", "Noviembre 2022", "Actualmente"));
        original.add(new Explaboral("../assets/logo-ate.png", "Profesor de taller", "", "A.T.E. - Asociación Trabajadores del Estado", "Profesor de taller para adultos mayores sobre uso de celulares", "2019", "Actualmente (interrumpido durante pandemia)"));
        original.add(new Explaboral("../assets/logo-vox.jpg", "Promoción de derechos", "", "VOX Asociación Civil", "Voluntario en organización LGBT sin fines de lucro. Promotor de derechos, charlas y talleres", "2018", "2020"));
        ExpLaborals.saveAll(original);
        return "Restaurado con éxito";
    }
}
