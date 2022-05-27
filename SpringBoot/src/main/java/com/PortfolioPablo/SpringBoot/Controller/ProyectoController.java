
package com.PortfolioPablo.SpringBoot.Controller;

import com.PortfolioPablo.SpringBoot.Interface.IProyectoService;
import com.PortfolioPablo.SpringBoot.model.Proyecto;
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
public class ProyectoController {
    
    @Autowired private IProyectoService proyectoServ;
    
     @PostMapping ("/proyecto/new")
        public ResponseEntity<Proyecto> agregarProyecto (@RequestBody Proyecto pro) {
        Proyecto newPro = proyectoServ.crearProyecto(pro);
            return new  ResponseEntity<>(newPro, HttpStatus.CREATED);
        }
        
        @GetMapping ("/proyecto/ver")
        @ResponseBody
        public List <Proyecto> verProyectos() {
            return proyectoServ.verProyectos();
        }
        
        @DeleteMapping ("/proyecto/borrar/{id}")
        public ResponseEntity<?> borrarProyecto (@PathVariable("id") Long id) {
            proyectoServ.borrarProyecto(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        
        @PutMapping ("/proyecto/editar")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto pro){
        Proyecto editarProyecto = proyectoServ.editarProyecto(pro);
        return new ResponseEntity<>(editarProyecto, HttpStatus.OK);
    }
        
        @GetMapping ("/proyecto/ver/perfil")
        public Proyecto buscarPersona() {
            return proyectoServ.buscarProyecto ((long)5);
        }
        
        
    
}
