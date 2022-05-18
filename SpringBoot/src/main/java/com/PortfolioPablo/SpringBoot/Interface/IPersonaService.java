
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    //traer una lista de personas
    public List <Persona> verPersonas ();
    //guardar un objeto del tipo persona
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    
    
    // cualquier cosa
    
}
