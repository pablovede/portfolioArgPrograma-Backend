
package com.PortfolioPablo.SpringBoot.service;

import com.PortfolioPablo.SpringBoot.Interface.IPersonaService;
import com.PortfolioPablo.SpringBoot.model.Persona;
import com.PortfolioPablo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
implemento todos los metodos de IPersonaService
 */

@Service
public class PersonaService implements IPersonaService {
    
    
    /** inyeccion de dependencias*/
    @Autowired public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public Persona crearPersona(Persona per) {
       persoRepo.save(per);
       return per;
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public  Persona buscarPersona(Long id) {
      return persoRepo.findById(id).orElse(null);
    }
    
    @Override
     public Persona editarPersona(Persona per){
        return persoRepo.save(per);
    }
}
