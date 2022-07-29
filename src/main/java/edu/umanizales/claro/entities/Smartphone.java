package edu.umanizales.claro.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Data
public class Smartphone extends EntityBase{

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "precio_compra")
    private BigDecimal precio_compra;

    @Column(name = "cantidad")
    private BigInteger cantidad;
}
