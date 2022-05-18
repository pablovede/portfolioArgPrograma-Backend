/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioPablo.SpringBoot.PersonaController;

import com.PortfolioPablo.SpringBoot.Interface.IExperienciaService;
import com.PortfolioPablo.SpringBoot.model.Experiencia;
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
public class ExperienciaController {
    
     @Autowired private IExperienciaService expServ;
     
     
     @PostMapping ("/experiencia/new")
        public String agregarExperiencia (@RequestBody Experiencia exp) {
            expServ.crearExperiencia(exp);
            return "La experiencia fue creada correctamente";
        }
        
        @GetMapping ("/experiencia/ver")
        @ResponseBody
        public List<Experiencia> verExperiencias () {
            return expServ.verExperiencias();
            //return listaPersonas;
        }
        @DeleteMapping ("/experiencia/borrar/{id}")
        public String borrarExperiencia (@PathVariable Long id) {
            expServ.borrarExperiencia(id);
            return "La experiencia fue eliminada correctamente";
        }
        
        @PutMapping ("/experiencia/editar/{id}")
        public Experiencia editExperiencia (@PathVariable Long id,
                                            @RequestParam("cargo") String nuevoCargo,
                                            @RequestParam("empresa") String nuevoEmpresa,
                                            @RequestParam("desde") Date nuevoDesde,
                                            @RequestParam("hasta") Date nuevoHasta,
                                            @RequestParam("descripcion") String nuevoDescripcion) {
            Experiencia experiencia = expServ.buscarExperiencia(id);
            
            experiencia.setCargo(nuevoCargo);
            experiencia.setEmpresa(nuevoEmpresa);
            experiencia.setDesde(nuevoDesde);
            experiencia.setHasta(nuevoHasta);
            experiencia.setDescripcion(nuevoDescripcion);
            
            expServ.crearExperiencia(experiencia);
            return experiencia;
        }
        
        //me trae los datos solo de la persona que tenga id=1
        @GetMapping ("/experiencia/ver/perfil")
        public Experiencia buscarExperiencia() {
            return expServ.buscarExperiencia ((long)8);
        }
}
   