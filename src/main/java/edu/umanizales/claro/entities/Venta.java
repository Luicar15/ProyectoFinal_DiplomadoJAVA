package edu.umanizales.claro.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Venta extends EntityBase{

    @ManyToOne
    private Vendedor vendedor;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Smartphone smartphone;

    private String ciudad;
    private String anio;
    private String mes;
}
