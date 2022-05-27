
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Persona;
import java.util.List;


public interface IPersonaService {
    
   
    public List <Persona> verPersonas ();

    public Persona crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    public Persona editarPersona(Persona per);
    
    
    
}
