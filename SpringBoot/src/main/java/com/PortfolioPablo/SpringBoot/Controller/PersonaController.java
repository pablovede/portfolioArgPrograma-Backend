/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioPablo.SpringBoot.Controller;

import com.PortfolioPablo.SpringBoot.model.Persona;
import com.PortfolioPablo.SpringBoot.Interface.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<Persona> agregarPersona (@RequestBody Persona per) {
        Persona newPer = persoServ.crearPersona(per);
            return new  ResponseEntity<>(newPer, HttpStatus.CREATED);
        }
        
        @GetMapping ("/persona/ver")
        @ResponseBody
        public List<Persona> verPersonas () {
            return persoServ.verPersonas();
            //return listaPersonas;
        }
        
        @DeleteMapping ("/persona/borrar/{id}")
        public ResponseEntity<?> borrarPersona (@PathVariable("id") Long id) {
            persoServ.borrarPersona(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        
        @PutMapping ("/persona/editar")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona per){
        Persona editarPersona = persoServ.editarPersona(per);
        return new ResponseEntity<>(editarPersona, HttpStatus.OK);
    }
        
//        //me trae los datos solo de la persona que tenga id=1
    
//        @GetMapping ("/persona/ver/perfil")
//        public Persona buscarPersona() {
//            return persoServ.buscarPersona ((long)4);
//        }
}
