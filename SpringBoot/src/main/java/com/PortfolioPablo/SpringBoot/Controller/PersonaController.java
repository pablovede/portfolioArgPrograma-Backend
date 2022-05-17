/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioPablo.SpringBoot.Controller;

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
   
        @PostMapping ("/new/persona")
        public String agregarPersona (@RequestBody Persona pers) {
            persoServ.crearPersona(pers);
            return "La persona fue creada correctamente";
            //listaPersonas.add(pers);
        }
        
        @GetMapping ("/ver/persona")
        @ResponseBody
        public List<Persona> verPersonas () {
            return persoServ.verPersonas();
            //return listaPersonas;
        }
        @DeleteMapping ("/delete/persona/{id}")
        public String borrarPersona (@PathVariable Long id) {
            persoServ.borrarPersona(id);
            return "La persona fue eliminada correctamente";
        }
        
        @PutMapping ("/editar/persona/{id}")
        public Persona editPersona (@PathVariable Long id,
                                    @RequestParam("nombre") String nuevoNombre,
                                    @RequestParam("apellido") String nuevoApellido,
                                    @RequestParam("img") String nuevoImg) {
            Persona persona = persoServ.buscarPersona(id);
            
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setImg(nuevoImg);
            
            persoServ.crearPersona(persona);
            return persona;
        }
        
        //me trae los datos solo de la persona que tenga id=1
        @GetMapping ("/ver/persona/perfil")
        public Persona buscarPersona() {
            return persoServ.buscarPersona ((long)1);
        }
}
