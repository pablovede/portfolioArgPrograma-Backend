
package com.PortfolioPablo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/** clase con todos valores que necesito
cada atributo es una columna
cada clase es una tabla*/

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String img;
    private String cargo;
    private String descripcion;
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String img, String cargo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.cargo = cargo;
        this.descripcion = descripcion;
    }
}
