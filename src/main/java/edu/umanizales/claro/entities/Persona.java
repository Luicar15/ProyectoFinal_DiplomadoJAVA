package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Persona extends EntityBase {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cedula")
    private String cedula;

}
