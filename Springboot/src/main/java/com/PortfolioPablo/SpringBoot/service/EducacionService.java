
package com.PortfolioPablo.SpringBoot.service;

import com.PortfolioPablo.SpringBoot.Interface.IEducacionService;
import com.PortfolioPablo.SpringBoot.model.Educacion;
import com.PortfolioPablo.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducacionService implements IEducacionService {
    
    @Autowired public EducacionRepository eduRepo;

    @Override
    public List<Educacion> verEducaciones() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save (edu);
    }

    @Override
    public void borrarEducacion(Long id) {
       eduRepo.deleteById (id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
    
}
