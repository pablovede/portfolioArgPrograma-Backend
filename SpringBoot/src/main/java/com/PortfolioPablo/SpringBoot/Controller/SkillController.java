
package com.PortfolioPablo.SpringBoot.Controller;

import com.PortfolioPablo.SpringBoot.Interface.ISkillService;
import com.PortfolioPablo.SpringBoot.model.Skill;
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
public class SkillController {
    
    @Autowired
    private ISkillService skServ;
    
    @PostMapping ("/skill/new")
        public ResponseEntity<Skill> agregarSkill (@RequestBody Skill sk) {
        Skill newSk = skServ.crearSkill(sk);
            return new  ResponseEntity<>(newSk, HttpStatus.CREATED);
        }
        
        @GetMapping ("/skill/ver")
        @ResponseBody
        public List<Skill> verSkills () {
            return skServ.verSkills();
            //return listaPersonas;
        }
        
        @DeleteMapping ("/skill/borrar/{id}")
        public ResponseEntity<?> borrarSkill (@PathVariable("id") Long id) {
            skServ.borrarSkill(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        
        @PutMapping ("/skill/editar")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill sk){
        Skill editarSkill = skServ.editarSkill(sk);
        return new ResponseEntity<>(editarSkill, HttpStatus.OK);
   
    }
    
    @GetMapping ("/skill/ver/perfil")
        public Skill buscarPersona() {
            return skServ.buscarSkill ((long)5);
        }
}
