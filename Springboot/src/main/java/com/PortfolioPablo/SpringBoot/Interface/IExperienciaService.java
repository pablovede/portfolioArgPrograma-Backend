/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Experiencia;
import java.util.List;

/**
 *
 * @author Win10
 */
public interface IExperienciaService {
    
    
    //traer una lista de experiencias
    public List <Experiencia> verExperiencias ();
    //guardar un objeto del tipo experiencia
    public void crearExperiencia (Experiencia exp);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
    
}
