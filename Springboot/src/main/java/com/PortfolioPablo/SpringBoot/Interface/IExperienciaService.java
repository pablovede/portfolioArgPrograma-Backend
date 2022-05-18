
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    
    //traer una lista de experiencias
    public List <Experiencia> verExperiencias ();
    //guardar un objeto del tipo experiencia
    public void crearExperiencia (Experiencia exp);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
    
}
