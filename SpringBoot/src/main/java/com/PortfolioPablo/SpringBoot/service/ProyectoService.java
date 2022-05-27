
package com.PortfolioPablo.SpringBoot.service;

import com.PortfolioPablo.SpringBoot.Interface.IProyectoService;
import com.PortfolioPablo.SpringBoot.model.Proyecto;
import com.PortfolioPablo.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired public ProyectoRepository proyectoRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
       return proyectoRepo.findAll();
    }

    @Override
    public Proyecto crearProyecto(Proyecto pro) {
      proyectoRepo.save(pro);
      return pro;
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
       return proyectoRepo.findById(id).orElse(null);
    }
    
    public Proyecto editarProyecto(Proyecto pro){
        return proyectoRepo.save(pro);
    }
    
    
}
