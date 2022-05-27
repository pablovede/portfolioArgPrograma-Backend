
package com.PortfolioPablo.SpringBoot.Controller;

import com.PortfolioPablo.SpringBoot.Interface.IExperienciaService;
import com.PortfolioPablo.SpringBoot.model.Experiencia;
import java.util.Date;
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

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class ExperienciaController {
    
     @Autowired private IExperienciaService expServ;
     
     
      @PostMapping ("/experiencia/new")
        public ResponseEntity<Experiencia> agregarExperiencia (@RequestBody Experiencia exp) {
        Experiencia newExp = expServ.crearExperiencia(exp);
            return new  ResponseEntity<>(newExp, HttpStatus.CREATED);
        }
        
        @GetMapping ("/experiencia/ver")
        @ResponseBody
        public List<Experiencia> verExperiencias () {
            return expServ.verExperiencias();
            
        }
        
        @DeleteMapping ("/experiencia/borrar/{id}")
        public ResponseEntity<?> borrarExperiencia (@PathVariable("id") Long id) {
            expServ.borrarExperiencia(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        
         @PutMapping ("/experiencia/editar")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp){
        Experiencia editarExperiencia = expServ.editarExperiencia(exp);
        return new ResponseEntity<>(editarExperiencia, HttpStatus.OK);
        
   
    }
        
        //me trae los datos solo de la persona que tenga id=1
        @GetMapping ("/experiencia/ver/perfil")
        public Experiencia buscarExperiencia() {
            return expServ.buscarExperiencia ((long)8);
        }
}
   