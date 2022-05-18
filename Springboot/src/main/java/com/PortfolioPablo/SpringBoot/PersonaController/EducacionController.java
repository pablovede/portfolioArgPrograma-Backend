
package com.PortfolioPablo.SpringBoot.PersonaController;

import com.PortfolioPablo.SpringBoot.Interface.IEducacionService;
import com.PortfolioPablo.SpringBoot.model.Educacion;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")

public class EducacionController {
    
    @Autowired private IEducacionService eduServ;
    
    @PostMapping ("/educacion/new")
        public String agregarEducacion (@RequestBody Educacion edu) {
            eduServ.crearEducacion(edu);
            return "La educacion fue creada correctamente";
        }
        
    @GetMapping ("/educacion/ver")
    @ResponseBody
        public List <Educacion> verEducaciones() {
            return eduServ.verEducaciones();
        }    
        
    @DeleteMapping ("/educacion/borrar/{id}")
        public String borrarEducacion (@PathVariable Long id) {
            eduServ.borrarEducacion(id);
            return "La educacion fue eliminada correctamente";
        }
        
    @PutMapping ("/educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                    @RequestParam ("establecimiento") String nuevoEstablecimiento,
                                    @RequestParam ("titulo") String nuevoTitulo,
                                    @RequestParam ("fecha") Date nuevoFecha,
                                    @RequestParam ("logo") String nuevoLogo) {
        
        Educacion educacion = eduServ.buscarEducacion(id);
        
        educacion.setEstablecimiento(nuevoEstablecimiento);
        educacion.setTitulo(nuevoTitulo);
        educacion.setFecha(nuevoFecha);
        educacion.setLogo(nuevoLogo);
        
        eduServ.crearEducacion(educacion);
        return educacion;

    }    
    
     @GetMapping ("/educacion/ver/perfil")
        public Educacion buscarEducacion () {
            return eduServ.buscarEducacion ((long)1);
    
        }
}
