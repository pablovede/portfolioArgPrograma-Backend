
package com.PortfolioPablo.SpringBoot.PersonaController;

import com.PortfolioPablo.SpringBoot.model.Persona;
import com.PortfolioPablo.SpringBoot.Interface.IPersonaService;

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


/** implemento todos los metodos del CRUD*/

@RestController
@CrossOrigin (origins = "http://localhost:4200")

public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
   
        @PostMapping ("/persona/new")
        public String agregarPersona (@RequestBody Persona pers) {
            persoServ.crearPersona(pers);
            return "La persona fue creada correctamente";
            //listaPersonas.add(pers);
        }
        
        @GetMapping ("/persona/ver")
        @ResponseBody
        public List<Persona> verPersonas () {
            return persoServ.verPersonas();
            //return listaPersonas;
        }
        @DeleteMapping ("/persona/borrar/{id}")
        public String borrarPersona (@PathVariable Long id) {
            persoServ.borrarPersona(id);
            return "La persona fue eliminada correctamente";
        }
        
        @PutMapping ("/persona/editar/{id}")
        public Persona editPersona (@PathVariable Long id,
                                    @RequestParam("nombre") String nuevoNombre,
                                    @RequestParam("apellido") String nuevoApellido,
                                    @RequestParam("img") String nuevoImg,
                                    @RequestParam("cargo") String nuevoCargo) {
            Persona persona = persoServ.buscarPersona(id);
            
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setImg(nuevoImg);
            persona.setCargo(nuevoCargo);
            
            persoServ.crearPersona(persona);
            return persona;
        }
        
        //me trae los datos solo de la persona que tenga id=1
        @GetMapping ("/persona/ver/perfil")
        public Persona buscarPersona() {
            return persoServ.buscarPersona ((long)1);
        }
}
