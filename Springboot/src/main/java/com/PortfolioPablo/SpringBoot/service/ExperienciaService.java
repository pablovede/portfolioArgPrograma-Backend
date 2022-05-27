/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioPablo.SpringBoot.service;

import com.PortfolioPablo.SpringBoot.Interface.IExperienciaService;
import com.PortfolioPablo.SpringBoot.model.Experiencia;
import com.PortfolioPablo.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired public ExperienciaRepository expRepo;

    @Override
    public List<Experiencia> verExperiencias() {
        return expRepo.findAll(); 
    }

    @Override
    public Experiencia crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
        return exp;
       
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
     return expRepo.findById(id).orElse(null);
    }
    
    public Experiencia editarExperiencia(Experiencia exp) {
        return expRepo.save(exp);
    }
    
}
