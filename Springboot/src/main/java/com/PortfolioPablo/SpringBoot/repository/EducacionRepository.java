
package com.PortfolioPablo.SpringBoot.repository;

import com.PortfolioPablo.SpringBoot.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducacionRepository extends JpaRepository <Educacion, Long> {
    
}
