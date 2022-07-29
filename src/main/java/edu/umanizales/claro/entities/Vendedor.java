package edu.umanizales.claro.entities;

import edu.umanizales.claro.entities.enums.EnumTipoVendedor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Vendedor extends Persona {

    @Column(name="codigo_empleado")
    private String codigoEmpleado;

    @Column(name = "tipo")
    private EnumTipoVendedor tipo;


}
