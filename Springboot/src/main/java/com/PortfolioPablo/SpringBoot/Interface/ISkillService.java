
package com.PortfolioPablo.SpringBoot.Interface;

import com.PortfolioPablo.SpringBoot.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List <Skill> verSkills ();
    public void crearSkill (Skill sk);
    public void borrarSkill (Long id);
    public Skill buscarSkill (Long id);
    
}
