
package com.PortfolioPablo.SpringBoot.PersonaController;

import com.PortfolioPablo.SpringBoot.model.Skill;
import com.PortfolioPablo.SpringBoot.Interface.ISkillService;

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
public class SkillControler {
    
    @Autowired private ISkillService skServ;
    
    @PostMapping ("/skill/new")
        public String agregarSkill (@RequestBody Skill sk) {
            skServ.crearSkill(sk);
            return "El skill fue creado correctamente";
        }

        
    @GetMapping ("/skill/ver")
    @ResponseBody
    public List <Skill> verSkills() {
        return skServ.verSkills ();
    }
    
    @DeleteMapping ("/skill/borrar/{id}")
    public String borrarSkill (@PathVariable Long id) {
        skServ.borrarSkill(id);
        return "El skill fue eliminado correctamente";
    }
    
    @PutMapping ("/skill/editar/{id}")
    public Skill editSkill (@PathVariable Long id,
                            @RequestParam ("nombre") String nuevoNombre,
                            @RequestParam ("porcentaje") Long nuevoPorcentaje) {
            
        Skill skill = skServ.buscarSkill(id);
    
        skill.setNombre(nuevoNombre);
        skill.setPorcentaje(nuevoPorcentaje);
        
        skServ.crearSkill(skill);
        return skill;
    }
}
