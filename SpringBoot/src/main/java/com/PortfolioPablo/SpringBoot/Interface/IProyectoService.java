
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List <Proyecto> verProyectos ();
    public Proyecto crearProyecto (Proyecto per);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public Proyecto editarProyecto(Proyecto per);
    
}
