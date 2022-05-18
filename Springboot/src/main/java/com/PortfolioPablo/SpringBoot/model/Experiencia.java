/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Experiencia {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String cargo;
    private String empresa;
    private Date desde;
    private Date hasta;
    private String descripcion;
    
    public Experiencia () {}
    
     public Experiencia (Long id, String cargo, String empresa, Date desde, Date hasta, String descripcion) {
            this.cargo = cargo;
            this.descripcion = descripcion;
            this.empresa = empresa;
            this.desde = desde;
            this.hasta = hasta;
            
     
     
     }
    
}
