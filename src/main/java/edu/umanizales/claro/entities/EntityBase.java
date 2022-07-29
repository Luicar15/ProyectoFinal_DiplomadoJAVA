package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.enums.EnumEstado;
import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class EntityBase {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EnumEstado enumEstado = EnumEstado.ACTIVO;
}
