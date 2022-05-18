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
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String establecimiento;
    private String titulo;
    private Date fecha;
    private String logo;
    
    public Educacion () {}

    public Educacion(Long id, String establecimiento, String titulo, Date fecha, String logo) {
        this.id = id;
        this.establecimiento = establecimiento;
        this.titulo = titulo;
        this.fecha = fecha;
        this.logo = logo;
    }
    
    
          
    
}
