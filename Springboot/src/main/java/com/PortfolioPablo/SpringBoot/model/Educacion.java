
package com.PortfolioPablo.SpringBoot.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String establecimiento;
    private String titulo;
    private Date desde;
    private String hasta;
    private String logo;
    
    public Educacion () {}

    public Educacion(Long id, String establecimiento, String titulo, Date desde, String hasta, String logo) {
        this.id = id;
        this.establecimiento = establecimiento;
        this.titulo = titulo;
        this.desde = desde;
        this.hasta = hasta;
        this.logo = logo;
    }
    
    
          
    
}
