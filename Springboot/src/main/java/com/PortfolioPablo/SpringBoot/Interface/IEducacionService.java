
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List <Educacion> verEducaciones();
    public void crearEducacion (Educacion edu);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
}
