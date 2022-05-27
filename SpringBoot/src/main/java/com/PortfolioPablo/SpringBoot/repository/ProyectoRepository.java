
package com.PortfolioPablo.SpringBoot.repository;

import com.PortfolioPablo.SpringBoot.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
    
}
