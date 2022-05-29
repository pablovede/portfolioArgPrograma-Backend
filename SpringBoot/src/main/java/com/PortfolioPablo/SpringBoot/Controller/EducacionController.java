
package com.PortfolioPablo.SpringBoot.Controller;

import com.PortfolioPablo.SpringBoot.Interface.IEducacionService;
import com.PortfolioPablo.SpringBoot.model.Educacion;
import com.PortfolioPablo.SpringBoot.service.EducacionService;
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
@CrossOrigin (origins = "https://portfolio-argentina-prog-2eb89.web.app/")

public class EducacionController {
    
    @Autowired private IEducacionService eduServ;
    
    
//    metodo de Luisina
//    @PostMapping ("/educacion/new")
//        public String agregarEducacion (@RequestBody Educacion edu) {
//            eduServ.crearEducacion(edu);
//            return "La educacion fue creada correctamente";
//        }
    
    
        //    metodo de AmigosCode
        @PostMapping ("/educacion/new")
        public ResponseEntity<Educacion> agregarEducacion (@RequestBody Educacion edu) {
        Educacion newEdu = eduServ.crearEducacion(edu);
            return new  ResponseEntity<>(newEdu, HttpStatus.CREATED);
        }
        
    @GetMapping ("/educacion/ver")
    @ResponseBody
        public List <Educacion> verEducaciones() {
            return eduServ.verEducaciones();
        }    
        
        //    metodo de AmigosCode
        
        @DeleteMapping ("/educacion/borrar/{id}")
        public ResponseEntity<?> borrarEducacion (@PathVariable("id") Long id) {
            eduServ.borrarEducacion(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        
        
//    @DeleteMapping ("/educacion/borrar/{id}")
//        public String borrarEducacion (@PathVariable Long id) {
//            eduServ.borrarEducacion(id);
//            return "La educacion fue eliminada correctamente";
//        }
     
        
        //    metodo de AmigosCode
    @PutMapping ("/educacion/editar")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion edu){
        Educacion editarEducacion = eduServ.editarEducacion(edu);
        return new ResponseEntity<>(editarEducacion, HttpStatus.OK);
        
   
    }

//    @PutMapping ("/educacion/editar/{id}") 
//    public Educacion editEducacion (@PathVariable Long id,
//                                    @RequestParam ("establecimiento") String nuevoEstablecimiento,
//                                    @RequestParam ("titulo") String nuevoTitulo,
//                                    @RequestParam ("fecha") String nuevoFecha,
//                                    @RequestParam ("logo") String nuevoLogo) {
//        
//        Educacion educacion = eduServ.buscarEducacion(id);
//        
//        educacion.setEstablecimiento(nuevoEstablecimiento);
//        educacion.setTitulo(nuevoTitulo);
//        educacion.setFecha(nuevoFecha);
//        educacion.setLogo(nuevoLogo);
//        
//        eduServ.crearEducacion(educacion);
//        return educacion;
//
//    }    
    
     @GetMapping ("/educacion/ver/perfil")
        public Educacion buscarEducacion () {
            return eduServ.buscarEducacion ((long)3);
    
        }
}
